//  로또

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static long dp[][];
    static long prefixSum[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new long[n + 1][m + 1];
            prefixSum = new long[n + 1][m + 1];

            for (int j = 1; j < m + 1; j++) {
                dp[1][j] = 1; // 초기값
                prefixSum[1][j] = prefixSum[1][j - 1] + dp[1][j];
            }

            for (int j = 2; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    dp[j][k] = prefixSum[j - 1][k / 2];
                }

                for (int k = 1; k < m + 1 ; k++) {
                    prefixSum[j][k] = prefixSum[j][k - 1] + dp[j][k];
                }
            }

            System.out.println(prefixSum[n][m]);
        }


    }

}
