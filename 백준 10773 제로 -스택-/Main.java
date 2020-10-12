import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.add(num);
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}