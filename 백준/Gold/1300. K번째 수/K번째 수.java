//  K번째 수

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1;
        long right = K;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid, N);
            if (count >= K) {
                answer = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        System.out.println(answer);
    }

    private static long getCount(long k, int N) {
        long count = 0;
        for (int i = 1; i <= N; i++) {
            count += Math.min(N, k / i);
        }
        return count;
    }
}
