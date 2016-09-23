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
import org.cloudfoundry.operations.routes.MapRouteRequest;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import reactor.core.publisher.Mono;

/**
 * Helper class for mapping a route
 *
 * @author Biju Kunjummen
 */
public class CfMapRouteDelegate {

    private static final Logger LOGGER = Logging.getLogger(CfMapRouteDelegate.class);

    public Mono<Void> mapRoute(CloudFoundryOperations cfOperations,
                               CfProperties cfAppProperties) {

        LOGGER.lifecycle("Mapping hostname '{}' in domain '{}' with path '{}' of app '{}'", cfAppProperties.hostName(),
            cfAppProperties.domain(), cfAppProperties.path(), cfAppProperties.name());

        Mono<Void> resp = cfOperations.routes()
            .map(MapRouteRequest
                .builder()
                .applicationName(cfAppProperties.name())
                .domain(cfAppProperties.domain())
                .host(cfAppProperties.hostName())
                .path(cfAppProperties.path()).build());

        return resp;

    }

}
