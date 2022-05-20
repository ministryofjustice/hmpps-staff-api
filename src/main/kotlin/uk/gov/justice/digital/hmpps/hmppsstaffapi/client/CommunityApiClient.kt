package uk.gov.justice.digital.hmpps.hmppsstaffapi.client

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import uk.gov.justice.digital.hmpps.hmppsstaffapi.client.dto.StaffSummary

class CommunityApiClient(private val webClient: WebClient) {

  fun getTeamStaff(teamCode: String): Mono<List<StaffSummary>> {
    val responseType = object : ParameterizedTypeReference<List<StaffSummary>>() {}
    return webClient
      .get()
      .uri("/teams/$teamCode/staff")
      .retrieve()
      .onStatus(
        { httpStatus -> HttpStatus.NOT_FOUND == httpStatus },
        { Mono.error(MissingTeamError("No team found for $teamCode")) }
      )
      .bodyToMono(responseType)
  }
}

class MissingTeamError(msg: String) : RuntimeException(msg)
