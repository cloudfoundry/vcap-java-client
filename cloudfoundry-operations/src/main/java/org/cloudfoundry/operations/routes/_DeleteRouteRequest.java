/*
 * Copyright 2013-2021 the original author or authors.
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

package org.cloudfoundry.operations.routes;

import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.time.Duration;

/**
 * The request options for the map route operation
 */
@Value.Immutable
abstract class _DeleteRouteRequest {

    @Value.Check
    void checkSetup() {
        if (getPort() != null && hostOrPathSet()) {
            throw new IllegalStateException("Cannot specify port together with hostname and/or path");
        }
    }

    /**
     * How long to wait for deletion
     */
    @Value.Default
    Duration getCompletionTimeout() {
        return Duration.ofMinutes(5);
    }

    /**
     * The domain of the route
     */
    abstract String getDomain();

    /**
     * The host of the route
     */
    @Nullable
    abstract String getHost();

    /**
     * The path of the route.
     * <p>
     * Note: the path is specified without a leading "/"
     */
    @Nullable
    abstract String getPath();

    /**
     * The port of the route
     */
    @Nullable
    abstract Integer getPort();

    private boolean hostOrPathSet() {
        return getHost() != null || getPath() != null;
    }

}
