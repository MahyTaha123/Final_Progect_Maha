package com.example.maha.final_progect_maha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import static com.example.maha.final_progect_maha.SignUp.SHARED_PREF_NAME;

public class LogIn extends AppCompatActivity {

    EditText userEmailLog;
    EditText passwordLog;
    Button signInLog;
    Button signUplog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

// hid action  bar
        getSupportActionBar().hide();
        ////*********************************************////
        userEmailLog = (EditText) findViewById(R.id.userNameLog);
        passwordLog = (EditText) findViewById(R.id.passwordLog);
        signInLog = (Button) findViewById(R.id.signInLog);

/////////////////////////////SIGN In LOG////////////////////////////////////

        signInLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uEmail = userEmailLog.getText().toString();
                int uPassword = Integer.parseInt(passwordLog.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                String xyz = sharedPreferences.getString("CurrentU", "no user");
                Gson gson = new Gson();
                User finalUser = gson.fromJson(xyz,User.class);
                if (uEmail.equals(finalUser.getEmail())&& uPassword==finalUser.getPassword() ) {

                    Intent IntentForSearch = new Intent(LogIn.this, Search.class);
                    startActivity(IntentForSearch);
                    finish();


                } else {

                    Toast.makeText(LogIn.this,"Not Vlaid",Toast.LENGTH_LONG).show();
                }


            }
        });


        ////////////////////////SIGN UP LOG IN////////////////
        signUplog = (Button) findViewById(R.id.signUpLog);

        signUplog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
                finish();

            }
        });

    }//main


}//class
