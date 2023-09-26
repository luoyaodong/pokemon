package org.example;

import java.util.List;

public class Pokemon implements Comparable<Pokemon>{
    private String twoShuxing;

    private Integer indexi;

    private Integer indexj;

    private List<Integer> doubleWeakness;

    private List<String> doubleWeaknessName;

    private List<Integer> fourWeakness;

    private List<String> fourWeaknessName;

    private List<Integer> doubleDefense;

    private List<String> doubleDefenseName;

    private List<Integer> fourDefense;

    private List<String> fourDefenseName;

    private List<Integer> totalDefense;

    private List<String> totalDefenseName;

    private String taijinshuxing;

    private double defendScore;

    private double attackScore;

    private double averageScore;

    public List<Integer> getDoubleDefense() {
        return doubleDefense;
    }

    public void setDoubleDefense(List<Integer> doubleDefense) {
        this.doubleDefense = doubleDefense;
    }

    public List<String> getDoubleDefenseName() {
        return doubleDefenseName;
    }

    public void setDoubleDefenseName(List<String> doubleDefenseName) {
        this.doubleDefenseName = doubleDefenseName;
    }

    public List<Integer> getFourDefense() {
        return fourDefense;
    }

    public void setFourDefense(List<Integer> fourDefense) {
        this.fourDefense = fourDefense;
    }

    public List<String> getFourDefenseName() {
        return fourDefenseName;
    }

    public void setFourDefenseName(List<String> fourDefenseName) {
        this.fourDefenseName = fourDefenseName;
    }

    public List<Integer> getTotalDefense() {
        return totalDefense;
    }

    public void setTotalDefense(List<Integer> totalDefense) {
        this.totalDefense = totalDefense;
    }

    public List<String> getTotalDefenseName() {
        return totalDefenseName;
    }

    public void setTotalDefenseName(List<String> totalDefenseName) {
        this.totalDefenseName = totalDefenseName;
    }

    public Integer getIndexi() {
        return indexi;
    }

    public void setIndexi(Integer indexi) {
        this.indexi = indexi;
    }

    public Integer getIndexj() {
        return indexj;
    }

    public void setIndexj(Integer indexj) {
        this.indexj = indexj;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(double attackScore) {
        this.attackScore = attackScore;
    }

    public String getTwoShuxing() {
        return twoShuxing;
    }

    public void setTwoShuxing(String twoShuxing) {
        this.twoShuxing = twoShuxing;
    }

    public List<Integer> getDoubleWeakness() {
        return doubleWeakness;
    }

    public void setDoubleWeakness(List<Integer> doubleWeakness) {
        this.doubleWeakness = doubleWeakness;
    }

    public List<Integer> getFourWeakness() {
        return fourWeakness;
    }

    public void setFourWeakness(List<Integer> fourWeakness) {
        this.fourWeakness = fourWeakness;
    }

    public String getTaijinshuxing() {
        return taijinshuxing;
    }

    public void setTaijinshuxing(String taijinshuxing) {
        this.taijinshuxing = taijinshuxing;
    }

    public double getDefendScore() {
        return defendScore;
    }

    public void setDefendScore(double defendScore) {
        this.defendScore = defendScore;
    }

    public List<String> getDoubleWeaknessName() {
        return doubleWeaknessName;
    }

    public void setDoubleWeaknessName(List<String> doubleWeaknessName) {
        this.doubleWeaknessName = doubleWeaknessName;
    }

    public List<String> getFourWeaknessName() {
        return fourWeaknessName;
    }

    public void setFourWeaknessName(List<String> fourWeaknessName) {
        this.fourWeaknessName = fourWeaknessName;
    }

    @Override
    public int compareTo(Pokemon o) {
//        Double dL = Double.valueOf(this.getDefendScore());
//        Double dR = Double.valueOf(o.getDefendScore());
        Double dL = Double.valueOf(this.getAverageScore());
        Double dR = Double.valueOf(o.getAverageScore());
        return dR.compareTo(dL);
    }


}
