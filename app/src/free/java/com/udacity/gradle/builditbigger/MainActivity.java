package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.thisobeystudio.jokes_android_lib.ShowJokeActivity;

public class MainActivity extends AppCompatActivity implements AsyncResponse {

    //private final String TAG = MainActivity.class.getSimpleName();

    private View mFragmentView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideProgressBar();

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

        showProgressBar();

        final InterstitialAd mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_test_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
                mInterstitialAd.show();
                hideProgressBar();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
                hideProgressBar();
                startEndPointAsyncTask();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");
                startEndPointAsyncTask();
            }
        });

    }

    private void startEndPointAsyncTask() {

        showProgressBar();

        EndpointsAsyncTask endPointAsyncTask = new EndpointsAsyncTask();
        endPointAsyncTask.delegate = this;
        endPointAsyncTask.execute();

    }

    @Override
    public void processFinish(String joke) {

        hideProgressBar();

        if (joke != null && !joke.isEmpty()) {
            Intent jokeIntent = new Intent(this, ShowJokeActivity.class);
            jokeIntent.putExtra(ShowJokeActivity.INTENT_EXTRA_JOKE, joke);
            startActivity(jokeIntent);
        } else {
            Toast.makeText(MainActivity.this, "ERROR RETRIEVING JOKE", Toast.LENGTH_SHORT).show();
        }

    }

    private void showProgressBar() {

        if (mFragmentView == null) {
            mFragmentView = findViewById(R.id.fragment);
        }

        mFragmentView.setVisibility(View.GONE);

        if (progressBar == null) {
            progressBar = findViewById(R.id.progress_bar);
        }

        progressBar.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar() {

        if (mFragmentView == null) {
            mFragmentView = findViewById(R.id.fragment);
        }

        mFragmentView.setVisibility(View.VISIBLE);

        if (progressBar == null) {
            progressBar = findViewById(R.id.progress_bar);
        }

        progressBar.setVisibility(View.GONE);

    }

}
