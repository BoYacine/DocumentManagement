package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.Folder;
import com.yacine.DocumentRules.Entity.User;
import com.yacine.DocumentRules.Repo.FolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    FolderRepo folderRepo;

    @Override
    public Folder saveFolderToUser(Folder folder) {
        return folderRepo.save(folder);
    }

    @Override
    public Folder getFolderForUser(Folder folder) {
        return folderRepo.findByUserIdAndName(folder.getUser().getId(), folder.getName());
    }

    @Override
    public List<Folder> getNodesOfFolder(Long id) {
        return folderRepo.findByPointer(id);
    }

    @Override
    public List<Folder> getTreeOfFolder(Long id) {
        List<Folder> folders=folderRepo.findByUserId(id);
        List<Folder> tree=new ArrayList<>();
        for (Folder folder : folders) {
            if (tree.contains(folder)){
                continue;
            }
            tree.add(folder);
            tree.addAll(folderRepo.findByPointer(folder.getId()));
        }
        return tree;
    }
}
