package api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodOutletsGson {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        List<String> seattle = FoodOutletsGson.getRelevantFoodOutles("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutles(String city, int maxCost) throws IOException, InterruptedException, URISyntaxException {

        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_Address = BASE_URL + "&page=1";

        String resBody = callURL(URL_Address);
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);
        int total_pages = foodOutlet.getTotal_pages();

        for (int i = 2; i <= total_pages; i++) {
            URL_Address = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Address);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }
        return res;
    }

    private static String callURL(String URL_Addr) throws IOException {
        URL url = new URL(URL_Addr);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new
                InputStreamReader(con.getInputStream()));
        String line = br.readLine();

        // only return response body
        return line;
    }

    private static List<String> processData(String resBody, int maxCost) {

        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);

        List<Data> datas = foodOutlet.getData();

        List<String> collect = datas.stream().filter(data -> data.getEstimated_cost() <= maxCost).map(data -> data.getName()).collect(Collectors.toList());

        return collect;
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



