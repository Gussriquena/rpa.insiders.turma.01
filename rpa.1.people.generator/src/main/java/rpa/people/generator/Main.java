package rpa.people.generator;

import java.util.ArrayList;
import java.util.List;

import rpa.people.generator.model.Person;

public class Main {
	public static void main(String[] args) {
		Person person = new Person();
		person.setFullName("Gustavo");
		person.setEmail("admin@rpainsiders");
		
		Person person2 = new Person();
		person2.setFullName("Diego");
		person2.setEmail("Diego@gmail");
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(person);
		personList.add(person2);
		
		for(Person currentPerson : personList) {
			System.out.println(currentPerson.getFullName());
		}
	}
}
