package com.overflow;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApiCall {
    private String url_string;
    private Object assignment1;

    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public ApiCall() {
        String API_KEY = "6936~L1BVISVpkgsTVWC3eszoBMsAp7uZSZM9yODojytdumMowsr8UsOmSoyh4N4O9E7s";
        url_string = "https://k12.instructure.com/api/v1/users/self/upcoming_events?access_token=" + API_KEY;

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

            Map<String, Object> respMap = jsonToMap(result.toString());

            assignment1 = respMap.get("title");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object return1() {
        return assignment1;
    }

}