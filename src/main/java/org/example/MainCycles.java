package org.example;

import java.util.*;

import static org.example.Main.maxtrix;
import static org.example.Main.shuxing;

public class MainCycles {

    public static  List<List<Integer>> results = new ArrayList<>();
    public static void main(String[] args) {
        getCicles();
    }

    /** 求一个环/
     *
     */
    public static void getCicles() {
        for(int i=0;i<shuxing.length;i++){
            Stack<Integer> list = new Stack<>();
            list.add(i);
            caculateCircle(3,0,list);
        }
        Map<String,Integer> map = new HashMap<>();
        for(List<Integer> list: results){
            String s="";
            for(int i=0;i<list.size();i++){
                String name = shuxing[list.get(i)];
                s = s+name+"===>";
                Integer count = map.get(name);
                if(count != null){
                    count = count+1;
                    map.put(name,count);
                }else {
                    map.put(name,1);
                }
            }
            System.out.println(s);
        }

        map.forEach((k,v)->{
            System.out.println(k+v);
        });
    }

    /**
     * 获取最大的路径
     * @param maxDepth
     * @param depth
     * @param stack
     */
    private static void caculateCircle(int maxDepth, int depth,Stack<Integer> stack) {
        if(depth>=maxDepth){
            return;
        }
        depth = depth+1;
        int temp = stack.get(stack.size()-1);
        int start = stack.get(0);
        List<Integer> doubleValue = getDoubleValue(temp);
        for(int m =0;m<doubleValue.size();m++){
            int tempdoubleValue = doubleValue.get(m);
            if(tempdoubleValue == start){
                boolean flag = true;
                for(List<Integer> tempList:results){
                    if(tempList.containsAll(stack)){
                        flag = false;
                    }
                    if(stack.containsAll(tempList)){
                        flag = false;
                    }
                }
                if(flag){
                    //深拷贝
                    List<Integer> clone = new ArrayList<>();
                    for(int i =0;i<stack.size();i++){
                        clone.add(stack.get(i));
                    }
                    results.add(clone);
                }
                return;
            }else {
                stack.push(tempdoubleValue);
                caculateCircle(maxDepth,depth,stack);
                //关键弹出
                stack.pop();
            }
        }
    }

    private static List<Integer> getDoubleValue(int i){
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<shuxing.length;j++){
            if(maxtrix[i][j] == 2){
                list.add(j);
            }
        }
        return list;
    }
}
