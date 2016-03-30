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

package org.cloudfoundry.operations;

import org.cloudfoundry.util.test.TestSubscriber;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.reactivestreams.Publisher;

import java.time.Duration;
import java.util.function.Supplier;

public abstract class AbstractOperationsApiTest<T> extends AbstractOperationsTest {

    @Rule
    public final TestName testName = new TestName();

    @Test
    public final void test() throws Exception {
        TestSubscriber<T> testSubscriber = new TestSubscriber<T>()
            .setScanningLoggerName(getScanningLoggerName());

        assertions(testSubscriber);

        invoke().subscribe(testSubscriber);
        testSubscriber.verify(Duration.ofSeconds(5));
    }

    protected abstract void assertions(TestSubscriber<T> testSubscriber);

    protected abstract Publisher<T> invoke();

    private Supplier<String> getScanningLoggerName() {
        return () -> String.format("%s.%s", this.getClass().getSimpleName(), this.testName.getMethodName());
    }
}
