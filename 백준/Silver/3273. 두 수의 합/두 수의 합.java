//  두 수의 합

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left < right) {
            int sum = prob[left] + prob[right];
            if (sum == x) {
                count++;
                left ++;
                right--;
            } else if (sum < x) {
                left++;
            } else
                right--;
        }

        System.out.println(count);
    }
}
