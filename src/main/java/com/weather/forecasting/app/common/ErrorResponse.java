package com.weather.forecasting.app.common;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String errorMassage;
    private String errorCode;
}
