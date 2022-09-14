package model.entity;

import java.util.Date;
import java.util.Objects;

public class Player {
    private String firstname;
    private String lastname;
    private Date birthDate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstname, player.firstname) && Objects.equals(lastname, player.lastname) && Objects.equals(birthDate, player.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthDate);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
