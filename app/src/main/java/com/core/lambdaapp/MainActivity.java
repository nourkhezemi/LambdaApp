package com.core.lambdaapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private LockManager lockManager;
    private FaultyView faultyCanvas;
    private StructuresManager structureManager;
    private View LongExecutionView;
    private View LotInstantiationView;
    Timer timer;



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

        setContentView(new LongExecutionView(this));
        //setContentView(new LotInstantiationView(this));

        final Context context = this;

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        alertDialogBuilder.setTitle("Congratulations");

        alertDialogBuilder
                .setMessage("Message")
                .setCancelable(false)
                .setPositiveButton(getString(R.string.nice), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog BoxDialog = alertDialogBuilder.create();

        float[] verts = new float[8];
        verts[0] = 50;
        verts[1] = 30;

        verts[2] = 20;
        verts[3] = 40;

        verts[4] = 2;
        verts[5] = 79;

        verts[6] = 5;
        verts[7] = 40;

        int n = 1000;
        Random r = new Random(1);
        r.nextInt(Integer.MAX_VALUE);

        int[] ranArray = new int[n];
        for (int i = 0; i < n; i++) {
            ranArray[i] = r.nextInt(Integer.MAX_VALUE);
            switch (ranArray[i]) {
                case 1:
                    verts[0] = +1;
                    break;
                case 2:
                    verts[2] = +1;
                    break;
                case 3:
                    verts[4] = +1;
                    break;
                case 4:
                    verts[6] = +1;
                    break;
                case 5:
                    verts[8] = +1;
                    break;
                case 6:
                    verts[10] = +1;
                    break;
                case 7:
                    verts[12] = +1;
                    break;
                case 8:
                    verts[14] = +1;
                    break;
                case 9:
                    verts[16] = +1;
                    break;
                case 10:
                    verts[18] = +1;
                    break;

            }


        }
        System.out.println("Méthode longue");




    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this, LotInstantiationView.class);
            startActivity(intent);
            finish();
        }
    },10000);

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
