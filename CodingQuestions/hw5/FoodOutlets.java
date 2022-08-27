package api;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodOutlets {

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException, URISyntaxException, InterruptedException {

        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_Address = BASE_URL + "&page=1";

        String resBody = callURL(URL_Address);
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        JsonObject jsonBody = (JsonObject) JsonParser.parseString(resBody);
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        for (int i = 2; i <= total_pages; i++){
            URL_Address = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Address);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }
        return res;
    }



    private static String callURL(String URL_Address) throws IOException, InterruptedException, URISyntaxException {

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(URL_Address))
                .header("User-Agent", "Java HttpClient")
                .header("Accept", "*/*")
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2).build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Map<String, List<String>> headers = httpResponse.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }

        if (httpResponse.statusCode() != 200){
            throw new RuntimeException("bad response");
        }
        return httpResponse.body();
    }

    private static List<String> processData(String resBody, int maxCost){
        List<String> res = new ArrayList<>();

        JsonObject jsonBody = (JsonObject) JsonParser.parseString(resBody);

        JsonArray jsonArray = jsonBody.get("data").get("estimated_cost").getAsInt();
        jsonArray.forEach(d -> {
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if (estimated_cost <= maxCost){
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });
        return res;
    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        List<String> seattle = FoodOutlets.getRelevantFoodOutlets("Seattle", 140);
        System.out.println(seattle);
    }
}
