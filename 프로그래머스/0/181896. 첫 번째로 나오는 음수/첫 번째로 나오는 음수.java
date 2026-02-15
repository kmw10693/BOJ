class Solution {
   public int solution(int[] num_list) {
       // num_list를 순회하면서 음수 찾기
       for (int i=0; i<num_list.length; i++) {
           // 현재 숫자가 0보다 작으면 (음수이면)
           // 해당 인덱스를 바로 반환
           if (num_list[i] < 0) {
               return i;
           }
       }
       
       // 음수를 찾지 못한 경우 -1 반환
       return -1;
   }
}