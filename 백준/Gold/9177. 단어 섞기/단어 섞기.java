//  단어 섞기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static String answer = "no";
    static String firstWord;
    static String secondWord;
    static String goalWord;
    static int firstWordLen = 0;
    static int secondWordLen = 0;
    static int goalWordLen = 0;
    static int[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            firstWord = line[0];
            secondWord = line[1];
            goalWord = line[2];

            firstWordLen = firstWord.length();
            secondWordLen = secondWord.length();
            goalWordLen = goalWord.length();
            isVisited = new int[firstWordLen + 1][secondWordLen + 1];

            if (dfs(0,0,0)) answer = "yes";

            System.out.printf("Data set %d: %s\n",i+1,answer);
            answer = "no";
        }

    }

    private static boolean dfs(int firstWordIdx, int secondWordIdx, int goalWordIdx) {

        if (goalWordIdx == goalWordLen) {
            return true;
        }

        if (isVisited[firstWordIdx][secondWordIdx] != 0) {
            return isVisited[firstWordIdx][secondWordIdx] == 1;
        }

        if (firstWordIdx < firstWordLen && firstWord.charAt(firstWordIdx) == goalWord.charAt(goalWordIdx)) {
            if (dfs(firstWordIdx + 1, secondWordIdx, goalWordIdx + 1)) return true;
        }

        if (secondWordIdx < secondWordLen && secondWord.charAt(secondWordIdx) == goalWord.charAt(goalWordIdx)) {
            if (dfs(firstWordIdx, secondWordIdx + 1, goalWordIdx + 1)) return true;
        }

        isVisited[firstWordIdx][secondWordIdx] = 2;
        return false;
    }
}
