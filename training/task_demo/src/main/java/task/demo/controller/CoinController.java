package task.demo.controller;

import task.demo.dto.CoinResponse;
import task.demo.service.CoinFeignClient;
import task.demo.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CoinController {

    @Autowired
    private CoinFeignClient coinFeignClient;

    @Autowired
    ICoinService coinService;

    @GetMapping("/coins")
    public List<CoinResponse> getCoinResponsePage(@RequestParam(name = "vs_currency") String currency,
                                                  @RequestParam(name = "page") int page,
                                                  @RequestParam(name = "per_page") int perPage) {
        return coinService.getCoins(currency, page, perPage);
    }

}
