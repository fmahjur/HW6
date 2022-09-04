package model;

import java.util.Objects;

public class FootballClub extends SportClub {
    private int goalsReceived;
    private int goalsScored;

    public FootballClub() {

    }

    public FootballClub(String nameOfTheClub, int wins, int defeats, int goalsReceived2,
                        int defeatsScored, int points, int matches) {
        this.nameOfTheClub = nameOfTheClub;
        this.countOFWins = wins;
        this.countOfDefeats = defeats;
        this.goalsReceived = goalsReceived2;
        this.goalsScored = defeatsScored;
        this.numberOfPoints = points;
        this.numberOfPlayed = matches;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub)) return false;
        FootballClub that = (FootballClub) o;
        return getGoalsReceived() == that.getGoalsReceived() && getGoalsScored() == that.getGoalsScored();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoalsReceived(), getGoalsScored());
    }

    @Override
    public String toString() {
        return "goalsReceived=" + goalsReceived +
                ", goalsScored=" + goalsScored +
                ", nameOfTheClub='" + nameOfTheClub + '\'' +
                ", countOFWins=" + countOFWins +
                ", countOfDefeats=" + countOfDefeats +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfPlayed=" + numberOfPlayed;
    }
}
