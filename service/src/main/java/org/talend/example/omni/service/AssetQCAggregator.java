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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.talend.example.omni.types.GetAutoQCAssetsResult;


public class AssetQCAggregator implements AggregationStrategy {

    @SuppressWarnings("unchecked")
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            GetAutoQCAssetsResult body = newExchange.getIn().getBody(GetAutoQCAssetsResult.class);
            if (body == null) {
                throw new IllegalArgumentException("AssetQCAggregator used in wrong context.");
            }
            String key = body.getMediaLocation();
            Map<String, Object> task = createPendingTask(key);
            addTaskQcItem(task, body.getIdQCItems());
            newExchange.getOut().setBody(task);
            newExchange.getOut().setHeader(OmniConstants.TASK_KEY, key);
            return newExchange;
        }
        if (oldExchange.getIn().getBody() == null
            || oldExchange.getIn().getBody() == null
            || !(oldExchange.getIn().getBody() instanceof Map)
            || !(newExchange.getIn().getBody() instanceof GetAutoQCAssetsResult)) {
            throw new IllegalArgumentException("AssetQCAggregator used in wrong context.");
        }
        Map<String, Object> task = oldExchange.getIn().getBody(Map.class);
        GetAutoQCAssetsResult qc = newExchange.getIn().getBody(GetAutoQCAssetsResult.class);
        addTaskQcItem(task, qc.getIdQCItems());
        return oldExchange;
    }

    public Map<String, Object> createPendingTask(String key) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(OmniConstants.TASK_KEY, key);
        result.put(OmniConstants.TASK_QCITEMS, new HashSet<Integer>());
        return result;
    }

    protected void addTaskQcItem(Map<String, Object> task, int qcItem) {
        Set<Integer> qcItems = getTaskQcItems(task);
        if (qcItems != null) {
            qcItems.add(qcItem);
        }
    }

    @SuppressWarnings("unchecked")
    protected Set<Integer> getTaskQcItems(Map<String, Object> task) {
        return (Set<Integer>) task.get("qcItems");
    }

}
