package com.zotteljedi.chucknorrisjokesclient.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zotteljedi.chucknorrisjokesclient.R;
import com.zotteljedi.chucknorrisjokesclient.androidrestqueue.RestApiController;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.ChuckNorrisObserver;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.ChuckNorrisRestInvoker;
import com.zotteljedi.chucknorrisjokesclient.chucknorris.Joke;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
