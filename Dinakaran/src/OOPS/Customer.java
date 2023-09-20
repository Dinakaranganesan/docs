package OOPS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Customer {
   private String name;
   private boolean member;
   private String memberType;
   Customer(String name)
   {
       this.name=name;
}

    public String getName() {
        return name;
    }
public boolean isMember()
{
    return member;
}

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setMember(boolean member) {
        this.member = member;
    }
@Override
public String toString()
{
    return name;
}
}
