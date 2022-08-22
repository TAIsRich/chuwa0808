public class Solution {

    public static void main(String[] args){

        List<String> seattle = Solution.getRelevenceFoodOutlets("seattle", 100);
        System.out.println(seattle);
    }

    public static List<String> getRelevenceFoodOutlets(String city, int maxCost){

        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        // 处理page 1
        String resBody = callURL(URL_Addr); //callURL helper function defined below
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        // get total_pages
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString()); // get the num of total pages of the json

        // 处理剩余page: 2 - last page
        for (int i = 2; i <= total_pages; i++) {
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

        // only return response body
        return line;
    }

    private static List<String> processData(String resBody, int maxCost) {

        List<String> res = new ArrayList<>();

        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();
        jsonArray.forEach(d -> {
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if (estimated_cost <= maxCost) { //add items to the res list if its cost <= maxCost
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });

        return res;


    }
}
