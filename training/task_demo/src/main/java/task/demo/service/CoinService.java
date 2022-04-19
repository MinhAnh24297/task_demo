package task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import task.demo.dto.CoinDetailDto;
import task.demo.dto.CoinDto;
import task.demo.dto.CoinResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService implements ICoinService {

    private final CoinFeignClient coinFeignClient;

    @Scheduled()
    public void sechuler() {

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
                    .tradeUrl(detailDto.getTickers().get(0).getTradeUrl())
                    .build());
        }
        return coinResponsesList;
    }

    private List<CoinDto> getCoinsByMarket(String currency, int page, int perPage) {
        return coinFeignClient.getCoinDtos(currency, page, perPage);
    }

    private CoinDetailDto getCoinDetailDto(String id) {
        return coinFeignClient.getDetailDto(id);
    }

}
