package com.core.lambdaapp;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private StructuresManager structureManager;
    private LockManager lockManager;
    private FaultyView faultyCanvas;

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
        setContentView(new LotInstantiationView(this ));
        setContentView(new LongExecutionView(this));
        setContentView(new FaultyView(this));


        //faultyCanvas = (FaultyView) findViewById(R.id.faulty_canvas);
    }

    @Override
    protected void onPause() {
        System.out.println("Petite pause");
        super.onPause();

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

}
