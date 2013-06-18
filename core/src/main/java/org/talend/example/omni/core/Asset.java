/*
 * Copyright 2013 The Fictitions OMNI Corporation
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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(namespace = "http://org.omni", name = "Asset")
@XmlType
public class Asset {
    
	private String autoQCUrl;
	private String comment;
	private String mediaLocation;
	private Date mediaMovedDate;
	private String mediaName;
	private int status;
	private String mediaNameInLibrary;
	private int idQCitems;
	private int idAssetsQCitems;
	private int idAssetsQCroot;

	public String getAutoQCUrl() {
		return autoQCUrl;
	}
	public void setAutoQCUrl(String autoQCUrl) {
		this.autoQCUrl = autoQCUrl;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMediaLocation() {
		return mediaLocation;
	}
	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}
	public Date getMediaMovedDate() {
		return mediaMovedDate;
	}
	public void setMediaMovedDate(Date mediaMovedDate) {
		this.mediaMovedDate = mediaMovedDate;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMediaNameInLibrary() {
		return mediaNameInLibrary;
	}
	public void setMediaNameInLibrary(String mediaNameInLibrary) {
		this.mediaNameInLibrary = mediaNameInLibrary;
	}
	public int getIdQCitems() {
		return idQCitems;
	}
	public void setIdQCitems(int idQCitems) {
		this.idQCitems = idQCitems;
	}
	public int getIdAssetsQCitems() {
		return idAssetsQCitems;
	}
	public void setIdAssetsQCitems(int idAssetsQCitems) {
		this.idAssetsQCitems = idAssetsQCitems;
	}
	public int getIdAssetsQCroot() {
		return idAssetsQCroot;
	}
	public void setIdAssetsQCroot(int idAssetsQCroot) {
		this.idAssetsQCroot = idAssetsQCroot;
	}

}
