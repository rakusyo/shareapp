package com.example.test;

public class str {
    private int mouth=0;
    private int day=0;
    private String dch;
    private String gh;
    private String fth;
    private String ks;
    private String ing;
    private String end;
    private int dd;
    private int gb;
    private String bz;

    public str() {
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDch() {
        return dch;
    }

    public void setDch(String dch) {
        this.dch = dch;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getFth() {
        return fth;
    }

    public void setFth(String fth) {
        this.fth = fth;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


    public String getstr(str xls){

        String st=xls.getMouth()+"/"+xls.getDay()
                +"/"+xls.getDch()+"/"+xls.getGh()+"/"
                +xls.getFth()+"/"+xls.getKs()+"/"+xls.getIng()+"/"+xls.getEnd()
                +"/"+xls.getDd()+"/"+xls.getGb()+"/"+xls.getBz();
        return st;

    }

}
