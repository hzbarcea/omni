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

package org.talend.example.omni.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.talend.example.omni.core.OsirisLibrary;


public class OsirisProvisioningTest extends CamelSpringTestSupport {
    private boolean ignore = true;

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("camel/OsirisProvisioningTest-context.xml");
    }

    @Test
    public void testProvisioning() throws Exception {
        OsirisLibrary library = applicationContext.getBean("osiris-library", OsirisLibrary.class);
        assertNotNull(library);

        if (ignore) {
            return;
        }

        context.startRoute("test-provision-assets");

        MockEndpoint assets = getMandatoryEndpoint("mock:osiris-data", MockEndpoint.class);
        assets.expectedMessageCount(2);

        assertMockEndpointsSatisfied();
        
        MockEndpoint meta = getMandatoryEndpoint("mock:osiris-meta", MockEndpoint.class);
        meta.expectedMessageCount(1);
        MockEndpoint qcitems = getMandatoryEndpoint("mock:osiris-qcitems", MockEndpoint.class);
        qcitems.expectedMessageCount(8);

        context.startRoute("test-provision-metadata");
        context.startRoute("test-provision-qcitems");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testTimer() throws Exception {
        Thread.sleep(5000);
    }
}
