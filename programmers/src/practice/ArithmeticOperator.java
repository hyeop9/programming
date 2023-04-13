package practice;

/**
 * 자릿수 합 구하기
 */

public class ArithmeticOperator {
    int soluton(int n) {
        int sum=0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}