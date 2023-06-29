package UI;

// Packages to import}
import SkinConsultationCenter.Doctor;

import javax.print.Doc;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.Scanner;

public class Table {
    // frame
    JFrame f;
    // Table
    JTable j;
    Doctor [] doctors = new Doctor [10];
    // Data to be displayed in the JTable
    String[][] data = new String[10][4];

    // Constructor
    public Table()
    {
        readFile(doctors);
        createData();
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("Doctor Table");


        // Column Names
        String[] columnNames = { "Name", "Medical Licence Number", "Specialisation ","Availability" };

        // Initializing the JTable
        j = new JTable();
        TableModel tableModel = new DefaultTableModel(data,columnNames);
        j.setModel(tableModel);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        //Frame Size
        f.setSize(900, 230);
        // Frame Visible = true
        f.setVisible(true);
    }

    public static void main(String[] args)

    {
        new Table();
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

    public void createData(){
        int i = 0;
        for (Doctor d:doctors){
            if (d.getMedicalLicenceNo() != 0) {
                data[i][0] = d.getName() + " " + d.getSurName();
                data[i][1] = String.valueOf(d.getMedicalLicenceNo());
                data[i][2] = d.getSpecialisation();
                data[i][3] = "";
                i++;
            }
        }
    }
}
