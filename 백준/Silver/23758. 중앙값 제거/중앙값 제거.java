//  중앙값 제거

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int mid = (N+1)/2;

        int result = 0;
        for (int i = 0; i < mid ; i++) {
            result += calcBinary(arr[i]);
        }

        System.out.println(result + 1);
    }

    private static int calcBinary(int n) {
        int count = 0;
        while (n > 1) {
            n /= 2;
            count++;
        }
        return count;
    }
}
