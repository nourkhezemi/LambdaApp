package com.core.lambdaapp;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks2;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LockManager lockManager;
    private FaultyView faultyCanvas;
    private StructuresManager structureManager;
    private View LongExecutionView;
    private View LotInstantiationView;

    protected static List<IMemoryInfo> memInfoList = new ArrayList<IMemoryInfo>();
    protected FreezingUIReceiver mReceiver = null;

    private static final String TAG = "FreezingActivity";
    protected static final String FREEZYACTION =
            "it.gmariotti.android.examples.antipattern.FREEZING_ACTION";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
//Par defaut TrustyView
       super.onCreate(savedInstanceState);
       super.setContentView(new LongExecutionView(this));
       // super.setContentView(new LotInstantiationView(this));
        // super.setContentView(new FaultyView(this));



        }
    public static abstract interface IMemoryInfo {
        public void goodTimeToReleaseMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
//don't compare with == as intermediate stages also can be reported, always better to check >= or <=
        if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            try {
                // Activity at the front will get earliest than activity at the
                // back
                for (int i = memInfoList.size() - 1; i >= 0; i--) {
                    try {
                        memInfoList.get(i).goodTimeToReleaseMemory();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void registerMemoryListener(IMemoryInfo implementor) {
        memInfoList.add(implementor);
    }

    public static void unregisterMemoryListener(IMemoryInfo implementor) {
        memInfoList.remove(implementor);
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
