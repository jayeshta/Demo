package com.apps.demo.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApiManager {

    public static final String Url = "https://playdevelopers.com/api/android/apps/json/auth";
    private String app_package = "com.apps.demo.master";
    private String app_version = "1.0.0";
    private String app_auth = "FGDRG32DS2GVD31VEG1XD2V36EF3D2BV";
    public static ApiManager apiManager = new ApiManager();
    ArrayList<DataModel> dataModels = new ArrayList<>();

    public void getData(final Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    JSONObject jsonObject = object.getJSONObject("response");

                    int app_id = jsonObject.getInt("app_id");
                    String app_name = jsonObject.getString("app_name");
                    String app_package = jsonObject.getString("app_package");
                    String app_version = jsonObject.getString("app_version");
                    String app_ads = jsonObject.getString("app_ads");
                    String app_interstitial = jsonObject.getString("app_interstitial");
                    String app_banner = jsonObject.getString("app_banner");
                    String app_auth = jsonObject.getString("app_auth");
                    String app_status = jsonObject.getString("app_status");

                    //DataModel dataModel = new DataModel(app_id, app_name, app_package, app_version, app_ads, app_interstitial, app_banner, app_auth, app_status);


                    dataModels.add(new DataModel(app_id, app_name, app_package, app_version, app_ads, app_interstitial, app_banner, app_auth, app_status));

//                    SharedPreferences sharedPreferences = context.getSharedPreferences("macncloud", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putInt("key_app_id", dataModel.getApp_id());
//                    editor.putString("key_app_name", dataModel.getApp_name());
//                    editor.putString("key_app_package", dataModel.getApp_package());
//                    editor.putString("key_app_version", dataModel.getApp_version());
//                    editor.putString("key_app_ads", dataModel.getApp_ads());
//                    editor.putString("key_app_interstitial", dataModel.getApp_interstitial());
//                    editor.putString("key_app_banner", dataModel.getApp_banner());
//                    editor.putString("key_app_auth", dataModel.getApp_auth());
//                    editor.putString("key_app_status", dataModel.getApp_status());
//                    editor.apply();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parms = new HashMap<String, String>();
                parms.put("app_package", app_package);
                parms.put("app_version", app_version);
                parms.put("app_auth", app_auth);
                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


}
