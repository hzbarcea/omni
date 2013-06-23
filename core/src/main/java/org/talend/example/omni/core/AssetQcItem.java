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


public class AssetQcItem {

    private int id;				// id_assets_root
    private int qcid;			// id_assets_QC_items
    private int qcitem;			// id_QC_items
    private int qcstatus;		// Status
    private Date updateTime;	// UpdateTime
    private String updateUser;	// UpdateUser

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQcid() {
		return qcid;
	}
	public void setQcid(int qcid) {
		this.qcid = qcid;
	}
	public int getQcitem() {
		return qcitem;
	}
	public void setQcitem(int qcitem) {
		this.qcitem = qcitem;
	}
	public int getQcstatus() {
		return qcstatus;
	}
	public void setQcstatus(int qcstatus) {
		this.qcstatus = qcstatus;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
