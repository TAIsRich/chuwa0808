import com.google.gson.Gson;
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
import java.util.stream.Collectors;

public class FoodOutletsGson {
    public static void main(String[] args) {
        List<String> food = FoodOutletsGson.getFood("Seattle", 140);
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
        Gson gson = new Gson();
        FoodOutlet foodOutlet = gson.fromJson(data, FoodOutlet.class);
        return foodOutlet.total_pages;
    }

    public static List<String> getRestaurants(String data) {
        Gson gson = new Gson();
        FoodOutlet foodOutlet = gson.fromJson(data, FoodOutlet.class);
        return foodOutlet.data.stream().map(d -> d.name).collect(Collectors.toList());
    }

    static class FoodOutlet {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<Data> getData() {
            return data;
        }
    }

    static class Data {
        String city;
        String name;
        int estimated_cost;
        UserRating user_rating;
        int id;


        public String getName() {
            return name;
        }

        public int getEstimated_cost() {
            return estimated_cost;
        }
    }

    static class UserRating {
        float average_rating;
        int votes;
    }

}
