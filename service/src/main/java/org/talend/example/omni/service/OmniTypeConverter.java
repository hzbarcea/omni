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

import java.util.Date;
import java.util.List;

import org.apache.camel.Converter;
import org.talend.example.omni.core.Asset;
import org.talend.example.omni.core.AssetMetadata;
import org.talend.example.omni.core.AssetQcItem;


@Converter
public class OmniTypeConverter {

    @Converter
    public static Asset toAsset(List<String> values) throws Exception {
        Asset result = new Asset();

        // use the values in order, assume correct values in right order
        int index = 0;
        result.setId(toInteger(values, index++));
        result.setUrl(toString(values, index++));
        result.setComment(toString(values, index++));
        result.setLocation(toString(values, index++));
        result.setDateMoved(toDate(values, index++));
        result.setName(toString(values, index++));
        result.setNameInLibrary(toString(values, index++));

        return result;
    }
    
    @Converter
    public static AssetMetadata toAssetMetadata(List<String> values) throws Exception {
        AssetMetadata result = new AssetMetadata();

        // use the values in order, assume correct values in right order
        int index = 0;
        result.setId(toInteger(values, index++));
        result.setAssetId(toInteger(values, index++));
        result.setAssetSubtype(toInteger(values, index++));
        result.setPropertyId(toInteger(values, index++));
        result.setPropertyValue(toString(values, index++));

        return result;
    }

    @Converter
    public static AssetQcItem toAssetQcItem(List<String> values) throws Exception {
        AssetQcItem result = new AssetQcItem();

        // use the values in order, assume correct values in right order
        int index = 0;
        result.setQcid(toInteger(values, index++));
        result.setId(toInteger(values, index++));
        result.setQcitem(toInteger(values, index++));
        result.setQcstatus(toInteger(values, index++));
        result.setUpdateTime(toDate(values, index++));
        result.setUpdateUser(toString(values, index++));

        return result;
    }
    
    private static String toString(List<String> values, int index) {
        return index < values.size() ? values.get(index) : "";
    }

    private static Integer toInteger(List<String> values, int index) {
        try { 
            return Integer.parseInt(toString(values, index));
        } catch (NumberFormatException e) {
            // ignore, will return -1 anyway
        }
        return -1;
    }

    private static Date toDate(List<String> values, int index) {
        String v = toString(values, index);
        if (v.length() > 0) {
            // TODO: parse date
        }
        return null;
    }

}
