package com.example.sadiaahmed.finalproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import org.json.JSONException;
import org.json.JSONObject;

public class HungryPage extends AppCompatActivity {
    public final String TAG = "HUNGRYPAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hungry_page);
        String url = "https://www.themealdb.com/api/json/v1/1/random.php";
        RequestQueue queue;
        queue = Volley.newRequestQueue(this);
        final TextView showTitle = findViewById(R.id.showTitle);
        final TextView showInstruc = findViewById(R.id.showLink);
        TextView mTextMessage = findViewById(R.id.HungryTitle);

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
                        String stringInstruc = null;
                        String stringTitle = null;
                        JSONObject jsonObject;
                        JSONArray jsonArray;
                        //String[] responseArray = response.split(",");
                        try {
                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray("meals");
                            information = jsonArray.getJSONObject(0);
                            stringTitle = (information.getString("strMeal"));
                            stringInstruc = (information.getString("strInstructions"));
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                        showTitle.setText(stringTitle);
                        showInstruc.setText(stringInstruc);
                        Log.d(TAG, "Got a response");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "No response");
                showTitle.setText("That didn't work!");
                showInstruc.setText("That didn't work!");
            }
        });
        queue.start();
        queue.add(stringRequest);
    }
    public void openHomePage() {
        Intent homeIntent = new Intent( HungryPage.this, MainActivity.class);
        startActivity(homeIntent);
    }
}