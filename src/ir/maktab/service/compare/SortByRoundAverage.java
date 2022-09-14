package ir.maktab.service.compare;

import ir.maktab.model.entity.VolleyballClub;

import java.util.Comparator;

public class SortByRoundAverage implements Comparator<VolleyballClub> {
    @Override
    public int compare(VolleyballClub club1, VolleyballClub club2) {
        return (club1.getNumberOfRoundsWin()/club1.getNumberOfRoundsDefeat()) - club2.getNumberOfRoundsWin()/club2.getNumberOfRoundsDefeat();
    }
}
