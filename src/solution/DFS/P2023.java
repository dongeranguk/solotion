package solution.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2023 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 자릿수가 한개인 소수는 2,3,5,7 이므로 이 수부터 탐색 시작
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

    }

    static void DFS(int num, int jarisu) { // 재귀함수 형태
        if (jarisu == N) {
            if(isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for(int i=1; i<10; i++) {
            if(i % 2 == 0) { // 뒤에 붙는 수가 홀수이면서,
                continue;
            }

            if(isPrime(num*10+i)) { // 소수일 때
                DFS(num * 10 + i, jarisu + 1); // 자릿수 1씩 늘리면서 DFS 실행
            }
        }
    }

    // 소수 구하기 함수
    static boolean isPrime(int num) {
        for(int i=2; i<num/2; i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
