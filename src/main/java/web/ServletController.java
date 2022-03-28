package web;

import domain.Client;
import data.ClientDao;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        List<Client> clients = new ClientDao().clientsList();
        
        System.out.println("Clients = " + clients);
        
        req.setAttribute("clients", clients);
        
        req.setAttribute("totalClients", clients.size());
        
        req.setAttribute("totalBalance", this.calculateTotalBalance(clients));
        
        req.getRequestDispatcher("clients.jsp").forward(req, res);
        
    }
    
    private double calculateTotalBalance(List<Client> clients){
        
        double totalBalance = 0;
        
        for(Client client: clients){
            totalBalance += client.getBalance();
        }
        
        return totalBalance;
    }
    
    
}