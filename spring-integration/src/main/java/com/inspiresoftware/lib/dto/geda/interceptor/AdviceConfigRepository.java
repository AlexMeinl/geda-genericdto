/*
 * This code is distributed under The GNU Lesser General Public License (LGPLv3)
 * Please visit GNU site for LGPLv3 http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright Denis Pavlov 2009
 * Web: http://www.genericdtoassembler.org
 * SVN: https://svn.code.sf.net/p/geda-genericdto/code/trunk/
 * SVN (mirror): http://geda-genericdto.googlecode.com/svn/trunk/
 */

package com.inspiresoftware.lib.dto.geda.interceptor;

import com.inspiresoftware.lib.dto.geda.annotations.Occurrence;
import com.inspiresoftware.lib.dto.geda.config.GeDAInfrastructure;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Advisable methods repository that is populated through {@link org.springframework.beans.factory.config.BeanPostProcessor}.
 * <p/>
 * User: denispavlov
 * Date: Jan 27, 2012
 * Time: 4:39:47 PM
 */
public interface AdviceConfigRepository extends GeDAInfrastructure {

    /**
     * Check if method is advisable and add it to this repository.
     *
     * @param bean spring bean
     */
    void addApplicableMethods(final Object bean);

    /**
     * @param targetClass target class
     * @return all valid methods configurations keyed by unique cache key.
     */
    Map<Integer, Map<Occurrence, AdviceConfig>> getAdvisableMethodsConfigurations(final Class<?> targetClass);

    /**
     * Allows to create a unique key that would identify current method invocation
     * as a key to applicable advisable methods stored in this repository.
     *
     * @param method potentially advisable method
     * @param targetClass bean class on which it is invoked
     * @return unique cache key.
     */
    Integer methodCacheKey(final Method method, final Class<?> targetClass);

}
