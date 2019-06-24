package com.zotteljedi.chucknorrisjokesclient.androidrestqueue;

import org.json.JSONObject;

public interface DataCallback {
    void onSuccess(JSONObject result);
    void onError(String error);
}
