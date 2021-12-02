import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 통나무 개수
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr); // 정렬
            int left = N - 1;
            int right = 0;
            int[] nums = new int[N];
            // 왼쪽 오른쪽에 하나씩 정렬된 통나무를 놓으면 가장 작은 차이를 만들 수 있음
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    nums[left--] = arr[i];
                } else {
                    nums[right++] = arr[i];
                }
            }
            // 인접한것들끼리의 크기비교
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                answer = Math.max(answer, Math.abs(nums[i] - nums[i - 1]));
            }
            // 처음과 끝 통나무도 크기비교
            answer = Math.max(answer,Math.abs(nums[0] - nums[N - 1]));
            System.out.println(answer + " ");
        }

    }
}
