package com.yacine.DocumentRules.Controller;
import com.yacine.DocumentRules.Entity.Document;
import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.MetaDataValue;
import com.yacine.DocumentRules.Entity.Type;
import com.yacine.DocumentRules.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("document/{id}")
    public Document GetDocumentById(@PathVariable long id) {
      return  documentService.GetDocumentById(id);
    }
    @GetMapping("document/{id}/type")
    public Type GetTypeDocument(@PathVariable Long id) {
        return documentService.GetTypeDocument(id);
    }
    @GetMapping("document/{id}/type/meta")
    public List<MetaData> GetMetadataDocument(@PathVariable Long id) {
        return documentService.GetMetadataDocument(id);
    }
    @GetMapping("document/{id}/type/meta/value")
    public List<MetaDataValue> GetMetadataValueDocument(@PathVariable Long id) {
        return documentService.GetMetadataValueDocument(id);
    }
}
