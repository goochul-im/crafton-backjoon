//  가장 긴 증가하는 부분 수열 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static ArrayList<Integer> list;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N);

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : prob) {
            int index = getIndex(i);

            if (index < list.size()) list.set(index, i);
            else list.add(i);

        }

        System.out.println(list.size());
    }

    private static int getIndex(int x) {

        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < x) {
                left = mid + 1;
            }else
                right = mid - 1;
        }

        return left;
    }
}
