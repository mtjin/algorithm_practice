import java.util.Scanner;

public class Main {

    // 최대공약수
    public static int gcd(int x, int y) {
        while (y > 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // 최소공배수
    public static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}