package com.codegym.model;

public class Settings {
    private String languages;
    private Integer pageSize;
    private String filter;
    private String signature;

    public Settings() {
    }

    public Settings(String languages, Integer pageSize, String filter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "languages='" + languages + '\'' +
                ", pageSize=" + pageSize +
                ", filter='" + filter + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
