package it.contrader.dto;

import it.contrader.model.User;

public class AgencyDTO {

    private int id;
    private String name_agency;
    private String city;
    private User user;

    public AgencyDTO() {

    }

    public AgencyDTO(int id, String name_agency, String city, User user) {
        this.id = id;
        this.name_agency = name_agency;
        this.city = city;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_agency() {
        return name_agency;
    }

    public void setName_agency(String name_agency) {
        this.name_agency = name_agency;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
