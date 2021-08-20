package com.example.demo.form;

// import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class EngWordForm {

    public String id;


    public String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int mondai_id;
    public int school_type;
    public int school_year;
    public int word_type;
    public String mondai;
    public String ask;
    public String hint;
    public String gazoPathOK;
    public String gazoPathNG;
    public String dogaUrl;
    public String kaisetu;

    public int getMondai_id() {
        return this.mondai_id;
    }

    public void setMondai_id(int mondai_id) {
        this.mondai_id = mondai_id;
    }

    public int getSchool_type() {
        return this.school_type;
    }

    public void setSchool_type(int school_type) {
        this.school_type = school_type;
    }

    public int getSchool_year() {
        return this.school_year;
    }

    public void setSchool_year(int school_year) {
        this.school_year = school_year;
    }

    public int getWord_type() {
        return this.word_type;
    }

    public void setWord_type(int word_type) {
        this.word_type = word_type;
    }

    public String getMondai() {
        return this.mondai;
    }

    public void setMondai(String mondai) {
        this.mondai = mondai;
    }

    public String getAsk() {
        return this.ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getHint() {
        return this.hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getGazoPathOK() {
        return this.gazoPathOK;
    }

    public void setGazoPathOK(String gazoPathOK) {
        this.gazoPathOK = gazoPathOK;
    }

    public String getGazoPathNG() {
        return this.gazoPathNG;
    }

    public void setGazoPathNG(String gazoPathNG) {
        this.gazoPathNG = gazoPathNG;
    }

    public String getDogaUrl() {
        return this.dogaUrl;
    }

    public void setDogaUrl(String dogaUrl) {
        this.dogaUrl = dogaUrl;
    }

    public String getKaisetu() {
        return this.kaisetu;
    }

    public void setKaisetu(String kaisetu) {
        this.kaisetu = kaisetu;
    }
    
}
