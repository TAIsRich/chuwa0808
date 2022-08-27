package ShortQuestions.hw6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class api_call {
    public static void main(String[] args) throws IOException {
        List<String> seattle = api_call.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException {
        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        String resBody = callURL(URL_Addr);
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        for (int i = 2; i <= total_pages; i++){
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }

        return res;
    }

    private static String callURL(String URL_Addr) throws IOException {
        URL url = new URL(URL_Addr);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = br.readLine();

        return line;
    }

    private static List<String> processData(String resBody, int maxCost){
        List<String> res = new ArrayList<>();

        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();
        jsonArray.forEach(
                d -> {
                    int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
                    if (estimated_cost <= maxCost)
                        res.add(d.getAsJsonObject().get("name").getAsString());
                }
        );
        return res;
    }


}
