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

package uk.gov.dbt.ndtp.jena.abac;

import uk.gov.dbt.ndtp.jena.abac.ABAC;
import uk.gov.dbt.ndtp.jena.abac.AE;
import uk.gov.dbt.ndtp.jena.abac.attributes.ValueTerm;
import uk.gov.dbt.ndtp.jena.abac.attributes.syntax.AE_Allow;
import uk.gov.dbt.ndtp.jena.abac.attributes.syntax.AE_Deny;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAE {

    @Test
    public void ae_parse_attribute_value() {
        assertNull(AE.parseAttrValue(null));
    }

    @Test
    public void ae_parse_expression_list() {
        assertEquals(List.of(), AE.parseExprList(null));
    }

    @Test
    public void ae_parse_attribute_value_list() {
        assertEquals(List.of(), AE.parseAttrValueList(null));
    }

    @Test
    public void ae_parse_value_term_list() {
        ABAC.LEGACY = false;
        List<ValueTerm> expected = new ArrayList<>(List.of(ValueTerm.value("test")));
        assertEquals(expected, AE.parseValueTermList("test"));
    }

    @Test
    public void ae_serialize() {
        assertEquals("*, !", AE.serialize(List.of(AE_Allow.value(), AE_Deny.value())));
    }

    @Test
    public void ae_eval_true() {
        ValueTerm expected = ValueTerm.value(true);
        ValueTerm actual = AE.eval("attr=1","attr=1");
        assertEquals(expected, actual);
    }

    @Test
    public void ae_eval_false() {
        ValueTerm expected = ValueTerm.value(false);
        ValueTerm actual = AE.eval("attr=1","attr=2");
        assertEquals(expected, actual);
    }

    @Test
    public void ae_eval_null_hierarchy() {
        ValueTerm expected = ValueTerm.value(true);
        ValueTerm actual = AE.eval("attr=1","attr=1" , null);
        assertEquals(expected, actual);
    }

}
