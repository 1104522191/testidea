package com.test.service;

import com.test.model.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ITreeNodeService {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

    List<TreeNode> createMenu(@Param("parentId") Integer parentId);
}
