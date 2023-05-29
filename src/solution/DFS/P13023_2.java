package solution.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_2 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive = false;

        A = new ArrayList[N];

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            DFS(i, 1);

            if(arrive) break;
        }

        if(arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void DFS(int num, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[num] = true;
        for(int now : A[num]) {
            if(!visited[now]) {
                DFS(now, depth+1);
            }
        }
        visited[num] = false;
    }
}
