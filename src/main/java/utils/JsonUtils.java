package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static String getJsonValue(String jsonFileName, String columnName) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(jsonFileName), JsonObject.class);
            return jsonObject.get(columnName).getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getJsonValues(String jsonFileName, String columnName) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(jsonFileName), JsonObject.class);

            List<String> paymentMethods = new ArrayList<>();
            if (jsonObject.has(columnName)) {
                for (var element : jsonObject.getAsJsonArray(columnName)) {
                    paymentMethods.add(element.getAsString());
                }
            }
            return paymentMethods;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}