import java.util.HashSet;
import java.util.Scanner;

public class Main {
    
    public static void main(String argv[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = str.length();
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= length; i++) { // 부분 문자열의 길이
            for (int head = 0; head <= length-i; head++) { // 부분문자열의 현재 헤드
                int rear = head + i;
                set.add(str.substring(head, rear));
            }
        }

        System.out.println(set.size());

    }

}
