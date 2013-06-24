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

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.talend.example.omni.core.ClubCheck;
import org.talend.example.omni.core.ClubManager;


public class ClubManagerService implements ClubManager {
    private static final Logger LOG = LoggerFactory.getLogger(ClubManagerService.class);
            
    private static final String TASK_ID = "taskId";
    private static final String RESULT = "result";
    private static final String FILE_FORMAT = "fileFormat";
    private static final String ERRORS = "errors";
    private static final String WARNS = "warnings";
    private static final String PRIORITY = "priority";
    private static final String CHECKER = "checker";
    // [...] some more values
    private static final String PROGRESS = "progress";
    private static final String STATUS_DESC = "statusDescription";
    private static final String STATUS = "status";
    private static final String TEST_PLAN = "testPlan";

    private static final AtomicInteger AUTO = new AtomicInteger(0);
    private static final Random RAND = new Random();
    private static final int MAX_IN_PROGRESS = 3;

    private Map<String, Map<String, Object>> tasks = new HashMap<String, Map<String, Object>>();
    private Set<String> progressQueue = new HashSet<String>();



    public String status() {
        step();

        return "ClubManager active. "
            + "Total: " + tasks.size() 
            + ", In Progress: " + progressQueue.size()
            + ", Completed: " + countCompletedTasks();
    }


    public Response addCheck(ClubCheck request) {
        String id = Integer.toHexString(AUTO.incrementAndGet());
        if (request.getMediaFilePath() == null || request.getTestPlan() == null) {
            return Response.status(400).build();
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(request.getMediaFilePath().getBytes());
            md.update(request.getTestPlan().getBytes());

            byte[] mdbytes = md.digest();
            StringBuffer mdhex = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                mdhex.append(Integer.toHexString(mdbytes[i] & 0xff));
            }
            id = mdhex.toString();
        } catch (Exception e) {
            // Ignore, will use the AUTO generated one
        }

        request.setId(id);
        tasks.put(id, createTask(request));
        return Response.ok(id).build();
    }
    
    protected void step() {
        LOG.debug("Club checker making progress...");

        Iterator<String> it = progressQueue.iterator();
        while (it.hasNext()) {
            String id = it.next();
            Map<String, Object> task = tasks.get(id);   // task should not be null
            if (workOnTask(task)) {
                // completed
                it.remove();
            }
        }
        
        // Add some more tasks to the progress queue if there's room left

        int count = MAX_IN_PROGRESS - progressQueue.size();
        for (Map<String, Object> task : tasks.values()) {
            if (count-- <= 0) {
                break;  // queue full
            }
            if (!task.containsKey(PROGRESS)) {
                task.put(PROGRESS, new Integer(0));
                progressQueue.add((String)task.get(TASK_ID));
            }
        }
    }

    private Map<String, Object> createTask(ClubCheck request) {
        Map<String, Object> task = new HashMap<String, Object>();
        task.put(TASK_ID, request.getId());
        task.put(RESULT, "Failure");
        task.put(FILE_FORMAT, "Unknown");
        task.put(ERRORS, new Integer(0));
        task.put(WARNS, new Integer(0));
        task.put(PRIORITY, "Normal");
        task.put(CHECKER, "127.0.0.1:7000");
        // [...] some more values
        task.put(STATUS_DESC, "Some Description");
        task.put(STATUS, "Incomplete");
        task.put(TEST_PLAN, request.getTestPlan());
        
        return task;
    }

    private boolean workOnTask(Map<String, Object> task) {
        int inc = RAND.nextInt(21);    // some random progress 0 -20%
        
        Integer progress = (Integer)task.get(PROGRESS);
        progress += inc;

        if (progress >= 100) {
            progress = 100;
            task.put(RESULT, "Success");
            task.put(STATUS, "Complete");
            // TODO: simulate errors
            return true;
        }
        return false;
    }

    private int countCompletedTasks() {
        int count = 0;
        for (Map<String, Object> task : tasks.values()) {
            Integer percent = (Integer)task.get(PROGRESS);
            count += (percent != null && percent >= 100) ? 1 : 0;
        }
        return count;
    }
}
