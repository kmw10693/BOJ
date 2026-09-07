import java.util.*;

class Solution {

    long[] end;
    long[] prefixSum;
    int[] arr;

    public long[] solution(int[] arr, long l, long r) {
        this.arr = arr;

        int n = arr.length;

        end = new long[n];
        prefixSum = new long[n];

        long totalLength = 0;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalLength += arr[i];

            // arr[i]가 arr[i]번 등장
            totalSum += (long) arr[i] * arr[i];

            end[i] = totalLength;
            prefixSum[i] = totalSum;
        }

        long len = r - l + 1;

        // 1. K 계산
        long K = getPrefix(r) - getPrefix(l - 1);

        /*
         * 윈도우 시작점:
         *
         * 0 ~ totalLength - len
         */
        long maxStart = totalLength - len;

        List<Long> events = new ArrayList<>();

        events.add(0L);
        events.add(maxStart);

        // 마지막 end는 totalLength라 실제 값 변경 경계가 아님
        for (int i = 0; i < n - 1; i++) {

            long e = end[i];

            // brr[s]가 바뀌는 지점
            if (0 < e && e < maxStart) {
                events.add(e);
            }

            // brr[s + len]이 바뀌는 지점
            long shifted = e - len;

            if (0 < shifted && shifted < maxStart) {
                events.add(shifted);
            }
        }

        Collections.sort(events);

        // 중복 제거
        List<Long> points = new ArrayList<>();

        for (long x : events) {
            if (points.isEmpty()
                    || points.get(points.size() - 1) != x) {
                points.add(x);
            }
        }

        // 시작점 0에서의 윈도우 합
        long current = getPrefix(len);

        long C = 0;

        long start = 0;

        for (int i = 1; i < points.size(); i++) {

            long next = points.get(i);

            /*
             * start ~ next-1 구간에서는
             *
             * brr[s]
             * brr[s + len]
             *
             * 두 값이 변하지 않음.
             */

            long out = getValue(start);
            long in = getValue(start + len);

            long diff = in - out;

            /*
             * 검사해야 하는 시작점 개수
             *
             * start, start+1, ... next-1
             */
            long count = next - start;

            if (diff == 0) {

                // 구간 전체의 윈도우 합이 동일
                if (current == K) {
                    C += count;
                }

            } else {

                /*
                 * current + diff * t = K
                 *
                 * t = (K-current)/diff
                 */

                long target = K - current;

                if (target % diff == 0) {

                    long t = target / diff;

                    if (0 <= t && t < count) {
                        C++;
                    }
                }
            }

            // next 지점의 윈도우 합
            current += diff * count;

            start = next;
        }

        // 마지막 시작점 maxStart
        if (current == K) {
            C++;
        }

        return new long[]{K, C};
    }

    /*
     * brr 앞에서 x개 원소 합
     */
    private long getPrefix(long x) {

        if (x == 0) {
            return 0;
        }

        int left = 0;
        int right = end.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (end[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int idx = left;

        long prevEnd = idx == 0 ? 0 : end[idx - 1];
        long prevSum = idx == 0 ? 0 : prefixSum[idx - 1];

        long count = x - prevEnd;

        return prevSum + count * arr[idx];
    }

    /*
     * 0-based brr[pos] 값
     */
    private long getValue(long pos) {

        int left = 0;
        int right = end.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            /*
             * end는 exclusive boundary.
             *
             * pos < end[mid]인 첫 run 찾기
             */
            if (pos < end[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return arr[left];
    }
}