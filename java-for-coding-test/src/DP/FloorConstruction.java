package DP;

import java.util.Scanner;

/**
 * 바닥 공사
 * 가로 길이가 N, 세로 길이가 2인 직사각형 형태의 얇은 바닥이 있다.
 * 이 얇은 바닥을 1 x 2의 덮개, 2 x 1의 덮개, 2 x 2의 덮개를 이용해 채우고자 한다.
 * 이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건:
 * 첫번 째 줄에 N이 주어진다.
 */

public class FloorConstruction {

    // DP 테이블 초기화
    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        System.out.println(d[n]);
    }
}
