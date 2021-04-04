package com.overflow;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class MyConnect {
    private String url_string;
    private Object assignment2;
    private Object assignment1;



    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public void getCalendarEvents() {
        String API_KEY = "6936~IAjWgaDXQMSHj1uTb8MQiFK7TCiDOvp6FPvqjw6TLwsBh9AXiqzncVoVQq46v0py";
        url_string = "https://k12.instructure.com/api/v1/users/self/upcoming_events?access_token=" + API_KEY;
        System.out.println(url_string);

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



            Map<String, Object> results = jsonToMap(result.toString());
            Map<String, Object> task1 = jsonToMap(results.get("0").toString());
            Map<String, Object> task2 = jsonToMap(results.get("1").toString());


            assignment1 = task1.get("title");
          //  assignment2 = task2.get("title");
            System.out.println(assignment1);
         //  System.out.println(assignment2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object return1() {
        return assignment1;
    }

   // public Object return2() {
    //    return assignment2;
   // }


}