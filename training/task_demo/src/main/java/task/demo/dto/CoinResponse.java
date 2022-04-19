package task.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String trade_url;

    @JsonIgnore
    CoinDetailDto coinDetailDto;
    @JsonIgnore
    CoinDto coinDto;

}
