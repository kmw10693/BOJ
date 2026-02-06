class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length-1];
        int secondlast = num_list[num_list.length-2];
        
        int[] newlist = new int[num_list.length+1];
        for(int i=0; i<num_list.length; i++) {
            newlist[i] = num_list[i];
        }
        if(last > secondlast) newlist[num_list.length] = last - secondlast;
        else newlist[num_list.length] = last*2;
        return newlist;
    }
}