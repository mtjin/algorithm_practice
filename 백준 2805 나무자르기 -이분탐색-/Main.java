import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int h : arr) {
                if (h - mid > 0) { // 자를수있는 나무인 경우
                    sum += (h - mid);
                }
            }
            if (sum < M) { //필요한 나무길이 부족
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
        br.close();
    }
}