package com.zotteljedi.chucknorrisjokesclient.chucknorris;

import com.google.gson.Gson;
import com.zotteljedi.chucknorrisjokesclient.androidrestqueue.DataCallback;
import com.zotteljedi.chucknorrisjokesclient.androidrestqueue.RestApiControllerImpl;

import org.json.JSONObject;

public class ChuckNorrisJockFetcher {

    private RestApiControllerImpl controller;
    private Observer observer;

    public ChuckNorrisJockFetcher(RestApiControllerImpl controller, Observer observer) {
        this.controller = controller;
        this.observer = observer;
    }

    public void getRandomJoke() {
        controller.fetchData("https://api.chucknorris.io/jokes/random", new DataCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                Gson gson = new Gson();
                Joke joke = gson.fromJson(result.toString(), Joke.class);
                observer.randomJoke(joke);
            }

            @Override
            public void onError(String error) {
                // TODO: handle Error...
            }
        });
    }
}
