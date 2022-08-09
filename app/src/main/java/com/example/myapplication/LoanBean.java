package com.example.myapplication;



public class LoanBean {
    /*
　　id             当月月数 唯一 id
　　all            总金额
　　yearFactor     年利率
　　monthFactor    月利率
　　yearInt        贷款年限
　　monthInt       贷款总期数
　　liMonth        当月偿还利息
　　benMonth       当月偿还本金
　　allMonth       当月还款总额
　　remainMoney    剩余未偿还本金
　　javaMoney      已偿还本金
　　year           还款年份
　　month          还款月份
    * */

    private int id;
    private double all;
    private double allMoney;
    private double yearFactor;
    private double monthFactor;
    private double yearInt;
    private double monthInt;
    private double liMonth;
    private double benMonth;
    private double allMonth;
    private double remainMoney;
    private double javaMoney;
    private int year;
    private int month;
    private int day;

    public LoanBean(int id, double all, double allMoney, double yearFactor, double monthFactor, double yearInt, double monthInt, double liMonth, double benMonth, double allMonth, double remainMoney, double javaMoney, int year, int month,int day) {
        this.id = id;
        this.all = all;
        this.allMoney = allMoney;
        this.yearFactor = yearFactor;
        this.monthFactor = monthFactor;
        this.yearInt = yearInt;
        this.monthInt = monthInt;
        this.liMonth = liMonth;
        this.benMonth = benMonth;
        this.allMonth = allMonth;
        this.remainMoney = remainMoney;
        this.javaMoney = javaMoney;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(double allMoney) {
        this.allMoney = allMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }

    public double getYearFactor() {
        return yearFactor;
    }

    public void setYearFactor(double yearFactor) {
        this.yearFactor = yearFactor;
    }

    public double getMonthFactor() {
        return monthFactor;
    }

    public void setMonthFactor(double monthFactor) {
        this.monthFactor = monthFactor;
    }

    public double getYearInt() {
        return yearInt;
    }

    public void setYearInt(double yearInt) {
        this.yearInt = yearInt;
    }

    public double getMonthInt() {
        return monthInt;
    }

    public void setMonthInt(double monthInt) {
        this.monthInt = monthInt;
    }

    public double getLiMonth() {
        return liMonth;
    }

    public void setLiMonth(double liMonth) {
        this.liMonth = liMonth;
    }

    public double getBenMonth() {
        return benMonth;
    }

    public void setBenMonth(double benMonth) {
        this.benMonth = benMonth;
    }

    public double getAllMonth() {
        return allMonth;
    }

    public void setAllMonth(double allMonth) {
        this.allMonth = allMonth;
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

    public double getJavaMoney() {
        return javaMoney;
    }

    public void setJavaMoney(double javaMoney) {
        this.javaMoney = javaMoney;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime(int year, int month,int day) {
        if (month==0){
            month=12;
        }
        return year+"年"+month+"月"+day+"日";
    }

}
