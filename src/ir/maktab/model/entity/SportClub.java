package ir.maktab.model.entity;

import java.util.List;
import java.util.Objects;

public class SportClub {
    String nameOfTheClub;
    int numberOFWins;
    int numberOfDefeats;
    int numberOfDraws;
    int numberOfPoints;
    int numberOfPlayed;
    List<Player> players;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SportClub sportClub))
            return false;
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