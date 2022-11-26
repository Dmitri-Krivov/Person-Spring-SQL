package telran.java2022.person.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.model.Person;


public interface PersonRepository extends CrudRepository<Person, Integer> {
	@Query("select p from Person p where p.name=?1")//"?1" -в SQL номерация с 1; здесь указан аргумент из функции ниже(то есть name)
	Stream<Person> findAllByName(String name);

	@Query("select p from Person p where p.address.city=:city ")//you need add @Param below
	Stream<Person> findAllByAddressCity(@Param("city") String city);

	Stream<Person> findAllByBirthDateBetween( LocalDate min, LocalDate max);

	
//	@Query(value = "SELECT city, COUNT(id) AS population FROM persons GROUP BY city", nativeQuery = true)
//	Stream<Map<String, Long>> getCitiesPopulation();
	
	@Query("select new telran.java2022.person.dto.CityPopulationDto(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc")
	List<CityPopulationDto> getCitiesPopulation();

}