package com.woowacourse.ternoko.dto;

import com.woowacourse.ternoko.domain.Reservation;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(builderMethodName = "reservationResponseBuilder")
public class ReservationResponse {

    private final Long id;
    private final String coachNickname;
    private final LocalDate reservationDate;
    private final LocalTime reservationStartTime;
    private final LocalTime reservationEndTime;

    public static ReservationResponse from(final Reservation reservation) {
        return ReservationResponse.reservationResponseBuilder()
                .id(reservation.getId())
                .coachNickname(reservation.getInterview().getCoach().getNickname())
                .reservationDate(reservation.getInterview().getReservationDate())
                .reservationStartTime(reservation.getInterview().getReservationStartTime())
                .reservationEndTime(reservation.getInterview().getReservationEndTime())
                .build();
    }
}
