package com.thisobeystudio.jokes_android_lib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    private final String TAG = ShowJokeActivity.class.getSimpleName();

    public static final String INTENT_EXTRA_JOKE = "intent_extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() != null && getIntent().hasExtra(ShowJokeActivity.INTENT_EXTRA_JOKE)) {
            setContentView(R.layout.activity_show_joke);
            TextView jokeTextView = findViewById(R.id.joke_text_view);
            String jokeString = getIntent().getStringExtra(ShowJokeActivity.INTENT_EXTRA_JOKE);
            jokeTextView.setText(jokeString);
            Log.e(TAG, "HAS EXTRA intent_extra_joke" + ShowJokeActivity.INTENT_EXTRA_JOKE);
        } else {
            Log.e(TAG, "DOESN'T HAS EXTRA intent_extra_joke" + ShowJokeActivity.INTENT_EXTRA_JOKE);
        }

    }

}
