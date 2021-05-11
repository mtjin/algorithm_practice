import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int k; // 부등호 문자의 개수(2 ≤ k ≤ 9)
    private static boolean[] isVisited = new boolean[10]; // 0~9 숫자방문여부 (중복숫자불가하므로)
    private static char[] signs;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }
        dfs("", 0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1)); //최댓값
        System.out.println(result.get(0)); //최솟값
    }

    private static void dfs(String num, int depth) { //처음 nums를 int[]로 접근했는데 String으로 하는게 간단해진다.
        if (depth == k + 1) {
            result.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !isVisited[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1])) { //처음건 비교할게없으므로 통과 || 방문안한숫자 && 비교
                isVisited[i] = true;
                dfs(num + i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean compare(int a, int b, char c) {
        if (c == '<') return a < b;
        else return a > b;
    }
}