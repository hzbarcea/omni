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


@XmlRootElement(namespace = "http://schemas.datacontract.org/2004/07/Adoniss.Model.Adoniss", name = "GetAutoQCAssets")
@XmlType
public class Asset {

	private String autoQCUrl;
	private String comment;
	private String mediaLocation;
	private Date mediaMovedDate;
	private String mediaName;
	private long status;
	private String mediaNameInLibrary;
	private long idQCitems;
	private long idAssetsQCitems;
	private long idAssetsQCroot;

	@XmlElement(name = "AutoQCUrl")
	public String getAutoQCUrl() {
		return autoQCUrl;
	}
	public void setAutoQCUrl(String autoQCUrl) {
		this.autoQCUrl = autoQCUrl;
	}
	@XmlElement(name = "Comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@XmlElement(name = "MediaLocation")
	public String getMediaLocation() {
		return mediaLocation;
	}
	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}
	@XmlElement(name = "MediaMovedDate")
	public Date getMediaMovedDate() {
		return mediaMovedDate;
	}
	public void setMediaMovedDate(Date mediaMovedDate) {
		this.mediaMovedDate = mediaMovedDate;
	}
	@XmlElement(name = "MediaName")
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	@XmlElement(name = "Status")
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	@XmlElement(name = "c_media_name_in_library")
	public String getMediaNameInLibrary() {
		return mediaNameInLibrary;
	}
	public void setMediaNameInLibrary(String mediaNameInLibrary) {
		this.mediaNameInLibrary = mediaNameInLibrary;
	}
	@XmlElement(name = "id_QC_items")
	public long getIdQCitems() {
		return idQCitems;
	}
	public void setIdQCitems(long idQCitems) {
		this.idQCitems = idQCitems;
	}
	@XmlElement(name = "id_assets_QC_items")
	public long getIdAssetsQCitems() {
		return idAssetsQCitems;
	}
	public void setIdAssetsQCitems(long idAssetsQCitems) {
		this.idAssetsQCitems = idAssetsQCitems;
	}
	@XmlElement(name = "id_assets_root")
	public long getIdAssetsQCroot() {
		return idAssetsQCroot;
	}
	public void setIdAssetsQCroot(long idAssetsQCroot) {
		this.idAssetsQCroot = idAssetsQCroot;
	}

}
