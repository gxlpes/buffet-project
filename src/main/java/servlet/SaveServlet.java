package servlet;

import bean.ClientBean;
import entity.Client;
import repository.ClientRepository;

import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static calc.Price.*;

@WebServlet(name = "SaveServlet", value = "/value")
public class SaveServlet extends HttpServlet {

    ClientRepository clientRepository = new ClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ClientRepository.setup();
        Client clientTest = null;

        try {
            clientTest = ClientRepository.getClient(id);
            ClientBean.getData(clientTest);
        } catch (Exception e) {
           throw new ServletException("Error page", e);
        } finally {
            response.sendRedirect("../pages/resultado.xhtml");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String client = request.getParameter("client");
        int guests = Integer.parseInt(request.getParameter("guests"));
        String desert = request.getParameter("desert");
        if (desert == (null)) desert = "Não";

        double priceGuest = priceGuest(guests, desert);
        double priceGuests = priceGuests(guests, priceGuest);
        int countWaiter = countWaiter(guests);
        double priceWaiters = priceWaiter(countWaiter);
        double priceTotal = priceTotal(guests, priceGuest, priceWaiters);

        Client clientData = new Client();
        clientData.setId(id);
        clientData.setClient(client);
        clientData.setGuests(guests);
        clientData.setWaiters(countWaiter);
        clientData.setDesert(desert);
        clientData.setPriceGuest(priceGuest);
        clientData.setPriceGuests(priceGuests);
        clientData.setPriceWaiters(priceWaiters);
        clientData.setPriceTotal(priceTotal);

        ClientRepository.setup();
        clientRepository.salvar(clientData);
        ClientBean.getData(clientData);

        response.sendRedirect("../pages/resultado.xhtml");
    }
}