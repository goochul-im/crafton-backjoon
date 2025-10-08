//  특정한 최단 경로

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int[][] graph;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int i = 0; i < E; i++) {

            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            graph[start][end] = cost;
            graph[end][start] = cost;

        }

        line = br.readLine().split(" ");
        int v1 = Integer.parseInt(line[0]);
        int v2 = Integer.parseInt(line[1]);

        int dist1_v1 = getClosestDistance(1, v1);
        int dist1_v2 = getClosestDistance(1, v2);
        int distV1_v2 = getClosestDistance(v1, v2);
        int distV1_N = getClosestDistance(v1, N);
        int distV2_N = getClosestDistance(v2, N);

        long path1 = -1, path2 = -1;
        long INF = Integer.MAX_VALUE; // 비교를 위해 long 타입으로 선언

        if (dist1_v1 != INF && distV1_v2 != INF && distV2_N != INF) {
            path1 = (long)dist1_v1 + distV1_v2 + distV2_N;
        }

        if (dist1_v2 != INF && distV1_v2 != INF && distV1_N != INF) {
            path2 = (long)dist1_v2 + distV1_v2 + distV1_N;
        }

        if (path1 == -1 && path2 == -1) {
            System.out.println(-1);
        }
        else if (path1 == -1 || path2 == -1) {
            System.out.println(Math.max(path1, path2));
        }
        else {
            System.out.println(Math.min(path1, path2));
        }

    }

    private static int getClosestDistance(int start, int end) {

        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(0, start));

        while (!Q.isEmpty()) {

            Node poll = Q.poll();

            if (poll.cost > distance[poll.start]) continue;

            for (int i = 1; i < N + 1; i++) {
                int startNode = poll.start;
                if (graph[startNode][i] < 0) continue;

                int cost = poll.cost;
                int next = graph[startNode][i];

                int nextCost = cost + next;

                if (nextCost < distance[i]) {
                    distance[i] = nextCost;
                    Q.add(new Node(nextCost, i));
                }

            }

        }

        return distance[end];
    }

    private static class Node implements Comparable<Node> {
        int cost;
        int start;

        public Node(int cost, int start) {
            this.cost = cost;
            this.start = start;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
