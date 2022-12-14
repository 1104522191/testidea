package com.test.controller;

import com.test.model.TreeNode;
import com.test.service.ITreeNodeService;
import com.test.service.impl.TreeNodeServiceImpl;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tree")
public class TreeNodeController {
    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping("/create")
    private JsonResponseBody createMenu(){
        List<TreeNode> menu = treeNodeService.createMenu(null);
        if(null!=menu&&menu.size()>0){
            return new JsonResponseBody(menu);
        }else{
            return new JsonResponseBody(JsonResponseStatus.CREATEMENUFAILE.getCode(),JsonResponseStatus.CREATEMENUFAILE.getMsg());
        }
    }
}
