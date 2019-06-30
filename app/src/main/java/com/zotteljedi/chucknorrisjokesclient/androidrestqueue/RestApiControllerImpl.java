package com.zotteljedi.chucknorrisjokesclient.androidrestqueue;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RestApiControllerImpl extends Application implements RestApiController {

    private static final String TAG = RestApiControllerImpl.class.getSimpleName();
    private static RestApiControllerImpl instance;
    private RequestQueue requestQueue;
    private Context context;

    public RestApiControllerImpl(Context context) {
        this.context = context;
        instance = this;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static synchronized RestApiControllerImpl getInstance() {
        return instance;
    }

    private <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void fetchData(String url, final DataCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.getMessage());
            }
        });
        RestApiControllerImpl.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
