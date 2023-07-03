package binary_serach;

import java.util.Scanner;

/**
 * 떡볶이 떡 만들기
 * 높이 H를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
 * 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건:
 * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다.
 * 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이므로, 필요한 양만큼 가져갈 수 있다.
 */

public class RiceCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;

        // 이진 탐색 수행
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                // 잘랐을 때의 떡의 양 계산
                if (arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }
            // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
            if (total < m) {
                end = mid - 1;
            }
            // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
            else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
