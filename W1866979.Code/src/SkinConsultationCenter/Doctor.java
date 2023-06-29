package SkinConsultationCenter;

import java.text.SimpleDateFormat;

public class Doctor extends Person{
    private int medicalLicenceNo;
    private String specialisation;

    public Doctor(String name,String surName,String dateOfBirth,String mobileNo,String specialisation, int medicalLicenceNo){
        super(name,surName,dateOfBirth,mobileNo);
        this.medicalLicenceNo =medicalLicenceNo;
        this.specialisation= specialisation;
    }

    public Doctor(){
        super("0","0",null,"0");
        this.medicalLicenceNo= 0;
        this.specialisation= "0";
    }
    public void setMedicalLicenceNo(int medicalLicenceNo){this.medicalLicenceNo = medicalLicenceNo;}
    public int getMedicalLicenceNo(){return medicalLicenceNo;}

    public void setSpecialisation(String specialisation){this.specialisation = specialisation;}
    public String getSpecialisation(){return specialisation;}

    public void doctorDetailsDisplay(){
        System.out.println("Name - "+super.getName()+super.getSurName());
        System.out.println("Medical Licence - "+medicalLicenceNo);
        System.out.println("Specialisation - "+specialisation);
        System.out.println("Date Of Birth - "+super.getDateOfBirth());
        System.out.println("Mobile Number - "+super.getMobileNo());
    }
    public void removeDoctor (){
        this.medicalLicenceNo=0;
        this.specialisation="0";
        this.setName("0");
        this.setSurName("0");
        this.setMobileNo("0");
        this.setDateOfBirth(null);

    }
    public String docRecodes (){
        String output = String.format(super.getName() + "\n" + super.getSurName() + "\n" + new SimpleDateFormat("YYYY-MM-DD").format(super.getDateOfBirth())+"\n"+getMobileNo()+"\n"+this.medicalLicenceNo+"\n"+this.specialisation);
        return output;
    }
    public void doctorRead (String name, String surName, String dateOfBirth, String mobilNo,String specialisation, int medicalLicenceNo ){
        this.setName(name);
        this.setSurName(surName);
        this.setDateOfBirth(dateOfBirth);
        this.setMobileNo(mobilNo);
        this.specialisation= specialisation;
        this.medicalLicenceNo= medicalLicenceNo;
    }
}
