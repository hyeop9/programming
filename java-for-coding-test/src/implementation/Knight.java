package implementation;

import java.util.Scanner;

/**
 * 체스판과 같은 8 x 8 좌표 평면에서 다음과 같은 2가지 경우로 이동할 수 있다.
 * <p>
 * 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
 * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
 *
 * 8 x 8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
 * 이때 행의 위치는 1부터 8로, 열의 위치는 a부터 h로 표현한다.
 *
 * 입력 조건:
 * 'a1'과 같은 두 문자로 구성된 좌표를 입력한다.
 */

public class Knight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 현재 나이트 위치 입력 받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
