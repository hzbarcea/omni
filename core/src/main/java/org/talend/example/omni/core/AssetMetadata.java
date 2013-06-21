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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(namespace = "http://schemas.datacontract.org/2004/07/Adoniss.Model.Adoniss", name = "GetAutoQCAssetMetadata")
@XmlType
public class AssetMetadata {

    private String value;
    private long idAssets;
    private long idAssetsRoot;
    private long idAssetSubtype;
    private long idObject;

	@XmlElement(name = "Value")
    public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@XmlElement(name = "id_assets")
	public long getIdAssets() {
		return idAssets;
	}
	public void setIdAssets(long idAssets) {
		this.idAssets = idAssets;
	}
	@XmlElement(name = "id_assets_root")
	public long getIdAssetsRoot() {
		return idAssetsRoot;
	}
	public void setIdAssetsRoot(long idAssetsRoot) {
		this.idAssetsRoot = idAssetsRoot;
	}
	@XmlElement(name = "id_assetsubtype")
	public long getIdAssetSubtype() {
		return idAssetSubtype;
	}
	public void setIdAssetSubtype(long idAssetSubtype) {
		this.idAssetSubtype = idAssetSubtype;
	}
	@XmlElement(name = "id_object")
	public long getIdObject() {
		return idObject;
	}
	public void setIdObject(long idObject) {
		this.idObject = idObject;
	}

}
