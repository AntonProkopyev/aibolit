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

		obj = new Object();
		obj.ohhhh().set(this.govno("Zh").zhopa(whaaat).concat(whaaat)).opopo(whaaat);
		System.out.println("asdasd" + aaa + "34234" + bbb);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);
		
    }


    public void doNothing() {
        for (int i = 0; i < 10; i++)
                for (int i = 0; i < 10; i++)
                    list.add(Boolean.FALSE);
    }
}