//  아름다운 단어

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = "";
        StringBuilder answer = new StringBuilder();

        char[] prob = br.readLine().toCharArray();
        boolean[] isUsed = new boolean[N];
        PriorityQueue<Word> Q = new PriorityQueue<>();
        List<Word> wordListForIndex = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Q.add(new Word(i, prob[i]));
            wordListForIndex.add(new Word(i, prob[i]));
        }

        int rightIdx = N - 1;
        for (int T = 0; T < N / 2; T++) {
            while (isUsed[rightIdx]) {
                rightIdx--;
            }

            Word sanggunWord = wordListForIndex.get(rightIdx);
            int findIdx = sanggunWord.index;
            isUsed[findIdx] = true;

            Word HWord;
            do {
                HWord = Q.poll();
            } while (isUsed[HWord.index]);

            isUsed[HWord.index] = true;

            answer.append(HWord.c);

            if (result.isEmpty() && HWord.c < sanggunWord.c) {
                result = "DA";
            } else if (result.isEmpty() && HWord.c > sanggunWord.c) {
                result = "NE";
            }

        }

        if (result.isEmpty()) result = "NE";

        System.out.println(result);
        System.out.println(answer);
    }

    private static class Word implements Comparable<Word>{
        int index;
        char c;

        public Word(int index, char c) {
            this.index = index;
            this.c = c;
        }

        @Override
        public int compareTo(Word o) {
            if (this.c == o.c)
                return o.index - this.index;
            return this.c - o.c;
        }
    }
}
