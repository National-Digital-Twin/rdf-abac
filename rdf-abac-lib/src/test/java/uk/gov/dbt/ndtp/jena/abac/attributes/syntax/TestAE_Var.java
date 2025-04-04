// SPDX-License-Identifier: Apache-2.0
// Originally developed by Telicent Ltd.; subsequently adapted, enhanced, and maintained by the National Digital Twin Programme.
/*
 *  Copyright (c) Telicent Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/*
 *  Modifications made by the National Digital Twin Programme (NDTP)
 *  © Crown Copyright 2025. This work has been developed by the National Digital Twin Programme
 *  and is legally attributed to the Department for Business and Trade (UK) as the governing entity.
 */

package uk.gov.dbt.ndtp.jena.abac.attributes.syntax;

import uk.gov.dbt.ndtp.jena.abac.attributes.VisitorAttrExpr;
import uk.gov.dbt.ndtp.jena.abac.attributes.syntax.AE_Var;
import uk.gov.dbt.ndtp.jena.abac.lib.CxtABAC;
import org.apache.jena.atlas.lib.NotImplemented;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestAE_Var {

    private final CxtABAC mockContext = mock(CxtABAC.class);

    @Test
    public void test_eval_exception() {
        AE_Var var = new AE_Var("test");
        assertThrows(NotImplemented.class, () -> {
            var.eval(mockContext);
        });
    }

    @Test
    public void test_visitor() {
        AE_Var var = new AE_Var("test");
        VisitorAttrExpr mockVistorAttrExpr = mock(VisitorAttrExpr.class);
        var.visitor(mockVistorAttrExpr);
        verify(mockVistorAttrExpr).visit(any(AE_Var.class));
    }

    @Test
    public void test_equals_same() {
        AE_Var var = new AE_Var("test");
        assertTrue(var.equals(var)); // we are specifically testing the equals method here
    }

    @Test
    public void test_equals_identical() {
        AE_Var var1 = new AE_Var("test");
        AE_Var var2 = new AE_Var("test");
        assertTrue(var1.equals(var2)); // we are specifically testing the equals method here
    }

    @Test
    public void test_equals_null() {
        AE_Var var = new AE_Var("test");
        assertFalse(var.equals(null)); // we are specifically testing the equals method here
    }

    @Test
    public void test_equals_different_class() {
        AE_Var var = new AE_Var("test");
        assertFalse(var.equals("test")); // we are specifically testing the equals method here
    }

}
