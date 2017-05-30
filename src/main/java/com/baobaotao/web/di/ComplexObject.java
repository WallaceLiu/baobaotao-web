package com.baobaotao.web.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by cap on 2017/5/30.
 */
public class ComplexObject {
    private java.util.Properties adminEmails;
    private java.util.List someList;
    private java.util.Map someMap;
    private java.util.Set someSet;

    public Properties getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public List getSomeList() {
        return someList;
    }

    public void setSomeList(List someList) {
        this.someList = someList;
    }

    public Map getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }

    public Set getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set someSet) {
        this.someSet = someSet;
    }
}
