package com.bloomberg.fx.request;

import com.bloomberg.fx.constants.RegexConstant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DealRequest {

    @NotNull(message = "dealId cannot be null")
    @NotBlank(message = "dealId cannot be empty")
    private String dealId;

    @NotNull(message = "fromCurrencyISOCode cannot be null")
    @NotBlank(message = "fromCurrencyISOCode cannot be empty")
    private String fromCurrencyISOCode;

    @NotNull(message = "toCurrencyISOCode cannot be null")
    @NotBlank(message = "toCurrencyISOCode cannot be empty")
    private String toCurrencyISOCode;

    @NotNull(message = "orderDate cannot be null")
    @Pattern(regexp = RegexConstant.DATETIME)
    private String orderDate;

    @NotNull(message = "dealAmount cannot be null")
    private Double dealAmount;
}
