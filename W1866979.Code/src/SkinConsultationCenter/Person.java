package SkinConsultationCenter;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surName;
    private String dateOfBirth;
    private String mobileNo;

    public Person (String name,String surName,String dateOfBirth,String mobileNo0){
        this.name= name;
        this.surName= surName;
        this.dateOfBirth= dateOfBirth;
        this.mobileNo= mobileNo0;
    }
    public String getName (){return name;}
    public void setName (String name){this.name=name;}

    public String getSurName (){return surName;}
    public void setSurName (String name){this.surName=name;}

    public String getDateOfBirth(){return dateOfBirth;}
    public void setDateOfBirth (String dateOfBirth){this.dateOfBirth=dateOfBirth;}

    public String getMobileNo (){return mobileNo;}
    public void setMobileNo (String name){this.mobileNo=mobileNo;}

}
