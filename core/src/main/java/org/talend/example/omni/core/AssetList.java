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


@XmlRootElement(namespace = "http://schemas.datacontract.org/2004/07/Adoniss.Model.Adoniss", name = "ArrayOfGetAutoQCAssets_Result")
@XmlType
public class AssetList {

	private Asset[] data;

	@XmlElement(name = "GetAutoQCAssets_Result")
    public Asset[] getData() {
		return data;
	}
	public void setData(Asset[] value) {
		this.data = value;
	}

}
