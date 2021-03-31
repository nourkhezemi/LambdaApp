package com.core.lambdaapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import static com.core.lambdaapp.R.id.action_settings;





public class NotHeavyProcessActivity extends AppCompatActivity {



    protected FreezingUIReceiver mReceiver = null;

    private static final String TAG = "NoFreezingActivity";
    protected static final String FREEZYACTION =
            "no freezing";

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver); //take care to unregister
    }

    @Override
    protected void onResume() {
        super.onResume();
        mReceiver = new FreezingUIReceiver();
        registerReceiver(mReceiver, new IntentFilter(FREEZYACTION));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     *
     */
    //

    private void newEvent() {
        Toast.makeText(this, getString(R.string.text_newevent), Toast.LENGTH_LONG ).show();
    }

    /**
     * Launch Intent Broadcast
     */

    private void launchBroadcast() {
        Toast.makeText(this,
                getString(R.string.text_broadcast),Toast.LENGTH_LONG ).show();
        Intent i = new Intent(FREEZYACTION);
        sendBroadcast(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freezing_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case action_settings:
                launchBroadcast();
                return true;
            case R.id.mnunewevent:
                newEvent();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
