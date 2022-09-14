package ir.maktab.model.entity;

import java.util.Objects;

public class FootballClub extends SportClub {
    private int goalsReceived;
    private int goalsScored;

    public FootballClub(String nameOfTheClub, int numberOFWins, int numberOfDefeats, int numberOfDraws,
                        int goalsReceived, int goalsScored, int numberOfPoints, int numberOfPlayed) {
        this.nameOfTheClub = nameOfTheClub;
        this.numberOFWins = numberOFWins;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfDraws = numberOfDraws;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.numberOfPoints = numberOfPoints;
        this.numberOfPlayed = numberOfPlayed;
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
        if (!(o instanceof FootballClub that)) return false;
        return getGoalsReceived() == that.getGoalsReceived() && getGoalsScored() == that.getGoalsScored();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoalsReceived(), getGoalsScored());
    }

    @Override
    public String toString() {
        return nameOfTheClub + " club \n" +
                "------------------------------------------------------------------------------------------------------------------------------" + "\n" +
                "| goalsReceived | goalsScored | numberOfWins | numberOfDefeats | numberOfDraws | numberOfPoints | numberOfPlayed |" + "\n" +
                "------------------------------------------------------------------------------------------------------------------------------" + "\n" +
                "|         " + goalsReceived + "         " +
                "|      " + goalsScored + "      " +
                "|       " + numberOFWins + "      " +
                "|        " + numberOfDefeats + "        " +
                "|       " + numberOfDraws + "       " +
                "|        " + numberOfPoints + "       " +
                "|        " + numberOfPlayed + "       |\n" +
                "------------------------------------------------------------------------------------------------------------------------------\n";
    }

    public String toStringForLeagueTable() {
        return "| " + nameOfTheClub + " " +
                "|         " + goalsReceived + "         " +
                "|      " + goalsScored + "      " +
                "|       " + numberOFWins + "      " +
                "|        " + numberOfDefeats + "        " +
                "|       " + numberOfDraws + "       " +
                "|        " + numberOfPoints + "       " +
                "|        " + numberOfPlayed + "       |";
    }
}
