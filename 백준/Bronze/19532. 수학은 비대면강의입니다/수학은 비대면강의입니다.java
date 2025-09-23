//  수학은 비대면강의입니다

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (prob[0] * i + prob[1] * j == prob[2] && prob[3] * i + prob[4] * j == prob[5]) {
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }
        }

    }
}
