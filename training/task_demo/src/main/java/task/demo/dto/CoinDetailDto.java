package task.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CoinDetailDto {

    @NotNull
    private Description description;

    @NotNull
    private List<Tickers> tickers;

}
