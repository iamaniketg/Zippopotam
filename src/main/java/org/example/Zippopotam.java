package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zippopotam {
    public static void main(String[] args){
        try{
            URL url = new URL("https://api.zippopotam.us/us/33162");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "Application/json");
            if(con.getResponseCode()!=200){
                throw new RuntimeException("Failed: HTTP code is:"+
                        con.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((
                    con.getInputStream())));
            String output;
            System.out.println("Output from server is.....");
            while ((output=br.readLine())!=null){
                System.out.println(output);
            }
            con.disconnect();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
