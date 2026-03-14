import java.io.*;
import java.util.*;

class Solution {
    int SIZE = 50;
    int[] parent = new int[SIZE * SIZE + 10];
    String[] valuearr = new String[SIZE * SIZE + 10];
    
    public String[] solution(String[] commands) {
        List<String> anslist = new ArrayList<>();
        
        for(int i=0; i<SIZE*SIZE; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<SIZE*SIZE; i++) {
            valuearr[i] = "";
        }
        
        for(String command : commands) {
            String[] splitc = command.split(" ");
            String editc = splitc[0];
            
            if(editc.equals("UPDATE")) {
                if(splitc.length == 4) {
                    int r = Integer.parseInt(splitc[1]);
                    int c = Integer.parseInt(splitc[2]); 
                    String value = splitc[3];
                    int onedimensionidx = getonedimension(r, c);
                    
                    int root = unionfind(onedimensionidx);
                    valuearr[root] = value;
                } else if(splitc.length == 3) {
                    String value1 = splitc[1];
                    String value2 = splitc[2];
                    
                    for(int i=0; i<SIZE*SIZE; i++) {
                        if(parent[i] == i && valuearr[i].equals(value1)) {
                            valuearr[i] = value2;
                        }
                    }
                }
            } else if(editc.equals("MERGE")) {
                int r1 = Integer.parseInt(splitc[1]);
                int c1 = Integer.parseInt(splitc[2]);
                
                int r2 = Integer.parseInt(splitc[3]);
                int c2 = Integer.parseInt(splitc[4]);
                
                int firstonedim = unionfind(getonedimension(r1, c1));
                int secondonedim = unionfind(getonedimension(r2, c2));
                
                if(firstonedim == secondonedim) continue;
                
                int oneparent = unionfind(firstonedim);
                int secondparent = unionfind(secondonedim);
                
                parent[secondparent] = oneparent;
                
                if(valuearr[oneparent].isEmpty() && !valuearr[secondparent].isEmpty()) {
                    valuearr[oneparent] = valuearr[secondparent];
                }
                valuearr[secondparent] = "";
            } else if(editc.equals("UNMERGE")) {
                int r = Integer.parseInt(splitc[1]);
                int c = Integer.parseInt(splitc[2]);
                
                int parentidx = getonedimension(r, c);
                int rootparentidx = unionfind(parentidx);
                    
                String memory = valuearr[rootparentidx];
                
                List<Integer> sameparentlist = new ArrayList<>();
                
                for(int i=0; i<SIZE*SIZE; i++) {
                    if(unionfind(i) == rootparentidx) {
                        sameparentlist.add(i);
                    }
                }
                
                for(Integer spl : sameparentlist) {
                    parent[spl] = spl;
                    valuearr[spl] = "";
                }
                
                valuearr[parentidx] = memory;
                
            } else if(editc.equals("PRINT")) {
                int r = Integer.parseInt(splitc[1]);
                int c = Integer.parseInt(splitc[2]);
                
                int onedim = getonedimension(r, c);
                String eachprint = valuearr[unionfind(onedim)].isEmpty() ? "EMPTY" : valuearr[unionfind(onedim)];
                anslist.add(eachprint);
            }
            
        }
        return anslist.toArray(new String[0]);
    }
    
    public int unionfind(int idx) {
        if(parent[idx] == idx) return idx;
        return parent[idx] = unionfind(parent[idx]);
    }
    
    public int getonedimension(int r, int c) {
        return SIZE * (r-1) + (c-1);
    }
}