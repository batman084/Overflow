package com.api;
//https://restapi100.herokuapp.com/studyGuide

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Api {

    private String url_string;

    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public Api(String a) {
        String API_KEY = a;
        url_string = "https://restapi100.herokuapp.com/studyGuide";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        Date result1;
        Date result2;
        Date result3;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(url_string);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result .append(line);
            }
            rd.close();

        }

}
