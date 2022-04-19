package task.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Tickers {
    @NotNull
    @JsonProperty("trade_url")
    private String tradeUrl;
}
