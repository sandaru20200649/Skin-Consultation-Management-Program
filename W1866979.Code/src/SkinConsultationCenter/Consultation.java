package SkinConsultationCenter;

import java.io.Serializable;

public class Consultation implements Serializable {
    private int date;
    private int doctor;
    private int patient;

    public Consultation(String date, int doctor, int patient){
        this.date = Integer.parseInt(date);
        this.doctor= doctor;
        this.patient= patient;
    }
    public int getDate(){return date;}
    public void setDate(String date) {this.date= Integer.parseInt(date);}

    public int getDoctor(){return doctor;}
    public void setDoctor(int doctor){this.doctor=doctor;}

    public int getPatient(){return patient;}
    public void setPatient(int patient){this.patient=patient;}

    public void displayConsultation(){
        System.out.println(+date );
        System.out.println(doctor);
        System.out.println(patient);
    }
}
