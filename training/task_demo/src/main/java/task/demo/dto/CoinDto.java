package task.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CoinDto {
    @NotNull
    private String id;
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
}
