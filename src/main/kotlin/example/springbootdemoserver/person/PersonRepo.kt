package example.springbootdemoserver.person

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo : JpaRepository<PersonEntity, Long> {
  fun findByFirstName(nam: String): List<PersonEntity>
}
