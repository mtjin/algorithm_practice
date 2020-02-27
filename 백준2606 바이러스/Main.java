import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int startNode = 1;
    static int nodeCnt = 0;
    static int edgeCnt = 0;
    static boolean isVisited[];
    static LinkedList<Integer> edgeList[];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        edgeCnt = Integer.parseInt(st.nextToken());

        //노드방문 boolean 생성
        isVisited = new boolean[nodeCnt + 1];

        //노드 연결리스트 생성
        edgeList = new LinkedList[nodeCnt + 1];
        for(int i=0; i<= nodeCnt; i++){
            edgeList[i] = new LinkedList();
        }

        // 간선 세팅
        for(int i=0; i < edgeCnt; i++ ){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            edgeList[node1].add(node2);
            edgeList[node2].add(node1);
        }

        dfs(startNode, isVisited);
        //자신이 감염시킨 컴퓨터 수가 결과이므로 -1 해줌
        System.out.println(result-1);
    }

    public static void dfs(int currentNode, boolean[] visited){
        if(visited[currentNode]){
            return;
        }
        visited[currentNode] = true;
        for(int nextNode : edgeList[currentNode]){
            dfs(nextNode, visited);
        }
        result++;
    }

}

