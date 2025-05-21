package org.kdt.kentseldonusumtakip.Backend;


public class DetachedHouse extends House implements IGarden{
    private int gardenSize,total_floor;

    public DetachedHouse(String name,int id,int risk,int total_floor,int gardenSize){
        super(name,id,risk);
        this.gardenSize = gardenSize;
        this.total_floor = total_floor;

    }
    public DetachedHouse(String name,int id,int risk,int total_floor){
           super(name,id,risk);
           gardenSize = 0;
           this.total_floor = total_floor;

    }
    @Override
    public String getType() {
        return "Müstakil Ev";
    }


    public String isGardenBigForKD() {
        if(gardenSize<25 ||gardenSize>300){
            return "Uygun";
        }else{
            return "Uygun Değil";
        }
    }

    public int getGardenSize(){return gardenSize;}

    @Override
    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }

    public int getTotalFloor(){return total_floor;}
    public void setTotalFloor(int total_floor){this.total_floor = total_floor;}
}
