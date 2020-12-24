import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    private static boolean[] isVisited = new boolean[10];
    private static int[] nums;
    private static String[] words;
    private static List<Character> alphaList = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            words[i] = str;
            for (int j = 0; j < str.length(); j++) {
                Character alpha = str.charAt(j);
                if (!alphaList.contains(alpha)) { //알파벳 단어 리스트
                    alphaList.add(alpha);
                }
            }
        }
        nums = new int[alphaList.size()]; //각 알파벳의 값(int)을 저장할 배열
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == alphaList.size()) {
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int tmp = 0;
                for (int j = 0; j < word.length(); j++) { //각 알파벳에 해당하는 수 더하기
                    tmp *= 10;
                    tmp += nums[alphaList.indexOf(word.charAt(j))];
                }
                sum += tmp;
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                nums[depth] = i;
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }

}