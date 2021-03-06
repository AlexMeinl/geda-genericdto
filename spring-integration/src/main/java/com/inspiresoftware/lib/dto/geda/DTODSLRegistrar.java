/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda;

/**
 * DSL registrar allows to register all necessary mappings at the point of initialising
 * all infrastructure beans.
 *
 * @since 2.1.0
 *
 * User: denispavlov
 * Date: 12-10-03
 * Time: 1:00 PM
 */
public interface DTODSLRegistrar {

    /**
     * Register all mappings via DSL registry.
     *
     * @param dtoSupport dto support
     * @param dslRegistry DSL mapping registry
     */
    void registerMappings(DTOSupport dtoSupport, com.inspiresoftware.lib.dto.geda.dsl.Registry dslRegistry);

}
