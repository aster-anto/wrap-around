package com.springboard.hackathon.wraparound.beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.springboard.hackathon.wraparound.service.ClientServiceImpl;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class ClientBean {

    @Inject
    private ClientServiceImpl clientService;

    public ClientBean() {

    }

    public ClientBean(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String createClient() {
        ClientBean client = new ClientBean("testname", "testLastname",
                new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        clientService.saveUser(client);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Successful",
                        "Sucessfully created oentryrder:  " + client.getFirstName() + " " + client.getLastName()));
        context.getExternalContext().getFlash().setKeepMessages(true);

        return "/client.xhtml?faces-redirect=true";
    }

    // public List<Client> getAvailableClients() {
    // return availableClients;
    // }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    private String firstName;
    private String lastName;

    private LocalDate dob;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
