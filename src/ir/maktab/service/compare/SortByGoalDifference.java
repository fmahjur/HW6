package ir.maktab.service.compare;

import ir.maktab.model.entity.FootballClub;

import java.util.Comparator;

public class SortByGoalDifference implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        return (club1.getGoalsReceived()-club1.getGoalsScored()) - (club2.getGoalsReceived()-club2.getGoalsScored());
    }
}
