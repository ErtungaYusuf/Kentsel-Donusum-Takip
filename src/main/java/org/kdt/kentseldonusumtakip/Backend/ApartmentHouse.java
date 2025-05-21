package org.kdt.kentseldonusumtakip.Backend;

public class ApartmentHouse extends House implements ISlenderness {
    private int floor;
    private int total_floor_num;
    private double floor_height;
    private double slanderness;

    //example data for all apartments:
    private int height = 100;
    private int width = 40;
    public ApartmentHouse(String name, int id,int risk, int floor,int total_floor_num,double floor_height) {
        super(name, id, risk);
        this.floor = floor;
        this.floor_height = floor_height;
        this.total_floor_num = total_floor_num;
        slanderness = CalculateSlanderness(height,width);
    }

    public ApartmentHouse(String name, int id,int risk, int floor) {
        super(name, id, risk);
        this.floor = floor;
    }

    public int getFloor(){return floor;}
    public void setFloor(int floor){this.floor = floor;}

    @Override
    public String getType() {
        return "Apartman Dairesi";
    }


    public double CalculateSlanderness(int height, int width) {
        return height/width;
    }


    public double getTotalLength() {
          return  total_floor_num*floor_height;
    }

}
