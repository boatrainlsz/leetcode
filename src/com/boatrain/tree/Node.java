package com.boatrain.tree;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder ans = new StringBuilder();
        if (root == null) return ans.toString();
        List<Node> children = root.children;
        if (children == null) {
            return ans.toString() + root.val;
        }
        if (children.size() != 0) {
            ans.append(root.val).append("[");
            for (int i = 0; i < children.size(); i++) {
                ans.append(serialize(children.get(i)));
                if (i != children.size() - 1) {
                    ans.append("#");
                }
            }
            ans.append("]");
        }
        ans.append(",");
        return ans.deleteCharAt(ans.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] split = data.split(",");
        Node root = new Node(Integer.parseInt(split[0]));
        return root;
    }

    private Node decode(String nodeStr) {
        if (isDigit(nodeStr)) {
            return new Node(Integer.parseInt(nodeStr));
        }
        new Node()
    }

    private boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));