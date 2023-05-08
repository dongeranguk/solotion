package solution.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        A = new ArrayList[n+1]; // 그래프를 인접 리스트로 표현
        visited = new boolean[n+1]; // 방문 배열 초기화

        for(int i=1; i<n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s); // 방향이 없는 그래프이므로, 양쪽 방향으로 에지를 모두 저장한다.
        }

        int count = 0;
        for(int i=1; i<n+1; i++) { // 시작점 1부터 DFS 수행
            if(!visited[i]) { // 방문하지 않은 노드를 탐색
                DFS(i);
                count++; // DFS 수행 횟수는 즉, 연결 요소의 개수
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v) {
        if(visited[v]) return;

        visited[v] = true;
        for(int i : A[v]) {
            if(visited[i] == false) {
                DFS(i); // 재귀 함수로 DFS 구현
            }
        }
    }
}
