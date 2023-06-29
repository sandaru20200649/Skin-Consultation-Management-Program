package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DataFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


//User Registration using Swing

    public class MainUI extends JFrame {
        private static final long serialVersionUID = 1L;
        private JPanel contentPane;
        private JTextField firstname;
        private JTextField surName;
        private JTextField email;
        private JTextField patientId;
        private JTextField mob;
        private JTextField DateOfBirth;
        private JButton btnNewButton;


        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        MainUI frame = new MainUI();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        public MainUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Skin Consultation");
            setBounds(500, 290, 1014, 800);
            setResizable(false);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewUserRegister = new JLabel("Welcome");
            lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
            lblNewUserRegister.setBounds(420, 20, 325, 50);
            contentPane.add(lblNewUserRegister);

            JLabel lblName = new JLabel("First Name");
            lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblName.setBounds(58, 152, 99, 43);
            contentPane.add(lblName);

            JLabel lblNewLabel = new JLabel("SurName");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblNewLabel.setBounds(58, 243, 110, 29);
            contentPane.add(lblNewLabel);


            firstname = new JTextField();
            firstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
            firstname.setBounds(214, 151, 228, 50);
            contentPane.add(firstname);
            firstname.setColumns(10);

            surName = new JTextField();
            surName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            surName.setBounds(214, 235, 228, 50);
            contentPane.add(surName);
            surName.setColumns(10);

            patientId = new JTextField();
            patientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
            patientId.setBounds(707, 151, 228, 50);
            contentPane.add(patientId);
            patientId.setColumns(10);

            JLabel lblUsername = new JLabel("Patient ID");
            lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblUsername.setBounds(542, 159, 99, 29);
            contentPane.add(lblUsername);

            JLabel lblDateOfBirth = new JLabel("Date Of Birth");
            lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblDateOfBirth.setBounds(542, 245, 99, 24);
            contentPane.add(lblDateOfBirth);

            JLabel lblMobileNumber = new JLabel("Mobile number");
            lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblMobileNumber.setBounds(58, 329, 139, 26);
            contentPane.add(lblMobileNumber);

            mob = new JTextField();
            mob.setFont(new Font("Tahoma", Font.PLAIN, 15));
            mob.setBounds(214, 320, 228, 50);
            contentPane.add(mob);
            mob.setColumns(10);

            lblDateOfBirth = new JLabel();
            lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblDateOfBirth.setBounds(707, 235, 228, 50);
            contentPane.add(lblDateOfBirth);


            JButton viewButton =new JButton("View Doctors");
            viewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
            viewButton.setBounds(250, 447, 259, 74);
            contentPane.add(viewButton);
            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Table();
                }
            });
            btnNewButton = new JButton("Register");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String firstName = firstname.getText();
                    String surNameText = surName.getText();
                    String emailId = email.getText();
                    String patientIdText = patientId.getText();
                    String mobileNumber = mob.getText();
                    int len = mobileNumber.length();
                    String dateOfBirthText = DateOfBirth.getText();

                    String msg = "" + firstName;
                    msg += " \n";
                    if (len != 10) {
                        JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                    }

                    try {

                        String query = "INSERT INTO account values('" + firstName + "','" + surNameText + "','" + patientIdText + "','" +
                                dateOfBirthText + "','" + emailId + "','" + mobileNumber + "')";

                       // Statement sta = connection.createStatement();
                        //int x = sta.executeUpdate(query);
                        //if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                        //} else {
                            JOptionPane.showMessageDialog(btnNewButton,
                                    "Welcome, " + msg + "Your account is sucessfully created");
                        //}
                        //connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
            btnNewButton.setBounds(550, 447, 259, 74);
            contentPane.add(btnNewButton);
        }
    }