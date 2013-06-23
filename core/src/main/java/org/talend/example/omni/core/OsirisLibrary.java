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

package org.talend.example.omni.core;

import java.util.HashMap;
import java.util.Map;


public class OsirisLibrary {

	private Map<Integer, Asset> assets = new HashMap<Integer, Asset>();
	private Map<Integer, Map<Integer, AssetMetadata>> metadata = new HashMap<Integer, Map<Integer, AssetMetadata>>();
	private Map<Integer, Map<Integer, AssetQcItem>> items = new HashMap<Integer, Map<Integer, AssetQcItem>>();


	public Map<Integer, Asset> getAssets() {
		return assets;
	}

	public Map<Integer, Map<Integer, AssetMetadata>> getAssetsMetadata() {
		return metadata;
	}

	public Map<Integer, Map<Integer, AssetQcItem>> getAssetsQcItems() {
		return items;
	}

	public Asset findAsset(int id) {
		return assets.get(id);
	}

	public void addAsset(Asset asset) {
		if (asset != null) {
			assets.put(asset.getId(), asset);
		}
	}

	public void addAssetMetadata(AssetMetadata meta) {
		if (meta != null) {
			Map<Integer, AssetMetadata> data = metadata.get(meta.getId());
			if (data == null) {
				data = new HashMap<Integer, AssetMetadata>();
				metadata.put(meta.getId(), data);
			}
			data.put(meta.getPropertyId(), meta);
		}
	}

	public void addQcItem(AssetQcItem qcItem) {
		if (qcItem != null) {
			Map<Integer, AssetQcItem> data = items.get(qcItem.getId());
			if (data == null) {
				data = new HashMap<Integer, AssetQcItem>();
				items.put(qcItem.getId(), data);
			}
			data.put(qcItem.getQcid(), qcItem);
		}
	}

}
