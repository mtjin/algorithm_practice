import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Integer> stack = new Stack<>();
    private static int num = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int current = sc.nextInt();
            if (num <= current) { //해당 숫자(current)까지 차례대로 스택 만들어주고 pop
                while (num <= current) {
                    sb.append("+\n");
                    stack.push(num++);
                }
                sb.append("-\n");
                stack.pop();
            } else { //해당 숫자(current)가 현재 값보다 크면 그 값은 스택에 들어가있는상태
                int n = stack.pop();
                if (n == current) { //가장 상단 값이 해당 값이어야함(오르막내리막차순이므로)
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb.toString());
    }
}