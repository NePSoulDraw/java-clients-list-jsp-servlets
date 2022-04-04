package data;

import domain.Client;
import java.sql.*;
import java.util.*;
        
public class ClientDao implements IClient{

  private static final String SQL_SELECT_ALL = "SELECT client_id, name, surname, email, phone, balance"  
                                             + " FROM clients";
  
  private static final String SQL_SELECT_BY_ID = "SELECT client_id, name, surname, email, phone, balance"  
                                               + " FROM clients"
                                               + " WHERE client_id = ?";
  
  private static final String SQL_INSERT = "INSERT INTO clients(name, surname, email, phone, balance)"
                                         + " VALUES(?, ?, ?, ?, ?)";
  
  private static final String SQL_UPDATE = "UPDATE clients"
                                         + " SET name = ?, surname = ?, email = ?, phone = ?, balance = ?"
                                         + " WHERE client_id = ?";
  
  private static final String SQL_DELETE = "DELETE FROM clients WHERE client_id = ?";
  
  @Override
  public List<Client> clientsList(){
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      Client client = null;
      
      List<Client> clients = new ArrayList<>();
      
      try {
          conn = SqlConnection.getConnection();
          stmt = conn.prepareStatement(SQL_SELECT_ALL);
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              int clientId = rs.getInt("client_id");
              String name = rs.getString("name");
              String surname = rs.getString("surname");
              String email = rs.getString("email");
              int phone = rs.getInt("phone");
              double balance = rs.getDouble("balance");
              
              client = new Client(clientId, name, surname, email, phone, balance);
              
              clients.add(client);
              
          }
      } catch (SQLException ex) {
          ex.printStackTrace(System.out);
      } finally {
          SqlConnection.close(rs);
          SqlConnection.close(stmt);
          SqlConnection.close(conn);
      }
      
      return clients;
      
  }
  
  @Override
  public Client findClient(Client client){
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      try {
          
          conn = SqlConnection.getConnection();
          
          stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
          stmt.setInt(1, client.getClientId());
          
          rs = stmt.executeQuery();
          if (rs.next()) {
              
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            int phone = rs.getInt("phone");
            double balance = rs.getDouble("balance");
          
            client.setName(name);
            client.setSurname(surname);
            client.setEmail(email);
            client.setPhone(phone);
            client.setBalance(balance);
              
          }
          
      } catch (SQLException ex) {
          ex.printStackTrace(System.out);
      } finally {
          SqlConnection.close(rs);
          SqlConnection.close(stmt);
          SqlConnection.close(conn);
      }
      
      return client;
      
  }
  
  @Override
  public int insertClient(Client client){
      
      Connection conn = null;
      PreparedStatement stmt = null;
      int rows = 0;
      
      try {
          
          conn = SqlConnection.getConnection();
          
          stmt = conn.prepareStatement(SQL_INSERT);
          stmt.setString(1, client.getName());
          stmt.setString(2, client.getSurname());
          stmt.setString(3, client.getEmail());
          stmt.setInt(4, client.getPhone());
          stmt.setDouble(5, client.getBalance());
          
          rows = stmt.executeUpdate();
          
            
      } catch (SQLException ex) {
          ex.printStackTrace(System.out);
      } finally {
          SqlConnection.close(stmt);
          SqlConnection.close(conn);
      }
      
      return rows;
  }
  
  @Override
  public int updateClient(Client client){
      
      Connection conn = null;
      PreparedStatement stmt = null;
      int rows = 0;
      
      try {
          
          conn = SqlConnection.getConnection();
          
          stmt = conn.prepareStatement(SQL_UPDATE);
          stmt.setString(1, client.getName());
          stmt.setString(2, client.getSurname());
          stmt.setString(3, client.getEmail());
          stmt.setInt(4, client.getPhone());
          stmt.setDouble(5, client.getBalance());
          stmt.setInt(6, client.getClientId());
          
          rows = stmt.executeUpdate();
          
            
      } catch (SQLException ex) {
          ex.printStackTrace(System.out);
      } finally {
          SqlConnection.close(stmt);
          SqlConnection.close(conn);
      }
      
      return rows;
      
  }
  
  @Override
  public int deleteClient(Client client){
      
      Connection conn = null;
      PreparedStatement stmt = null;
      int rows = 0;
      
      try {
          
          conn = SqlConnection.getConnection();
          
          stmt = conn.prepareStatement(SQL_DELETE);
          stmt.setInt(1, client.getClientId());
          
          rows = stmt.executeUpdate();
            
      } catch (SQLException ex) {
          ex.printStackTrace(System.out);
      } finally {
          SqlConnection.close(stmt);
          SqlConnection.close(conn);
      }
      
      return rows;
      
  }
  
}
