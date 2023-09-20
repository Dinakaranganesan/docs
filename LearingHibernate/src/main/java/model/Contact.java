/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author bas200181
 */
@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @Column(name="contact_id")
    private long contactId;
    @Column(name="member_id")
    private long member_id;
    @Column(name="name")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="mobile")
    private String mobile;
    @Column(name="email")
    private String mail;

    public long getContactId() {
        return contactId;
    }
    public  Contact(){
        
    }

    public Contact(long contactId, long member_id, String name, String mobile, String mail) {
        this.contactId = contactId;
        this.member_id = member_id;
        this.name = name;
        this.mobile = mobile;
        this.mail = mail;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
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
        return "Contact{" + "contactId=" + contactId + ", member_id=" + member_id + ", name=" + name + ", mobile=" + mobile + ", mail=" + mail + '}';
    }

}
