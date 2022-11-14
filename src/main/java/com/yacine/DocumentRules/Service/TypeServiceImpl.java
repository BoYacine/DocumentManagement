package com.yacine.DocumentRules.Service;
import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.Type;
import com.yacine.DocumentRules.Entity.TypesMetadatas;
import com.yacine.DocumentRules.Repo.MetaDataRepo;
import com.yacine.DocumentRules.Repo.TypeRepo;
import com.yacine.DocumentRules.Repo.TypesMetadatasRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TypeServiceImpl implements TypeService {

    TypeRepo typeRepo;
    MetaDataRepo metaDataRepo;
    TypesMetadatasRepo typesMetadatasRepo;

    @Override
    public Type AddType(Type type) {
        return typeRepo.save(type);
    }

    @Override
    public MetaData AddMetaData(MetaData metaData) {
        return metaDataRepo.save(metaData);
    }

    @Override
    public Type findTypeByName(String name) {
        return typeRepo.findByName(name);
    }

    @Override
    public MetaData findMetaDataByName(String name) {
        return metaDataRepo.findByname(name);
    }

    @Override
    public void AddMetaDataToType(long typeId, long MetaDataId) {
        Type type=typeRepo.findById(typeId).get();
        MetaData metaData=metaDataRepo.findById(MetaDataId).get();
        TypesMetadatas typesMetadatas= new TypesMetadatas(null,type,metaData,null);
        typesMetadatasRepo.save(typesMetadatas);
        }
/*
    @Override
    public void AddMetaDataToType(String typeName, String MetaName) {
        Type type=typeRepo.findByName(typeName);
        MetaData metaData=metaDataRepo.findByname(MetaName);
        if (type.getMetaData()!=null) {
            type.getMetaData().add(metaData);
            metaData.getTypes().add(type);
        }
    }
*/
    @Override
    public void AddListMetaDataTotype(String typeName, List<String> metaNames) {
        Type type=typeRepo.findByName(typeName);
        List<MetaData> metaData= new ArrayList<>();
        metaNames.forEach(name -> metaData.add(findMetaDataByName(name)));
        metaData.forEach(meta -> {
            TypesMetadatas typesMetadatas= new TypesMetadatas(null,type,meta,null);
            typesMetadatasRepo.save(typesMetadatas);
        } );
    }

    @Override
    public List<MetaData> GetMetaOfType(String name) {
        Type type=typeRepo.findByName(name);
        List<MetaData> metaDatas=new ArrayList<>();
        type.getTypesMetadatas().forEach(typesMetadatas ->
                metaDatas.add(typesMetadatas.getMetaData()));
        return metaDatas;
    }


}
