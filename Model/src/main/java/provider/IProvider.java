package provider;

import entity.Entity;

import java.util.List;

public interface IProvider {
    <T extends Entity> T get(String name, int id);

    <T extends Entity> List<T> getAll(String name);

    <T extends Entity> void add(String entityName, T t);

    <T extends Entity> void update(String entityName, T t);

    <T extends Entity> void delete(String entityName, int id);

    <T extends Entity> List<Integer> getIdList(String name);
}
