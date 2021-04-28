package com.overflow;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyConnect {
    private String url_string;
    private Object currentGrade;
    private Object assignment1;
    private Object assignment2;
    private Object assignment3;



    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public MyConnect() {
        String API_KEY = "6936~wL5KoYWDF0iXRzn8OtDXEj98IK8mdh1s6Ha3cvXNk9ap28xM3k7QCXgkjyr34t2P";
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

            JSONArray jsonArray = new JSONArray(result.toString());
            Map<String, Object> respMap1 = jsonToMap(jsonArray.getJSONObject(0).toString());
/*            Map<String, Object> respMap2 = jsonToMap(jsonArray.getJSONObject(1).toString());
            Map<String, Object> respMap3 = jsonToMap(jsonArray.getJSONObject(2).toString());*/

            assignment1 = respMap1.get("title");
/*            assignment2 = respMap2.get("title");
            assignment3 = respMap3.get("title");*/

        } catch (IOException | JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object return1() {
        return assignment1;
    }

/*    public Object return2() {
        return assignment2;
    }

    public Object return3() {
        return assignment3;
    }*/

}

