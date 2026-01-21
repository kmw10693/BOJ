import java.io.*;
import java.util.*;

public class Main {
    static int r,c,k;
    static List<List<Integer>> arr;
    static int firstRow = 3, firstCol = 3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>(100);
        for (int i = 0; i < firstRow; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<>());
            for (int j = 0; j < firstCol; j++) {
                arr.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        // 행에 대해서는 -1로 채워야 할듯
        for(int i = 0; i< 100 - firstRow; i++) {
            arr.add(new ArrayList<>());
            for(int j=0; j<firstCol; j++) {
                arr.get(i).add(-1);
            }
        }

        // 열에 대해서도 -1로 채우자
        for(int i= 0; i< 100; i++) {
            for(int j=0; j<100-firstCol; j++) {
                arr.get(i).add(-1);
            }
        }

        // 100초
        for(int i=0; i<=100; i++) {
            if(arr.get(r-1).get(c-1) == k) {
                System.out.print(i);
                return;
            }
            sort();
        }
        System.out.print(-1);
    }
    public static void sort() {
        // 행의 개수 >= 열의 개수
        if(firstRow >= firstCol) {
            rsort();
        }
        // 행의 개수 < 열의 개수
        else csort();
    }
    public static void debug() {
        for(int i=0; i<firstRow; i++) {
            for(int j=0; j<firstCol; j++) {
                System.out.print(arr.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void csort() {
        // firstRow가 바뀔수 있으니 일단 temp로 최댓값 저장
        int temp = firstRow;

        for(int i=0; i<firstCol; i++) {
            // 각각의 수가 몇번 나왔는지 확인
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<firstRow; j++) {
                // 수를 정렬할때 0은 무시 해야 함
                if(arr.get(j).get(i) == -1) continue;
                map.put(arr.get(j).get(i), map.getOrDefault(arr.get(j).get(i), 0) + 1);
            }
            // 다시 정렬을 한다 Value 오름차순, key 오름차순
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(
                    Comparator.comparing(Map.Entry<Integer, Integer>::getValue)
                            .thenComparing(Map.Entry::getKey)
            );
            // 열의 값을 -1로 만들어야 겠지
            for(int k=0; k<firstRow; k++) {
                arr.get(k).set(i, -1);
            }
            // 0번째 인덱스부터 시작
            int tmpRow = 0;
            for(Map.Entry<Integer, Integer> e : list) {
                arr.get(tmpRow++).set(i, e.getKey());
                arr.get(tmpRow++).set(i, e.getValue());
            }
            // max 값으로 바꾸기
            temp = Math.max(tmpRow, temp);
        }
        firstRow = Math.max(firstRow, temp);
    }
    public static void rsort() {
        // firstRow가 바뀔수 있으니 일단 temp로 최댓값 저장
        int temp = firstCol;

        for(int i=0; i<firstRow; i++) {
            // 각각의 수가 몇번 나왔는지 확인
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<firstCol; j++) {
                // 수를 정렬할때 0은 무시 해야 함
                if(arr.get(i).get(j) == -1) continue;
                map.put(arr.get(i).get(j), map.getOrDefault(arr.get(i).get(j), 0) + 1);
            }
            // 다시 정렬을 한다 Value 오름차순, key 오름차순
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(
                    Comparator.comparing(Map.Entry<Integer, Integer>::getValue)
                            .thenComparing(Map.Entry::getKey)
            );
            // 정렬된 연산을 넣고, max 값 바꾸기
            // 근데 -1로 바꾼다. 근데 어차피 0으로 나오는거는 무시해도 됨
            int tempCol = 0;
            for(Map.Entry<Integer, Integer> e : list) {
                arr.get(i).set(tempCol++, e.getKey());
                arr.get(i).set(tempCol++, e.getValue());
            }
            // -1로 바꾸기
            for(int k=tempCol; k<100; k++) arr.get(i).set(k, -1);
            // max 값으로 바꾸기
            temp = Math.max(temp, tempCol);
        }
        firstCol = Math.max(firstCol, temp);

        // 애초에 0으로 채울필요가 없음
    }

}