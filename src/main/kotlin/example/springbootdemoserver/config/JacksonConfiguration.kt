package example.springbootdemoserver.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class JacksonConfiguration {

  @Bean
  @Primary
  fun objectMapperBuilder(): Jackson2ObjectMapperBuilder =
    Jackson2ObjectMapperBuilder().apply {
      serializationInclusion(JsonInclude.Include.NON_NULL)
      featuresToDisable(
        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
        DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE
      ) // Timezone-Information should be propagated
      featuresToEnable(
        DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS,
        DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES
      )
      modules(JavaTimeModule(), KotlinModule.Builder().build())
    }
}
