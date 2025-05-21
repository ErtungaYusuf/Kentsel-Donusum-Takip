package org.kdt.kentseldonusumtakip.Backend;

public class Slum extends House implements IGarden{
    private int gardenSize;
    public Slum(String name, int id,int risk, int gardenSize) {

        super(name, id, risk);
        this.gardenSize = gardenSize;
    }
    public Slum(String name, int id,int risk) {

        super(name, id, risk);
        gardenSize = 0;
    }

    @Override
    public String getType() {
        return "Gecekondu";
    }


    public String isGardenBigForKD() {
        if(gardenSize<25 ||gardenSize>300){
            return "Uygun";
        }else{
            return "Uygun Değil";
        }
    }

    public int getGardenSize(){return gardenSize;}
    public void setGardenSize(int gardenSize){this.gardenSize = gardenSize;}
}
