package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        combine(0,2,shuxing);
        for(int i=0;i<pokemons.size();i++){
//            System.out.println(twoCombines[i]);
        }

        for(int i=0;i<result.length;i++){
            Pokemon pokemon = pokemons.get(i);
//            System.out.printf(pokemon.getTwoShuxing()+"---");
            double he = 0;
            List<Integer> doubleWeakness = new ArrayList<>();

            List<String> doubleWeaknessName = new ArrayList<>();

            List<Integer> fourWeakness = new ArrayList<>();

            List<String> fourWeaknessName = new ArrayList<>();

            List<Integer> doubleDefense = new ArrayList<>();

            List<String> doubleDefenseName = new ArrayList<>();

            List<Integer> fourDefense = new ArrayList<>();

            List<String> fourDefenseName = new ArrayList<>();

            List<Integer> totalDefense = new ArrayList<>();

            List<String> totalDefenseName = new ArrayList<>();

            for(int j=0;j<result[i].length;j++){
//                System.out.print(result[i][j]+",");
                if(result[i][j]==2){
                    doubleWeakness.add(j);
                    doubleWeaknessName.add(shuxing[j]);
                }else if(result[i][j]==4){
                    fourWeakness.add(j);
                    fourWeaknessName.add(shuxing[j]);
                }else if(result[i][j]==0.5){
                    doubleDefense.add(j);
                    doubleDefenseName.add(shuxing[j]);
                }else if(result[i][j]==0.25){
                    fourDefense.add(j);
                    fourDefenseName.add(shuxing[j]);
                }else if(result[i][j]==0){
                    totalDefense.add(j);
                    totalDefenseName.add(shuxing[j]);
                }
                he = he+result[i][j];
            }
//            System.out.println();

            pokemon.setDefendScore(40-he);
            pokemon.setDoubleWeakness(doubleWeakness);
            pokemon.setDoubleWeaknessName(doubleWeaknessName);
            pokemon.setFourWeakness(fourWeakness);
            pokemon.setFourWeaknessName(fourWeaknessName);
            pokemon.setDoubleDefense(doubleDefense);
            pokemon.setDoubleDefenseName(doubleDefenseName);
            pokemon.setFourDefense(fourDefense);
            pokemon.setFourDefenseName(fourDefenseName);
            pokemon.setTotalDefense(totalDefense);
            pokemon.setTotalDefenseName(totalDefenseName);
            List<Integer> weakness = new ArrayList<>();
            weakness.addAll(doubleWeakness);
            weakness.addAll(fourWeakness);

            pokemon.setDefendScore(pokemon.getDefendScore());

            pokemon.setTaijinshuxing(getTaijing(weakness));
            pokemon.setAttackScore(getAttackScore(pokemon));
            pokemon.setAverageScore((pokemon.getAttackScore()+pokemon.getDefendScore())/2);
            pokemons.set(i,pokemon);
        }

        Collections.sort(pokemons);
        pokemons = pokemons.stream().filter(pokemon -> {
            return (pokemon.getDoubleDefense().size()+pokemon.getFourDefense().size()+pokemon.getTotalDefense().size())>3
                    && (pokemon.getDoubleWeakness().size()+pokemon.getFourWeakness().size())<3;
        }).collect(Collectors.toList());
        System.out.println("属性---平均分---攻击分---防御分---钛晶属性---二倍抵抗---四倍抵抗---完全抵抗---二倍弱点---四倍弱点");
        for(Pokemon pokemon:pokemons){

            System.out.println(pokemon.getTwoShuxing()+"---"+pokemon.getAverageScore()+"---"+
                    pokemon.getAttackScore()+"---"+pokemon.getDefendScore()+"---"+pokemon.getTaijinshuxing()+"---"+
                    pokemon.getDoubleDefenseName().toString()+"---"+ pokemon.getFourDefenseName().toString()+"---"+pokemon.getTotalDefenseName()+"---"+
                    pokemon.getDoubleWeaknessName().toString()+"---"+ pokemon.getFourWeaknessName().toString());
        }

        List<String> danruodian = new ArrayList<>();
        for(int i=0;i<18;i++){
            String s = "";
            for(Pokemon pokemon:pokemons){
                if(pokemon.getDoubleWeakness().size()==1 && pokemon.getFourWeakness().size()==0){
                    if(pokemon.getDoubleWeakness().contains(i)){
                        s=s+" "+pokemon.getTwoShuxing();
                    }
                }else if(pokemon.getDoubleWeakness().size()==0 && pokemon.getFourWeakness().size()==1){
                    if(pokemon.getFourWeakness().contains(i)){
                        s=s+" "+pokemon.getTwoShuxing();
                    }
                }
            }
            danruodian.add(s);
        }
        danruodian.stream().forEach(System.out::println);
    }

    private static String getTaijing(List<Integer> weakness){
        Map<Integer,Double> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        for(int i=0;i<18;i++){
            double total = 0.0;
            for(int j=0;j<weakness.size();j++){
                total += maxtrix[weakness.get(j)][i];
            }
//            System.out.println(total);
            list.add(total);
            map.put(i,total);
        }
        //取最小值
        Double ipCountMin = Collections.min(list);
        //取最大值
        //Integer ipCountMax = Collections.max(ipCountList);
        //取索引
        AtomicReference<String> name = new AtomicReference<>("");
        map.forEach((k,v)->{
            if(v.equals(ipCountMin)){
                name.set(name + " " + shuxing[k]);
            }
        });
        return name.get();
    }

    private static Double getAttackScore(Pokemon pokemon){
        Integer indexi = pokemon.getIndexi();
        Integer indexj = pokemon.getIndexj();

        double he = 0;

        for(int i=0;i<18;i++){
            Double tempa = result[indexi][i];
            Double tempb = result[indexj][i];
            if(tempa.compareTo(tempb)>0){
                he = he+result[indexi][i];
            }else {
                he = he+result[indexj][i];
            }

        }

        return he;
    }


    public static String[] shuxing = {"一般", "斗", "飞", "毒", "地", "岩", "虫", "幽", "钢", "火", "水", "草", "电", "超", "冰", "龙", "恶", "妖精"};
    public static double[][] maxtrix = {
            {1, 1, 1, 1, 1, 0.5, 1,0, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5},
            {1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1, 1, 1, 1},
            {1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1, 1, 1, 2},
            {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1, 1, 1, 1},
            {1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1, 1, 2, 0.5},
            {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 1, 1, 2},
            {1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2, 0.5, 1, 1},
            {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5, 1, 1},
            {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 0.5, 2, 0.5, 1, 1, 1, 0.5, 1, 1},
            {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5, 1, 1},
            {1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 1, 0, 1},
            {1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5, 2, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 1, 1, 2, 1, 0},
            {1, 0.5, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5},
            {1, 2, 1, 0.5, 1, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 1, 1, 2, 2, 1}
    };
    private static double result[][] = new double[171][18];

    private static List<Pokemon> pokemons = new ArrayList<>();
    private static ArrayList<String> tmpArr = new ArrayList<>();
    private static int count = 0;
    public static void combine(int index,int k,String []arr) {
        if(k == 1){
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                caculateResult(result,index,i);
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = index; i <= arr.length - k+1; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combine(i,k - 1, arr); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }
    }

    private static void caculateResult(double[][] result, int index, int indexj) {
        for(int i =0; i<18; i++){
            result[count][i] = maxtrix[i][index]*maxtrix[i][indexj];
        }
        Pokemon pokemon  = new Pokemon();
        pokemon.setIndexi(index);
        pokemon.setIndexj(indexj);
        pokemon.setTwoShuxing(tmpArr.toString());
        pokemons.add(pokemon);
        count ++;
    }


}