//  나머지 합

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        long sum = 0;
        long[] remain = new long[M];

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : prob) {
            sum = (sum + i) % M;
            remain[(int) sum]++;
        }

        long answer = 0;
        answer = remain[0];

        for (int i = 0; i < M; i++) {
            long count = remain[i];
            answer += count * (count - 1) / 2;
        }

        System.out.println(answer);
    }
}
