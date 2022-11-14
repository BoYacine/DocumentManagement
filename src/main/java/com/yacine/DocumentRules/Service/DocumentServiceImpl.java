package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.*;
import com.yacine.DocumentRules.Repo.DocumentRepo;
import com.yacine.DocumentRules.Repo.MetaDataValueRepo;
import com.yacine.DocumentRules.Repo.TypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    DocumentRepo documentRepo;
    TypeService typeService;
    MetaDataValueRepo metaDataValueRepo;
    TypeRepo typeRepo;

    @Override
    public Document GetDocumentById(long id) {
        return documentRepo.findById(id).get();
    }

    @Override
    public Type GetTypeDocument(Long id) {
        return documentRepo.findById(id).get().getType();
    }

    @Override
    public List<MetaData> GetMetadataDocument(Long id) {
        return typeService.GetMetaOfType(documentRepo.findById(id).get().getType().getName());
    }

    @Override
    public List<MetaDataValue> GetMetadataValueDocument(Long id) {
        return documentRepo.findById(id).get().getMetaDataValues();
    }

    @Override
    public void AddValue(Document document, String [] value) {
        Type type=typeRepo.findByName(document.getType().getName());
        //value = new String[type.getTypesMetadatas().size()];
        int cp=0;
        for (TypesMetadatas typesMetadata : type.getTypesMetadatas()) {
            MetaDataValue metaDataValue=
            new MetaDataValue(null,value[cp],typesMetadata,document);
            metaDataValueRepo.save(metaDataValue);
            cp++;
        }
    }
}
