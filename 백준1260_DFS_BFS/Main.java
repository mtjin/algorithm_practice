import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int nodeCount;
    public static LinkedList<Integer>[] nodeList;
    public static int edgeCount;
    public static StringBuilder dfsResult = new StringBuilder();
    public static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점개수, 간선개수, 탐색시작노드 세팅
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());


        //노드리스트 세팅
        nodeList = new LinkedList[nodeCount + 1];
        boolean[] bfsVisited = new boolean[nodeCount + 1];
        boolean[] dfsVisited = new boolean[nodeCount + 1];
        for(int i=0; i <= nodeCount; i++){
            nodeList[i] = new LinkedList();
        }
        for (int i=0; i< edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2= Integer.parseInt(st.nextToken());

            nodeList[node1].add(node2);
            nodeList[node2].add(node1);
            //리스트 정렬 (점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문)
            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }

        dfs(startNode, dfsVisited);
        bfs(startNode, bfsVisited);

        //결과
        System.out.println(dfsResult + "\n" + bfsResult);
    }

    public static void dfs(int currentNode, boolean[] visited){
        if(visited[currentNode]){
            return;
        }
        visited[currentNode] = true;
        dfsResult.append(currentNode +" ");
        for(int nextNode : nodeList[currentNode]){
            dfs(nextNode, visited);
        }
    }

    public static void bfs(int currentNode, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        while (!queue.isEmpty()){
            currentNode = queue.poll();
            if(visited[currentNode]) continue;
            visited[currentNode] = true;
            bfsResult.append(currentNode + " ");
            queue.addAll(nodeList[currentNode]);
        }
    }
}
