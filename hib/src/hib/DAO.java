
package hib;

import java.util.List;

public interface DAO<T extends Client> {

    T findById(String id);

    List<T> getAll();

    List<T> getClientAfterAge(int age);

    void save(T client);

    void update(T client);
    
}
