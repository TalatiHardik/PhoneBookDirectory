package Person;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddressBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private PhoneBook pb = new PhoneBook();
	JComboBox comboBox;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AddressBook");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(249, 11, 102, 14);
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
		lblNewLabel_3.setBounds(61, 178, 42, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 175, 121, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address :");
		lblNewLabel_4.setBounds(46, 117, 57, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(125, 112, 121, 52);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("State :");
		lblNewLabel_5.setBounds(55, 217, 48, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 214, 121, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Zip :");
		lblNewLabel_6.setBounds(61, 256, 34, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 253, 121, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Number  :");
		lblNewLabel_7.setBounds(36, 296, 73, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(125, 296, 121, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 364, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(125, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(233, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(396, 77, 138, 262);
		frame.getContentPane().add(textArea_1);
		
		
		
		JButton btnNewButton_3 = new JButton("Print All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pb.addPerson("Hardik", "lastName0", "address", "city", "state", 584701, 12547707);
				pb.addPerson("Hardik2", "lastName2", "address", "city", "state", 284701, 12547707);
				pb.addPerson("Hardik1", "lastName1", "address", "city", "state", 284701, 12547707);
				pb.addPerson("hardik", "lastName3", "address", "city", "state", 184701, 12547707);
				textArea_1.setText(pb.getAllPerson());
				
		
			}
		});
		btnNewButton_3.setBounds(423, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sort By LastName");
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
		btnNewButton_4.setBounds(406, 411, 128, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "Zip"}));
		comboBox.setBounds(396, 40, 102, 22);
		frame.getContentPane().add(comboBox);
		
		
	}
}
