package Person;

import java.io.*;
import java.util.*;

public class PhoneBook {

	LinkedList<PersonData> PhoneBooklist;
	public PhoneBook()
    {
		PhoneBooklist = new LinkedList<>();
    }
	
	public void addPerson(String firstName, String lastName,String address , String city , String state ,int zip,int phoneNumber) {
		int flag=0;
		for (int i=0 ;i< PhoneBooklist.size();i++) {
			PersonData person = PhoneBooklist.get(i);
			if(person.getFirstName().equals(firstName)) {
				flag=1;
			}
		}
		
		if(flag == 0) {
			PersonData newPerson = new PersonData(firstName, lastName,address , city , state ,zip,phoneNumber);
			PhoneBooklist.add(newPerson);
			
		}
	}

	public PersonData searchPerson(String firstName) {
		PersonData searchPerson = null ;
		for (int i=0 ;i< PhoneBooklist.size();i++) {
			PersonData person = PhoneBooklist.get(i);
			if(person.getFirstName().equals(firstName)) {
				searchPerson=person;
			}
			
		}
		return searchPerson;
	}
	
	public String getAllPerson() {
		String data="";
		for (int i=0 ;i< PhoneBooklist.size();i++) {
			PersonData person = PhoneBooklist.get(i);
			data=data+(person.getFirstName())+"  "+(person.getLastName())+"\n";
		}
		return data;
	}
	
	public void readFile() {
		try{
		    FileInputStream readData = new FileInputStream("peopledata.ser");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    PhoneBooklist = (LinkedList<PersonData>) readStream.readObject();
		    readStream.close();
		    System.out.println("File read"+PhoneBooklist.get(1));
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void writeFile() {
		try{
		    FileOutputStream writeData = new FileOutputStream("peopledata.ser");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
	
		    writeStream.writeObject(PhoneBooklist);
		    writeStream.flush();
		    writeStream.close();
	
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook pb = new PhoneBook();
		pb.addPerson("Hardik", "lastName", "address", "city", "state", 984701, 12547707);
		pb.addPerson("Hardik21", "lastName", "address", "city", "state", 984701, 12547707);
		System.out.println("Output:"+pb.getAllPerson());
		/*String abc="Hardik1";
		PersonData s123 = null;
		s123=pb.searchPerson(abc);	
		System.out.println("Output:"+s123);*/
	}

}
