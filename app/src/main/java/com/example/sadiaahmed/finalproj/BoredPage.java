package com.example.sadiaahmed.finalproj;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.net.URL;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class BoredPage extends AppCompatActivity {
    public final String TAG = "BOREDPAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bored_page);
        Log.d(TAG, "Got here");
        String url = "https://www.boredapi.com/api/activity/";
        RequestQueue queue;
        queue = Volley.newRequestQueue(this);
        final TextView showActivity = findViewById(R.id.showActivity);
        TextView mTextMessage = findViewById(R.id.BoredTitle);
        Button homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
        Log.d(TAG, "Gets here too");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String information = null;
                        JSONObject jsonObject;
                        Log.d(TAG, "Got a response");
                        try {
                            jsonObject = new JSONObject(response);
                            information = jsonObject.getString("activity");
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                        showActivity.setText(information);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "No response");
                showActivity.setText("That didn't work!");
            }
        });
        queue.start();
        queue.add(stringRequest);
    }
    public void openHomePage() {
        Intent homeIntent = new Intent( BoredPage.this, MainActivity.class);
        startActivity(homeIntent);
    }
}

