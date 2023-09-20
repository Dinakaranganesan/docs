/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Contact1;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author bas200181
 */
@Entity
@Table(name = "members")
public class Member1 {
    
    @Override
    public String toString() {
        return "Member{" + "memberId=" + memberId + ", name=" + name + ", mobile=" + mobile + '}';
    }

    @Id
    @Column(name = "member_id")
    private long memberId;

    public List<Contact1> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact1> contactList) {
        this.contactList = contactList;
    }

   
    @Column(name = "name")
    private String name;
    @Column(name = "mobile")
    private String mobile;
    @OneToMany(mappedBy = "member")
    private List<Contact1> contactList;

    public Member1() {
        super();
    }

    public Member1(long memberId, String name, String mobile) {
        this.memberId = memberId;
        this.name = name;
        this.mobile = mobile;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
}
