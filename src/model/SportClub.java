package model;

import java.util.Objects;

public abstract class SportClub {
    String nameOfTheClub;
    int countOFWins;
    int countOfDefeats;
    int numberOfPoints;
    int numberOfPlayed;

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public int getCountOFWins() {
        return countOFWins;
    }

    public void setCountOFWins(int countOFWins) {
        this.countOFWins = countOFWins;
    }

    public int getCountOfDefeats() {
        return countOfDefeats;
    }

    public void setCountOfDefeats(int countOfDefeats) {
        this.countOfDefeats = countOfDefeats;
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
        return getCountOFWins() == sportClub.getCountOFWins() && getCountOfDefeats() == sportClub.getCountOfDefeats() && getNumberOfPoints() == sportClub.getNumberOfPoints() && getNumberOfPlayed() == sportClub.getNumberOfPlayed() && getNameOfTheClub().equals(sportClub.getNameOfTheClub());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfTheClub(), getCountOFWins(), getCountOfDefeats(), getNumberOfPoints(), getNumberOfPlayed());
    }

    @Override
    public String toString() {
        return "nameOfTheClub='" + nameOfTheClub + '\'' +
                ", countOFWins=" + countOFWins +
                ", countOfDefeats=" + countOfDefeats +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfPlayed=" + numberOfPlayed;
    }
}