package nicebank;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BalanceServlet extends HttpServlet {
    private final Account account;

    public BalanceServlet(Account account) {
        this.account = account;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>Balance</title></head>" +
                        "<body><p id=\"message\">Your balance is $" + account.getBalance() + "</p></body></html>"
        );
    }

}
