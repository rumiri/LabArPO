package data_access_object;

import java.util.List;

public interface IDao<T> {

    T get(int id);

    List<T> getAll();

    void add(T t);

    void update(T t);

    void delete(int id);

    List<Integer> getIdList();
}
