//  구간 합 구하기 5

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] prob = new int[N][N];
        int[][] accSum = new int[N][N];

        for (int i = 0; i < N; i++) {
            prob[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    accSum[i][j] = prob[i][j];
                    continue;
                }

                accSum[i][j] = accSum[i][j - 1] + prob[i][j];
            }
        }


        for (int i = 0; i < M; i++) {
            int answer = 0;
            line = br.readLine().split(" ");
            int startRow = Integer.parseInt(line[0]) - 1;
            int startCol = Integer.parseInt(line[1]) - 1;
            int endRow = Integer.parseInt(line[2]) - 1;
            int endCol = Integer.parseInt(line[3]) - 1;

            for (int row = startRow; row <= endRow; row++) {
                int temp = accSum[row][endCol];
                if (startCol > 0) {
                    temp -= accSum[row][startCol - 1];
                }
                answer += temp;
            }
            System.out.println(answer);
        }

    }
}
