package com.zotteljedi.chucknorrisjokesclient.androidrestqueue;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RestApiController extends Application {

    private static final String TAG = RestApiController.class.getSimpleName();
    private static RestApiController instance;
    private RequestQueue requestQueue;
    private Context context;

    public RestApiController(Context context) {
        this.context = context;
        instance = this;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static synchronized RestApiController getInstance() {
        return instance;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public static void fetchData(String url, final DataCallback callback) {
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
        RestApiController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
