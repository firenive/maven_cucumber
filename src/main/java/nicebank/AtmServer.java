package nicebank;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class AtmServer {
    private final Server server;

    public AtmServer(int port) {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new AtmServlet()), "/*");
    }
    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }
    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        new AtmServer(9988).start();
    }
    // mvn compile exec:java -Dexec.mainClass=nicebank.AtmServer


}
