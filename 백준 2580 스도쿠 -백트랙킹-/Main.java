import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[][] map = new int[9][9];
    static LinkedList<Node> list = new LinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == list.size()) { //빈값 모두 채운 경우
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        Node node = list.get(depth);
        int x = node.x;
        int y = node.y;
        for (int i = 1; i <= 9; i++) { //빈칸인 map[x][y]에 1~9 값 되는지 check
            if (check(x, y, i)) {
                map[x][y] = i; //되는 숫자면 넣고 이어서 탐색
                dfs(depth + 1);
                map[x][y] = 0;
            }
        }
    }

    static boolean check(int x, int y, int num) {
        if (map[x][y] != 0) { // 빈칸 아니면 false
            return false;
        }
        for (int i = 0; i < 9; i++) { //가로,세로줄 중복검사
            if (map[i][y] == num || map[x][i] == num) {
                return false;
            }
        }
        int x2 = (x / 3) * 3;
        int y2 = (y / 3) * 3;
        for (int i = x2; i < x2 + 3; i++) { //3x3 중복체크
            for (int j = y2; j < y2 + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;

    }


    static class Node {
        int x; //행
        int y; //열

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}