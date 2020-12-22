import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static boolean[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        nums = new boolean[N + 1];
        makeSosu(N);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!nums[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    private static void makeSosu(int n) {
        nums[0] = true;
        nums[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (nums[i]) continue;
            for (int j = i*i; j < nums.length; j += i) {
                nums[j] = true;
            }
        }
    }

}