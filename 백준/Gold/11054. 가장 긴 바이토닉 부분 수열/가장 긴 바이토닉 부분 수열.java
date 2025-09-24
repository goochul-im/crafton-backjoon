import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] inc = new int[N];
        int[] dec = new int[N]; 

        ArrayList<Integer> lisTail = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(lisTail, arr[i]);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == lisTail.size()) {
                lisTail.add(arr[i]);
            } else {
                lisTail.set(pos, arr[i]);
            }

            inc[i] = pos + 1;
        }

        lisTail.clear();
        for (int i = N - 1; i >= 0; i--) {
            int pos = Collections.binarySearch(lisTail, arr[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == lisTail.size()) {
                lisTail.add(arr[i]);
            } else {
                lisTail.set(pos, arr[i]);
            }
            dec[i] = pos + 1;
        }

        // inc[i] + dec[i] - 1 의 최댓값 찾기
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
        }

        System.out.println(maxLen);
    }
}
