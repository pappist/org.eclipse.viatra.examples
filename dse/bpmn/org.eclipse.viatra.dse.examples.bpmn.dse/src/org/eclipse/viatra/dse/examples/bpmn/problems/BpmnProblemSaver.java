/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.problems;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.junit.Test;

/**
 * This class saves the BPMN models into .sbpmn files.
 * 
 * @author Andras Szabolcs Nagy
 */
public class BpmnProblemSaver {

    @Test
    public void run() {

        SimplifiedBPMN root;

        root = BpmnProblems.createOneTaskProblem(false);
        EMFHelper.serializeModel(root, "onetask", "sbpmn");

        root = BpmnProblems.create3TaskProblem(false);
        EMFHelper.serializeModel(root, "threetask", "sbpmn");

        root = BpmnProblems.createWebShopProblem();
        EMFHelper.serializeModel(root, "webshop", "sbpmn");

        root = BpmnProblems.createInvoiceProblem(false);
        EMFHelper.serializeModel(root, "invoice", "sbpmn");

        root = BpmnProblems.createBookProblem(false);
        EMFHelper.serializeModel(root, "book", "sbpmn");

    }

}
