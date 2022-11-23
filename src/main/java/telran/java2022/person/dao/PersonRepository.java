package telran.java2022.person.dao;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java2022.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	Stream<Person> findAllByName(String name);

	Stream<Person> findAllByBirthDateBetween(LocalDate min, LocalDate max);

	Stream<Person> findAllByAddressCity(String city);
	
	@Query(value = "SELECT city, COUNT(id) AS population FROM persons GROUP BY city", nativeQuery = true)
	Stream<Map<String, Long>> getCitiesPopulation();

}