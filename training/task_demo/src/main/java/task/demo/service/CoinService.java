package task.demo.service;

import task.demo.dto.CoinDetailDto;
import task.demo.dto.CoinDto;
import task.demo.dto.CoinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService implements ICoinService {
    @Autowired
    private CoinFeignClient coinFeignClient;

    @Override
    public List<CoinDto> getCoinsByMarket(String currency, int page, int perPage) {
        List<CoinDto> coinDtos = coinFeignClient.getCoinDtos(currency, page, perPage);
        return coinDtos;
    }

    @Override
    public CoinDetailDto getCoinDetailDto(String id) {
        CoinDetailDto coinDetailDto = coinFeignClient.getDetailDto(id);
        return coinDetailDto;
    }

    @Override
    public List<CoinResponse> getCoins(String currency, int page, int perPage) {
        List<CoinResponse> coinResponsesList = new ArrayList<>();
        for (CoinDto coinDto : getCoinsByMarket(currency, page, perPage)) {

            CoinDetailDto detailDto = getCoinDetailDto(coinDto.getId());

            coinResponsesList.add(CoinResponse.builder()
                    .image(coinDto.getImage())
                    .name(coinDto.getName())
                    .symbol(coinDto.getSymbol())
                    .price_change_percentage_24h(coinDto.getPrice_change_percentage_24h())
                    .current_price(coinDto.getCurrent_price())
                    .description(detailDto.getDescription().getEn())
                    .trade_url(detailDto.getTickers().get(0).getTradeUrl())
                    .build());
        }
        return coinResponsesList;
    }

}
