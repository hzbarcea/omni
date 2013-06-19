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

import org.talend.example.omni.core.Asset;
import org.talend.example.omni.core.AssetList;
import org.talend.example.omni.core.AssetMetadata;
import org.talend.example.omni.core.AssetMetadataList;
import org.talend.example.omni.core.AssetUpdateItemList;
import org.talend.example.omni.core.AssetUpdateRequest;
import org.talend.example.omni.core.Osiris;


public class OsirisService implements Osiris {

	private Map<Long, Asset> assets = new HashMap<Long, Asset>();
	private Map<Long, AssetMetadata> assetMetadata = new HashMap<Long, AssetMetadata>();

	public AssetUpdateItemList updateItems(AssetUpdateRequest items) throws Exception {
		// TODO: implement me
		return null;
	}

	public AssetList listAssets() {
		AssetList assetArray = new AssetList();
		assetArray.setData((Asset[])assets.values().toArray(new Asset[]{}));
        return assetArray;
	}

	public AssetMetadataList listAssetMetadata() {
		AssetMetadataList assetMetadataArray = new AssetMetadataList();
		assetMetadataArray.setData((AssetMetadata[])assetMetadata.values().toArray(new AssetMetadata[]{}));
        return assetMetadataArray;
	}

}
