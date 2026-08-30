import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int ans = 0;
        
        for(String st : skill_trees) {
            String containskill = "";
            
            for(int i=0; i<st.length(); i++) {
                for(int j=0; j<skill.length(); j++) {
                    if(skill.charAt(j) == st.charAt(i)) containskill += skill.charAt(j);
                }
            }
            
            int minlength = Math.min(containskill.length(), skill.length());
            boolean eachans = true;
            for(int i=0; i< minlength; i++) {
                if(containskill.charAt(i) != skill.charAt(i)) eachans = false;
            }
            if(eachans) ans++;
        }
        return ans;
    }
}