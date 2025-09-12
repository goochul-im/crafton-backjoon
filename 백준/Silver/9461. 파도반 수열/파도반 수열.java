//  파도반 수열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }

    }
}
