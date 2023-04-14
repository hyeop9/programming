package practice;

/**
 * 땅따먹기 문제
 * 땅따먹기 게임을 하려고 합니다.
 * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
 */
public class Land {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += maxScore(land[i - 1][1], land[i - 1][2], land[i - 1][3]); // 이전 행에서 현재칸을 제외한 칸의 최대값을 더함
            land[i][1] += maxScore(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += maxScore(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += maxScore(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }

        for (int score : land[land.length - 1]) { // 마지막 행의 최대값 탐색
            answer = Math.max(answer, score);
        }

        return answer;
    }

    public int maxScore(int a, int b, int c) {
        int max = 0;

        max = Math.max(Math.max(a, b), c);

        return max;
    }
}
