import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Capital {
    public static void main(String[] args) {
        String china = Capital.getCapital("China");
        System.out.println(china);
    }

    public static String getCapital(String country) {
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + country.replace(" ", "%20"));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = br.readLine();
            Gson gson = new Gson();
            Country countryFromJson = gson.fromJson(line, Country.class);
            return countryFromJson.data.stream().findFirst().map(d -> d.capital).orElse("Not Found");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Country{
        int page, per_page, total, total_pages;
        List<Data> data;
    }
    static class Data{
        String name, capital;
        List<String> callingCodes;
    }
}
