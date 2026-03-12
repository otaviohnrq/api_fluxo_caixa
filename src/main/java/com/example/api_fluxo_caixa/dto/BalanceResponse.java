package com.example.api_fluxo_caixa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {

    private BigDecimal totalEntries;
    private BigDecimal totalExits;
    private BigDecimal balance;

}
