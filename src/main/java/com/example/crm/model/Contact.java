package com.example.crm.model;

import javax.persistence.*;
import java.util.ArrayList;
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
        FirstName = Utilities.StringEncrypt(firstName);
        LastName = Utilities.StringEncrypt(lastName);
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

    public List getAllFields() {
        List<String[]> contactFields = new ArrayList<>();
        String[] data = {"FirstName", this.getFirstName()};
        contactFields.add(data);
        String[] data2 = {"LastName", this.getLastName()};
        contactFields.add(data2);
        String[] data3 = {"NickName", this.getNickName()};
        contactFields.add(data3);
        String[] data4 = {"Email", this.getEmail()};
        contactFields.add(data4);
        String[] data5 = {"Phone", this.getPhone()};
        contactFields.add(data5);
        String[] data6 = {"CVR", this.getCVR()};
        contactFields.add(data6);
        String[] data7 = {"DOB", this.getDOB()};
        contactFields.add(data7);
        String[] data8 = {"Adress1", this.getAdress1()};
        contactFields.add(data8);
        String[] data9 = {"Adress2", this.getAdress2()};
        contactFields.add(data9);
        String[] data10 = {"City", this.getCity()};
        contactFields.add(data10);
        String[] data11 = {"PostalCode", this.getPostalCode()};
        contactFields.add(data11);
        String[] data12 = {"Country", this.getCountry()};
        contactFields.add(data12);
        String[] data13 = {"Website", this.getWebsite()};
        contactFields.add(data13);
        String[] data14 = {"Facebook", this.getFacebook()};
        contactFields.add(data14);
        String[] data15 = {"Trello", this.getTrello()};
        contactFields.add(data15);
        String[] data16 = {"GitHub", this.getGitHub()};
        contactFields.add(data16);
        String[] data17 = {"Gmail", this.getGmail()};
        contactFields.add(data17);
        return contactFields;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() { return Utilities.StringDecrypt(FirstName); }

    public void setFirstName(String firstName) {
        FirstName = Utilities.StringEncrypt(firstName);
    }

    public String getLastName() { return Utilities.StringDecrypt(LastName); }

    public void setLastName(String lastName) { LastName = Utilities.StringEncrypt(lastName); }

    public String getNickName() {
        return Utilities.StringDecrypt(NickName);
    }

    public void setNickName(String nickName) { NickName = Utilities.StringEncrypt(nickName); }

    public String getEmail() {
        return Utilities.StringDecrypt(Email);
    }

    public void setEmail(String email) {
        Email = Utilities.StringEncrypt(email);
    }

    public String getPhone() {
        return Utilities.StringDecrypt(Phone);
    }

    public void setPhone(String phone) {
        Phone = Utilities.StringEncrypt(phone);
    }

    public String getCVR() {
        return Utilities.StringDecrypt(CVR);
    }

    public void setCVR(String CVR) {
        this.CVR = Utilities.StringEncrypt(CVR);
    }

    public String getDOB() {
        return Utilities.StringDecrypt(DOB);
    }

    public void setDOB(String DOB) {
        this.DOB = Utilities.StringEncrypt(DOB);
    }

    public String getAdress1() {
        return Utilities.StringDecrypt(Adress1);
    }

    public void setAdress1(String adress1) {
        Adress1 = Utilities.StringEncrypt(adress1);
    }

    public String getAdress2() {
        return Utilities.StringDecrypt(Adress2);
    }

    public void setAdress2(String adress2) {
        Adress2 = Utilities.StringEncrypt(adress2);
    }

    public String getCity() {
        return Utilities.StringDecrypt(City);
    }

    public void setCity(String city) {
        City = Utilities.StringEncrypt(city);
    }

    public String getPostalCode() {
        return Utilities.StringDecrypt(PostalCode);
    }

    public void setPostalCode(String postalCode) {
        PostalCode = Utilities.StringEncrypt(postalCode);
    }

    public String getCountry() {
        return Utilities.StringDecrypt(Country);
    }

    public void setCountry(String country) {
        Country = Utilities.StringEncrypt(country);
    }

    public String getWebsite() {
        return Utilities.StringDecrypt(Website);
    }

    public void setWebsite(String website) {
        Website = Utilities.StringEncrypt(website);
    }

    public String getFacebook() {
        return Utilities.StringDecrypt(Facebook);
    }

    public void setFacebook(String facebook) {
        Facebook = Utilities.StringEncrypt(facebook);
    }

    public String getTrello() {
        return Utilities.StringDecrypt(Trello);
    }

    public void setTrello(String trello) {
        Trello = Utilities.StringEncrypt(trello);
    }

    public String getGitHub() {
        return Utilities.StringDecrypt(GitHub);
    }

    public void setGitHub(String gitHub) {
        GitHub = Utilities.StringEncrypt(gitHub);
    }

    public String getGmail() {
        return Utilities.StringDecrypt(Gmail);
    }

    public void setGmail(String gmail) {
        Gmail = Utilities.StringEncrypt(gmail);
    }

    public List<Note> getNotes() {
        return Notes;
    }

    public void setNotes(List<Note> notes) {
        this.Notes = notes;
    }
}
