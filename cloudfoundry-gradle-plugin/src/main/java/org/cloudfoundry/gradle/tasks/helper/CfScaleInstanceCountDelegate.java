/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.gradle.tasks.helper;

import org.cloudfoundry.gradle.CfProperties;
import org.cloudfoundry.operations.CloudFoundryOperations;
import org.cloudfoundry.operations.applications.ScaleApplicationRequest;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import reactor.core.publisher.Mono;

/**
 * Helper class for scaling instance Count of an app
 *
 * @author Biju Kunjummen
 */
public class CfScaleInstanceCountDelegate {

    private static final Logger LOGGER = Logging.getLogger(CfScaleInstanceCountDelegate.class);

    public Mono<Void> scaleInstances(CloudFoundryOperations cfOperations,
                                     CfProperties cfAppProperties, int instanceCount) {

        LOGGER.lifecycle("Scaling app {} to instance count {}", cfAppProperties.name(), instanceCount);
        Mono<Void> resp = cfOperations.applications().scale(
            ScaleApplicationRequest.builder()
                .instances(instanceCount)
                .build()
        );

        return resp;

    }

}
