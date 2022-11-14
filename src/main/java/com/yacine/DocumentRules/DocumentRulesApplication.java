package com.yacine.DocumentRules;

import com.yacine.DocumentRules.Entity.*;
import com.yacine.DocumentRules.Repo.DocumentRepo;
import com.yacine.DocumentRules.Repo.MetaDataValueRepo;
import com.yacine.DocumentRules.Repo.TypeRepo;
import com.yacine.DocumentRules.Repo.TypesMetadatasRepo;
import com.yacine.DocumentRules.Service.DocumentService;
import com.yacine.DocumentRules.Service.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DocumentRulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentRulesApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(TypeService typeService, TypeRepo typeRepo,
							 DocumentRepo documentRepo, MetaDataValueRepo metaDataValueRepo,
							 DocumentService documentService){
		return args -> {

			//Type Management
		Type type=new Type(null,"note",new ArrayList<>(),new ArrayList<>());
		typeService.AddType(type);
		Type type2=new Type(null,"mail",new ArrayList<>(),new ArrayList<>());
		typeService.AddType(type2);

			//MetaData Management
		MetaData metaData=new MetaData(null,"name","txt",null);
		MetaData metaData2=new MetaData(null,"date","Date",null);
		MetaData metaData3=new MetaData(null,"addressMail","txt",null);
		MetaData metaData4=new MetaData(null,"addressDestination","txt",null);
		typeService.AddMetaData(metaData);
		typeService.AddMetaData(metaData2);
		typeService.AddMetaData(metaData3);
		typeService.AddMetaData(metaData4);

			// Type_MetaData Management
/*
			typeService.AddMetaDataToType(1,2);
			typeService.AddMetaDataToType(1,3);
			typeService.AddMetaDataToType(1,4);
			typeService.AddMetaDataToType(2,2);
			typeService.AddMetaDataToType(2,3);
			typeService.AddMetaDataToType(2,4);

			typeService.AddMetaDataToType("note","name");
			typeService.AddMetaDataToType("note","date");

			typeService.AddMetaDataToType("mail","date");
			typeService.AddMetzzaDataToType("mail","addressMail");
			typeService.AddMetaDataToType("mail","addressDestination");
*/
			typeService.AddListMetaDataTotype("note",
											List.of(metaData.getName(), metaData2.getName()));
			typeService.AddListMetaDataTotype("mail",
					List.of(metaData2.getName(), metaData3.getName(),metaData4.getName()));

			Document document = new Document(null,"doc1",type2,new ArrayList<>());
			documentRepo.save(document);


			//get type
			Type typee=typeRepo.findByName(document.getType().getName());
			//List<MetaData> metaDatas=new ArrayList<>();
			typee.getTypesMetadatas().forEach(typesMetadatas ->{
				MetaDataValue metaDataValue=
						new MetaDataValue(null,"value+"+document.getId(),typesMetadatas,document);
						metaDataValueRepo.save(metaDataValue);
						//metaDatas.add(typesMetadatas.getMetaData());
					});
			Document document2 = new Document(null,"doc2",type2,new ArrayList<>());
			documentRepo.save(document2);
			String[] value={"value1","value2","value3"};
			documentService.AddValue(document2,value);
		};

	}
}
