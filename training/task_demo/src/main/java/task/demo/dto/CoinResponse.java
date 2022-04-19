package task.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinResponse {
    @NotNull
    private String image;
    @NotNull
    private String name;
    @NotNull
    private String symbol;
    @NotNull
    private double price_change_percentage_24h;

    @NotNull
    private int current_price;

    @NotNull
    private String description;

    @NotNull
    @JsonProperty("trade_url")
    private String tradeUrl;

    @JsonIgnore
    CoinDetailDto coinDetailDto;
    @JsonIgnore
    CoinDto coinDto;

}
