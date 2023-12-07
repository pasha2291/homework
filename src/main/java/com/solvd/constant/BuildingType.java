package com.solvd.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BuildingType {
    M20(20, 35, 100000.0, 0.45),
    M10(10, 25, 80000.0, 0.5),
    M5(5, 20, 75000.0, 0.55),
    COTTAGE(1, 15, 65000.0, 0.6);

    private int stories;
    private double basicWeeksToBuild;
    private double basicPrice;
    private double netProfit;

    @Override
    public String toString() {
        return (this.ordinal() + 1) + ". Проект " + this.name() + "\nЭтажей: " + this.stories + "\nБазовое время строительства: "
                + this.basicWeeksToBuild + " недель" + "\nБазовая цена: " + this.basicPrice + "$\n";
    }
}
