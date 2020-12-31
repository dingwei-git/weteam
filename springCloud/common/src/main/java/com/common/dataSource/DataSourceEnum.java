package com.common.dataSource;

public enum DataSourceEnum {

    management("management"),
    demand("demand");


    private String value;

    DataSourceEnum(String value) {
            this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
