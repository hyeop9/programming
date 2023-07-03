package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 두 배열의 원소 교체
 * 두 개의 배열 A와 B는 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.
 * 최대 K번의 바꿔치기 연산을 수행할 수 있는데, 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다.
 * 최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이다.
 * N, K, 그리고 배열 A와 B의 정보가 주어졌을 때,
 * 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건:
 * 첫 번째 줄에 N, K가 공백으로 구분되어 입력된다.
 * 두 번째 줄에 배열 A의 원소들이 공백으로 구분되어 입력된다.
 * 세 번째 줄에 배열 B의 원소들이 공백으로 구분되어 입력된다.
 */

public class Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // A는 오름차순 정렬
        Arrays.sort(a);

        // B는 내림차순 정렬
        Arrays.sort(b, Collections.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                // swap
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}
