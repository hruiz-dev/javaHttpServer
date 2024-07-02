import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

public class HttpClient implements HttpHandler {

    @Override
    /**
     * Funzio honek zerbitzariak hhtp eskaera bat jasotzen duenean exekutatzen da
     * @param t HttpExchange klaseko objektua prametro gisa jasotzen du, honek eskaera burutu duen klientearen datuak gortzen ditu
     */
    public void handle(HttpExchange t) throws IOException {
        ClientData client = new ClientData();
        Headers headers = t.getRequestHeaders();


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

        File file = FileLoader.getRecurse(client);

        if (file.getName().endsWith("404.html")) {
            ResponseBuilder.send404Response(t, file);
        } else {
            ResponseBuilder.send200Response(t, file);
        }


            t.close();
    }
}