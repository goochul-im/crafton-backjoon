//  부분합

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        int[] prob = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] accSum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            accSum[i + 1] = accSum[i] + prob[i];
        }

        int left = 0;
        int right = 1;
        int sum;
        int len = Integer.MAX_VALUE;

        while (right <= N) {
            sum = accSum[right] - accSum[left];

            if (sum >= S) {
                len = min(len, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
