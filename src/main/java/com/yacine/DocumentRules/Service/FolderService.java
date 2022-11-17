package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.Folder;
import com.yacine.DocumentRules.Entity.User;

import java.util.List;

public interface FolderService {

    Folder saveFolderToUser(Folder folder);
    Folder getFolderForUser(Folder folder);
    List<Folder> getNodesOfFolder(Long id);
    List<Folder> getTreeOfFolder(Long id);


}
