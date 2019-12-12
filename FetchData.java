package com.example.dg;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<String, Void, String> {

    Context ctx;

    FetchData(Context ctx) {
        this.ctx = ctx;
    }



    InputStream is = null;
    String line = null;
    String result = null;

    public String[] driver_id;
    public String[] load_city;
    public String[] discharge_city, volume, weight, quantity, type, status, price;
    public String[] id;
    public String[] owner_id;

    @Override
    protected String doInBackground(String... params) {
        URL url;

        {
            try {
                url = new URL("https://psiproject.herokuapp.com/d_orders.php?driver_id=8");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                is = new BufferedInputStream(httpURLConnection.getInputStream());


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //reading data to string

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();


            } catch (Exception e) {
                e.printStackTrace();
            }

            //Parse to json


        }

        return result;
    }

    @Override
    protected void onPostExecute(String aVoid) {



        // super.onPostExecute(aVoid);
        try {
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;

            id = new String[ja.length()];
            owner_id = new String[ja.length()];
            driver_id = new String[ja.length()];
            load_city = new String[ja.length()];
            discharge_city = new String[ja.length()];
            volume = new String[ja.length()];
            weight = new String[ja.length()];
            quantity = new String[ja.length()];
            type = new String[ja.length()];
            status = new String[ja.length()];
            price = new String[ja.length()];


            for (int i = 0; i <= ja.length(); i++) {
                jo = ja.getJSONObject(i);
                id[i] = jo.getString("id");
                owner_id[i] = jo.getString("owner_id");
                driver_id[i] = jo.getString("driver_id");
                load_city[i] = jo.getString("load_city");
                discharge_city[i] = jo.getString("discharge_city");
                volume[i] = jo.getString("volume");
                weight[i] = jo.getString("weight");
                quantity[i] = jo.getString("quantity");
                type[i] = jo.getString("type");
                status[i] = jo.getString("status");
                price[i] = jo.getString("price");
                //Uzsakymai.discharge_city = this.discharge_city;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
