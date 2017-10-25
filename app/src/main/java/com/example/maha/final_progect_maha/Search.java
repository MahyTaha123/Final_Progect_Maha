package com.example.maha.final_progect_maha;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Search extends AppCompatActivity {

    Button logOut;
    Button favorits;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
         toolbar = (Toolbar) findViewById(R.id.action1_bar);
        setSupportActionBar(toolbar);

//////////////////////////////////////////////////////////////////
        logOut = (Button) findViewById(R.id.logOut);
        favorits = (Button) findViewById(R.id.favorits);/// lsaaaaa
///////////////////////////////////////////////////////////////

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForLogin = new Intent(Search.this, LogIn.class);
                startActivity(intentForLogin);
                finish();
            }
        });




    }// main



}//class
