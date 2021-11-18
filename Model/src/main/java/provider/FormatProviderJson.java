package provider;

import entity.Entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatProviderJson implements IProvider{
    public static final String NEWS = "news";
    public static final String CATEGORY = "category";
    public static final String PATH_NEWS = "news.json";
    public static final String PATH_CATEGORY = "category.json";

    ObjectMapper objectMapper;
    String path;

    public FormatProviderJson(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T extends Entity> T get(String entityName, int id) {
        choosePath(entityName);
        List<T> list = readJson();
        return list.get(id);

    }

    @Override
    public <T extends Entity> List<T> getAll(String entityName) {
        choosePath(entityName);
        return readJson();
    }

    @Override
    public <T extends Entity> void update(String entityName, T item) {
        choosePath(entityName);
        List<T> list = readJson();
        list.set(item.getId(),item);
        writeList(list);
    }

    @Override
    public <T extends Entity> void add(String entityName, T item) {
        choosePath(entityName);
        List<T> list = readJson();
        list.add(item);
        writeList(list);
    }

    @Override
    public <T extends Entity> void delete(String entityName, int id) {
        choosePath(entityName);
        List<T> list = readJson();
        list.remove(id);
        writeList(list);
    }

    @Override
    public <T extends Entity> List<Integer> getIdList(String entityName) {
        choosePath(entityName);
        List<T> list = readJson();
        List <Integer> idList = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            idList.add(list.get(i).getId());
        }
        return idList;
    }

    public <T> List<T> readJson(){
        File file = new File(path);
        try {
            return objectMapper.readValue(file, new TypeReference<List<T>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void writeList(List<T> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(objectMapper.writeValueAsString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choosePath(String entityName){
        if(NEWS.equals(entityName)) {
            path = PATH_NEWS;
        }
        else{
            path = PATH_CATEGORY;
        }
    }
}
