import java.util.*;

class Clone_Graph {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        return Sol(node, map);
    }

    Node Sol(Node node, HashMap<Node, Node> map) {
        Node ans = new Node(node.val);
        map.put(node, ans);
        for (Node x : node.neighbors) {
            if (map.containsKey(x)) {
                ans.neighbors.add(map.get(x));
                continue;
            }
            Sol(x, map);
            ans.neighbors.add(map.get(x));
        }
        return ans;
    }
}

class Node {
    int val;
    List<Node> neighbors;

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}