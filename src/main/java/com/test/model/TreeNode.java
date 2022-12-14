package com.test.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNode {
    private Integer treeNodeId;

    private String treeNodeName;

    private Integer treeNodeType;

    private Integer parentNodeId;

    private String url;

    private Integer position;

    private String icon;

    private List<TreeNode> children=new ArrayList<>();
}