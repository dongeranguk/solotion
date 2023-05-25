package solution.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for(int i=0; i<=n; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[n+1];
        DFS(start);
        System.out.println();
        visited = new boolean[n+1];
        BFS(start);
        System.out.println();

    }

    private static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node +  " ");
            for(int i : A[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
