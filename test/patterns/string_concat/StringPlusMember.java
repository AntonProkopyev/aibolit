// SPDX-FileCopyrightText: Copyright (c) 2019-2025 CQFN.org
// SPDX-License-Identifier: MIT

class Test {
public void start() {
final JndiService jndiService = serviceRegistry
.getService(JndiService.class);
final ConnectionFactory jmsConnectionFactory = jndiService
.locate(jmsConnectionFactoryName);

this.jmsConnection = jmsConnectionFactory.createConnection();
this.jmsSession = jmsConnection.createSession(
true,
Session.AUTO_ACKNOWLEDGE
);
list = new ArrayList<>();
for (int i = 0; i < 10; i++)
for (int i = 0; i < 10; i++)
list.add(Boolean.FALSE);
"Another String" + sizeMinusOne;
for (int i = 0; i < 10; i++)
for (int i = 0; i < 10; i++)
list.add(Boolean.FALSE);
final Destination destination = jndiService.locate(destinationName);

this.publisher = jmsSession.createProducer(destination);
}
}
