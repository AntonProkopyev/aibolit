// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

class Test {
    public void start() {
        final JndiService jndiService = serviceRegistry
                .getService(JndiService.class);
        final ConnectionFactory jmsConnectionFactory = jndiService
                .locate(jmsConnectionFactoryName);

        this.jmsSession = jmsConnection.createSession(
                true,
                Session.AUTO_ACKNOWLEDGE
        );

		System.out.println("asdasd" + aaa + "34234" + bbb);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);


		Person p = new Person()
          .firstName("Tim")
          .lastName("Smith")
          .age(31);

    }


    public void doNothing() {
        for (int i = 0; i < 10; i++)
                for (int i = 0; i < 10; i++)
                    list.add(Boolean.FALSE);
		CriteriaCollection().instance()
			.addSelect(Criteria.equalTo(XyzCriteria.COLUMN_1, value1))
			.addSelect(Criteria.equalTo(XyzCriteria.COLUMN_2, value2))
			.addSelect(Criteria.isIn(XyzCriteria.COLUMN_3, values3))
			.addOrder(OrderCriteria.desc(XyzCriteria.Order.COLUMN_1));
    }
}
