package greedy;

/**
 * 거스름돈 문제
 * 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
 * 손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라.
 * 단, 거슬러 줘야 할 돈 N은 항상 10배수 이다.
 */

public class Change {
    public static void main(String[] args) {
        int n = 1206;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }
        System.out.println(cnt);
    }
}