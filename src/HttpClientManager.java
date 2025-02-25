import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientManager {
    private static final String RAPID_API_KEY = "f773ded639msh0be96d81c906b26p171a4cjsn4672fc0c776c";
    private static final String RAPID_API_HOST = "exercises-by-api-ninjas.p.rapidapi.com";

    public static String sendGetRequest(String apiUrl, String queryString) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl + queryString))
                    .header("X-RapidAPI-Key", RAPID_API_KEY)
                    .header("X-RapidAPI-Host", RAPID_API_HOST)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
