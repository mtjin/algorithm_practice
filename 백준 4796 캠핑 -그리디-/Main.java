import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = 1;
        int answer = 0;
        while (true) {
            answer = 0;
            int L = sc.nextInt(); //L일 동안만 사용할 수 있다. (2)
            int P = sc.nextInt(); //연속하는 P일 중 (1)
            int V = sc.nextInt(); //휴가를 V일 받았다.
            if (L == 0 && P == 0 && V == 0) break;
            int quot = V / P; //몫
            int div = V % P; //나머지
            answer += quot * L;
            if (div > L) answer += L;
            else answer += div;
            System.out.println("Case " + caseCnt + ": " + answer);
            caseCnt++;
        }
    }
}