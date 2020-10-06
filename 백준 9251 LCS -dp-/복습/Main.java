import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.next();
        String line2 = sc.next();
        int[][] lcs = new int[line1.length() + 1][line2.length() + 1];
        for (int i = 1; i <= line1.length(); i++) {
            for (int j = 1; j <= line2.length(); j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        System.out.println(lcs[line1.length()][line2.length()]);
    }
}