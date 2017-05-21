package com.baobaotao.web.IntBeans;

/**
 * Created by cap on 2017/5/21.
 */
public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {
    }

    public static ClientService createInstance() {
        return clientService;
    }

    public void print() {
        System.out.println("ClientService");
    }
}
