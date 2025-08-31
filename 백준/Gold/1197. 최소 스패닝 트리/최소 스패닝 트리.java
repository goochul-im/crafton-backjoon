//  최소 스패닝 트리

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static PriorityQueue<Node> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");
        int V = Integer.parseInt(lines[0]);
        int E = Integer.parseInt(lines[1]);

        pq = new PriorityQueue<>();
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            lines = br.readLine().split(" ");
            int start = Integer.parseInt(lines[0]);
            int end = Integer.parseInt(lines[1]);
            int cost = Integer.parseInt(lines[2]);

            pq.add(new Node(cost, start, end));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!union(node.start, node.end)) {
                continue;
            }
            result += node.cost;
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int cost;
        int start;
        int end;

        public Node(int cost, int start, int end) {
            this.cost = cost;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return false;
        }
        parent[xParent] = yParent;
        return true;
    }
}
