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

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.talend.example.omni.core.Asset;
import org.talend.example.omni.core.AssetMetadata;
import org.talend.example.omni.core.AssetQcItem;
import org.talend.example.omni.core.Osiris;
import org.talend.example.omni.core.OsirisLibrary;
import org.talend.example.omni.types.ArrayOfGetAutoQCAssetMetadataResult;
import org.talend.example.omni.types.ArrayOfGetAutoQCAssetsResult;
import org.talend.example.omni.types.ArrayOfUpdateAssetsQCItemsResult;
import org.talend.example.omni.types.GetAutoQCAssetMetadataResult;
import org.talend.example.omni.types.GetAutoQCAssetsResult;
import org.talend.example.omni.types.UpdateAssetsQCItemsRequest;


public class OsirisService implements Osiris {
    private static final String ALL = "*";

    private OsirisLibrary library = new OsirisLibrary();
    // private Map<Integer, GetAutoQCAssetsResult> assets = new HashMap<Integer, GetAutoQCAssetsResult>();
    // private Map<Integer, GetAutoQCAssetMetadataResult> assetMetadata = new HashMap<Integer, GetAutoQCAssetMetadataResult>();

    public OsirisLibrary getLibrary() {
        return library;
    }

    public void setLibrary(OsirisLibrary library) {
        this.library = library;
    }


    public ArrayOfUpdateAssetsQCItemsResult updateItems(UpdateAssetsQCItemsRequest items) throws Exception {
        // TODO: implement me
        return null;
    }

    public ArrayOfGetAutoQCAssetsResult listAssets(String items, String statuses) {
        boolean allItems = ALL.equals(items);
        boolean allStatuses = ALL.equals(statuses);
        Collection<Integer> is = toIntegerSet(items, ",");
        Collection<Integer> ss = toIntegerSet(statuses, ",");
        ArrayOfGetAutoQCAssetsResult result = new ArrayOfGetAutoQCAssetsResult();

        for (Map<Integer, AssetQcItem> qcitems : library.getAssetsQcItems().values()) {
            for (AssetQcItem qci : qcitems.values()) {
                boolean matchItem = allItems || is.contains(qci.getQcitem());
                boolean matchStatus = allStatuses || ss.contains(qci.getQcstatus());
                if (matchItem && matchStatus) {
                    Asset asset = library.findAsset(qci.getId());
                    if (asset != null) {
                        GetAutoQCAssetsResult r = new GetAutoQCAssetsResult();
                        r.setAutoQCUrl(asset.getUrl());
                        r.setComment(asset.getComment());
                        r.setMediaLocation(asset.getLocation());
                        r.setMediaMovedDate(toXml(asset.getDateMoved()));
                        r.setMediaName(asset.getName());
                        r.setStatus(qci.getQcstatus());
                        r.setCMediaNameInLibrary(asset.getNameInLibrary());
                        r.setIdAssetsQCItems(qci.getQcid());
                        r.setIdAssetsRoot(qci.getId());
                        r.setIdQCItems(qci.getQcitem());
                        result.getGetAutoQCAssetsResults().add(r);
                    }
                }
            }
        }
        return result;
    }

    public ArrayOfGetAutoQCAssetMetadataResult listAssetMetadata(int root, String ids) {
        Collection<Integer> is = toIntegerSet(ids, ",");
        ArrayOfGetAutoQCAssetMetadataResult result = new ArrayOfGetAutoQCAssetMetadataResult();
        Map<Integer, AssetMetadata> meta = library.getAssetsMetadata().get(root);
        for (AssetMetadata m : meta.values()) {
            if (is.contains(m.getPropertyId())) {
                GetAutoQCAssetMetadataResult r = new GetAutoQCAssetMetadataResult();
                r.setIdAssets(m.getAssetId());
                r.setIdAssetsRoot(m.getId());
                r.setIdAssetsubtype(m.getAssetSubtype());
                r.setIdObject(m.getPropertyId());
                r.setValue(m.getPropertyValue());
                result.getGetAutoQCAssetMetadataResults().add(r);
            }
        }
        return result;
    }

    private static Collection<String> toStringSet(String value, String delim) {
        String[] vs = value.split(delim);
        HashSet<String> result = new HashSet<String>();
        result.addAll(Arrays.asList(vs));
        return result;
    }

    private static Collection<Integer> toIntegerSet(String value, String delim) {
        String[] vs = value.split(delim);
        HashSet<Integer> result = new HashSet<Integer>(vs.length);
        for (String v : vs) {
            try {
                result.add(Integer.parseInt(v));
            } catch (NumberFormatException e) {
                // Ignore, but in a realistic scenario we may log as warn or, slightly better, info
            }
        }
        return result;
    }
    
    private XMLGregorianCalendar toXml(Date date) {
        return null;
    }

}
