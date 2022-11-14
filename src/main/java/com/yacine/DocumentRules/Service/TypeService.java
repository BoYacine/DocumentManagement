package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.Type;

import java.util.List;

public interface TypeService {

    Type AddType(Type type);
    MetaData AddMetaData(MetaData metaData);
    Type findTypeByName(String name);
    MetaData findMetaDataByName(String name);
    void AddMetaDataToType(long typeId, long MetaDataId);
    //void AddMetaDataToType(String typeName, String MetaName);
    void AddListMetaDataTotype(String typeName, List<String> metaNames);
    List<MetaData> GetMetaOfType(String name);



}
