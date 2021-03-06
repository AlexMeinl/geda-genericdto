/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.examples.usecases.maps;

import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.assembler.Assembler;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.inspiresoftware.lib.dto.geda.exception.GeDAException;

import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * User: denispavlov
 * Date: 13-04-22
 * Time: 11:41 PM
 */
public class RunMapToMap {

    /**
     * Example of how to map an entity map to dto map where map entry key is simple object
     * and entry value is dto item.
     */
    public void mapToMapMapping() throws GeDAException {
        final EntityItemInterface eItem1 = new EntityItemClass();
        eItem1.setName("itm1");
        final EntityItemInterface eItem2 = new EntityItemClass();
        eItem2.setName("itm2");

        final EntityMapInterface eMap = new EntityMapClass();
        eMap.setItems(new HashMap<String, EntityItemInterface>());
        eMap.getItems().put("itm1", eItem1);
        eMap.getItems().put("itm2", eItem2);

        final DtoMapIterface dMap = new DtoMapToMapClass();

        final Assembler assembler = DTOAssembler.newAssembler(dMap.getClass(), eMap.getClass());

        assembler.assembleDto(dMap, eMap, null, new BeanFactory() {

            public Class getClazz(final String entityBeanKey) {
                if ("dtoItem".equals(entityBeanKey)) {
                    return DtoItemClass.class;
                }
                return null;
            }

            public Object get(final String entityBeanKey) {
                if ("dtoItem".equals(entityBeanKey)) {
                    return new DtoItemClass();
                }
                return null;
            }

        });

        assertNotNull(dMap.getItems());
        assertEquals(2, dMap.getItems().size());
        final Set<String> keys = dMap.getItems().keySet();
        for (String key : keys) {
            if ("itm1".equals(key)) {
                assertEquals("itm1", dMap.getItems().get(key).getName());
            } else if ("itm2".equals(key)) {
                assertEquals("itm2", dMap.getItems().get(key).getName());
            } else {
                fail("Unknown key");
            }
        }

        final DtoItemClass dto3 = new DtoItemClass();
        dto3.setName("itm3");
        dMap.getItems().put("itm3", dto3);

        dMap.getItems().remove("itm1"); // first

        assembler.assembleEntity(dMap, eMap, null, new BeanFactory() {

            public Class getClazz(final String entityBeanKey) {
                if ("entityItem".equals(entityBeanKey)) {
                    return EntityItemInterface.class;
                }
                return null;
            }

            public Object get(final String entityBeanKey) {
                if ("entityItem".equals(entityBeanKey)) {
                    return new EntityItemClass();
                }
                return null;
            }

        });

        assertNotNull(eMap.getItems());
        assertEquals(2, eMap.getItems().size());

        final Set<String> ekeys = eMap.getItems().keySet();
        for (String key : ekeys) {
            if ("itm2".equals(key)) {
                assertEquals("itm2", eMap.getItems().get(key).getName());
            } else if ("itm3".equals(key)) {
                assertEquals("itm3", eMap.getItems().get(key).getName());
            } else {
                fail("Unknown key");
            }
        }

    }


    public static void main(String[] args) {
        new RunMapToMap().mapToMapMapping();
    }


}
