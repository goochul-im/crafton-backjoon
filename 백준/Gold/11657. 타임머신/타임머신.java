//  타임머신

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int N;
    private static int M;
    private static ArrayList<Node> graph;
    private static long[] distance;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        graph = new ArrayList<>();

        for (int j = 0; j < M; j++) {

            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            graph.add(new Node(cost, start, end));

        }

        boolean isCycle = bellmanFord(1);

        if (isCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (distance[i] == Integer.MAX_VALUE) System.out.println(-1);
                else
                    System.out.println(distance[i]);
            }
        }

    }

    private static boolean bellmanFord(int x) {

        distance[x] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cost = graph.get(j).cost;
                int start = graph.get(j).start;
                int dest = graph.get(j).dest;

                if (distance[start] != Integer.MAX_VALUE && distance[dest] > distance[start] + cost) {
                    distance[dest] = distance[start] + cost;
                    if (i == N - 1) return true;
                }

            }
        }

        return false;
    }

    private static class Node {
        int cost;
        int start;
        int dest;

        public Node(int cost, int start, int dest) {
            this.cost = cost;
            this.start = start;
            this.dest = dest;
        }
    }
}
