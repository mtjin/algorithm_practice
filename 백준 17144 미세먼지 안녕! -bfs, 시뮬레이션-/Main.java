import java.util.Scanner;

class Main {
    //(6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
    private static int R;//행
    private static int C;//열
    private static int cleanR1 = -1; //공기청정기 위치(상단)
    private static int cleanC1 = -1;
    private static int cleanR2; //공기청정기 위치(하단)
    private static int cleanC2;
    private static int T;//시간초
    private static int[][] map;
    private static int[][] newMap;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) { //공기 청정기 위치
                    if (cleanR1 == -1) { //상단 공기청정
                        cleanR1 = i;
                        cleanC1 = j;
                    } else { //하단
                        cleanR2 = i;
                        cleanC2 = j;
                    }
                }
            }
        }
        for (int t = 0; t < T; t++) {
            newMap = new int[R][C];
            newMap[cleanR1][cleanC1] = -1;
            newMap[cleanR2][cleanC2] = -1;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) { //1.미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
                    if (map[i][j] >= 5) { //퍼질 수 있는 양의 미세먼지인 경우
                        bfs(i, j);
                    } else { //퍼질 수 없는 경우 새로운 맵에 그냥 추가해줌
                        newMap[i][j] += map[i][j];
                    }
                }
            }
            cloneMap(); //map 재생성하고 newMap 값 복사
            makeNewMap(); //newMap에 map 값 복사해서 초기화(바람이동에 영향없는 값 세팅을 위해)
            upCleaner(cleanR1, cleanC1 + 1);
            downCleaner(cleanR2, cleanC2 + 1);
            cloneMap();
        }
        System.out.println(sum());
    }

    private static void makeNewMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    private static int sum() {
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] >= 1) {
                    answer += map[i][j];
                }
            }
        }
        return answer;
    }

    private static void cloneMap() { //미세먼지 퍼진 뒤의 맵 복사(newMap -> map)
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = newMap[i][j];
            }
        }
        newMap = new int[R][C]; // 초기화
    }

    private static void bfs(int r, int c) {
        int spreadCnt = 0; //퍼트린 개수
        for (int i = 0; i < 4; i++) {
            int r2 = r + dr[i];
            int c2 = c + dc[i];
            if (isCanSpread(r2, c2)) { //퍼트릴 수 있는 곳
                spreadCnt++;
                newMap[r2][c2] += (map[r][c] / 5);
            }
        }
        //미세먼지 퍼트린만큼 원래 근원지 조정
        newMap[r][c] += (map[r][c] - ((map[r][c] / 5) * spreadCnt));
    }

    private static boolean isCanSpread(int r, int c) { //외부벽이나 공기청정기가 위치한게 아닌 곳
        return (r >= 0 && r < R && c >= 0 && c < C && (r != cleanR1 || c != cleanC1) && (r != cleanR2 || c != cleanC2));
    }

    private static void upCleaner(int r, int c) { //상단공기청정기실행
        int r2 = r;
        int c2 = c;
        while (c2 < C - 1) { //우측이동
            newMap[r2][c2 + 1] = map[r2][c2];
            c2++;
        }
        while (r2 > 0) {//상단이동
            newMap[r2 - 1][c2] = map[r2][c2];
            r2--;
        }
        while (c2 > 0) {//좌측이동
            newMap[r2][c2 - 1] = map[r2][c2];
            c2--;
        }
        while (r2 < r) {//하단이동
            newMap[r2 + 1][c2] = map[r2][c2];
            r2++;
        }
        newMap[cleanR1][cleanC1 + 1] = 0;//가장 처음 공기청정기 미는 곳 0
        newMap[cleanR1][cleanC1] = -1; //원래 공기청정기 위치 리셋
    }

    private static void downCleaner(int r, int c) { //하단공기청정기실행
        int r2 = r;
        int c2 = c;
        while (c2 < C - 1) { //우측이동
            newMap[r2][c2 + 1] = map[r2][c2];
            c2++;
        }
        while (r2 < R - 1) {//하단이동
            newMap[r2 + 1][c2] = map[r2][c2];
            r2++;
        }
        while (c2 > 0) {//좌측이동
            newMap[r2][c2 - 1] = map[r2][c2];
            c2--;
        }
        while (r2 > r) {//상단이동
            newMap[r2 - 1][c2] = map[r2][c2];
            r2--;
        }
        newMap[cleanR2][cleanC2 + 1] = 0;//가장 처음 공기청정기 미는 곳 0
        newMap[cleanR2][cleanC2] = -1; //원래 공기청정기 위치 리셋
    }
}