package DP;

import java.util.Scanner;

/**
 * 1로 만들기
 * 정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
 * 1. X가 5로 나누어떨어지면, 5로 나눈다.
 * 2. X가 3으로 나누어떨어지면, 3로 나눈다.
 * 3. X가 2로 나누어떨어지면, 2로 나눈다.
 * 4. X에서 1을 뺀다.
 * 정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 정수 X가 주어진다.
 */

public class MakeOne {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍 진행
        for (int i = 2; i <= x; i++) {
            // 현재 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 현재 수에가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }
        System.out.println(d[x]);
    }
}
