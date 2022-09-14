package ir.maktab.model.entity;

import ir.maktab.model.enums.LeagueType;

import java.util.Date;

public class League {
    private Date startLeagueDate;
    private LeagueType leagueType;


    public Date getStartLeagueDate() {
        return startLeagueDate;
    }

    public void setStartLeagueDate(Date startLeagueDate) {
        this.startLeagueDate = startLeagueDate;
    }

    public LeagueType getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(LeagueType leagueType) {
        this.leagueType = leagueType;
    }


    @Override
    public String toString() {
        return "League{" +
                "leagueType=" + leagueType +
                '}';
    }
}
