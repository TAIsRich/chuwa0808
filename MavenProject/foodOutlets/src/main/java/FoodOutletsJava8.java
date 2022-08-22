import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FoodOutletsJava8 {
    public static void main(String[] args) {
        List<String> food = FoodOutletsJava8.getFood("Seattle", 140);
        System.out.println(food);
    }

    public static List<String> getFood(String city, int maxCost) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String firstPageUrl = baseUrl + "&page=1";
        String data = loadData(firstPageUrl);
        int totalPages = getTotalPages(data);
        List<String> restaurants = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            restaurants.addAll(getRestaurants(loadData(baseUrl + "&page=" + i)));
        }
        return restaurants;
    }

    public static String loadData(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return br.readLine();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getTotalPages(String data) {
        JsonObject jsonObject = new JsonParser().parse(data).getAsJsonObject();
        return jsonObject.get("total_pages").getAsInt();
    }

    public static List<String> getRestaurants(String data) {
        JsonObject jsonObject = new JsonParser().parse(data).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
        List<String> restaurants = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            restaurants.add(jsonArray.get(i).getAsJsonObject().get("name").getAsString());
        }
        return restaurants;
    }
}
