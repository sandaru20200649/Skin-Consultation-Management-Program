package SkinConsultationCenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class WestminsterSkinConsultationManager {
    public static void main(String[] args) {

        boolean loop = true;
        Doctor[] doctors = new Doctor[10];
        initialiseDoctor(doctors);
        readFile(doctors);

        while (loop) {
            String mainMenu = mainMenu().toLowerCase();
            switch (mainMenu) {
                case "a", "add":
                    addDoctor(doctors);
                    break;
                case "d", "delete":
                    deleteDoctor(doctors);
                    break;
                case "s", "save":
                    saveFile(doctors);
                    break;
                case "print", "p":
                    printDoctor(doctors);
                    break;
                case "exit", "e":
                    loop = false;
                    break;

            }
        }
    }

    public static void initialiseDoctor(Doctor[] doctors) {
        for (int i = 0; i < doctors.length; i++) {
            doctors[i] = new Doctor();
        }
    }

    public static void Menu() {
        String[] menu = {
                "Add new doctor-------------- add/a"
                , "Delete doctor--------------- delete/d"
                , "save in folder-------------- save/s"
                , "Print the doctor list------- print/p"
                , "Exit the program------------ exit/e"};
        for (String m : menu) {
            System.out.println(m);
        }
    }

    public static String mainMenu() {
        boolean loop = true;
        String mainMenu = "";

        while (loop) {
            Menu();
            Scanner get = new Scanner(System.in);
            System.out.println("--- Select Your Option Form Above Menu ---");
            mainMenu = get.next();
            //
            if (mainMenu.equalsIgnoreCase("a")
                    || mainMenu.equalsIgnoreCase("add")
                    || mainMenu.equalsIgnoreCase("d")
                    || mainMenu.equalsIgnoreCase("delete")
                    || mainMenu.equalsIgnoreCase("s")
                    || mainMenu.equalsIgnoreCase("save")
                    || mainMenu.equalsIgnoreCase("p")
                    || mainMenu.equalsIgnoreCase("print")
                    || mainMenu.equalsIgnoreCase("e")
                    || mainMenu.equalsIgnoreCase("exit")) {
                loop = false;
            } else {
                System.out.println(" ---- Your input is wrong please input correct input --- ");
            }
        }
        return mainMenu;
    }

    public static void addDoctor(Doctor[] doctors) {
        outerloop:
        while (true) {
            for (Doctor d : doctors) {
                if (d.getMedicalLicenceNo() == 0) {
                    Scanner get = new Scanner(System.in);

                    int medicalLicence = 0;
                    while (true) {
                        System.out.println("Medical licence number-- ");
                        if (get.hasNextInt()) {
                            medicalLicence = get.nextInt();
                            if (medicalLicence == 0) {
                                break outerloop;
                            }
                            break;
                        }
                         else
                        {
                            get.next();
                            System.out.println("Input is invalid ");
                        }
                    }
                    get.nextLine();

                    System.out.println("Specialisation -- ");
                    String specialisation = get.nextLine();
                    if (specialisation.equals("e")) {

                        break outerloop;
                    }
                    System.out.println("First name of the doctor -- ");
                    String firstName = get.nextLine();
                    if (firstName.equals("e")) {
                        break outerloop;
                    }
                    System.out.println("Surname of the doctor -- ");
                    String surName = get.next();
                    if (surName.equals("e")) {
                        break outerloop;
                    }
                    String dateFormated;
                    while (true) {
                        System.out.println("Date of birth (yyyy-mm-dd)");
                        String dateofbirth = get.nextLine();
                        if (dateofbirth.equals("e")) {
                            break outerloop;
                        }
                        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            dateFormated = new SimpleDateFormat("yyyy-mm-dd").format(dateInput.parse(dateofbirth));
                            break;
                        } catch (ParseException e) {
                            System.out.println("--- inserted format is wrong ! ---");
                        }
                    }
                    System.out.println("Mobile number -- ");
                    String mobNum = get.nextLine();
                    if (mobNum.equals("e")) {
                        break outerloop;
                    }
                    //adding information to the doctors object
                    d.setMedicalLicenceNo(medicalLicence);
                    d.setSpecialisation(specialisation);
                    d.setName(firstName);
                    d.setSurName(surName);
                    d.setMobileNo(mobNum);
                    d.setDateOfBirth(dateFormated);
                    System.out.println("--Doctor " + d.getName() + d.getSurName() + " Added--");
                    break outerloop;
                }
            }
        }
    }

    public static void deleteDoctor(Doctor[] doctors) {
        Scanner get = new Scanner(System.in);
        int medicalLicence;
        while (true){
            System.out.println("Enter Medical licence number of the doctor to remove -- ");
            if (get.hasNextInt()){
                medicalLicence = get.nextInt();
                break;
            }
            else {
                get.next();
                System.out.println("invalid input ! ");
            }
        }
        for (Doctor d: doctors){
            if(d.getMedicalLicenceNo() == medicalLicence){
                System.out.println("--Doctor " + d.getName() + d.getSurName() + " Removed");
                d.removeDoctor();
            }
        }
    }
    public static void arraySort(Doctor [] doctors){
        for (int i=0; i< doctors.length; i++){
            for (int j=i+1; j<doctors.length; j++){
                
                if (doctors[i].getSurName().compareTo(doctors[j].getSurName()) >0){
                    Doctor temper = doctors[i];
                    doctors[i] = doctors[j];
                    doctors[j] = temper;
                }
            }
        }
        for (int i=0; i < doctors.length;i++){
            for (int j = i+1; j< doctors.length; j++){
                if (doctors [j].getMedicalLicenceNo() !=0){
                    Doctor temper = doctors[i];
                    doctors[i] = doctors[j];
                    doctors[j] = temper;
                    break;
                }
            }
        }
    }
    public static void printDoctor(Doctor[] doctors) {
        arraySort(doctors);
        int index = 0;
        for (Doctor d : doctors) {
            if (d.getMedicalLicenceNo() != 0) {
                System.out.println("Doctor" + (index + 1) + "\n Name - " + d.getName() + " " + d.getSurName() + "\n Medical licence - " + d.getMedicalLicenceNo() + "\n Specialisation - " + d.getSpecialisation());
            }
            index++;
        }
    }
    public static void saveFile(Doctor [] doctors){
        String fileName = "doctors.bin";

        try {
            FileOutputStream fos   = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Doctor d: doctors) {
                oos.writeObject(d);
            }
            oos.close();
        }
        catch (IOException e){
            System.out.println("Fill not found");
        }
    }


    public static void readFile (Doctor [] doctors){

        String fileName = "doctors.bin";

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o;

            int i = 0;

            while (true){
                try {
                    o = ois.readObject();
                    if (o instanceof Doctor) {
                        doctors[i] = ((Doctor) o);
                        i++;
                    } else {
                        System.out.println("unexpected Object file");
                    }
                }catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        }
        catch (IOException e){
            System.out.println("Fill not founded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
