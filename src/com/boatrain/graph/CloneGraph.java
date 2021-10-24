package com.boatrain.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        cloned.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

}
