package org.kdt.kentseldonusumtakip.Backend;

import org.kdt.kentseldonusumtakip.Backend.MyExeptions.UnknownChoosingExeption;

public class House extends Building {
    private String name;
    private int id;
    private int risk;
    private String construction_date;
    public House(String name, int id, int risk, String construction_date){
        super(construction_date);
        this.name = name;
        this.id = id;
        this.risk = risk;

    }

    public House(String name, int id, int risk){
        super("Belirtilmemiş");
        this.name = name;
        this.id = id;
        this.risk = risk;
    }
    public House(int id, int risk){
        super("Belirtilmemiş");
        this.name = "Belirtilmemiş";
        this.id = id;
        this.risk = risk;
    }

    public String calculateSafety(){
        if(risk>10){
            return "Güveli Değil";
        }else if(risk>0 && risk<10){
            return "Güvenli";
        }else{
            throw new ArithmeticException("Wrong risk value");
        }
    }
    public String getType() {
        return "Belirtilmemiş";
    }

    public int getId(){
        return(id);
    }
    public String getName(){return(name);}
    public int getRisk(){
        return(risk);
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRisk(String name){
        this.risk = risk;
    }



}
