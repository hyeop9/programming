package DP;

import java.util.Scanner;

/**
 * 개미 전사
 * 식량창고는 일직선으로 이어져 있다.
 * 각 식향창고에는 정해진 수의 식량을 저장하고 있으며 개미 전사는 선택적으로 약탈하여 식량을 빼앗을 예정이다.
 * 약탈하기 위해선 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 한다.
 * 식량창고 N개에 대한 정보가 주어졌을 때, 얼ㄷ을 수 있는 식량의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 입력 조건:
 * 첫째 줄에 식량창고의 개수 N이 주어진다.
 * 둘째 줄에 공백으로 구분되어 각 식량창고에 저장된 식량의 개수 K가 주어진다.
 */

public class AntWarrior {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 모든 식량 정보 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 다이나믹 프로그래밍 진행
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println(d[n - 1]);
    }
}
