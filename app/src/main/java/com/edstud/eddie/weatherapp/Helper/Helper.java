package com.edstud.eddie.weatherapp.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    static String stream = null;

    public Helper() {
    }

    public String getHTTPData(String urlString){
        //make a request to OpenWeatherMap and get return result
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection.getResponseCode() == 200 ) {  //200 = OK
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ( (line = reader.readLine()) != null){
                    stringBuilder.append(line);
                }

                stream = stringBuilder.toString();
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //just ignore the exception.
        }

        return stream;
    }
}
