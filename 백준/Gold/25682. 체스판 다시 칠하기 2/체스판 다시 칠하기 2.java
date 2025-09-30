//  체스판 다시 칠하기 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        String[] prob = new String[N];
        for (int i = 0; i < N; i++) {
            prob[i] = br.readLine();
        }

        int[][] costB = new int[N + 1][M + 1];
        int[][] costW = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ((i + j) % 2 == 0) {
                    if (prob[i - 1].charAt(j - 1) == 'W') {
                        costB[i][j] = 1;
                    } else {
                        costW[i][j] = 1;
                    }
                }
                else {
                    if (prob[i - 1].charAt(j - 1) == 'B') {
                        costB[i][j] = 1;
                    } else {
                        costW[i][j] = 1;
                    }
                }
            }
        }

        int[][] accSumB = new int[N + 1][M + 1];
        int[][] accSumW = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                accSumB[i][j] = accSumB[i][j - 1] + costB[i][j] + accSumB[i - 1][j] - accSumB[i - 1][j - 1];
                accSumW[i][j] = accSumW[i][j - 1] + costW[i][j] + accSumW[i - 1][j] - accSumW[i - 1][j - 1];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int costBSum = accSumB[i + K - 1][j + K - 1] - accSumB[i - 1][j + K - 1] - accSumB[i + K - 1][j - 1] + accSumB[i - 1][j - 1];
                int costWSum = accSumW[i + K - 1][j + K - 1] - accSumW[i - 1][j + K - 1] - accSumW[i + K - 1][j - 1] + accSumW[i - 1][j - 1];

                int whoIsMin = Math.min(costBSum, costWSum);
                answer = Math.min(answer, whoIsMin);
            }
        }

        System.out.println(answer);
    }
}
