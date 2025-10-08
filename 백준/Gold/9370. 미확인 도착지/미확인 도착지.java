//  미확인 도착지

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static ArrayList<Node>[] graph;
    private static int nodeLen;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int t = Integer.parseInt(line[2]);
            nodeLen = n;

            graph = new ArrayList[n + 1];

            for (int j = 0; j < n + 1; j++) {
                graph[j] = new ArrayList<Node>();
            }

            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int g = Integer.parseInt(line[1]);
            int h = Integer.parseInt(line[2]);

            int ghCost = 0;

            for (int j = 0; j < m; j++) {
                line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                int cost = Integer.parseInt(line[2]);

                graph[start].add(new Node(cost, end));
                graph[end].add(new Node(cost, start));

                if ((start == g && end == h) || (start == h && end == g) ) ghCost = cost;
            }

            int[] distFromG = getDistance(g);
            int[] distFromH = getDistance(h);
            int[] distFromS = getDistance(s);

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < t; j++) {

                int x = Integer.parseInt(br.readLine());

                int path1 = distFromS[g] + ghCost + distFromH[x];
                int path2 = distFromS[h] + ghCost + distFromG[x];

                int minDistance = Math.min(path1, path2);

                if (minDistance == distFromS[x]) list.add(x);

            }

            StringBuilder sb = new StringBuilder();
            Collections.sort(list);
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }

            System.out.println(sb);
        }

    }

    private static int[] getDistance(int start) {
        int[] distance = new int[nodeLen + 1];
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(0, start));
        Arrays.fill(distance, 100_000_000);
        distance[start] = 0;

        while (!Q.isEmpty()) {
            Node poll = Q.poll();

            if (poll.cost > distance[poll.dest]) continue;

            for (Node next : graph[poll.dest]) {
                int cost = poll.cost + next.cost;

                if (cost < distance[next.dest]) {
                    distance[next.dest] = cost;
                    Q.add(new Node(cost, next.dest));
                }

            }

        }

        return distance;
    }

    private static class Node implements Comparable<Node> {
        int cost;
        int dest;

        public Node(int cost, int dest) {
            this.cost = cost;
            this.dest = dest;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
