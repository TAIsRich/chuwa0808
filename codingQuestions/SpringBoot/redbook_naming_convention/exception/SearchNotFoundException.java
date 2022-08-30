package com.chuwa.redbook.exception;

public class SearchNotFoundException extends RuntimeException{
    private String resourceName;
    private String keywordValue;

    public SearchNotFoundException(String resourceName, String keywordValue){
        super(String.format("%s not found with '%s'", resourceName, keywordValue));
        this.resourceName = resourceName;
        this.keywordValue = keywordValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getKeywordValue() {
        return keywordValue;
    }

    public void setKeywordValue(String keywordValue) {
        this.keywordValue = keywordValue;
    }
}
