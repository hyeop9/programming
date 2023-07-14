package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 미래 도시
 * 공중 미래 도시에는 1번부터 N번까지의 회사가 있는데 특정 회사끼리는 서로 도로를 통해 연결되어 있다.
 * A는 현재 1번 회사에 위치해 있으며, X번 회사에 방문해 물건을 판매하고자 한다.
 * 회사끼리 연결되어 있는 도로를 이용하는 방법이 유일하다. 또한 연결된 2개의 회사는 양방향으로 이동이 가능하다.
 * 이동시간은 1이다.
 * A는 1번 회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 것이 목표다.
 * 최소 시간을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 전체 회사의 개수 N과 경로의 개수 M이 공으로 구분되어 차례대로 주어진다.
 * 둘째 줄부터 M + 1번째 줄에는 연결된 두 회사의 번호가 공백으로 구분되어 주어진다.
 * M + 2번째 줄에는 X와 K가 공백으로 구분되어 차례대로 주어진다.
 */

public class FutureCity {

    public static final int INF = (int) 1e9;
    // 노드의 개수(N), 간선의 개수(M), 거쳐 갈 노드(X), 최종 목적지 노드(K)
    public static int n, m, x, k;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신 => 자기 자신 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력받아 초기화
        for (int i = 0; i < m; i++) {
            // A와 B가 서로에게 가는 비용 1
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 플로이드 워셜 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1 출력
        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}
