package factory;

import data_access_object.DaoCategory;
import data_access_object.DaoNews;
import provider.FormatProviderDB;
import provider.FormatProviderJson;
import provider.IProvider;

public class FormatModel extends ModelFactory{

    private IProvider provider;

    @Override
    public DaoNews getDaoNews(int value) {
        if (value == 1) {
            provider = new FormatProviderDB();
        } else {
            provider = new FormatProviderJson();
        }
        return new DaoNews(provider);
    }

    @Override
    public DaoCategory getDaoCategory(int value) {
        if (value == 1) {
            provider = new FormatProviderDB();
        } else {
            provider = new FormatProviderJson();
        }
        return new DaoCategory(provider);
    }
}
