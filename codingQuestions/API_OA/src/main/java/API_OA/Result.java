package API_OA;

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Result {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{

        List<String> seattle = Result.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException {
        List<String> res = new ArrayList<>();
        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        //request parameter: page 1
        String URL_Addr = BASE_URL + "&page=1";

        //grab the info from page1
        String resBody = callURL(URL_Addr);

        List<String> strings = processData(resBody, maxCost);

        //get the info from the page1
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        //get the total pages from the json body we created
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        //repeat the steps we've done for the page1
        for(int i = 2; i < total_pages; i++){
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }

        return res;
    }

    public static String callURL(String URL_Addr) throws IOException{
        //get the URL type of url address
        //automatically cast protocol, host, file, query, authority, path, userinfo...
        URL url = new URL(URL_Addr);
        //access the HTTP by HttpURLConnection
        //method:GET
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        /**
         * buffer reader minimize the number of I/O operations by reading chunks of characters and storing them in an internal buffer
         * InputStream is an abstract class instead of an interface, which is the super class of all input stream
         * 除了特殊的CharArrayReader和StringReader，普通的Reader实际上是基于InputStream构造的，因为Reader需要从InputStream中读入字节流（byte），
         * 然后，根据编码设置，再转换为char就可以实现字符流。如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream。
         * 既然Reader本质上是一个基于InputStream的byte到char的转换器，那么，如果我们已经有一个InputStream，想把它转换为Reader，
         * 是完全可行的。InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader
         **/

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        //get the info from the HTTP address in String data type
        String line = br.readLine();

        return line;
    }

    private static List<String> processData(String resBody, int maxCost){
        List<String> res = new ArrayList<>();

        //convert it into json format
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        //convert the jsonBody members with "data" into json array
        // consider "data" as key, the value is all the info we need i.e.data -> {JsonArray@1923} "[{"city":"Seattle","name":"Cafe Juanita","estimated_cost":160,"user_rating":{"average_rating":4.9,"votes":16203},"id":41},{"city":"Seattle","name":"Cafe Munir","estimated_cost":160,"user_rating":{"average_rating":4.9,"votes":4699},"id":42},{"city":"Seattle","name":"Flechazo","estimated_cost":140,"user_rating":{"average_rating":4.8,"votes":2663},"id":43},{"city":"Seattle","name":"Vanilla Sky","estimated_cost":120,"user_rating":{"average_rating":4.6,"votes":645},"id":44},{"city":"Seattle","name":"The Shambles","estimated_cost":110,"user_rating":{"average_rating":4.4,"votes":2116},"id":45},{"city":"Seattle","name":"Stories","estimated_cost":150,"user_rating":{"average_rating":4.5,"votes":2087},"id":46},{"city":"Seattle","name":"Big Pitcher","estimated_cost":180,"user_rating":{"average_rating":4.7,"votes":9011},"id":47},{"city":"Seattle","name":"The Black Pearl","estimated_cost":150,"user_rating":{"average_rating":4.8,"votes":6976},"id":48},{"city":"Seattle","name":"Truffles","estimated_co"
        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();
        jsonArray.forEach(d ->{
           // get the estimate_cost from the array
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            //the cost less than what we're expecting
            //add them into the list
           if(estimated_cost <= maxCost){
               res.add(d.getAsJsonObject().get("name").getAsString());
           }
        });

        return res;
    }
}
