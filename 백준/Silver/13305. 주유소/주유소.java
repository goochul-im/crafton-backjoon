//  주유소

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int now = 0;
        int compare = 0;
        int answer = 0;

        while (now < N - 1) {

            do {
                compare++;
                answer += prob[now] * cost[compare - 1];
            } while (prob[now] < prob[compare]);

            now = compare;

        }

        System.out.println(answer);
    }
}
