import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] t = new Integer[N];
        for (int i = 0; i < N; i++) {
            t[i] = sc.nextInt();
        }
        // 오래걸리는거부터 심어야 최대한 빠르므로 역정렬
        Arrays.sort(t, Collections.reverseOrder());
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            // 나무자라는데걸리는시간 + 며칠지났는지 + 심는데 하루
            maxDay = Math.max(maxDay, t[i] + i + 1);
        }
        // 다 심은 다음날 이장님 초대 가능
        maxDay += 1;
        System.out.println(maxDay);
    }
}
