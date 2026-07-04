package nicebank;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class WithdrawalServlet  extends HttpServlet {
    private final CashSlot cashSlot;
    private final Account account;
    public WithdrawalServlet(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teller teller = new AutomatedTeller(cashSlot);
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>" +
                        "<body>Please take your $" + amount + "</body></html>");
    }
}
