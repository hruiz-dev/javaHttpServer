import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.nio.file.Files;

public class ResponseBuilder {

    public static void sendResponse(HttpExchange exchange, File file, int statusCode, String contentType) {
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(statusCode, fileContent.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(fileContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send404Response(HttpExchange exchange, File file) throws IOException{
        sendResponse(exchange, file, 200, "text/html");
    }

    public static void send200Response(HttpExchange exchange, File file) throws IOException{
        sendResponse(exchange, file, 200, "text/html");
    }
}
