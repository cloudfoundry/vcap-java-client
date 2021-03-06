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

package org.cloudfoundry.operations.applications;

import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.time.Duration;

/**
 * The request options for the copy source application operation
 */
@Value.Immutable
abstract class _CopySourceApplicationRequest {

    @Value.Check
    void check() {
        if (getTargetOrganization() != null && getTargetSpace() == null) {
            throw new IllegalStateException("Cannot build CopySourceApplicationRequest, attribute targetSpace must be specified with targetOrganization");
        }
    }

    /**
     * The name of the application
     */
    abstract String getName();

    /**
     * Whether to restart the target application
     */
    @Nullable
    abstract Boolean getRestart();

    /**
     * How long to wait for staging
     */
    @Value.Default
    Duration getStagingTimeout() {
        return Duration.ofMinutes(5);
    }

    /**
     * How long to wait for startup
     */
    @Value.Default
    Duration getStartupTimeout() {
        return Duration.ofMinutes(5);
    }

    /**
     * The name of the target application
     */
    abstract String getTargetName();

    /**
     * The organization of the target application
     */
    @Nullable
    abstract String getTargetOrganization();

    /**
     * The space of the target application
     */
    @Nullable
    abstract String getTargetSpace();

}
