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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.talend.example.omni.types.ArrayOfGetAutoQCAssetMetadataResult;
import org.talend.example.omni.types.ArrayOfGetAutoQCAssetsResult;
import org.talend.example.omni.types.ArrayOfUpdateAssetsQCItemsResult;
import org.talend.example.omni.types.UpdateAssetsQCItemsRequest;


@Path("/AdonissRESTService")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public interface Osiris {

    @PUT
	@Path("/UpdateAssetsQCItems")
    ArrayOfUpdateAssetsQCItemsResult updateItems(UpdateAssetsQCItemsRequest items) throws Exception;

	@GET
	@Path("/GetAutoQCAssets/{items}/{statuses}")
	ArrayOfGetAutoQCAssetsResult listAssets(@PathParam("items") String items, @PathParam("statuses") String statuses);

	@GET
	@Path("/GetAutoQCAssetMetadata/{root}/{obids}")
	ArrayOfGetAutoQCAssetMetadataResult listAssetMetadata(@PathParam("root") long root, @PathParam("obids") String ids);

}
