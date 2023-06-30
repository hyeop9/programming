package implementation;

import java.util.Scanner;

/**
 * 상하좌우 문제
 * A는 N x N 크기의 정사각형 공간 위에 서 있다. 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다.
 * 가장 왼쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다.
 * A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1)이다.
 * N x N 크기의 정사각형 공간을 벗아너난 움직임은 무시된다.
 * 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 공간의 크기를 나타내는 N이 주어진다.
 * 둘째 줄에 A가 이동할 내용이 주어진다.
 */

public class UDLR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력 받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D 에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            // 이동 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
