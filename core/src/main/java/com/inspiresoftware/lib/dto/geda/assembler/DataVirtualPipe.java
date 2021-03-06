
/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */


package com.inspiresoftware.lib.dto.geda.assembler;

import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.ValueConverter;
import com.inspiresoftware.lib.dto.geda.assembler.extension.DataReader;
import com.inspiresoftware.lib.dto.geda.assembler.extension.DataWriter;
import com.inspiresoftware.lib.dto.geda.assembler.meta.FieldPipeMetadata;
import com.inspiresoftware.lib.dto.geda.exception.*;
import com.inspiresoftware.lib.dto.geda.exception.AnnotationMissingBindingException.MissingBindingType;

import java.util.Map;



/**
 * Object that handles read and write streams between Dto and Entity objects.
 *
 * @author Denis Pavlov
 * @since 1.0.0
 *
 */
class DataVirtualPipe implements Pipe {
	
    private final FieldPipeMetadata meta;

    private final DataReader dtoRead;
	private final DataWriter dtoWrite;
		
	private static final Object NULL = null;
	
	/**
	 * @param dtoRead method for reading data from DTO field
	 * @param dtoWrite method for writting data to DTO field
	 * @param meta meta data for this pipe.
	 * @throws AnnotationMissingBindingException if some of the parameter missing from the annotation
	 * @throws AnnotationValidatingBindingException if binding pipes are invalid
	 */
	public DataVirtualPipe(
					final DataReader dtoRead,
					final DataWriter dtoWrite,
					final FieldPipeMetadata meta) throws AnnotationMissingBindingException, AnnotationValidatingBindingException {
		
		this.meta = meta;
		
		this.dtoWrite = dtoWrite;
		if (meta.isReadOnly()) {
			
			this.dtoRead = null;

		} else {
			
			this.dtoRead = dtoRead;

		}
		
		if (meta.getConverterKey() == null || meta.getConverterKey().length() == 0) {
			throw new AnnotationMissingBindingException(MissingBindingType.VIRTUAL_CONVERTER ,meta.getDtoFieldName());
		}
		
	}
	
	/** {@inheritDoc} */
	public String getBinding() {
		return meta.getEntityFieldName();
	}

	/** {@inheritDoc} */
	public void writeFromEntityToDto(final Object entity,
                                     final Object dto,
                                     final Map<String, Object> converters,
                                     final BeanFactory dtoBeanFactory) 
		throws BeanFactoryNotFoundException, BeanFactoryUnableToCreateInstanceException, 
			   AnnotationMissingException, NotValueConverterException, ValueConverterNotFoundException, 
			   InspectionInvalidDtoInstanceException, InspectionInvalidEntityInstanceException, InspectionScanningException, 
			   UnableToCreateInstanceException, InspectionPropertyNotFoundException, InspectionBindingNotFoundException, 
			   AnnotationMissingBindingException, AnnotationValidatingBindingException, GeDARuntimeException, 
			   AnnotationDuplicateBindingException, CollectionEntityGenericReturnTypeException {
		
		if (entity == null) {
			return;
		}

		final Object entityData = entity; // the data is the whole entity

		if (entityData != null) {

			this.dtoWrite.write(dto, getConverter(converters).convertToDto(entityData, dtoBeanFactory));
		
		} else {
			
			this.dtoWrite.write(dto, NULL);
		
		}
	}

    /** {@inheritDoc} */
	public void writeFromDtoToEntity(final Object entity,
                                     final Object dto,
			                         final Map<String, Object> converters,
                                     final BeanFactory entityBeanFactory) 
		throws BeanFactoryNotFoundException, BeanFactoryUnableToCreateInstanceException, 
			   NotEntityRetrieverException, EntityRetrieverNotFoundException, NotValueConverterException, 
			   ValueConverterNotFoundException, AnnotationMissingBeanKeyException, AnnotationMissingException, 
			   InspectionInvalidDtoInstanceException, InspectionInvalidEntityInstanceException, InspectionScanningException, 
			   UnableToCreateInstanceException, InspectionPropertyNotFoundException, InspectionBindingNotFoundException, 
			   AnnotationMissingBindingException, AnnotationValidatingBindingException, GeDARuntimeException, 
			   AnnotationDuplicateBindingException, CollectionEntityGenericReturnTypeException, DtoToEntityMatcherNotFoundException, 
			   NotDtoToEntityMatcherException {

		if (meta.isReadOnly()) {
			return;
		}

		
        final Object dtoData = this.dtoRead.read(dto);
        getConverter(converters).convertToEntity(dtoData, entity, entityBeanFactory);

	}

    private ValueConverter getConverter(final Map<String, Object> converters) 
    		throws NotValueConverterException, ValueConverterNotFoundException {
    	
    	if (converters != null && !converters.isEmpty() && converters.containsKey(this.meta.getConverterKey())) {
    		final Object conv = converters.get(this.meta.getConverterKey());
    		if (conv instanceof ValueConverter) {
    			return (ValueConverter) conv;
    		}
    		throw new NotValueConverterException(
        			this.meta.getDtoFieldName(), this.meta.getEntityFieldName(), this.meta.getConverterKey());
    	}
    	throw new ValueConverterNotFoundException(
    			this.meta.getDtoFieldName(), this.meta.getEntityFieldName(), this.meta.getConverterKey());
    }
	
}
