package com.zotteljedi.chucknorrisjokesclient.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zotteljedi.chucknorrisjokesclient.R;
import com.zotteljedi.chucknorrisjokesclient.androidrestqueue.RestApiControllerImpl;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.ChuckNorrisJockFetcher;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.Joke;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestApiControllerImpl controller = new RestApiControllerImpl(getApplicationContext());
        controller.onCreate();

        ChuckNorrisJockFetcher fetcher = new ChuckNorrisJockFetcher(controller, this);
        fetcher.getRandomJoke();
    }

    @Override
    public void randomJoke(Joke joke) {
        TextView txtJoke = findViewById(R.id.txtJoke);
        txtJoke.setText(joke.getValue());
    }
}
