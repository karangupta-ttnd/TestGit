package com.linksharing.model.entities;

import com.linksharing.dto.UserDTO;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by karan on 11/7/17.
 */

@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String password;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String oauthid;
    @Lob
    @Column(nullable = true)
    private byte[] photo;
    @Column(nullable = false)
    private Boolean admin;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
        
    public User(){}
    
    public User(UserDTO userDTO){
        if (userDTO!=null) {
            this.id = userDTO.getId();
            this.firstName = userDTO.getFirstName();
            this.lastName = userDTO.getLastName();
            this.email = userDTO.getEmail();
            this.photo = userDTO.getPhoto();
            this.username = userDTO.getUsername();
            this.password=userDTO.getPassword();
            this.setAdmin(false);
            this.setDateCreated(new Date());
            this.setLastUpdated(new Date());
            this.setOauthid("none");
        }
    }
    
    public String getOauthid() {
        return oauthid;
    }

    public void setOauthid(String oauthid) {
        this.oauthid = oauthid;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", oauthid='" + oauthid + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", admin=" + admin +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
