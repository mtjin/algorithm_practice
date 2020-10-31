import java.util.Scanner;

class Main {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("1 0");
                continue;
            }
            if (num == 1) {
                System.out.println("0 1");
                continue;
            }
            arr = new int[num+1][2];
            arr[0][0] = 1;
            arr[1][1] = 1;
            for (int k = 2; k <= num; k++) {
                arr[k][0] = arr[k - 1][0] + arr[k - 2][0];
                arr[k][1] = arr[k - 1][1] + arr[k - 2][1];
            }
            System.out.println(arr[num][0] + " " + arr[num][1]);
        }
    }

}