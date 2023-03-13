package com.example.hom_dien_tu.model;

public class Thudientu {
    private String language;
    private int size;
    private boolean filter;
    private String signature;

    public Thudientu(String language, int size, boolean filter, String signature) {
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public Thudientu() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
