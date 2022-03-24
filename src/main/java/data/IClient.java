package data;

import domain.Client;
import java.util.List;

public interface IClient {
    
    List<Client> clientsList();
    
    Client findClient(Client client);
    
    int insertClient(Client client);
    
    int updateClient(Client client);
    
    int deleteClient(Client client);
    
}
