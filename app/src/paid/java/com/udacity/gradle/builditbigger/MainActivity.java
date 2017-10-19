package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.thisobeystudio.jokes_android_lib.ShowJokeActivity;

public class MainActivity extends AppCompatActivity implements AsyncResponse {

    private ProgressBar progressBar;
    private View mFragmentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("UnusedParameters")
    public void tellJoke(View view) {

        if (mFragmentView == null) {
            mFragmentView = findViewById(R.id.fragment);
        }

        mFragmentView.setVisibility(View.GONE);

        if (progressBar == null) {
            progressBar = findViewById(R.id.progress_bar);
        }

        progressBar.setVisibility(View.VISIBLE);

        EndpointsAsyncTask endPointAsyncTask = new EndpointsAsyncTask();
        endPointAsyncTask.delegate = this;
        endPointAsyncTask.execute();

    }

    @Override
    public void processFinish(String joke) {

        if (mFragmentView != null) {
            mFragmentView.setVisibility(View.VISIBLE);
        } else {
            mFragmentView = findViewById(R.id.fragment);
            mFragmentView.setVisibility(View.VISIBLE);
        }

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);
        }

        //Toast.makeText(MainActivity.this, "output = " + joke, Toast.LENGTH_SHORT).show();

        if (joke != null && !joke.isEmpty()) {
            Intent jokeIntent = new Intent(this, ShowJokeActivity.class);
            jokeIntent.putExtra(ShowJokeActivity.INTENT_EXTRA_JOKE, joke);
            startActivity(jokeIntent);
        } else {
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }

    }

}
