package nicebank;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AtmServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>ATM</title></head>" +
                        "<body><form action=\"/withdraw\" method=\"post\">" +
                        "<label for=\"amount\">Amount</label>" +
                        "<button type=\"submit\" id=\"withdraw20\" name=\"amount\" value=\"20.00\">$20</button>" +
                        "<button type=\"submit\" id=\"withdraw50\" name=\"amount\" value=\"50.00\">$50</button>" +
                        "<button type=\"submit\" id=\"withdraw100\" name=\"amount\" value=\"100.00\">$100</button>" +
                        "<button type=\"submit\" id=\"withdraw200\" name=\"amount\" value=\"200.00\">$200</button></form>" +
                        "<form action=\"/balance\" method=\"get\">" +
                        "<button type=\"submit\" id=\"checkBalance\">Check Balance</button></form>" +
                        "</body></html>"
        );
    }
}
