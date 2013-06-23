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


public class Asset {

    private int id;
    private String url;
    private String comment;
    private String location;
    private Date dateMoved;
    private String name;
    private String nameInLibrary;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDateMoved() {
		return dateMoved;
	}
	public void setDateMoved(Date dateMoved) {
		this.dateMoved = dateMoved;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameInLibrary() {
		return nameInLibrary;
	}
	public void setNameInLibrary(String nameInLibrary) {
		this.nameInLibrary = nameInLibrary;
	}

}
