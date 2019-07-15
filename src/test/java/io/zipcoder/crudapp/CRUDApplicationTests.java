package io.zipcoder.crudapp;

import io.zipcoder.crudapp.Controller.PersonController;
import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class CRUDApplicationTests {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonController personController;


	@Test
	public void contextLoads() {
	}

	@Test
	public void findall (){
		when(personController.getPersonList()).thenReturn(subData());
		personController.getPersonList();
		verify(personRepository,times(1)).findAll();
	}




	@Test
	public void find(){
		when(personController.getPerson(1)).thenReturn(subData().get(1));
		personController.getPerson(1);

		verify(personRepository,times(1)).findOne(1);
	}



	@Test
	public void createPerson() {
		Person person = mockPerson();

		when(personController.createPerson(person)).thenReturn(person);
		personController.createPerson(person);

		verify(personRepository, times(1)).save(person);
	}

	@Test
	public void deletePerson() {

		personController.DeletePerson(1);
		verify(personRepository, times(1)).delete(1);
	}



	@Test
	public void updatePerson() {

		Person person = mockPerson();

		when(personController.updatePerson(person, 1)).thenReturn(person);

		personController.updatePerson(person, 1);

		verify(personRepository,times(1)).save(person);


	}

	private List<Person> subData() {
		Person person1 = new Person("Bob", "Rieger");
		Person person2 = new Person("steve", "trafficman");

		return Arrays.asList(person1, person2);
	}

	private Person mockPerson () {
		return new Person("steve", "trafficman");
	}

}
