import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });
        for (String str : list) {
            System.out.println(str);
        }
    }
}