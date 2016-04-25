package com.example.aaron.islandharvestrefined;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainRouteActivity extends AppCompatActivity {

    private static final String USER_PREFERENCES = "userPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPref = getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "");
        String fullName = sharedPref.getString("fullName", "");

        if (email.equals("") || fullName.equals("")) {
            Intent takeUserToLoginActivity = new Intent(MainRouteActivity.this, LoginActivity.class);
            startActivity(takeUserToLoginActivity);
        } else {
            Toast.makeText(this, email + " " + fullName, Toast.LENGTH_LONG).show();
        }
    }
}
