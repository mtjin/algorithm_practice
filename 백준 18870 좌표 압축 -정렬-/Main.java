import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] sortNums = new int[N];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            sortNums[i] = num;
        }
        //오름차순 정렬
        Arrays.sort(sortNums);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (map.get(sortNums[i]) == null) { //아직 압축 안된 숫자인 경우
                map.put(sortNums[i], cnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}