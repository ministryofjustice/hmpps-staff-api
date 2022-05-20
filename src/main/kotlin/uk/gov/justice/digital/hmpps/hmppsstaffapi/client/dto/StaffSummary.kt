package uk.gov.justice.digital.hmpps.hmppsstaffapi.client.dto

import com.fasterxml.jackson.annotation.JsonCreator
import java.math.BigInteger

data class StaffSummary @JsonCreator constructor(
  val email: String?,
  val staffIdentifier: BigInteger,
  val staffCode: String,
  val staff: StaffName,
)

data class StaffName @JsonCreator constructor(
  val forenames: String,
  val surname: String
)
