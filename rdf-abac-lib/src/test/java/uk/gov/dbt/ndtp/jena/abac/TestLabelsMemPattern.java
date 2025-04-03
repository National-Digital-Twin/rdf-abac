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

import java.util.stream.Stream;

import uk.gov.dbt.ndtp.jena.abac.labels.LabelsStoreMem;
import uk.gov.dbt.ndtp.jena.abac.labels.LabelsStoreMemPattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Run test files on the default in-memory labels store. {@link LabelsStoreMem}
 */
@SuppressWarnings("deprecation")
public class TestLabelsMemPattern extends BaseTestLabels {

    @ParameterizedTest(name = "{0}")
    @MethodSource("labels_files")
    public void labels(String filename, Integer expected) {
        test(filename, expected,  LabelsStoreMemPattern.create());
    }

    protected static Stream<Arguments> labels_files() {
        return BaseTestLabels.labels_files_with_patterns();
    }
}
