package com.example.sadiaahmed.finalproj;

import android.content.Intent;
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
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class LostPage extends AppCompatActivity {
    public final String TAG = "LOSTPAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lost_page);
        TextView mTextMessage = findViewById(R.id.LostTitle);
        String url = "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1";
        RequestQueue queue;
        queue = Volley.newRequestQueue(this);
        final TextView showActivity = findViewById(R.id.showAdvice);

        Button homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject information = null;
                        JSONObject jsonObject;
                        JSONArray jsonArray;
                        String stringAdvice = null;
                        Log.d(TAG, "Got a response");
                        try {
                            jsonArray = new JSONArray(response);
                            information = new JSONObject(response);
                            stringAdvice = (information.getString("content"));
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                        showActivity.setText(stringAdvice);
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
        Intent homeIntent = new Intent( LostPage.this, MainActivity.class);
        startActivity(homeIntent);
    }
}