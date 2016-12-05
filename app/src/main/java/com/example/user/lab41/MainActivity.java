package com.example.user.lab41;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxEN;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        checkBoxEN = (CheckBox) findViewById(R.id.checkBoxEN);
        textViewName = (TextView) findViewById(R.id.textViewName);
        loadPref();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
* Because it's only ONE option in the menu. In order to make it simple,
* We always start SetPreferenceActivity without checking.
*/
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SetPreferenceActivity.class);
        startActivityForResult(intent, 0);
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadPref();
    }

    private void loadPref() {
        SharedPreferences mySharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        boolean my_checkbox_preference = mySharedPreferences.getBoolean("en", false);
        checkBoxEN.setChecked(my_checkbox_preference);
        String my_edittext_preference = mySharedPreferences.getString("name", "");
        textViewName.setText(my_edittext_preference);
    }
}
