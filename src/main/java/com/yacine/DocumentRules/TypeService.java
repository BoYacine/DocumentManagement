package com.yacine.DocumentRules;

import java.util.List;

public interface TypeService {

    Type AddType(Type type);
    MetaData AddMetaData(MetaData metaData);
    Type findTypeByName(String name);
    MetaData findMetaDataByName(String name);
    void AddMetaDataToType(long typeId, long MetaDataId);
    void AddMetaDataToType(String typeName, String MetaName);
    void AddListMetaDataTotype(String typeName, List<String> metaNames);

}
