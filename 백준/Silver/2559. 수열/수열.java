//  수열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cur = 0;
        for (int i = 0; i < K; i++) {
            cur += prob[i];
        }
        int answer = cur;

        for (int i = 1; i < N - K + 1; i++) {
            int now = (cur - prob[i - 1] + prob[i + K - 1]);
            answer = Math.max(now, answer);
            cur = now;
        }

        System.out.println(answer);
    }
}
