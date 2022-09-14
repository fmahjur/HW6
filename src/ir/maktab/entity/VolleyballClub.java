package ir.maktab.entity;

import java.util.Objects;

public class VolleyballClub extends SportClub {
    private int numberOfRoundsWin;
    private int NumberOfRoundsDefeat;

    public VolleyballClub() {
    }

    public VolleyballClub(String name) {
        this.nameOfTheClub = name;
    }

    public VolleyballClub(String nameOfTheClub, int numberOFWins, int numberOfDefeats, int numberOfRoundsWin,
                          int numberOfRoundsDefeat, int numberOfPoints, int numberOfPlayed) {
        this.nameOfTheClub = nameOfTheClub;
        this.numberOFWins = numberOFWins;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfRoundsWin = numberOfRoundsWin;
        this.NumberOfRoundsDefeat = numberOfRoundsDefeat;
        this.numberOfPoints = numberOfPoints;
        this.numberOfPlayed = numberOfPlayed;
    }

    public int getNumberOfRoundsWin() {
        return numberOfRoundsWin;
    }

    public void setNumberOfRoundsWin(int numberOfRoundsWin) {
        this.numberOfRoundsWin = numberOfRoundsWin;
    }

    public int getNumberOfRoundsDefeat() {
        return NumberOfRoundsDefeat;
    }

    public void setNumberOfRoundsDefeat(int numberOfRoundsDefeat) {
        NumberOfRoundsDefeat = numberOfRoundsDefeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VolleyballClub that)) return false;
        if (!super.equals(o)) return false;
        return getNumberOfRoundsWin() == that.getNumberOfRoundsWin() && getNumberOfRoundsDefeat() == that.getNumberOfRoundsDefeat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfRoundsWin(), getNumberOfRoundsDefeat());
    }

    @Override
    public String toString() {
        return "numberOfRoundsWin=" + numberOfRoundsWin +
                ", NumberOfRoundsDefeat=" + NumberOfRoundsDefeat +
                ", nameOfTheClub='" + nameOfTheClub + '\'' +
                ", numberOFWins=" + numberOFWins +
                ", numberOfDefeats=" + numberOfDefeats +
                ", numberOfDraws=" + numberOfDraws +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfPlayed=" + numberOfPlayed;
    }
}
