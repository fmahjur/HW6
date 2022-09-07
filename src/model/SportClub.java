package model;

import java.util.Objects;

public abstract class SportClub {
    String nameOfTheClub;
    int numberOFWins;
    int numberOfDefeats;
    int numberOfDraws;
    int numberOfPoints;
    int numberOfPlayed;

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public int getNumberOFWins() {
        return numberOFWins;
    }

    public void setNumberOFWins(int numberOFWins) {
        this.numberOFWins = numberOFWins;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfPlayed() {
        return numberOfPlayed;
    }

    public void setNumberOfPlayed(int numberOfPlayed) {
        this.numberOfPlayed = numberOfPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportClub)) return false;
        SportClub sportClub = (SportClub) o;
        return getNumberOFWins() == sportClub.getNumberOFWins() && getNumberOfDefeats() == sportClub.getNumberOfDefeats() && getNumberOfPoints() == sportClub.getNumberOfPoints() && getNumberOfPlayed() == sportClub.getNumberOfPlayed() && getNameOfTheClub().equals(sportClub.getNameOfTheClub());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfTheClub(), getNumberOFWins(), getNumberOfDefeats(), getNumberOfPoints(), getNumberOfPlayed());
    }

    @Override
    public String toString() {
        return "nameOfTheClub='" + nameOfTheClub + '\'' +
                ", countOFWins=" + numberOFWins +
                ", countOfDefeats=" + numberOfDefeats +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfPlayed=" + numberOfPlayed;
    }
}