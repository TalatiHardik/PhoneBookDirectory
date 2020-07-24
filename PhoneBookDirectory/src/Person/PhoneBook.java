package Person;

import java.io.*;
import java.util.*;


class lastNameCompare implements Comparator<PersonData>{
	 
    @Override
    public int compare(PersonData e1, PersonData e2) {
    	if(e1.getLastName().compareToIgnoreCase(e2.getLastName()) == 0) {
    		if(e1.getFirstName().compareToIgnoreCase(e2.getFirstName()) > 0)
    		{
    			return 1;
    		}
    		else
    		{
    			return -1;
    		}
    		
    	}
    	else if(e1.getLastName().compareToIgnoreCase(e2.getLastName()) > 0){
            return 1;
        } else {
            return -1;
        }
    }
}

class ZipCompare implements Comparator<PersonData>{
	 
    @Override
    public int compare(PersonData e1, PersonData e2) {
    	if(e1.getZip() == e2.getZip()) {
    		if(e1.getFirstName().compareToIgnoreCase(e2.getFirstName()) > 0)
    		{
    			return 1;
    		}
    		else
    		{
    			return -1;
    		}
    		
    	}
    	else if(e1.getZip() < e2.getZip()){
            return -1;
        } else {
            return 1;
        }
    }
}

public class PhoneBook {

	Vector<PersonData> PhoneBooklist;
	public PhoneBook()
    {
		PhoneBooklist = new Vector<PersonData>();
    }
	
	public int addPerson(String firstName, String lastName,String address , String city , String state ,int zip,int phoneNumber) {
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
			return 1;
		}
		return 0;
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
	
	public int removePerson(String firstName) {
		PersonData searchPerson = this.searchPerson(firstName) ;
		if(searchPerson != null)
		{
		if(PhoneBooklist.remove(searchPerson)) {
			return 1;	
		}
		else {
			return 0;
		}
		}
		else {
			return 0;
		}
		
	}
	public int updatePerson(String firstName, String lastName,String address , String city , String state ,int zip,int phoneNumber) {
		int flag=0;
		for (int i=0 ;i< PhoneBooklist.size();i++) {
			PersonData person = PhoneBooklist.get(i);
			if(person.getFirstName().equals(firstName)) {
				
				person.setLastName(lastName);
				person.setAddress(address);
				person.setCity(city);
				person.setState(state);
				person.setZip(zip);
				person.setPhoneNumber(phoneNumber);
				flag=1;
				break;
			}
		}
		
		if(flag == 0) {
			
			return 0;
		}
		return 1;
	}
	
	public String getAllPerson() {
		String data="";
		//Vector<String> data = new Vector<>();
		for (int i=0 ;i< PhoneBooklist.size();i++) {
			PersonData person = PhoneBooklist.get(i);
			data=data+(person.getFirstName())+"  "+(person.getLastName())+"\n";
			//data.add((person.getFirstName())+"  "+(person.getLastName()));
		}
		return data;
	}
	
	public void readFile() {
		try{
		    FileInputStream readData = new FileInputStream("peopledata.ser");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    PhoneBooklist = (Vector<PersonData>) readStream.readObject();
		    readStream.close();
		   // System.out.println("File read"+PhoneBooklist.get(1));
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
	
	public void sortZip() {
		
		Collections.sort(PhoneBooklist, new ZipCompare()); 
	}
	
	public void sortLastName() {
		
		Collections.sort(PhoneBooklist, new lastNameCompare()); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook pb = new PhoneBook();
		pb.addPerson("Hardik", "lastName0", "address", "city", "state", 584701, 12547707);
		pb.addPerson("Hardik2", "lastName2", "address", "city", "state", 284701, 12547707);
		pb.addPerson("Hardik1", "lastName1", "address", "city", "state", 284701, 12547707);
		pb.addPerson("hardik", "lastName3", "address", "city", "state", 184701, 12547707);
		System.out.println("Output:"+pb.getAllPerson());
		pb.writeFile();
		pb.sortZip();
		System.out.println("Output:"+pb.getAllPerson());
		pb.updatePerson("Hardik", "Talati", "B-203", "surat", "Guj", 584701, 12547707);
		pb.sortLastName();
		System.out.println("Output:"+pb.getAllPerson());
		/*
		String abc="Hardik";
		PersonData s123 = null;
		s123=pb.searchPerson(abc);	
		System.out.println("Output:"+s123);*/
	}

}
