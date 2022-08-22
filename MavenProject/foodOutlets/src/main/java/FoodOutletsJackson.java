import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class FoodOutletsJackson {
    public static void main(String[] args) {
        List<String> food = FoodOutletsJackson.getFood("Seattle", 140);
        System.out.println(food);
    }

    public static List<String> getFood(String city, int maxCost) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String firstPageUrl = baseUrl + "&page=1";
        String data = loadData(firstPageUrl);
        int totalPages = getTotalPages(data);
        List<String> restaurants = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            restaurants.addAll(getRestaurants(loadData(baseUrl + "&page=" + i), maxCost));
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FoodOutlet foodOutlet = objectMapper.readValue(data, FoodOutlet.class);
            return foodOutlet.total_pages;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getRestaurants(String data, int maxCost) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FoodOutlet foodOutlet = objectMapper.readValue(data, FoodOutlet.class);
            return foodOutlet.data.stream().filter(d -> d.estimated_cost <= maxCost).map(d -> d.name).collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    static class FoodOutlet {
        @JsonProperty("page")
        int page;

        @JsonProperty("per_page")
        int per_page;

        @JsonProperty("total")
        int total;

        @JsonProperty("total_pages")
        int total_pages;

        @JsonProperty("data")
        List<Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<Data> getData() {
            return data;
        }
    }

    static class Data {
        @JsonProperty("city")
        String city;

        @JsonProperty("name")
        String name;

        @JsonProperty("estimated_cost")
        int estimated_cost;

        @JsonProperty("user_rating")
        UserRating user_rating;

        @JsonProperty("id")
        int id;

        public String getName() {
            return name;
        }

        public int getEstimated_cost() {
            return estimated_cost;
        }
    }

    static class UserRating {
        @JsonProperty("average_rating")
        float average_rating;

        @JsonProperty("votes")
        int votes;
    }
}
