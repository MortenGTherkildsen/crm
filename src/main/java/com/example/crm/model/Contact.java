package com.example.crm.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "firstName")
    private String FirstName;

    @Column(name = "lastName")
    private String LastName;

    @Column(name = "nickName")
    private String NickName;

    @Column(name = "email")
    private String Email;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "cvr")
    private String CVR;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "adress1")
    private String Adress1;

    @Column(name = "adress2")
    private String Adress2;

    @Column(name = "city")
    private String City;

    @Column(name = "postalCode")
    private String PostalCode;

    @Column(name = "country")
    private String Country;

    @Column(name = "website")
    private String Website;

    @Column(name = "facebook")
    private String Facebook;

    @Column(name = "trello")
    private String Trello;

    @Column(name = "gitHub")
    private String GitHub;

    @Column(name = "gmail")
    private String Gmail;

    @OneToMany(mappedBy = "owner")
    private List<Note> Notes;

    public Contact(String firstName, String lastName, String nickName, String email, String phone, String CVR, String DOB, String adress1, String adress2, String city, String postalCode, String country, String website, String facebook, String trello, String gitHub, String gmail, List<Note> noteList) {
        FirstName = firstName;
        LastName = lastName;
        NickName = nickName;
        Email = email;
        Phone = phone;
        this.CVR = CVR;
        this.DOB = DOB;
        Adress1 = adress1;
        Adress2 = adress2;
        City = city;
        PostalCode = postalCode;
        Country = country;
        Website = website;
        Facebook = facebook;
        Trello = trello;
        GitHub = gitHub;
        Gmail = gmail;
        Notes = noteList;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", CVR='" + CVR + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Adress1='" + Adress1 + '\'' +
                ", Adress2='" + Adress2 + '\'' +
                ", City='" + City + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", Country='" + Country + '\'' +
                ", Website='" + Website + '\'' +
                ", Facebook='" + Facebook + '\'' +
                ", Trello='" + Trello + '\'' +
                ", GitHub='" + GitHub + '\'' +
                ", Gmail='" + Gmail + '\'' +
                ", Notes=" + Notes +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAdress1() {
        return Adress1;
    }

    public void setAdress1(String adress1) {
        Adress1 = adress1;
    }

    public String getAdress2() {
        return Adress2;
    }

    public void setAdress2(String adress2) {
        Adress2 = adress2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getTrello() {
        return Trello;
    }

    public void setTrello(String trello) {
        Trello = trello;
    }

    public String getGitHub() {
        return GitHub;
    }

    public void setGitHub(String gitHub) {
        GitHub = gitHub;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public List<Note> getNotes() {
        return Notes;
    }

    public void setNotes(List<Note> notes) {
        this.Notes = notes;
    }
}
