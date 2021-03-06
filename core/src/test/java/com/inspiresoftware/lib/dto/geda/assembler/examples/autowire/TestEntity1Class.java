
/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.assembler.examples.autowire;

import org.junit.Ignore;

/**
 * Test entity for Assembler.
 *
 * @author Denis Pavlov
 * @since 1.0.0
 *
 */
@Ignore
public class TestEntity1Class implements TestEntity1Interface {
	
	private Long entityId;
	private String name;
	private Double number;
	
	/** {@inheritDoc} */
	public Long getEntityId() {
		return entityId;
	}
	/** {@inheritDoc} */
	public void setEntityId(final Long entityId) {
		this.entityId = entityId;
	}
	/** {@inheritDoc} */
	public String getName() {
		return name;
	}
	/** {@inheritDoc} */
	public void setName(final String name) {
		this.name = name;
	}
	/** {@inheritDoc} */
	public Double getNumber() {
		return number;
	}
	/** {@inheritDoc} */
	public void setNumber(final Double number) {
		this.number = number;
	}
	
	

}
