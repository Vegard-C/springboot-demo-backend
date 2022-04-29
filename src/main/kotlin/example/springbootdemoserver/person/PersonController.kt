package example.springbootdemoserver.person

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(private val personService: PersonService) {
  @PostMapping("/api/person")
  fun addPerson(@RequestBody person: PersonDto) {
    personService.addPerson(person.firstName, person.lastName)
  }
  @GetMapping("/api/person/list")
  fun persons() = personService.list()

  @GetMapping("/api/person/entities")
  fun personEntities() = personService.entities()
}
