/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.talend.example.omni.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.xmlrpc.XmlRpcConstants;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlrpcClubTest extends CamelSpringTestSupport {
    
    @Test
    @Ignore
    public void testRequestMessage() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:club");
        mock.expectedMessageCount(1);

        // List<String> result = template.requestBodyAndHeader("direct:club", new Object[]{}, XmlRpcConstants.METHOD_NAME, "Tasks.tasksCompleted", List.class);
        // XmlRpcRequest result = template.requestBody("direct:request", new XmlRpcRequestImpl("Tasks.taskInfo", new Object[]{"00000137a00ef4180475d64b000a0004001c009c"}), XmlRpcRequest.class);
        String result = template.requestBodyAndHeader("direct:club", new Object[]{"00000137a00ef4180475d64b000a0004001c009c"}, XmlRpcConstants.METHOD_NAME, "Tasks.report", String.class);

        System.out.println(result);

        assertNotNull(result);
        assertMockEndpointsSatisfied();
        
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("camel/SpringXmlrpcClubTest-context.xml");
    }

}
