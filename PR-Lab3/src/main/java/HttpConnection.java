/**
 * Created by nicol on 10.05.2017.
 */
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpConnection http = new HttpConnection();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        System.out.println("Testing 2 - Send Http GET request");
        http.sendHead();

        System.out.println("\nTesting 3 - Send Http POST request");
        http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com/search?q=parallel+programing";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer result = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(result.toString());

    }

    // HTTP HEAD request
    private void sendHead() throws Exception {

        String url = "http://www.google.com/search?q=parallel+programing";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("HEAD");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'HEAD' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//        System.out.println(in);

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://httpbin.org/post/";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "data=data";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
