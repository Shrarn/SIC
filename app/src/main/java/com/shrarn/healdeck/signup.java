package com.shrarn.healdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    AppCompatButton btn_signUp3;
    AppCompatButton heartlog;
    AppCompatButton btn_logged3;
    EditText tf_name3;
    EditText tf_dob3;
    EditText tf_sex3;
    EditText tf_emailid3;
    EditText tf_phonenum3;
    EditText tf_passw3;

    DBHelper DB;

    int patientid = 10001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btn_signUp3=findViewById(R.id.btn_signed3);
        btn_logged3=findViewById(R.id.btn_logged3);
        heartlog=findViewById(R.id.btn_heart3);

        tf_name3 = findViewById(R.id.tf_name3);
        tf_dob3 = findViewById(R.id.tf_DOB3);
        tf_sex3 = findViewById(R.id.tf_sex3);
        tf_emailid3 = findViewById(R.id.tf_email3);
        tf_phonenum3 = findViewById(R.id.tf_phoneno3);
        tf_passw3 = findViewById(R.id.tf_pass3);

        DB = new DBHelper(this);

        btn_signUp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this,"Signed Up Successfully!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signup.this,main_screen.class);
                startActivity(intent);
                finish();
            }
        });

        heartlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_logged3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });



    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}