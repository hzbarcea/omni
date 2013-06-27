/*
 * Copyright 2013 The Fictitious OMNI Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.talend.example.omni.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;


public class OmniManagedService {
    
    private Map<String, Map<String, Object>> pendingTasks = new HashMap<String, Map<String, Object>>();

    @SuppressWarnings("unchecked")
    public boolean newTask(Exchange exchange) {
        Map<String, Object> task = exchange.getIn().getBody(Map.class);
        String key = (String)task.get("mediaKey");
        return !pendingTasks.containsKey(key);
    }

    public void trackTask(Map<String, Object> task) {
        task.put(OmniConstants.TASK_STATUS, OmniConstants.STATUS_PENDING);
        pendingTasks.put(getKey(task), task);
    }

    public void scheduleTask(@Body String key, 
            @Header(value = OmniConstants.TASK_PROCESS_URI) String bpStart,
            @Header(value = OmniConstants.TASK_TRIGGER_URI) String bpTrigger) {
        Map<String, Object> task = pendingTasks.get(key);
        task.put(OmniConstants.TASK_PROCESS_URI, bpStart);
        task.put(OmniConstants.TASK_TRIGGER_URI, bpTrigger);
        
        // Invoke Baton.verifyFile and the taskId
        String taskId = "0000"; // Baton.verifyFile(...)
        task.put(OmniConstants.TASK_ID, taskId);
        task.put(OmniConstants.TASK_STATUS, OmniConstants.STATUS_SCHEDULED);
    }

    private String getKey(Map<String, Object> task) {
        return (String)task.get("mediaKey");
    }
}
