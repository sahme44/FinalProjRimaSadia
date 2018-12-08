package com.example.sadiaahmed.finalproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);

        Button tiredButton = findViewById(R.id.tiredButton);
        Button boredButton = findViewById(R.id.boredButton);
        Button lostButton = findViewById(R.id.lostButton);
        Button hungryButton = findViewById(R.id.hungryButton);
        tiredButton.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                    openTiredPage();
                }
            });
        boredButton.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                    openBoredPage();
                }
            });
        lostButton.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                    openLostPage();
                }
            });
        hungryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openHungryPage();
            }
            });
        }

        public void openBoredPage() {
            Intent boredIntent = new Intent( MainActivity.this, BoredPage.class);
            startActivity(boredIntent);
        }
        public void openTiredPage() {
            Intent tiredIntent = new Intent( MainActivity.this, TiredPage.class);
            startActivity(tiredIntent);
        }
        public void openLostPage() {
            Intent lostIntent = new Intent( MainActivity.this, LostPage.class);
            startActivity(lostIntent);
        }
        public void openHungryPage() {
            Intent hungryIntent = new Intent( MainActivity.this, HungryPage.class);
            startActivity(hungryIntent);
        }
    }
