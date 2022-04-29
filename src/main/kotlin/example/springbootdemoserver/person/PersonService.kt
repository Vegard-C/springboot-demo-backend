package example.springbootdemoserver.person

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class PersonService(private val personRepo: PersonRepo) {
  fun addPerson(firstName: String, lastName: String) =
    personRepo.save(PersonEntity(firstName = firstName, lastName = lastName))

  fun list(): List<PersonDto> =
    personRepo.findAll().map { PersonDto(firstName = it.firstName, lastName = it.lastName) }

  fun entities(): List<PersonEntity> = personRepo.findAll()
}
