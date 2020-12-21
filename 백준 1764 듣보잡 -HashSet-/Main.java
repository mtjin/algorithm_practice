import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //듣도못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람의 수
        HashSet<String> nList = new HashSet<>();
        List<String> mList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nList.add(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            mList.add(st.nextToken());
        }
        Collections.sort(mList);
        int count = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (nList.contains(mList.get(i))) {
                sb.append(mList.get(i)).append("\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}