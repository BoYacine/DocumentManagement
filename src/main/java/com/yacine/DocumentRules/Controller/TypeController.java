package com.yacine.DocumentRules.Controller;
import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.Type;
import com.yacine.DocumentRules.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("types/{name}")
    public Type findByTypeName(@PathVariable String name){
        return typeService.findTypeByName(name);
    }

    @GetMapping("types/{name}/meta")
    public List<MetaData> GetMetadataOfType(@PathVariable String name){
        return typeService.GetMetaOfType(name);
    }

}
