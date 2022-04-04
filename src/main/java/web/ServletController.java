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
        
        String action = req.getParameter("action");
        
        if(action != null){
            
            switch(action){
                case "edit":
                    this.updateClient(req, res);
                    break;
                case "delete":
                    this.deleteClient(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
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
                case "modify":
                    this.modifyClient(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
    }
    
    private void deployInfo(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        List<Client> clients = new ClientDao().clientsList();
        
        System.out.println("Clients = " + clients);
        
        HttpSession session = req.getSession();
        
        session.setAttribute("clients", clients);
        
        session.setAttribute("totalClients", clients.size());
        
        session.setAttribute("totalBalance", this.calculateTotalBalance(clients));
        
        res.sendRedirect("clients.jsp");
        
        
    }
    
    private double calculateTotalBalance(List<Client> clients){
        
        double totalBalance = 0;
        
        for(Client client: clients){
            totalBalance += client.getBalance();
        }
        
        return totalBalance;
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
    
    
    private void updateClient(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        int clientId = Integer.parseInt(req.getParameter("clientId"));
        
        Client client = new ClientDao().findClient(new Client(clientId));
        
        req.setAttribute("client", client);
        
        String editJsp = "/WEB-INF/components/client/editClient.jsp";
        
        req.getRequestDispatcher(editJsp).forward(req, res);
        
    }
    
    private void modifyClient(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        int clientId = Integer.parseInt(req.getParameter("clientId"));
        
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
        
        Client client = new Client(clientId, name, surname, email, phone, balance);
        
        int ModifiedRecords = new ClientDao().updateClient(client);
        
        System.out.println("Modified records = " + ModifiedRecords);
        
        this.deployInfo(req, res);
        
    }
    
    private void deleteClient(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        int clientId = Integer.parseInt(req.getParameter("clientId"));
        
        int recordsDeleted = new ClientDao().deleteClient(new Client(clientId));
        
        System.out.println("Records deleted = " + recordsDeleted);
        
        this.deployInfo(req, res);
        
    }
    
}



