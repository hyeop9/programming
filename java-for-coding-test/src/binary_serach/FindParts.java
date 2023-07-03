package binary_serach;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 부품 찾기
 * 부품이 N개 있고, M개의 종류를 모두 확인하는 프로그램을 작성하시오.
 * 이때 부품 번호가 순서대로 있으면 yes를, 없으면 no를 출력하시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 정수 N이 주어진다.
 * 둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다.
 * 셋째 줄에는 정수 M이 주어진다.
 * 넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다.
 */

public class FindParts {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) {
                return mid;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(요청한 부품 개수)
        int m = sc.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        // 부품 번호 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품 존재하는지 확인
            int result = binarySearch(arr, target[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
