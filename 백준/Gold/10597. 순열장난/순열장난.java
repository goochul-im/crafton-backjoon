//  순열장난

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.IntStream;

class Main {

    private static int len;
    private static String line;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        len = line.length();
        isVisited = new boolean[51];
        dfs(0, 0, new StringBuilder());
    }

    private static void dfs(int idx, int N, StringBuilder sb) {
        if (idx == len) {
            boolean hasFalse = IntStream.range(1, N + 1).anyMatch(i -> !isVisited[i]);
            if (hasFalse) return;
            System.out.println(sb.toString().trim());
            System.exit(0);
            return;
        } else if (idx > len) {
            return;
        }

        int temp = Integer.parseInt(line.substring(idx, idx + 1)); // 1자리숫자
        if (!isVisited[temp]) {
            isVisited[temp] = true;
            int originalSbLength = sb.length();
            dfs(idx + 1, N + 1, sb.append(temp).append(" "));
            sb.setLength(originalSbLength);
            isVisited[temp] = false;
        }
        if (idx + 1 < len) {
            temp = Integer.parseInt(line.substring(idx, idx + 2)); // 2자리숫자
            if (temp <= 50 && !isVisited[temp]) {
                isVisited[temp] = true;
                int originalSbLength = sb.length();
                dfs(idx + 2, N + 1, sb.append(temp).append(" "));
                sb.setLength(originalSbLength);
                isVisited[temp] = false;
            }
        }

    }
}
