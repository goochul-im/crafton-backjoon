//  구간 합 구하기 4

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] accSum = new int[N];
        accSum[0] = prob[0];

        for (int i = 1; i < N; i++) {
            accSum[i] = prob[i] + accSum[i - 1];
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]) - 1;

            int answer = accSum[end];
            if (start > 0) {
                answer -= accSum[start - 1];
            }

            System.out.println(answer);
        }

    }
}
