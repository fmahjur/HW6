package ir.maktab.service.compare;

import ir.maktab.model.entity.SportClub;

import java.util.Comparator;

public class SortByPoints implements Comparator<SportClub> {
    @Override
    public int compare(SportClub club1, SportClub club2) {
        return club1.getNumberOfPoints() - club2.getNumberOfPoints();
    }
}
