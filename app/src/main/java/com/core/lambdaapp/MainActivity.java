package com.core.lambdaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private LockManager lockManager;
    private FaultyView faultyCanvas;
    private StructuresManager structureManager;
    private View LongExecutionView;
    private View LotInstantiationView;
    Timer timer;

    protected FreezingUIReceiver mReceiver = null;

    private static final String TAG = "FreezingActivity";
    protected static final String FREEZYACTION =
            "it.gmariotti.android.examples.antipattern.FREEZING_ACTION";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        structureManager = new StructuresManager();
        lockManager = new LockManager((PowerManager)getSystemService(Context.POWER_SERVICE));
        lockManager.acquire();
        lockManager.release();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // setContentView(new LongExecutionView(this));
        //setContentView(new LotInstantiationView(this));



        }


    @Override
    protected void onPause() {
        System.out.println("Petite pause");
        super.onPause();
        unregisterReceiver(mReceiver);

    }
    @Override
    protected void onResume() {
        super.onResume();
        mReceiver = new FreezingUIReceiver();
        registerReceiver(mReceiver, new IntentFilter(FREEZYACTION));
        System.out.println("OnResume");
    }
    @Override
    protected void onStop() {
        System.out.println("On stop tout");
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        System.out.println("Au revoir");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @SuppressLint("WrongConstant")
    private void newEvent() {
        Toast.makeText(this, getString(R.string.text_newevent), 1000).show();
        System.out.println("newEvent");
    }

    /**
     * Launch Intent Broadcast
     */
    @SuppressLint("WrongConstant")
    private void launchBroadcast() {
        Toast.makeText(this, getString(R.string.text_broadcast), 1000).show();
        Intent i = new Intent(FREEZYACTION);
        sendBroadcast(i);
        System.out.println("Launch brodcast");
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
        if(id == R.id.mnuRefresh) {

            return true;

        }
        if(id == R.id.mnunewevent) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }




}
