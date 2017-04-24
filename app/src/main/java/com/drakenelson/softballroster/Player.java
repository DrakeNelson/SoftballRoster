package com.drakenelson.softballroster;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 2/27/2017.
 */

public class Player {

    private UUID id;
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String lastName;
    private String number;
    private String positions;
    private Date lastUpdate;
    private boolean isPitcher;
    private boolean isCatcher;

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = Integer.toString(number);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions() {
        positions = "";
        if (isPitcher) positions += R.string.symbol_pitcher + " ";
        if (isCatcher) positions += R.string.symbol_pitcher + " ";
        if (isInfield) positions += R.string.symbol_pitcher + " ";
        if (isOutfield) positions += R.string.symbol_pitcher + " ";
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate() {
        this.lastUpdate = new Date();
    }
    public void setLastUpdate(Date date) {
        this.lastUpdate = date;
    }

    public boolean isPitcher() {
        return isPitcher;
    }

    public void setPitcher(boolean pitcher) {
        isPitcher = pitcher;
        setPositions();
    }

    public boolean isCatcher() {
        return isCatcher;
    }

    public void setCatcher(boolean catcher) {
        isCatcher = catcher;
        setPositions();
    }

    public boolean isInfield() {
        return isInfield;
    }

    public void setInfield(boolean infield) {
        isInfield = infield;
        setPositions();
    }

    public boolean isOutfield() {
        return isOutfield;
    }

    public void setOutField(boolean outfield) {
        isOutfield = outfield;
        setPositions();
    }

    private boolean isInfield;
    private boolean isOutfield;

    public Player() {
        setId();
        setLastUpdate();
        setLastName("");
        setFirstName("");
        setNumber(99);
        setPitcher(false);
        setCatcher(false);
        setInfield(false);
        setOutField(true);
        setPositions();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Player p;
        try {
            p = (Player) obj;
        } catch (Exception ignored) {
            return false;
        }
        return this.getId().equals(p.getId());
    }

    @Override
    public String toString() {
        return "Player{ " +
                "id= " + id +
                " lastName= " + lastName +
                " firstName= " + firstName +
                " number= " + number +
                " lastUpdate= " + lastUpdate +
                " positions= " + positions +
                "}";
    }

}
