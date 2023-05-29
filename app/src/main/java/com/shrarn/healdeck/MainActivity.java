package com.shrarn.healdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatButton logo;
    AppCompatButton btn_login;
    AppCompatButton btn_signup;
    AppCompatButton btn_phone;
    AppCompatButton btn_website;
    AppCompatButton btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.btn_heart);
        btn_signup=findViewById(R.id.btn_signup);
        btn_login=findViewById(R.id.btn_login);
        btn_phone=findViewById(R.id.btn_phone);
        btn_website=findViewById(R.id.btn_web);
        btn_email=findViewById(R.id.btn_email);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        });

        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"102"));
                startActivity(intent);
            }
        });

        btn_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://www.google.com/search?q=doctors+near+me&client=opera-gx&hs=Svz&sxsrf=APwXEdeExTomOs4T8lGUDPrl2lKsPOwCdQ%3A1683770893423&ei=DU5cZLy3GcyIjuMPvr-G-AQ&ved=0ahUKEwj88fCvl-z-AhVMhGMGHb6fAU8Q4dUDCA8&uact=5&oq=doctors+near+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIKCAAQigUQsQMQQzIICAAQigUQkQIyCAgAEIoFEJECMggIABCKBRCRAjIICAAQigUQkQIyBwgAEIoFEEMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgQIABBHSgQIQRgAUMkGWMkGYK0LaABwAngAgAHQAYgB0AGSAQMyLTGYAQCgAQHIAQjAAQE&sclient=gws-wiz-serp");
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
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