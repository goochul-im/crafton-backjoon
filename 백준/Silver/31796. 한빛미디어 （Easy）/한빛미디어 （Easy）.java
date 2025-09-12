//  한빛미디어 (Easy)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int criteria = prob[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (prob[i] >= criteria * 2) {
                criteria = prob[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
