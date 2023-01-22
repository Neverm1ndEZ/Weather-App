package com.nevermind.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button getCityID, getWeatherByCityID;
    EditText dataInput;
    ListView weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCityID = findViewById(R.id.btn_getCityID);
        getWeatherByCityID = findViewById(R.id.btn_getWeatherByCityID);

        dataInput = findViewById(R.id.et_dataInput);
        weatherReports = findViewById(R.id.ls_weatherReports);

        WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);

        getCityID.setOnClickListener(v -> weatherDataService.getCityID(dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(String Latitude, String Longitude) {
                Toast.makeText(MainActivity.this, "Coordinates: \n Latitude = "+Latitude+"\nLongitude = "+Longitude, Toast.LENGTH_LONG).show();
            }
        }));

        getWeatherByCityID.setOnClickListener(v -> weatherDataService.getCityForecastByID(String.valueOf(dataInput.getText()), new WeatherDataService.ForecastByIDResponse() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(List<WeatherReportModel> weatherReportModels) {
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, weatherReportModels){
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view =super.getView(position, convertView, parent);

                        TextView textView=(TextView) view.findViewById(android.R.id.text1);

                        /*YOUR CHOICE OF COLOR*/
                        textView.setTextColor(Color.WHITE);

                        return view;
                    }
                };

                weatherReports.setAdapter(adapter);
            }
        }));

    }
}