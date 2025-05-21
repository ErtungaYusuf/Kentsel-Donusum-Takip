package org.kdt.kentseldonusumtakip.Backend;

import org.kdt.kentseldonusumtakip.Backend.MyExeptions.AgeCouldntCalculateExeption;

import java.time.LocalDate;
import java.time.Period;

public abstract class Building {
    String construction_date;

    public Building(String construction_date) {
        this.construction_date = construction_date;
    }

    public int calculateAge() throws AgeCouldntCalculateExeption {
        try {
            LocalDate currentDate = LocalDate.now();
            LocalDate constructionDate = LocalDate.parse(construction_date);
            Period period = Period.between(constructionDate, currentDate);
            return period.getYears();
        }catch (Exception e){
            throw new AgeCouldntCalculateExeption("Age couldnt calculated, probably due to non available date");
        }

    }
    public int calculteEstimatedValue(){
        //For further use:
        return -1;
    }

}
