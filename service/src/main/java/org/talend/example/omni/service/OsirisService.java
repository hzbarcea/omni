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

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.talend.example.omni.core.Osiris;
import org.talend.example.omni.types.ArrayOfGetAutoQCAssetMetadataResult;
import org.talend.example.omni.types.ArrayOfGetAutoQCAssetsResult;
import org.talend.example.omni.types.ArrayOfUpdateAssetsQCItemsResult;
import org.talend.example.omni.types.GetAutoQCAssetMetadataResult;
import org.talend.example.omni.types.GetAutoQCAssetsResult;
import org.talend.example.omni.types.UpdateAssetsQCItemsRequest;


public class OsirisService implements Osiris {

	private Map<Integer, GetAutoQCAssetsResult> assets = new HashMap<Integer, GetAutoQCAssetsResult>();
	private Map<Integer, GetAutoQCAssetMetadataResult> assetMetadata = new HashMap<Integer, GetAutoQCAssetMetadataResult>();

	public OsirisService() {
		GregorianCalendar now = new GregorianCalendar();

		try {
			GetAutoQCAssetsResult asset = new GetAutoQCAssetsResult();
			asset.setAutoQCUrl("String content");
			asset.setComment("String content");
			asset.setMediaLocation("String content");
			asset.setMediaMovedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(now));
			asset.setMediaName("String content");
			asset.setStatus(2147483646);
			asset.setCMediaNameInLibrary("String content");
			asset.setIdQCItems(2147483646);
			asset.setIdAssetsQCItems(2147483646);
			asset.setIdAssetsRoot(2147483646);
			assets.put(asset.getIdQCItems(), asset);
	
			asset = new GetAutoQCAssetsResult();
			asset.setAutoQCUrl("String content");
			asset.setComment("String content");
			asset.setMediaLocation("String content");
			asset.setMediaMovedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(now));
			asset.setMediaName("String content");
			asset.setStatus(2147483647);
			asset.setCMediaNameInLibrary("String content");
			asset.setIdQCItems(2147483647);
			asset.setIdAssetsQCItems(2147483647);
			asset.setIdAssetsRoot(2147483647);
			assets.put(asset.getIdQCItems(), asset);
		} catch (DatatypeConfigurationException e) {
			// ignore
		}
	}

	public ArrayOfUpdateAssetsQCItemsResult updateItems(UpdateAssetsQCItemsRequest items) throws Exception {
		// TODO: implement me
		return null;
	}

	public ArrayOfGetAutoQCAssetsResult listAssets(String items, String statuses) {
		ArrayOfGetAutoQCAssetsResult result = new ArrayOfGetAutoQCAssetsResult();
		result.getGetAutoQCAssetsResults().addAll(assets.values());
        return result;
	}

	public ArrayOfGetAutoQCAssetMetadataResult listAssetMetadata(long root, String ids) {
		ArrayOfGetAutoQCAssetMetadataResult result = new ArrayOfGetAutoQCAssetMetadataResult();
		result.getGetAutoQCAssetMetadataResults().addAll(assetMetadata.values());
        return result;
	}

}
