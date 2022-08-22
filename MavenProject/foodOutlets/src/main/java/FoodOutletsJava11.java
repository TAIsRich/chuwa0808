import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FoodOutletsJava11 {
    public static void main(String[] args) {
        List<String> food = FoodOutletsJava11.getFood("Seattle", 140);
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

        try {
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(urlString))
                    .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
                    .timeout(Duration.ofSeconds(5))
                    .version(HttpClient.Version.HTTP_2).build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
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
