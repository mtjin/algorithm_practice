import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static int T; //테스트케이스 수
    private static int F; //친구 관계의 수
    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            F = sc.nextInt();
            parent = new int[F * 2];
            count = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
            }
            Arrays.fill(count, 1);
            HashMap<String, Integer> map = new HashMap<>();
            int index =0;
            for (int f = 0; f < F; f++) {
                String friend1 = sc.next();
                String friend2 = sc.next();
                if (!map.containsKey(friend1)) {
                    map.put(friend1,index++);
                }
                if (!map.containsKey(friend2)) {
                    map.put(friend2, index++);
                }
                System.out.println(union(map.get(friend1), map.get(friend2)));
            }
        }
    }

    private static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(a < b){
                parent[b] = a;
                count[a] += count[b];
                return count[a];
            }else{
                parent[a] = b;
                count[b] += count[a];
                return count[b];
            }
        }
        return count[a];
    }
}