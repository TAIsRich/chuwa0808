package apiCall;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.HttpURLConnection;


/**
 * @author Flora Zhong
 * @data 8/22/22
 */

public class FoodOutletsJava8 {
    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException {
        List<String> res = new ArrayList<>();
        String baseURL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String urlAdd = baseURL + "&page=1"; // request parameter: page=1

        // 处理page 1
        String resBody = callURL(urlAdd); // grab info. from response body: locating in Seattle in page 1
        List<String> list = processData(resBody, maxCost);
        res.addAll(list);

        // get the field total_pages of the json object we created
        JsonObject jsonBody = JsonParser.parseString(resBody).getAsJsonObject(); // get info. from response body: locating in Seattle in page 1
                                                                                 // JsonParser.parseString()是Java 11中的方法
        int totalPages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        // 处理剩余page: 2 ~ last
        for (int i = 2; i < totalPages; i++) {
            urlAdd = baseURL + "&page=" + i;
            resBody = callURL(urlAdd);
            list = processData(resBody, maxCost);
            res.addAll(list);
        }
        return res;
    }

    private static String callURL(String urlAdd) throws IOException {
        URL url = new URL(urlAdd); // get the URL type of url address
                                   // automatically cast protocol, host, file, query, authority, path, userinfo...
        HttpURLConnection con = (HttpURLConnection) url.openConnection(); // access the HTTP by HttpURLConnection
                                                                          // method:GET
        /*
        BufferReader minimize the number of I/O operations by reading chunks of characters and storing them in an internal buffer.
        InputStream is an abstract class instead of an interface, which is the super class of all input stream.
        除了特殊的CharArrayReader和StringReader, 普通的Reader实际上是基于InputStream构造的，因为Reader需要从InputStream中读入字节流(byte), 然后根据编码设置再转换为char就可以实现字符流。如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream.
        既然Reader本质上是一个转换InputStream的byte到char的转换器，那么如果我们已经有一个InputStream, 构造一个Reader是完全可行的。InputStreamReader就是这样一个转换器，它可以把任何InputStream的byte转换为char.
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = reader.readLine(); // get info. from the HTTP address in String data type
        return line; // only return response body
    }

    private static List<String> processData(String resBody, int maxCost) {
        List<String> res = new ArrayList<>();
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject(); // convert it into json format
                                                                                 // 将要淘汰、但目前还没淘汰的，在Java 11中成为static method:JsonParser.parseString()
        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray(); // convert the field data of jsonBody into a json array
                                                                     // consider "data" as key, the value is all the info we need
        jsonArray.forEach(d ->{
            int estCost = d.getAsJsonObject().get("estimated_cost").getAsInt(); // jsonArray里面含的不一定是json object, 需要d.getAsJsonObject()

            if (estCost <= maxCost) {
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });
        return res;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        List<String> inSeattle = FoodOutletsJava8.getRelevantFoodOutlets("Seattle", 260);
        System.out.println(inSeattle);
    }
}
