package com.zotteljedi.chucknorrisjokesclient.androidrestqueue;

public interface RestApiController {
    void fetchData(String url, final DataCallback callback);
}
