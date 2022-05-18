package uk.gov.justice.digital.hmpps.hmppsstaffapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
class HmppsStaffApi

fun main(args: Array<String>) {
  runApplication<HmppsStaffApi>(*args)
}
