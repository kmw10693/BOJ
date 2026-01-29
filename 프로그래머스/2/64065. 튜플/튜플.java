import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> hashSet = new HashSet<>();
        
        StringBuilder tmp = new StringBuilder();
        for(int i=1; i<s.length()-1; i++) {
            tmp.append(s.charAt(i));
        }
        
        List<String> tmplist = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        boolean check = false;
        for(int i=0; i<tmp.length(); i++) {
            if(tmp.charAt(i) == '{') {
                check = true;
            }
            if(check && tmp.charAt(i) != '{' && tmp.charAt(i) != '}') {
                num.append(tmp.charAt(i));
            }
            if(tmp.charAt(i) == '}') {
                check = false;
                tmplist.add(num.toString());
                num = new StringBuilder();
            }
        }
        
        List<List<Integer>> intlist = new ArrayList<>();
        for(String tmps : tmplist) {
           List<Integer> intnum = new ArrayList<>(); 
           String[] numtmps = tmps.split(",");
           for(String onenum : numtmps) {
               intnum.add(Integer.parseInt(onenum));
           }
           intlist.add(intnum);
        }
        Collections.sort(intlist, (o1, o2) -> (o1.size() - o2.size()));
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultlist = new ArrayList<>();
        
        for(int i=0; i<intlist.size(); i++) {
            for(int j=0; j<intlist.get(i).size(); j++) {
                if(!map.containsKey(intlist.get(i).get(j))) {
                    resultlist.add(intlist.get(i).get(j));
                    map.put(intlist.get(i).get(j), 1);
                }
            }
        }
        int[] result = new int[resultlist.size()];
        for(int i=0; i<resultlist.size(); i++) {
            result[i] = resultlist.get(i);
        }
        return result;
    }
}