package Person;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AddressBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea textArea_1;
	private JTextArea textArea;
	private PhoneBook pb = new PhoneBook();
	private PhoneBook pb1 = new PhoneBook();
	private JComboBox comboBox;
	private File fi = null;
	JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBook window = new AddressBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddressBook() {
		initialize();
	}
	
	public int validate() {
		if((textField.getText().equals("")) || (textField_1.getText().equals(""))   || (textField_2.getText().equals(""))  || (textField_3.getText().equals(""))  || (textField_4.getText().equals(""))  || (textField_5.getText().equals(""))  || (textArea.getText().equals(""))   )
		{
			JOptionPane.showMessageDialog(null,"Please fill all details.");
			return 0;
		}
		
		return 1;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//pb.readFile(fi);
		
		frame = new JFrame();
		frame.setBounds(0, 0, 626, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AddressBook");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(236, 11, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName :");
		lblNewLabel_1.setBounds(36, 48, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(125, 45, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("LastName :");
		lblNewLabel_2.setBounds(36, 82, 67, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 76, 121, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City :");
		lblNewLabel_3.setBounds(61, 217, 42, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 175, 121, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address :");
		lblNewLabel_4.setBounds(46, 117, 57, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textArea = new JTextArea();
		textArea.setBounds(125, 112, 121, 52);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("State :");
		lblNewLabel_5.setBounds(55, 178, 48, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 214, 121, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Zip :");
		lblNewLabel_6.setBounds(61, 256, 34, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if((key>=e.VK_0 && key<=e.VK_9) || (key>=e.VK_NUMPAD0 && key<=e.VK_NUMPAD9) || (key == KeyEvent.VK_BACK_SPACE)) {
					textField_4.setEditable(true);
				}
				else {
					textField_4.setEditable(false);
				}
			}
		});
		textField_4.setBounds(125, 253, 121, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Number  :");
		lblNewLabel_7.setBounds(36, 296, 73, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if((key>=e.VK_0 && key<=e.VK_9) || (key>=e.VK_NUMPAD0 && key<=e.VK_NUMPAD9) || (key == KeyEvent.VK_BACK_SPACE)) {
					textField_5.setEditable(true);
				}
				else {
					textField_5.setEditable(false);
				}
			}
		});
		textField_5.setBounds(125, 296, 121, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fi != null) {
				int check=validate();
				if(check == 1) {
					String firstName = textField.getText();
					String lastName = textField_1.getText();
					String address = textArea.getText();
					String state = textField_2.getText();
					String city = textField_3.getText();
					int zip  = Integer.parseInt(textField_4.getText());
					int phoneNumber = Integer.parseInt(textField_5.getText());
					int success=pb.addPerson(firstName, lastName, address, city, state, zip, phoneNumber);
					if(success == 0){
						JOptionPane.showMessageDialog(null,"Error Field not inserted person already exsist");
					}
					else {
						JOptionPane.showMessageDialog(null,"Insertion Successfull");
						textArea_1.setText(pb.getAllPerson());
					}
					
				}
				
				
			}
			else {
				JOptionPane.showMessageDialog(null,"Load file first");
			}
		 }
		});
		btnNewButton.setBounds(10, 364, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=textField.getText();
				PersonData searchPerson = null;
				
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter name to search.");
				
				}
				else {
					textField_1.setText(""); 
				    textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textArea.setText("");
					searchPerson=pb.searchPerson(firstName);
					if(searchPerson == null){
						
						JOptionPane.showMessageDialog(null,"Person not found.");
					}
					else {
					
					textField_1.setText(searchPerson.getLastName());
					textArea.setText(searchPerson.getAddress());
					textField_2.setText(searchPerson.getState());
					textField_3.setText(searchPerson.getCity());
					textField_4.setText(String.valueOf(searchPerson.getZip()));
					textField_5.setText(String.valueOf(searchPerson.getPhoneNumber()));
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(181, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check=validate();
				if(check == 1) {
					String firstName = textField.getText();
					String lastName = textField_1.getText();
					String address = textArea.getText();
					String state = textField_2.getText();
					String city = textField_3.getText();
					int zip  = Integer.parseInt(textField_4.getText());
					int phoneNumber =  Integer.parseInt(textField_5.getText());
					int success=pb.updatePerson(firstName, lastName, address, city, state, zip, phoneNumber);
					if(success == 0){
						JOptionPane.showMessageDialog(null,"Error Field not updated person doesnt exsist");
					}
					else {
						JOptionPane.showMessageDialog(null,"Updation Successfull");
						textArea_1.setText(pb.getAllPerson());
					}
					
				}
				
			}
		});
		btnNewButton_2.setBounds(10, 398, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	
		textArea_1 = new JTextArea(10,20);
		textArea_1.setEditable(false);
		textArea_1.setBounds(396, 77, 138, 344);
		//scroll = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scroll.setPreferredSize(new Dimension(300, 50));
		//scroll.setBounds(396, 77, 138, 262);
		frame.getContentPane().add(textArea_1);
		//frame.getContentPane().add(scroll);
		
		
		
		JButton btnNewButton_3 = new JButton("Print All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				pb.addPerson("Hardik", "lastName0", "address", "city", "state", 584701, 12547707);
				pb.addPerson("Hardik2", "lastName2", "address", "city", "state", 284701, 12547707);
				pb.addPerson("Hardik1", "lastName1", "address", "city", "state", 284701, 12547707);
				pb.addPerson("hardik", "lastName3", "address", "city", "state", 184701, 12547707);*/
				
				textArea_1.setText(pb.getAllPerson());
				
		
			}
		});
		btnNewButton_3.setBounds(423, 432, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sort");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getItemAt(comboBox.getSelectedIndex())=="Zip")
				{
					pb.sortZip();
				}
				else
				{
					pb.sortLastName();
				}
				textArea_1.setText(pb.getAllPerson());
				
			}
		});
		btnNewButton_4.setBounds(290, 44, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "Zip"}));
		comboBox.setBounds(410, 44, 102, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_5 = new JButton("Save to file");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fi != null) {
				pb.writeFile(fi);
				JOptionPane.showMessageDialog(null,"Data stored in file.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Load file first");
				}
			}
		});
		btnNewButton_5.setBounds(96, 432, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=textField.getText();
				PersonData searchPerson = null;
				
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter name to delete.");
				
				}
				else {
					
					searchPerson=pb.searchPerson(firstName);
					if(searchPerson == null){
						
						JOptionPane.showMessageDialog(null,"Person not found.");
					}
					else {
					
					textField_1.setText(searchPerson.getLastName());
					textArea.setText(searchPerson.getAddress());
					textField_2.setText(searchPerson.getState());
					textField_3.setText(searchPerson.getCity());
					textField_4.setText(String.valueOf(searchPerson.getZip()));
					textField_5.setText(String.valueOf(searchPerson.getPhoneNumber()));
					int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to remove the person?", "Delete person",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	int check=pb.removePerson(firstName);
				            	if(check == 1)
				            		JOptionPane.showMessageDialog(null,"Person removed.");
				            		textField.setText("");
					            	textField_1.setText(""); 
								    textField_2.setText("");
									textField_3.setText("");
									textField_4.setText("");
									textField_5.setText("");
									textArea.setText("");
				            		textArea_1.setText(pb.getAllPerson());
				           
				            }else if (result == JOptionPane.NO_OPTION){
				          
				            }else {
				            	JOptionPane.showMessageDialog(null,"Person did not removed choose one option.");
				            }
					}
				}
				
			}
		});
		btnNewButton_6.setBounds(181, 398, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(16, 0, 87, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("Ser is serializable class", "ser");
				fs.setDialogTitle("Open File");
				fs.setFileFilter(filter);
				fs.setAcceptAllFileFilterUsed(false);
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					fi = fs.getSelectedFile();
					pb.readFile(fi);
					JOptionPane.showMessageDialog(null,"File has been loaded.");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fi != null) {
					pb.writeFile(fi);
					JOptionPane.showMessageDialog(null,"Your Data has been stored in file.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Load file first");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Are you sure , you want to quit?", "Close Program",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	System.exit(0);
			            }
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		
	}
}
