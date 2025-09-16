//  알파벳 블록

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Character> Q = new ArrayDeque<>();
        Stack<Boolean> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            String[] line = br.readLine().split(" ");
            int button = Integer.parseInt(line[0]);

            switch (button) {
                case 1:
                    Q.addLast(line[1].charAt(0));
                    stack.add(true);
                    break;
                case 2:
                    Q.addFirst(line[1].charAt(0));
                    stack.add(false);
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        if (stack.pop()) {
                            Q.pollLast();
                        } else {
                            Q.pollFirst();
                        }
                    }
                    break;
            }

        }

        if (Q.isEmpty()) {
            System.out.println(0);
        }else {
            StringBuilder sb = new StringBuilder();
            for (Character c : Q) {
                sb.append(c);
            }

            System.out.println(sb);
        }

    }
}
