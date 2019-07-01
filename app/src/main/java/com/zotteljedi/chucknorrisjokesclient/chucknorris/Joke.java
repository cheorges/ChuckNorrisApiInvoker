package com.zotteljedi.chucknorrisjokesclient.chucknorris;

public class Joke {
    private String value;

    public Joke(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
