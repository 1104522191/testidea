package com.test.service.impl;

import com.test.mapper.TreeNodeMapper;
import com.test.model.TreeNode;
import com.test.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;



    @Override
    public int deleteByPrimaryKey(Integer treeNodeId) {
        return 0;
    }

    @Override
    public int insert(TreeNode record) {
        return 0;
    }

    @Override
    public int insertSelective(TreeNode record) {
        return 0;
    }

    @Override
    public TreeNode selectByPrimaryKey(Integer treeNodeId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TreeNode record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TreeNode record) {
        return 0;
    }

    @Override
    public List<TreeNode> createMenu(Integer parentId) {
        List<TreeNode> parent = treeNodeMapper.createMenu(parentId);
        if(parent!=null&&parent.size()>0){
            for (TreeNode treeNode : parent) {
                if(treeNode.getTreeNodeType()!=2){
                    List<TreeNode> children = createMenu(treeNode.getTreeNodeId());
                    treeNode.setChildren(children);
                }
            }
        }
        return parent;
    }
}
