import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                String type = sc.next();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int answer = 1;
            for (String key : map.keySet()){
                answer *= (map.get(key) + 1);
            }
            System.out.println(answer-1);
        }
    }
}