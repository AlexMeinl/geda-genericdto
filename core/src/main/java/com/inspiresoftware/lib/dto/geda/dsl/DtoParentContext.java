/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.dsl;

/**
 * DSL version of {@link com.inspiresoftware.lib.dto.geda.annotations.DtoParent}.
 *
 * @since 3.0.0
 *
 * User: denispavlov
 * Date: 13-02-20
 * Time: 8:46 AM
 */
public interface DtoParentContext {
    /**
     * textual reference to {@link com.inspiresoftware.lib.dto.geda.adapter.EntityRetriever} within
     * converters map that will do the entity retrieval.
     *
     * @param retriever retriever key (requires adapters parameter during assembly)
     * @return dto field context
     */
    DtoFieldContext retriever(String retriever);
}
