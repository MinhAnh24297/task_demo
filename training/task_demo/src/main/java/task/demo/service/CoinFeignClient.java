package task.demo.service;

import task.demo.dto.CoinDetailDto;
import task.demo.dto.CoinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="CoinFeignClient", url = "https://api.coingecko.com/api/v3/")
public interface CoinFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/coins/markets", produces = "application/json")
    List<CoinDto> getCoinDtos(@RequestParam("vs_currency") String currency, @RequestParam("page") int page, @RequestParam("per_page") int perPage);

    @RequestMapping(method = RequestMethod.GET, value = "/coins/{id}", produces = "application/json")
    CoinDetailDto getDetailDto(@PathVariable("id") String id);

}
