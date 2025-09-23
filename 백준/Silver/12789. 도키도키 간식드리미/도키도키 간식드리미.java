//  도키도키 간식드리미

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        int count = 1;

        for (int i = 0; i < N; i++) {

            stack.push(prob[i]);

            while (!stack.isEmpty() && count == stack.peek()) {
                count++;
                stack.pop();
            }
        }

        while (!stack.isEmpty() && count == stack.peek()) {
            count++;
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

    }
}
