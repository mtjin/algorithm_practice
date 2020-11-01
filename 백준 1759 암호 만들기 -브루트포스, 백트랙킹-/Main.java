import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static String[] arr;
    private static String[] nums;
    private static boolean[] isVisited;
    private static int L;
    private static int C;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); //조합길이
        C = sc.nextInt(); //알파벳총개수(중복없음)
        arr = new String[C];
        nums = new String[L];
        isVisited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int count) {
        if (count == L) {
            if (!check(nums)) {
                return;
            }
            for (int i = 0; i < L; i++) {
                sb.append(nums[i]);
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < C; i++) {
            if (count == 0) {
                isVisited[i] = true;
                nums[count] = arr[i];
                dfs(count+1);
                isVisited[i] = false;
            } else if (!isVisited[i]) {
                if (nums[count - 1].compareTo(arr[i]) < 0) {
                    isVisited[i] = true;
                    nums[count] = arr[i];
                    dfs(count+1);
                    isVisited[i] = false;
                }
            }
        }
    }

    private static boolean check(String[] str) {
        int moeumCnt = 0;
        int jaeumCnt = 0;
        for (String s : str) {
            if (isMoeum(s)) {
                moeumCnt++;
            } else {
                jaeumCnt++;
            }
        }
        return moeumCnt >= 1 && jaeumCnt >= 2;
    }

    private static boolean isMoeum(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

}