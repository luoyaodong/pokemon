package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Majiang {
    static List<List<Integer>> result = new ArrayList<>();
    static int total=0;
    static int total3=0;
    static int total2=0;
    public static void main(String[] args) {

        List<Integer> temp = new ArrayList<>();
        findOne(temp,0);
        for(int i=0;i<result.size();i++){
            System.out.println(total2);
            System.out.println(total3);
            System.out.println(total);
//            System.out.println(i+result.get(i).toString());
        }
    }
    static void findOne(List<Integer> list,int index){
        if(list.size()<4){
            for(int i=1;i<4;i++){
                list.add(i);
                findOne(list,index+1);
                list.remove(index);
            }
        }else {
            int count = findMaxDuplicate(list);
            total++;
            if(count==3){
                total3++;
                System.out.println(list.toString());
            }else if(count==2){
                total2++;
            }
            result.add(list);
        }
    }

    static int findMaxDuplicate(List<Integer> array) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int maxElement = array.get(0);

        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > maxCount) {
                maxCount = countMap.get(num);
                maxElement = num;
            }
        }
        return maxCount;
    }
}
