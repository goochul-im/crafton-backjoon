//  소가 길을 건너간 이유 5

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] trafficLights = new boolean[N + 1];
        Arrays.fill(trafficLights, true);
        for (int i = 0; i < B; i++) {
            int light = Integer.parseInt(br.readLine());
            trafficLights[light] = false;
        }

        int result = 0;
        for (int i = 1; i <= K; i++) {
            if (!trafficLights[i]) result ++;
        }

        int minResult = result;
        for (int i = 2; i <= N - K + 1; i++) {
            if (!trafficLights[i - 1]) result--;

            if (!trafficLights[i + K - 1]) result++;
            minResult = Math.min(minResult, result);
        }

        System.out.println(minResult);
    }
}
