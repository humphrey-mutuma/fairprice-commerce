package com.fairprice.fairprice.rewards;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.dto.UpdateProductDto;
import com.fairprice.fairprice.products.services.ProductService;
import com.fairprice.fairprice.reponse.ApiResponse;
import com.fairprice.fairprice.rewards.model.Reward;
import com.fairprice.fairprice.rewards.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/rewards")
public class RewardsController {
    private final RewardService rewardsService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<ProductDto>> findReward( ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,rewardsService.findReward()));
    }

    // create reward **************************
    @PostMapping("/")
    public ResponseEntity<ApiResponse<String>> createReward(
             @RequestBody() Reward reward
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(rewardsService.createReward(reward), null));
    }

    // update reward **************************
    @PatchMapping("/{rewardId}")
    public ResponseEntity<ApiResponse<String>> updateReward(
            @PathVariable() Long rewardId,
            @RequestBody() Reward reward
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(rewardsService.updateReward(rewardId, reward), null));
    }

    // delete reward *******************
    @DeleteMapping("/{rewardId}")
    public ResponseEntity<ApiResponse<String>> deleteReward(
            @PathVariable("rewardId") Long rewardId
             )  {
        return ResponseEntity
                .ok(new ApiResponse<>( rewardsService.deleteReward(rewardId), null));
    }

}
