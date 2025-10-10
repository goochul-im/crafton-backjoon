//  두 용액

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] prob = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted().toArray();

        int left = 0;
        int right = N - 1;
        int answer = prob[left] + prob[right];
        int leftAnswer = prob[left];
        int rightAnswer = prob[right];

        while (left < right) {
            int now = prob[left] + prob[right];

            if (abs(answer) > abs(now)) {
                answer = now;
                leftAnswer = prob[left];
                rightAnswer = prob[right];
            }

            if (now < 0) {
                left++;
            } else if (now > 0) {
                right--;
            } else {
                System.out.printf("%d %d", prob[left], prob[right]);
                return;
            }

        }

        System.out.printf("%d %d", leftAnswer, rightAnswer);
    }
}
