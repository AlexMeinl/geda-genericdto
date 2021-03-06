
/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.assembler.examples.simple;

import org.junit.Ignore;

/**
 * Test DTO for Assembler.
 *
 * @param <T> generic test.
 *
 * @author Denis Pavlov
 * @since 1.0.0
 *
 */
@Ignore
public interface TestEntity10Interface1<T> {
	
	/**
	 * @return test generic.
	 */
	T getIm1();
	/**
	 * @param im1 test generic.
	 */
	void setIm1(T im1);

}
