/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.examples.usecases.generics.extend;

import java.util.Collection;

/**
 * User: denispavlov
 * Date: 13-04-20
 * Time: 9:10 AM
 */
public interface EntityCatalog<T extends EntityCode> {

    public String getId();
    public void setId(String id);

    public T getType();
    public void setType(T type);

    public Collection<T> getCodes();
    public void setCodes(Collection<T> codes);

}
