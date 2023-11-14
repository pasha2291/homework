package com.solvd.action;

import com.solvd.exception.InvalidBuildFastProfitException;
import com.solvd.exception.InvalidInteriorWorkProfitException;

public interface ProfitAction {
    double getProfitFromBuilding();
    double getProfitFromBuildFast() throws InvalidBuildFastProfitException;
    double getProfitFromInteriorWork() throws InvalidInteriorWorkProfitException;
}
