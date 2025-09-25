//  평범한 배낭

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int[][] dp;
    private static myObject[] prob;
    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        dp = new int[N + 1][K + 1];

        prob = new myObject[N + 1];
        for (int i = 1; i < N + 1; i++) {
            line = br.readLine().split(" ");
            prob[i] = new myObject(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        System.out.println(dynamic(N,K));
    }

    private static int dynamic(int count, int weight) {
        if (dp[count][weight] != 0) {
            return dp[count][weight];
        }

        if (count == 0) return 0;

        if (prob[count].weight <= weight) {
            dp[count][weight] = Math.max(
                    dynamic(count - 1, weight), dynamic(count - 1, weight - prob[count].weight) + prob[count].value
            );
        } else {
            dp[count][weight] = dynamic(count - 1, weight);
        }

        return dp[count][weight];
    }

    private static class myObject{
        int weight;
        int value;

        public myObject(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
