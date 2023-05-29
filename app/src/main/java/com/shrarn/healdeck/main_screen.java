package com.shrarn.healdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class main_screen extends AppCompatActivity {

    AppCompatButton btn_profile6;
    AppCompatButton btn_report6;
    AppCompatButton btn_search6;
    AppCompatButton btn_routine6;
    AppCompatButton btn_covid6;
    AppCompatButton btn_phone6;
    AppCompatButton btn_web6;
    AppCompatButton btn_email6;
    AppCompatButton heart_logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btn_profile6=findViewById(R.id.btn_profile5);
        btn_report6=findViewById(R.id.btn_report5);
        btn_search6=findViewById(R.id.btn_search5);
        btn_routine6=findViewById(R.id.btn_routine5);
        btn_covid6=findViewById(R.id.btn_covid5);
        btn_phone6=findViewById(R.id.btn_phone5);
        btn_web6=findViewById(R.id.btn_web5);
        btn_email6=findViewById(R.id.btn_emailr5);
        heart_logo=findViewById(R.id.btn_heart5);


        btn_profile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_screen.this,profile.class);
                startActivity(intent);
            }
        });

        btn_report6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_screen.this,medrep.class);
                startActivity(intent);
            }
        });

        btn_search6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_screen.this,search.class);
                startActivity(intent);
            }
        });

        btn_routine6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_screen.this,routine.class);
                startActivity(intent);
            }
        });

        btn_covid6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_screen.this,covid.class);
                startActivity(intent);
            }
        });

        btn_phone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"102"));
                startActivity(intent);
            }
        });

        btn_web6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://www.google.com/search?q=doctors+near+me&client=opera-gx&hs=Svz&sxsrf=APwXEdeExTomOs4T8lGUDPrl2lKsPOwCdQ%3A1683770893423&ei=DU5cZLy3GcyIjuMPvr-G-AQ&ved=0ahUKEwj88fCvl-z-AhVMhGMGHb6fAU8Q4dUDCA8&uact=5&oq=doctors+near+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIKCAAQigUQsQMQQzIICAAQigUQkQIyCAgAEIoFEJECMggIABCKBRCRAjIICAAQigUQkQIyBwgAEIoFEEMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgQIABBHSgQIQRgAUMkGWMkGYK0LaABwAngAgAHQAYgB0AGSAQMyLTGYAQCgAQHIAQjAAQE&sclient=gws-wiz-serp");

            }
        });

        btn_email6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"arnavs1812@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback for Heal Deck!");
                intent.putExtra(Intent.EXTRA_TEXT,"Hello Team,\n");
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