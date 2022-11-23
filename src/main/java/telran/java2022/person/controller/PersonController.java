package telran.java2022.person.controller;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.person.dto.AddressDto;
import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.dto.PersonDto;
import telran.java2022.person.service.PersonService;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
	
	final PersonService personService;
	
	@PostMapping
	public Boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
	
	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}
	@DeleteMapping("/{id}")
	public PersonDto deletePerson(@PathVariable Integer id) {
		return personService.removePerson(id);
	}

	@PutMapping("/{id}/name/{name}")
	public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
		return personService.updatePersonName(id, name);
	}

	@PutMapping("/{id}/address")
	public PersonDto updatePersonAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
		return personService.updatePersonAddress(id, addressDto);
	}

	@GetMapping("/name/{name}")
	@Transactional
	public Iterable<PersonDto> findPersonByName(@PathVariable String name) {
		return personService.findPersonsByName(name);
	}

	@GetMapping("/ages/{minAge}/{maxAge}")
	@Transactional
	public Iterable<PersonDto> findPersonByAge(@PathVariable Integer minAge, @PathVariable Integer maxAge) {
		return personService.findPersonsBetweenAge(minAge, maxAge);
	}

	@GetMapping("/city/{city}")
	@Transactional
	public Iterable<PersonDto> findPersonByCity(@PathVariable String city) {
		return personService.findPersonsByCity(city);
	}
	
	@GetMapping("/population/city")
	@Transactional
	public Iterable<CityPopulationDto> getCitiesPopulation() {
		return personService.getCitiesPopulation();
	}

}