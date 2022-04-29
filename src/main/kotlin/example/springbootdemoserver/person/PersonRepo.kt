package example.springbootdemoserver.person

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo : JpaRepository<PersonEntity, Long>
