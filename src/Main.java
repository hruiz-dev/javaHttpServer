import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        //HttpServer erabiliz http zerbitzari bat sortu eta 8080 portuan entzuten hasiko da
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // "/" helbidera iritsitako eskaera guztiak HttpClient klasean prozesatuko dira
        server.createContext("/", new HttpClient());
        // hemen zerbitzariren kontestua ejekutatzena ze funtzio ejekutatuko den zehazten da, null denez delfault ejekutatuko da
        server.setExecutor(null);
        // Zerbitzaria abiarazi
        server.start();
    }

}