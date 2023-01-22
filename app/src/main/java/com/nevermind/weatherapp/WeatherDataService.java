package com.nevermind.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String TIMELINE = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    public static final String API_KEY_AND_FORMAT = "?unitGroup=metric&include=current&key=Q78KULGXHA9TYLRGWZUKKFGUR&contentType=json";
    public static final String FIRST_PART = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    public static final String KEY = "?unitGroup=metric&elements=datetime%2Ctempmax%2Ctempmin%2Ctemp%2Cfeelslikemax%2Cfeelslikemin%2Cfeelslike%2Cdew%2Chumidity%2Cwindgust%2Cwindspeed%2Csunrise%2Csunset%2Cconditions%2Cdescription&include=current&key=Q78KULGXHA9TYLRGWZUKKFGUR&contentType=json";

    Context context;
    String latitude;
    String longitude;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String Latitude, String Longitude);
    }


    public void getCityID(String cityName, VolleyResponseListener volleyResponseListener) {
        String url = TIMELINE + cityName + API_KEY_AND_FORMAT;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            latitude = "";
            longitude = "";
            try {
                latitude = response.getString("latitude");
                longitude = response.getString("longitude");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(context, "Latitude = " + latitude + "\n Longitude = " + longitude, Toast.LENGTH_SHORT).show();
            volleyResponseListener.onResponse(latitude, longitude);
        }, error -> {
            Toast.makeText(context, "Error Occurred", Toast.LENGTH_SHORT).show();
            volleyResponseListener.onError("System Error Occurred");
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface ForecastByIDResponse {
        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherReportModels);
    }

    public void getCityForecastByID(String cityID, ForecastByIDResponse forecastByIDResponse) {
        List<WeatherReportModel> report = new ArrayList<>();
        String url = FIRST_PART + cityID + KEY;

        //get the json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                JSONArray weather = response.getJSONArray("days");
                for (int i = 0; i < weather.length(); i++) {

                    WeatherReportModel first_day = new WeatherReportModel();
                    JSONObject first_day_from_api = (JSONObject) weather.get(i);
                    first_day.setDate(first_day_from_api.getString("datetime"));
                    first_day.setTemp(first_day_from_api.getLong("temp"));
                    first_day.setTempmax(first_day_from_api.getLong("tempmax"));
                    first_day.setTempmin(first_day_from_api.getLong("tempmin"));
                    first_day.setFeelslike(first_day_from_api.getLong("feelslike"));
                    first_day.setSunrise(first_day_from_api.getString("sunrise"));
                    first_day.setSunset(first_day_from_api.getString("sunset"));
                    first_day.setDescription(first_day_from_api.getString("description"));
                    first_day.setConditions(first_day_from_api.getString("conditions"));
                    report.add(first_day);
                }

                forecastByIDResponse.onResponse(report);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {

        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
