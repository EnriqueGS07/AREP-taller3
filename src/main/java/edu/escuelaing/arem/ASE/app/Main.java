package edu.escuelaing.arem.ASE.app;

import java.io.IOException;

public class Main {

    /**
     * Metodo que agrega los servicios y corre el servidor
     * @param args
     * @throws IOException
     */
        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.getInstance();
            Spark2 spark2 = Spark2.getInstance();
            RouteHandler handler = (response) -> {
                response.setType("text/html");
                response.setRoute("/index.html");
                response.setRespondeCode(" 202 OK");
                return response.getHeader() + response.getBody();
            };
            spark2.get(handler, "/index.html");
            spark2.post(handler, "/index.html");
            server.run();
        }

}
