package task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task.demo.dto.CoinResponse;
import task.demo.service.ICoinService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CoinController {

    private final ICoinService coinService;

    @GetMapping("/coins")
    public ResponseEntity<List<CoinResponse>> getCoinResponsePage(@RequestParam(name = "vs_currency") String currency,
                                                                 @RequestParam(name = "page") int page,
                                                                 @RequestParam(name = "per_page") int perPage) {
        return ResponseEntity.ok(coinService.getCoins(currency, page, perPage));
    }

}
