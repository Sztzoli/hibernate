package hib;

import static hib.ClientDaoIT.factory;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbDataSource;

public class ClientServiceTest {

    ClientService clientService;
    static EntityManagerFactory factory;

    @BeforeClass
    public static void initFactory() {
        factory = Persistence.createEntityManagerFactory("hibPU");
    }

    @Before()
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/clients?useUnicode=true");
        dataSource.setUser("clients");
        dataSource.setPassword("clients");
        
        clientService = new ClientService(new ClientDtoJDBC(dataSource));
     //   clientService = new ClientService(new ClientDaoHExtend(factory));
    }
    
    @Test
    public void save() {
        Client client = new ClientH();
        client.setId("10");
        client.setName("z");
        client.setAge(10);
        clientService.save(client);
    }
    

}
