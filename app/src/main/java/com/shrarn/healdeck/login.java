package com.shrarn.healdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    AppCompatButton logo_login;
    AppCompatButton btn_eye1;
    AppCompatButton btn_forgot;
    AppCompatButton btn_logged;
    AppCompatButton btn_sign;
    AppCompatButton btn_phone1;
    AppCompatButton btn_web1;
    AppCompatButton btn_email1;
    EditText tf_email;
    EditText tf_password;
    String email;
    String pass;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo_login=findViewById(R.id.btn_heartp);
        btn_eye1=findViewById(R.id.btn_eye);
        btn_forgot=findViewById(R.id.btn_forgotpassword);
        btn_logged=findViewById(R.id.btn_login2);
        btn_sign=findViewById(R.id.btn_signlog);
        btn_phone1=findViewById(R.id.btn_phone1);
        btn_email1=findViewById(R.id.btn_email1);
        btn_web1=findViewById(R.id.btn_web1);
        tf_email=findViewById(R.id.tf_email);
        tf_password=findViewById(R.id.tf_pass);

        DB = new DBHelper(this);



        logo_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        }});

        btn_eye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this,"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this,"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        btn_logged.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                    email = tf_email.getText().toString();
                    pass = tf_password.getText().toString();

                    if (email.equals("") || pass.equals(""))
                    {
                        Toast.makeText(login.this, "Please Fill all the Details", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(email.equalsIgnoreCase("arnavs1812@gmail.com")&&pass.equals("arnavsingh"))
                        {
                            Intent intent = new Intent(login.this,main_screen.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(login.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(login.this, "Incorrect Credentials!", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

        btn_phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"102"));
                startActivity(intent);
            }
        });

        btn_web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://www.google.com/search?q=doctors+near+me&client=opera-gx&hs=Svz&sxsrf=APwXEdeExTomOs4T8lGUDPrl2lKsPOwCdQ%3A1683770893423&ei=DU5cZLy3GcyIjuMPvr-G-AQ&ved=0ahUKEwj88fCvl-z-AhVMhGMGHb6fAU8Q4dUDCA8&uact=5&oq=doctors+near+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIKCAAQigUQsQMQQzIICAAQigUQkQIyCAgAEIoFEJECMggIABCKBRCRAjIICAAQigUQkQIyBwgAEIoFEEMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgQIABBHSgQIQRgAUMkGWMkGYK0LaABwAngAgAHQAYgB0AGSAQMyLTGYAQCgAQHIAQjAAQE&sclient=gws-wiz-serp");

            }
        });

        btn_email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"arnavs1812@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback for Heal Deck!");
                intent.putExtra(Intent.EXTRA_TEXT,"Hello Team,\n");
                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });


    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}