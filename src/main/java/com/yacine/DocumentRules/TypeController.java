package com.yacine.DocumentRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("types/{name}")
    public Type findByTypeName(@PathVariable String name){
        return typeService.findTypeByName(name);
    }

}
