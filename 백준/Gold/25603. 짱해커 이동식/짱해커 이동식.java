//  짱해커 이동식

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        System.out.println(binarySearch());

    }

    private static int binarySearch() {
        int left = 1, right = (int) Math.pow(10,9), mid = 0;
        int answer = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static boolean check(int maxCost) {
        int rejectCount = 0;

        for (int now : arr) {
            if (now <= maxCost) rejectCount = 0;
            else rejectCount++;

            if (rejectCount == K) return false;
        }

        return true;
    }
}
