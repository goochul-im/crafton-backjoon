import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1. 동전 정보를 담을 간단한 클래스 정의
class Coin {
    int value; // 금액
    int count; // 개수

    public Coin(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        // 2. Map 대신 Coin 객체를 담을 List 생성
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coins.add(new Coin(line[0], line[1]));
        }
        
        long[] dp = new long[T + 1];
        dp[0] = 1;

        // 3. Map 순회 대신 List를 순회 (핵심 로직은 동일)
        for (Coin coinInfo : coins) {
            int coinValue = coinInfo.value;
            int coinCount = coinInfo.count;

            // '무제한' 사용 가정하고 더하기 (정방향)
            for (int j = coinValue; j <= T; j++) {
                dp[j] += dp[j - coinValue];
            }

            // '너무 많이 사용한 경우' 빼서 보정하기 (역방향)
            int limit = coinValue * (coinCount + 1);
            for (int j = T; j >= limit; j--) {
                dp[j] -= dp[j - limit];
            }
        }

        System.out.println(dp[T]);
    }
}