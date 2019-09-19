package leetcode.queue.stack;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    public ArrayList<Node> nodes = new ArrayList<>();
    public ArrayList<Integer> visited = new ArrayList<>();

    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private boolean isVisited(int val) {
        for (Integer integer : visited) {
            if (integer == val) {
                return true;
            }
        }
        return false;
    }

    private void DFS(Node node) {
        for (Node neighbor : node.neighbors) {
            if (!visited.contains(node.val)) {
                visited.add(node.val);
                nodes.add(node);
            }
            if (!isVisited(neighbor.val)) {
                DFS(neighbor);
            }
        }
    }

    private Node getNode(Node[] nodes, int val) {
        for (Node node : nodes) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }

    public Node cloneGrap(Node node) {
        visited.add(node.val);
        nodes.add(node);
        DFS(node);
        int totalNum = visited.size();
        Node[] newNodes = new Node[totalNum];

        for (int i = 0; i < totalNum; i++) {
            ArrayList<Node> neighbors = new ArrayList<>();
            newNodes[i] = new Node(visited.get(i), neighbors);
        }

        Node[] nodes_array = new Node[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            nodes_array[i] = nodes.get(i);
        }
        for (Node newNode : newNodes) {
            Node originNode = getNode(nodes_array, newNode.val);
            for (Node neighbor : originNode.neighbors) {
                newNode.neighbors.add(getNode(newNodes, neighbor.val));
            }
        }

        Node result = getNode(newNodes, node.val);
        return result;
    }




}
