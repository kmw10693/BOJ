class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sub = s.split(" ");
        for(int i=0; i<sub.length; i++) {
            String s2 = sub[i];
            System.out.println(s2);
            if(s2.length() == 0){
                answer += " ";
            }
            else {
                answer += s2.substring(0,1).toUpperCase();
                answer += s2.substring(1, s2.length()).toLowerCase();
                answer += " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        return answer.substring(0, answer.length()-1);
    }
}