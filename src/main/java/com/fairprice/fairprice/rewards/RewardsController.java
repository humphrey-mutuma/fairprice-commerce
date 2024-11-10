package com.fairprice.fairprice.rewards;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.reponse.ApiResponse;
import com.fairprice.fairprice.rewards.dto.RewardDto;
import com.fairprice.fairprice.rewards.model.Reward;
import com.fairprice.fairprice.rewards.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/rewards")
@CrossOrigin
public class RewardsController {
    private final RewardService rewardsService;

    //    fetch rewards***********************
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Reward>>> findRewards( ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,rewardsService.findRewards()));
    }

    // create reward **************************
    @PostMapping("")
    public ResponseEntity<ApiResponse<String>> createReward(
             @RequestBody() RewardDto reward
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(rewardsService.createReward(reward), null));
    }

    // update reward **************************
//    @PatchMapping("/{rewardId}")
//    public ResponseEntity<ApiResponse<String>> updateReward(
//            @PathVariable() Long rewardId,
//            @RequestBody() Reward reward
//    ) {
//        return ResponseEntity
//                .ok(new ApiResponse<>(rewardsService.updateReward(rewardId, reward), null));
//    }

    // delete reward *******************
    @DeleteMapping("/{rewardId}")
    public ResponseEntity<ApiResponse<String>> deleteReward(
            @PathVariable("rewardId") Long rewardId
             )  {
        return ResponseEntity
                .ok(new ApiResponse<>( rewardsService.deleteReward(rewardId), null));
    }

}
