package practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단어 퍼즐 문제 단어 퍼즐은 주어진 단어 조각들을 이용해서 주어진 문장을 완성하는 퍼즐입니다. 이때, 주어진 각 단어 조각들은 각각 무한개씩 있다고 가정합니다. 예를 들어 주어진 단어 조각이 [“ba”,
 * “na”, “n”, “a”]인 경우 "ba", "na", "n", "a" 단어 조각이 각각 무한개씩 있습니다. 이때, 만들어야 하는 문장이 “banana”라면 “ba”, “na”, “n”, “a”의 4개를
 * 사용하여 문장을 완성할 수 있지만, “ba”, “na”, “na”의 3개만을 사용해도 “banana”를 완성할 수 있습니다. 사용 가능한 단어 조각들을 담고 있는 배열 strs와 완성해야 하는 문자열 t가
 * 매개변수로 주어질 때, 주어진 문장을 완성하기 위해 사용해야 하는 단어조각 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 만약 주어진 문장을 완성하는 것이 불가능하면 -1을
 * return 하세요.
 */

public class WordPuzzle {
    String t;
    String[] strs;
    int dp[];

    //문자열의 길이 순 정렬
    Comparator<String> c = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return Integer.compare(s2.length(), s1.length());
        }
    };

    int solve(int idx) {

        //dp[i]는 i~마지막 문자열을 채울 수 있는 최소 횟수를 의미

        //더 이상 진행 불가능
        if (idx == t.length()) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // 최소값을 찾아야 하므로 충분히 큰 값으로 초기화
        dp[idx] = 20001;
        for (int i = 0; i < strs.length; i++) {

            // (현재까지 만들어진 문자열의 길이 + 새로운 퍼즐의 크기)가
            // 단어의 길이보다 짧아야 함
            if (idx + strs[i].length() <= t.length()) {
                boolean flag = true;
                // substring으로 잘라서 문자열을 비교할경우 시간초과가 납니다. ㅠㅠ
                // 채워나갈 수 있는 단어인지 검사
                for (int j = 0; j < strs[i].length(); j++) {
                    if (t.charAt(idx + j) != strs[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    dp[idx] = Math.min(dp[idx], solve(idx + strs[i].length()) + 1);
                }
            }
        }
        return dp[idx];
    }

    public int solution(String[] strs, String t) {

        dp = new int[t.length()];
        Arrays.fill(dp, -1);
        Arrays.sort(strs, c);
        this.strs = strs;
        this.t = t;

        int answer = solve(0);
        return answer = (answer <= 20000) ? answer : -1;
    }
}
