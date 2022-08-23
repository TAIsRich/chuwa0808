package exercise.foodOutlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FoodOutletsJava8 {


    public static List<String> getRelevantFoodOutLets11(String city, int maxCost) throws IOException{
        List<String> result = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        //先处理page1?
        String responseBody = callURL(URL_Addr);
        List<String> strings = processData(responseBody, maxCost);
        result.addAll(strings);

        //get total pages
        JasonObject jsonBody = new JsonParser().parse(responseBody).getAsJsonObject();
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        //处理剩余pages, 其实就是重复上面的步骤
        for(int i = 2; i <= total_pages; i++){
            URL_Addr = BASE_URL+ "&page=" + i;
            responseBody = callURL(URL_Addr);
            strings = processData(responseBody, maxCost);
            result.addAll(strings);
        }

        return result;
    }

    private static String callURL(String URL_Addr) throws IOException{
        URL url = new URL(URL_Addr);   //把urlAddr 变成一个url

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = br.readLine();

        return line;
    }

    private static List<String> processData(String responseBody, int maxCost){
        List<String> result = new ArrayList<>();

        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();
        jsonArray.forEach(d -> {
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if(estimated_cost <= maxCost){
                result.add(d.getAsJsonOjbect().get("name").getAsString());
            }
        });
        return result;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        List<String> seattle = FoodOutletsJava8.getRelevantFoodOutLets11("Seattle", 140);
        System.out.println(seattle);
    }
}
