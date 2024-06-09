import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class HttpClient implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        ClientData client = new ClientData();
        Headers headers = t.getRequestHeaders();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.getFirst(header));
        }

        client.setUrl(t.getRequestURI().toString());

        Field[] fields = ClientData.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(HeaderMapping.class)) {
                HeaderMapping mapping = field.getAnnotation(HeaderMapping.class);
                String headerName = mapping.value();
                if (headers.containsKey(headerName)) {
                    String headerValue = headers.getFirst(headerName);
                    field.setAccessible(true);
                    try {
                        if (field.getType() == List.class) {
                            field.set(client, List.of(headerValue.split(",")));
                        } else if (field.getType() == int.class) {
                            field.set(client, Integer.parseInt(headerValue));
                        } else {
                            field.set(client, headerValue);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}