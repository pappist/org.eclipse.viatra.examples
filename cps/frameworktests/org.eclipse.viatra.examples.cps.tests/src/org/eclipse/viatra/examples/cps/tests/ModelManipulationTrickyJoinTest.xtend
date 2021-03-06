/*******************************************************************************
 * Copyright (c) 2017-2017 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gabor Bergmann - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.tests

import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test
import org.eclipse.viatra.examples.cps.tests.queries.util.TrickyJoin1QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.TrickyJoin2QuerySpecification
import org.junit.runners.Parameterized.Parameters
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.eclipse.viatra.examples.cps.tests.queries.TrickyJoin
import org.eclipse.viatra.query.runtime.api.IQuerySpecification
import org.junit.runners.Parameterized.Parameter

@RunWith(Parameterized)
class ModelManipulationTrickyJoinTest {
    public static val SNAPSHOT_PATH = "org.eclipse.viatra.examples.cps.tests/models/snapshots/test_trickyJoin.snapshot"
    
    @Parameters(name = "{index}: {1}")
    public static def data() {
        return TrickyJoin::instance.specifications.toList.sortBy[fullyQualifiedName].map[
        	val Object[] params = #[it,fullyQualifiedName]
        	params
        ];
    }    
    
    @Parameter(0) 
    public var IQuerySpecification query;
    @Parameter(1) 
    public var String fqn;
    
    @Test
    def void test_trickyJoin() {
        ViatraQueryTest.test(query)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .with(SNAPSHOT_PATH)
                        .assumeInputs
                        .assertEqualsThen
                        .modify(HostInstance,
                            [true],
                            [
                            	val lastCharIndex = identifier.length-1
                            	val lastChar = identifier.charAt(lastCharIndex)
                            	val oldNumber = lastChar - '0'
                            	val newNumber = (oldNumber + 1) % 5
                            	val char replacement = Character.forDigit(newNumber, 10) 
                            	val newIdentifier = identifier.substring(0, lastCharIndex) + replacement
                            	identifier = newIdentifier
							])
                        .with("org.eclipse.viatra.examples.cps.tests/models/snapshots/test_trickyJoin.snapshot")
                        .assertEquals
    }
    
}