import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 삼각형 높이
        int[][] num = new int[n + 1][n + 1]; // [높이][개수]
        //초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        //두번째 줄 부터 n 줄까지 더해나감
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) { //왼쪽구석
                    num[i][j] += num[i - 1][1];
                } else if (j == i) { //오른쪽 구석
                    num[i][j] += num[i - 1][j - 1];
                } else { //그 외 중간위치들
                    num[i][j] += Math.max(num[i - 1][j], num[i - 1][j - 1]);
                }
            }
        }
        //결과
        int result = num[1][0];
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, num[n][i]);
        }
        System.out.println(result);
    }
}