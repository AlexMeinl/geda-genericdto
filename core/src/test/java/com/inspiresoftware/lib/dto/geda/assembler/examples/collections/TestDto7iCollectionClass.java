
/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.assembler.examples.collections;


import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoCollection;
import org.junit.Ignore;

/**
 * .
 * <p/>
 * User: Denis Pavlov
 * Date: Jan 26, 2010
 * Time: 11:38:26 AM
 */
@Ignore
@Dto
public class TestDto7iCollectionClass implements TestDto7CollectionInterface {

    @DtoCollection(
            value = "collection",
            entityBeanKeys = "com.inspiresoftware.lib.dto.geda.assembler.TestEntity7iCollectionSubClass",
            dtoBeanKey = "com.inspiresoftware.lib.dto.geda.assembler.TestDto7iCollectionSubClass",
            dtoToEntityMatcher = Test7iMatcher.class,
            entityGenericType = TestEntity7CollectionSubInterface.class
    )
	private java.util.Collection<TestDto7CollectionSubInterface> nestedString;

	/**
	 * @return nested property.
	 */
	public java.util.Collection<TestDto7CollectionSubInterface> getNestedString() {
		return nestedString;
	}
	/**
	 * @param nestedString nested property.
	 */
	public void setNestedString(final java.util.Collection<TestDto7CollectionSubInterface> nestedString) {
		this.nestedString = nestedString;
	}



}
