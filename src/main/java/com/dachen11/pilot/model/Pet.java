package com.dachen11.pilot.model;

public class Pet {
    private int id;
    private String name;
    private String birthDate;
    private String type;
    private String ownerId;
    private int visits;

    public Pet(int id, String name, String birthDate, String type, String ownerId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getVisits() {
        return visits;
    }

    public void incVisits() {
        this.visits++;
    }


}
