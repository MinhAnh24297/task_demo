package task.demo.service;

import task.demo.dto.CoinDetailDto;
import task.demo.dto.CoinDto;
import task.demo.dto.CoinResponse;

import java.util.List;

public interface ICoinService {
    List<CoinResponse> getCoins(String currency, int page, int perPage);
}
