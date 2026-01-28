import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        for(int i=0; i<skill_trees.length; i++) {
            if(check(skill, skill_trees[i])) ans++;
        }
        return ans;
    }
    public boolean check(String skill, String skill_trees){
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<skill.length(); i++) q.add(skill.charAt(i));
        for(int i=0; i<skill_trees.length(); i++) {
            if(check2(skill, skill_trees.charAt(i)) && !q.isEmpty() && q.peek() != skill_trees.charAt(i)) return false;
            else if(!q.isEmpty() && q.peek() == skill_trees.charAt(i)) q.poll()
                    ;        }
        return true;
    }
    public boolean check2(String skill, char skill2) {
        for(int i=0; i<skill.length(); i++) {
            if(skill.charAt(i) == skill2) return true;
        }
        return false;
    }
}