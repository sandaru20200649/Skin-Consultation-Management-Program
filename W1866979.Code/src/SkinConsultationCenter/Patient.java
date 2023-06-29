package SkinConsultationCenter;

public class Patient extends Person {
    public static Patient patient;
    static int patientNo = 1;
    private int patientId;

    public Patient(String name,String surName,String dateOfBirth,String mobileNo){
        super(name,surName,dateOfBirth,mobileNo);
        this.patientId=patientNo++;
    }

    public int getPatientId(){return patientId;}
    public void setPatientId(){this.patientId=patientId;}

    public void displayPatient(){
        System.out.println("Patient ID - "+patientId);
        System.out.println("Name - "+super.getName()+super.getSurName());
        System.out.println("Date Of Birth - "+super.getDateOfBirth());
        System.out.println("Mobile Number - "+super.getMobileNo());
    }
}
