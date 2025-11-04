class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        if(length == 1) {
            int[] tmp = {-1};
            return tmp;
        }
        
        int min = Integer.MAX_VALUE;
        int[] ans = new int[length-1];
        
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == min) continue;
            else ans[idx++] = arr[i];
        }
        return ans;
    }
}