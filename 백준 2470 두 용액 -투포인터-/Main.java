import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static int N; //  2 이상 100,000 이하
    private static int left;
    private static int right;
    private static int[] nums;
    private static int diff = Integer.MAX_VALUE;
    private static int answer1 = 0;
    private static int answer2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        left = 0;
        right = N - 1;
        Arrays.sort(nums); //정렬
        while (left < right) {
            int tmpDiff = Math.abs(nums[left] + nums[right]);  //두 수의 차이의 양수화
            if (tmpDiff < diff) { //0에 더 가까우면 정답 갱신
                diff = tmpDiff;
                answer1 = nums[left];
                answer2 = nums[right];
            }
            if (nums[left] + nums[right] > 0) { // 둘의 차이가 양수면 오른쪽 포인터를 더 작은 값을 가진
                // 왼쪽으로 움직음으로써 더 0에 가깝게 만들어본다.
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}