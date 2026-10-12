class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        if(n<=2) {
            return n;
        }
        
        int[] rightMin = new int[n];
        rightMin[n-1] = a[n-1];
        
        for(int i=n-2; i>=0; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i+1]);
        }
        
        int answer = 2;
        int leftMin = a[0];
        
        for(int i=1; i<n-1; i++) {
            if(a[i] < leftMin || a[i] < rightMin[i+1]) {
                answer++;
            }
            leftMin = Math.min(leftMin, a[i]);
        }
        return answer;
    }
}