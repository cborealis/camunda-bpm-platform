/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.engine.impl.db.entitymanager;

import org.camunda.bpm.engine.impl.db.entitymanager.operation.DbOperation;
import org.camunda.bpm.engine.impl.db.entitymanager.operation.DbOperationType;

/**
 * Allows registering a listener which is notified when an
 * {@link DbOperationType#UPDATE} or {@link DbOperationType#DELETE}
 * could not be performed.
 *
 * @author Daniel Meyer
 *
 */
public interface OptimisticLockingListener {

  void failedOperation(DbOperation operation);

}
