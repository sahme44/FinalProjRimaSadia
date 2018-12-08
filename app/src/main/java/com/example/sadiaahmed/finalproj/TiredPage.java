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

public class TiredPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tired_page);

        TextView mTextMessage = findViewById(R.id.TiredTitle);

        Button homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }
    public void openHomePage() {
        Intent homeIntent = new Intent( TiredPage.this, MainActivity.class);
        startActivity(homeIntent);
    }
}