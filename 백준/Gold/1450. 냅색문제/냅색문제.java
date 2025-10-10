//  냅색문제

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int N;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        int[] prob = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] groupA = Arrays.copyOfRange(prob, 0, N / 2);
        int[] groupB = Arrays.copyOfRange(prob, N / 2, N);

        ArrayList<Integer> sumA = new ArrayList<>();
        ArrayList<Integer> sumB = new ArrayList<>();

        addByDfs(groupA, 0, sumA, 0);
        addByDfs(groupB, 0, sumB, 0);

        Collections.sort(sumB);
        int answer = 0;

        for (Integer i : sumA) {
            if (i <= C) {
                answer += getCount(sumB, C - i);
            }
        }

        System.out.println(answer);
    }

    private static int getCount(List<Integer> list, int find) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            int now = list.get(mid);

            if (now <= find) {
                left = mid + 1;
            } else
                right = mid;

        }

        return left;
    }

    private static void addByDfs(int[] list, int idx, List<Integer> addList, int curSum) {

        if (curSum > C) {
            return;
        }

        if (idx == list.length) {
            addList.add(curSum);
            return;
        }

        addByDfs(list, idx + 1, addList, curSum);
        addByDfs(list, idx + 1, addList, curSum + list[idx]);

    }
}
