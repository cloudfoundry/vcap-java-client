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

package org.cloudfoundry.client.v3.droplets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.cloudfoundry.client.v3.packages.Package;

/**
 * The state of a {@link Package}
 */
public enum State {

    /**
     * The expired state
     */
    EXPIRED("EXPIRED"),

    /**
     * The failed state
     */
    FAILED("FAILED"),

    /**
     * The pending state
     */
    PENDING("PENDING"),

    /**
     * The staged state
     */
    STAGED("STAGED"),

    /**
     * The staging state
     */
    STAGING("STAGING");

    private final String value;

    State(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    @JsonCreator
    public static State from(String s) {
        switch (s.toLowerCase()) {
            case "expired":
                return EXPIRED;
            case "failed":
                return FAILED;
            case "pending":
                return PENDING;
            case "staged":
                return STAGED;
            case "staging":
                return STAGING;
            default:
                throw new IllegalArgumentException(String.format("Unknown state: %s", s));
        }
    }

}