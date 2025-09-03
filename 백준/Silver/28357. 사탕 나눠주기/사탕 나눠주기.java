import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long K;
    static long[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        scores = new long[N];
        st = new StringTokenizer(br.readLine());
        long maxScore = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Long.parseLong(st.nextToken());
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        long left = 0;
        long right = maxScore; 
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long candiesNeeded = calculateCandies(mid);

            if (candiesNeeded <= K) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long calculateCandies(long threshold) {
        long totalCandies = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] > threshold) {
                totalCandies += (scores[i] - threshold);
            }
        }
        return totalCandies;
    }
}
