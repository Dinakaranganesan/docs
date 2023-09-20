/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author bas200181
 */
@Entity
@Table(name="contacts")
public class Contact1 {

    @Id
    @Column(name = "contact_id")
    private long contactId;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String mail;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member1 member;

    public long getContactId() {
        return contactId;
    }

    public Contact1() {

    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Contact1(long contactId, String name, String mobile, String mail, Member1 member) {
        this.contactId = contactId;
        this.name = name;
        this.mobile = mobile;
        this.mail = mail;
        this.member = member;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Contact1{" + "contactId=" + contactId + ", name=" + name + ", mobile=" + mobile + ", mail=" + mail + ", member=" + member + '}';
    }

}
