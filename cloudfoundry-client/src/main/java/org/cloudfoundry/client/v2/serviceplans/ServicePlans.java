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

package org.cloudfoundry.client.v2.serviceplans;


import reactor.core.publisher.Mono;

public interface ServicePlans {

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_plans/delete_a_particular_service_plans.html">Delete the Service Plan</a> request
     *
     * @param request the Delete Service Plan request
     * @return the response from the Delete Service Plan request
     */
    Mono<DeleteServicePlanResponse> delete(DeleteServicePlanRequest request);

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_plans/retrieve_a_particular_service_plan.html">Retrieve a Particular Service Plan</a> request
     *
     * @param request the Get Service Plan request
     * @return the response from the Get Service Plan request
     */
    Mono<GetServicePlanResponse> get(GetServicePlanRequest request);

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_plans/list_all_service_plans.html">List Service Plans</a> request
     *
     * @param request the List Service Plans request
     * @return the response from the List Service Plans request
     */
    Mono<ListServicePlansResponse> list(ListServicePlansRequest request);

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_plans/list_all_service_instances_for_the_service_plan.html">List all Service Instances for the Service Plan</a>
     * request
     *
     * @param request the List Service Instances request
     * @return the response from the List Service Instances request
     */
    Mono<ListServicePlanServiceInstancesResponse> listServiceInstances(ListServicePlanServiceInstancesRequest request);

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_instances/migrate_service_instances_from_one_service_plan_to_another_service_plan_%28experimental%29.html">Migrate
     * Service Instances from one Service Plan to the other</a> request
     *
     * @param request the Migrate Service Instance request
     * @return the response from the Migrate Service Instance request
     */
    Mono<MigrateServiceInstancesResponse> migrateServiceInstances(MigrateServiceInstancesRequest request);

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/latest-release/service_plans/updating_a_service_plan.html">Update Service Plan</a> request
     *
     * @param request the Update Service Plan request
     * @return the response from the Update Service Plan request
     */
    Mono<UpdateServicePlanResponse> update(UpdateServicePlanRequest request);

}
