package level2;

/**
 * 피보나치 수
 * 2 이상의 n이 입력되었을 때,
 * n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 */

public class Fibonacci {
    public int solution(int n) {
        int answer[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                answer[i] = 0;
            } else if (i == 1) {
                answer[i] = 1;
            } else {
                int sum = answer[i - 2] + answer[i - 1];
                answer[i] = sum % 1234567;
            }
        }

        return answer[n];
    }
}
