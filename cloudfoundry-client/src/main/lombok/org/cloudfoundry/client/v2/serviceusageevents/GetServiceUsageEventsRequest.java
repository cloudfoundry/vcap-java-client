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

package org.cloudfoundry.client.v2.serviceusageevents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.cloudfoundry.client.Validatable;
import org.cloudfoundry.client.ValidationResult;

/**
 * The request payload for the Get Service Usage Events operation
 */
@Data
public class GetServiceUsageEventsRequest implements Validatable {

    /**
     * The service usage events id
     *
     * @param serviceUsageEventsId the service instance id
     * @return the service usage events id
     */
    @Getter(onMethod = @__(@JsonIgnore))
    private final String serviceUsageEventsId;

    @Builder
    GetServiceUsageEventsRequest(String serviceUsageEventsId) {
        this.serviceUsageEventsId = serviceUsageEventsId;
    }

    @Override
    public ValidationResult isValid() {
        ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();

        if (this.serviceUsageEventsId == null) {
            builder.message("service usage events id must be specified");
        }

        return builder.build();
    }
    
}
