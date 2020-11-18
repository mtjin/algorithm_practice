import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n-1; i > 0; i--) { //끝에서부터 내림차순을 만들어준다
            while (arr[i - 1] >= arr[i]) {
                arr[i - 1]--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}