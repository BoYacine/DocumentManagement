package com.yacine.DocumentRules;

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
	CommandLineRunner runner(TypeService typeService, TypeRepo typeRepo){
		return args -> {

			//Type Management
		Type type=new Type(null,"note",null);
		typeService.AddType(type);
		Type type2=new Type(null,"mail",null);
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
			// typeService.AddMetaDataToType(1,1);
			/*
			typeService.AddMetaDataToType("note","name");
			typeService.AddMetaDataToType("note","date");

			typeService.AddMetaDataToType("mail","date");
			typeService.AddMetaDataToType("mail","addressMail");
			typeService.AddMetaDataToType("mail","addressDestination");
			*/
			typeService.AddListMetaDataTotype("note",
											List.of(metaData.getName(), metaData2.getName()));
			typeService.AddListMetaDataTotype("mail",
					List.of(metaData2.getName(), metaData3.getName(),metaData4.getName()));

		};
	}
}
