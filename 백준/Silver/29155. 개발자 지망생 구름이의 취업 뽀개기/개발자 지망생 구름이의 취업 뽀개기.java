//  개발자 지망생 구름이의 취업 뽀개기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] difficulty = new int[6];
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 5; i++) {
            difficulty[i + 1] = line[i];
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.computeIfAbsent(line[0], k -> new ArrayList<>()).add(line[1]);
        }

        int result = 0;
        for (int i = 1; i < 6; i++) {
            int numOfTest = difficulty[i];
            ArrayList<Integer> arr = map.get(i);
            Collections.sort(arr);
            int curTime = 0;
            for (int j = 0; j < numOfTest; j++) {
                Integer time = arr.get(j);
                if (j != 0)
                    result += (time - curTime);
                result += time;
//                System.out.printf("grade: %d , time: %d, addTime = %d\n", i, time, time - curTime);
                curTime = time;
            }
            result += 60;
        }

        System.out.println(result - 60);

    }
}
