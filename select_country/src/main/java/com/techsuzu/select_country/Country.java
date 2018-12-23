package com.techsuzu.select_country;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private static Process processLisner;

    public static List<Data> getData(Context context, Process process) {
        processLisner = process;
        return converter(new String(Base64.decode(context.getString(R.string.data), Base64.DEFAULT)));
    }

    private static List<Data> converter(String dataString) {
        if (processLisner != null)
            processLisner.started();

        List<Data> dataList = new ArrayList<>();

        try {
            JSONArray list = new JSONArray(dataString);
            for (int i = 0; i < list.length(); i++) {
                JSONObject data = list.getJSONObject(i);
                byte[] decodedString = Base64.decode(data.getString("flag"), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                dataList.add(new Data(data.getString("country"), data.getString("country_code"), data.getString("dialing_code"), Bitmap.createBitmap(decodedByte)));//context.getResources().getIdentifier(, "drawable", context.getPackageName())));
            }

            if (processLisner != null)
                processLisner.success();

        } catch (JSONException e) {
            if (processLisner != null)
                processLisner.failed(e);
        }

        return dataList;
    }

    public interface Process {
        void started();

        void success();

        void failed(Exception e);
    }
}
