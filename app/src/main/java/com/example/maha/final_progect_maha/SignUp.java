package com.example.maha.final_progect_maha;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp extends AppCompatActivity {

    static final String SHARED_PREF_NAME = "current_user";
    CircleImageView CircleImageView;

    Calendar myCalendar;
    EditText birthDate;

    EditText nameSign;
    EditText emailSign;
    EditText passwordSign;
    Button signUpSUP;
    Button signinSup;
    Button plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

//////////////////////////////////////////////////////////////////////////////////////
        CircleImageView = (CircleImageView) findViewById(R.id.profile_image);

        signUpSUP = (Button) findViewById(R.id.signUpSUP);
        signinSup = (Button) findViewById(R.id.signinSup);
        plus = (Button) findViewById(R.id.plus);

        nameSign = (EditText) findViewById(R.id.NameSign);
        emailSign = (EditText) findViewById(R.id.emailSign);
        passwordSign = (EditText) findViewById(R.id.passwordSign);
        birthDate = (EditText) findViewById(R.id.birthDate);

        /////////// ///// BirthDay edit text/////////////////////////////////////
        myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }


        };

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignUp.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

//////////////////////////////// BUTTONS /////////////////////////////////////////////////////////////////////

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                plus.setVisibility(View.GONE);

                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 10);


            }
        });


        signUpSUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(nameSign.getText().toString(), emailSign.getText().toString(), birthDate.getText().toString(), Integer.parseInt(passwordSign.getText().toString()));
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                Gson gson = new Gson();

                String theUser = gson.toJson(user);
                editor.putString("CurrentU", theUser);

                editor.apply();
                Intent intentForLogIn = new Intent(SignUp.this, LogIn.class);
                startActivity(intentForLogIn);
                finish();

            }
        });


        signinSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentSigInSup = new Intent(SignUp.this, LogIn.class);
                startActivity(intentSigInSup);
                finish();

            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////

    }//main


    ////////////////////////////////method birthday//////////////////////
    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthDate.setText(sdf.format(myCalendar.getTime()));
    }
////////////////////////////////////////////////////////////////////////////
/////////////////////////////Camera  ACTIVITY RESULT //////////////

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 10 && resultCode == RESULT_OK && null != data)

            {
                // The URI of image in content provider
                Uri selectedImage = data.getData();

                //The columns that i want to get from database row
                String[] selectedColumns = {MediaStore.Images.Media.DATA};


                // query and Get result in cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        selectedColumns, null, null, null);


                // Move to first row
                cursor.moveToFirst();

                //Know the index of the column that i want it's data
                int columnIndex = cursor.getColumnIndex(selectedColumns[0]);

                //Get image physical path on my storage from this column
                String imagePath = cursor.getString(columnIndex);

                //close the cursor
                cursor.close();

                CircleImageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));

///////////////SAVE IMAGE PATH///
                SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor edit=shre.edit();
                edit.putString("imagepath",imagePath);
                edit.commit();

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }


}// class
