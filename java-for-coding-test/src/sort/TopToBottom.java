package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 위에서 아래로.
 * 하나의 수열에는 다양한 수가 존재한다. 이러한 수는 크기에 상관없이 나열되어 있다.
 * 이 수를 큰 수부터 작은 수의 순서로 정렬해야 한다. 수열의 내림차군으로 정렬하는 프로그램을 만드시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다.
 * 둘째 줄부터 N + 1번째 줄까지 N개의 수가 입력된다.
 */

public class TopToBottom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력 받기
        int n = sc.nextInt();

        // N개의 정수를 입력받아 리스트에 저장
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
