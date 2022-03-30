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
        
       this.deployInfo(req, res);
        
    }
    
    private void deployInfo(HttpServletRequest req, HttpServletResponse res) 
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
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        String action = req.getParameter("action");
        
        if(action != null){
            
            switch(action){
                case "insert":
                    this.insertClient(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
                    break;
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
    }
    
    private void insertClient(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        String name = req.getParameter("name");
        
        String surname = req.getParameter("surname");
        
        String email = req.getParameter("email");
        
        int phone = 0;
        
        double balance = 0;
        
        String phoneString = req.getParameter("phone");
        
        String balanceString = req.getParameter("balance");
        
        if(phoneString != null && !"".equals(phoneString)){
            
            phone = Integer.parseInt(phoneString);
            
        }
        
        if(balanceString != null && !"".equals(balanceString)){
            
            balance = Double.parseDouble(balanceString);
            
        }
        
        Client client = new Client(name, surname, email, phone, balance);
        
        int ModifiedRecords = new ClientDao().insertClient(client);
        
        System.out.println("Modified records = " + ModifiedRecords);
        
        this.deployInfo(req, res);
    }
    
    
}
