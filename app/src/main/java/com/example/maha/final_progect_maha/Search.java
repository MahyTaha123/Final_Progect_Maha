package com.example.maha.final_progect_maha;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Search extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
         toolbar = (Toolbar) findViewById(R.id.action1_bar);
        setSupportActionBar(toolbar);



        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

            case R.id.logOut:

                Intent intentforlogin = new Intent(Search.this, LogIn.class);

                break;
                    case R.id.favorits:

                        // code is here
                 break;
                }



                    return true;
            }

        });

    }// main

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return true;
//    }


 //   @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//
//            case android.R.id.:
//
//            default:
//                return true;
//        }
//    }

}//class
