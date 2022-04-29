package example.springbootdemoserver.person

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
data class PersonEntity (
  @Id
  @GeneratedValue
  val id: Long? = null,
  val createTs: Instant = Instant.now(),
  val firstName: String,
  val lastName: String,
)
