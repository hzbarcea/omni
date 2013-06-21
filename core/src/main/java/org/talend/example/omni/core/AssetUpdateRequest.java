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

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(namespace = "http://schemas.datacontract.org/2004/07/Adoniss.RESTServices", name = "UpdateAssetsQCItemsRequest")
@XmlType
public class AssetUpdateRequest {
    
	private String autoQCUrl;
	private String comment;
	private String items;
	private Date dtStatus;
	private long iStatus;
	private long user;

	@XmlElement(name = "c_auto_QC_URL")
	public String getAutoQCUrl() {
		return autoQCUrl;
	}
	public void setAutoQCUrl(String autoQCUrl) {
		this.autoQCUrl = autoQCUrl;
	}
	@XmlElement(name = "c_comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@XmlElement(name = "c_id_assets_QC_items")
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	@XmlElement(name = "dt_status")
	public Date getDtStatus() {
		return dtStatus;
	}
	public void setDtStatus(Date dtStatus) {
		this.dtStatus = dtStatus;
	}
	@XmlElement(name = "i_status")
	public long getIStatus() {
		return iStatus;
	}
	public void setIStatus(long iStatus) {
		this.iStatus = iStatus;
	}
	@XmlElement(name = "id_adonissuser")
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}

}
