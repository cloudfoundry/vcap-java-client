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

package org.cloudfoundry.gradle.tasks;

import org.cloudfoundry.gradle.CfProperties;
import org.cloudfoundry.gradle.tasks.helper.CfRenameAppDelegate;
import org.cloudfoundry.operations.CloudFoundryOperations;
import org.gradle.api.tasks.TaskAction;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Responsible for handling renaming an app.
 *
 * @author Biju Kunjummen
 */
public class CfRenameAppTask extends AbstractCfTask {

    private CfRenameAppDelegate renameDelegate = new CfRenameAppDelegate();

    @TaskAction
    public void renameApp() {
        CloudFoundryOperations cfOperations = getCfOperations();
        CfProperties cfAppProperties = getCfProperties();

        if (getNewName() == null) {
            throw new RuntimeException("New name not provided");
        }

        CfProperties oldAppProperties = cfAppProperties;

        CfProperties newAppProperties = oldAppProperties.withName(getNewName());

        Mono<Void> resp = renameDelegate.renameApp(cfOperations, oldAppProperties, newAppProperties);

        resp.block(Duration.ofMillis(defaultWaitTimeout));
    }

    private String getNewName() {
        return this.cfPropertiesMapper.getNewName();
    }


    @Override
    public String getDescription() {
        return "Rename an Application";
    }
}
