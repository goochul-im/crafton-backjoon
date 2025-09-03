import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    // 2. 자료형을 long으로 변경
    static long[][] dp;
    static long[][] sum; // 누적 합을 저장할 배열 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new long[n + 1][m + 1];
            sum = new long[n + 1][m + 1]; // 누적 합 배열 초기화

            // 초기값 설정 (n=1일 때)
            for (int j = 1; j <= m; j++) {
                dp[1][j] = 1;
                // n=1일 때의 누적 합도 미리 계산
                sum[1][j] = sum[1][j - 1] + dp[1][j];
            }

            // 1. DP 점화식에 누적 합을 이용한 최적화 적용
            for (int j = 2; j <= n; j++) { // j: 고른 숫자의 개수
                for (int k = 1; k <= m; k++) { // k: 마지막으로 고른 숫자
                    // 점화식: dp[j][k] = Σ dp[j-1][x] (1 <= x <= k/2)
                    // 이 합은 sum[j-1][k/2] 와 같다.
                    dp[j][k] = sum[j - 1][k / 2];
                }
                
                // 현재 계산된 dp[j] 배열을 바탕으로 누적 합 sum[j] 배열을 계산
                for (int k = 1; k <= m; k++) {
                    sum[j][k] = sum[j][k - 1] + dp[j][k];
                }
            }
            
            // 최종 결과는 dp[n]의 모든 값을 더한 것과 같고, 이는 sum[n][m]과 같다.
            System.out.println(sum[n][m]);
        }
    }
}