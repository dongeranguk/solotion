package solution.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023 {

    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrive = false;
        A = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for(int i=0; i<n; i++) {
            DFS(i, 1);

            if(arrive) break;
        }

        if(arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void DFS(int i, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[i] = true;
        for(int v : A[i]) {
            if(!visited[v]) {
                DFS(v, depth+1);
            }
        }

        visited[i] = false;
    }
}
