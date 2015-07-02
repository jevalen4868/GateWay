package com.fallenman.apps.gateway;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
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

    public void launchApplication(View view) {
        // Get the depressed button.
        Button button = (Button) view;
        // Get context that we are displaying to.
        Context context = getApplicationContext();
        // Get text from button and string resource for app launch
        String appName = (String) button.getText();
        // Load libraries for opening app.
        PackageManager packMan = getPackageManager();
        String fullPackagePath = null;
        switch (appName) {
            case "Sunshine":
                fullPackagePath = getString(R.string.package_sunshine);
                break;
        }
        Intent i = packMan.getLaunchIntentForPackage(fullPackagePath);
        startActivity(i);
        // Toast to our app launch!
        String text = getString(R.string.app_launch) + appName;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        // Display toast!
        toast.show();
    }
}
