package com.baoli.leetcode.tree;

/**
 * @program: common-demo
 * @description: 平衡二叉树
 * @author: li baojian
 * @create: 2020-04-02 13:29
 */
public class TreeNode {
    public int key;
    public String value = "";
    public static TreeNode rootTree = null;
    private TreeNode parent = null;
    private TreeNode left;
    private TreeNode right;

    //私有化空参构造方法  初始化对象必须设置根节点。
    private TreeNode() {

    }

    public TreeNode(int key) {
        this.key = key;
    }

    public TreeNode insert(int key) {
        if (rootTree == null) {
            return rootTree = new TreeNode(key);
        }
        TreeNode currentTree = insertTree(this.rootTree, key);
        return currentTree;
    }

    public boolean delete(int key) {
        if (TreeNode.rootTree == null) {
            return false;
        }
        return deleteTree(TreeNode.rootTree, key);
    }

    private boolean deleteTree(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        TreeNode parent = root.parent;
        if (root.key == key) {
            if (root.right == null && root.right == null) {
                if (parent.right == root) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
                return true;
            }
            if (root.right == null && root.left != null) {
                if (parent.right == root) {
                    parent.right = root.left;
                } else {
                    parent.left = root.left;
                }
                return true;
            }
            if (root.left == null && root.right != null) {
                if (parent.right == root) {
                    parent.right = root.right;
                } else {
                    parent.left = root.right;
                }
                return true;
            }
            TreeNode tree = getLastTreeNode(root.right, key);
            delete(tree.key);
            if (parent.right == root) {
                parent.right.key = tree.key;
                parent.right.value = tree.value;
            } else {
                parent.left.key = tree.key;
                parent.left.value = tree.value;
            }
            return true;
        } else if (root.key > key) {
            return deleteTree(root.left, key);
        } else {
            return deleteTree(root.right, key);
        }
    }

    //获取后继节点
    private TreeNode getLastTreeNode(TreeNode root, int key) {
        if (root.left == null && root.right == null) {
            TreeNode treeNode = root;
            root = null;
            return treeNode;
        } else if (root.left == null && root.right != null) {
            TreeNode node = root;
            root = root.right;
            return node;
        } else {
            return getLastTreeNode(root.left, key);
        }
    }

    public TreeNode getTreeNode(int key) {
        if (rootTree == null) {
            return rootTree;
        }
        TreeNode tree = getTree(rootTree, key);
        return tree;
    }

    public String get(int key) {
        if (rootTree == null) {
            return rootTree.value;
        }
        TreeNode tree = getTree(rootTree, key);
        return tree == null ? "" : tree.value;
    }


    private TreeNode getTree(TreeNode root, int key) {
        if (key == root.key) {
            return root;
        }
        if (key > root.key) {
            if (root.right == null) {
                return null;
            } else {
                if (root.right.key == key) {
                    return root.right;
                } else {
                    return getTree(root.right, key);
                }
            }
        } else {
            if (root.left == null) {
                return null;
            } else {
                if (root.left.key == key) {
                    return root.left;
                } else {
                    return getTree(root.left, key);
                }
            }
        }
    }

    private TreeNode insertTree(TreeNode root, int key) {

        if (key == root.key) {
            return root;
        }
        if (key > root.key) {
            if (root.right == null) {
                root.right = new TreeNode(key);
                root.right.parent = root;
                return root.right;
            } else {
                return insertTree(root.right, key);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(key);
                root.left.parent = root;
                return root.left;
            } else {
                return insertTree(root.left, key);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode tree = treeNode;
        treeNode = null;
        System.out.println(tree.key);
        System.out.println(treeNode);

    }
}
