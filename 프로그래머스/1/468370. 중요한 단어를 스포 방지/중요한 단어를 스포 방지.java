import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        int m = spoiler_ranges.length;

        List<String> spoilerWords = new ArrayList<>();
        List<Integer> revealTimes = new ArrayList<>();
        Set<String> normalWords = new HashSet<>();

        int r = 0;
        int order = 0;

        for (int i = 0; i < n; ) {
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i - 1;

            String word = message.substring(start, end + 1);

            while (r < m && spoiler_ranges[r][1] < start) r++;

            boolean isSpoiler = false;
            int last = -1;
            int t = r;

            while (t < m && spoiler_ranges[t][0] <= end) {
                isSpoiler = true;
                last = t;
                t++;
            }

            if (isSpoiler) {
                spoilerWords.add(word);
                revealTimes.add(last * 100000 + order); // 공개 시점 + 왼쪽부터 순서
            } else {
                normalWords.add(word);
            }

            order++;
            i++; // 공백 넘기기
        }

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < spoilerWords.size(); i++) idx.add(i);

        idx.sort((a, b) -> Integer.compare(revealTimes.get(a), revealTimes.get(b)));

        int answer = 0;
        Set<String> seen = new HashSet<>();

        for (int i : idx) {
            String word = spoilerWords.get(i);
            if (normalWords.contains(word)) continue;
            if (seen.contains(word)) continue;
            seen.add(word);
            answer++;
        }

        return answer;
    }
}