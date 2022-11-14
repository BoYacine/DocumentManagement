package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.Document;
import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.MetaDataValue;
import com.yacine.DocumentRules.Entity.Type;

import java.util.List;

public interface DocumentService {



    Document GetDocumentById(long id);
    Type GetTypeDocument(Long id);
    List<MetaData> GetMetadataDocument(Long id);
    List<MetaDataValue> GetMetadataValueDocument(Long id);
    void AddValue(Document document,String [] value);

}
