package practice;

/**
 * 나머지 한 점 찾기
 * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다.
 * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때,
 * 직사각형을 만드는 데 필요한 나머지 한점의 좌표를 return 하도록 solution 함수를 완성해주세요.
 * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
 */

public class LastPoint {
    int[] solution(int[][] v) {
        int x, y;

        // x좌표값 찾기
        if (v[0][0] == v[1][0]) {
            x = v[2][0];
        } else if (v[0][0] == v[2][0]) {
            x = v[1][0];
        } else {
            x = v[0][0];
        }

        // y좌표값 찾기
        if (v[0][1] == v[1][1]) {
            y = v[2][1];
        } else if (v[0][1] == v[2][1]) {
            y = v[1][1];
        } else {
            y = v[0][1];
        }

        int[] answer = {x, y};
        return answer;
    }
}
