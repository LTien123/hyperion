package com.fanci.Hyperion_be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PaypalDto {
    private Double total;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
