//  운동

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int N;
    private static int M;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        int[][] distance = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(distance[i], INF);
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int dest = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            distance[start][dest] = cost;
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1 ; j++) {
                for (int k = 0; k < N + 1 ; k++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int answer = INF;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1 && i != j; j++) {
                int cycle = distance[i][j] + distance[j][i];
                answer = Math.min(answer, cycle);
            }
        }

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);

    }

}
