package com.yacine.DocumentRules.Controller;

import com.yacine.DocumentRules.Entity.Folder;
import com.yacine.DocumentRules.Entity.User;
import com.yacine.DocumentRules.Service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class FolderController {

    FolderService folderService;
    @PostMapping("folders")
    public Folder saveFolderToUser(@RequestBody Folder folder){
        return folderService.saveFolderToUser(folder);
    }
    @PostMapping("folders/get")
    public Folder getFolderByName(@RequestBody Folder folder) {
        return folderService.getFolderForUser(folder);
    }
    @GetMapping("folders/nodes/{id}")
    public List<Folder> getNodesOfFolder(@PathVariable Long id) {
        return folderService.getNodesOfFolder(id);
    }
    @GetMapping("folders/tree/{id}")
    public List<Folder> getTreeOfFolder(@PathVariable Long id) {
        return folderService.getTreeOfFolder(id);
    }


}
