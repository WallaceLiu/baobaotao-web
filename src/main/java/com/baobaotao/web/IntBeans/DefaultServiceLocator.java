package com.baobaotao.web.IntBeans;

/**
 * Created by cap on 2017/5/21.
 */
public class DefaultServiceLocator {
    private static CliService cliService = new CliServiceImpl();

    private DefaultServiceLocator() {
    }

    public CliService createClientServiceInstance() {
        return cliService;
    }
}
