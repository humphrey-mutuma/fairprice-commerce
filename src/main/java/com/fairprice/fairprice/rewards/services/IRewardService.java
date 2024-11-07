package com.fairprice.fairprice.rewards.services;


import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.rewards.model.Reward;

public interface IRewardService {

    ProductDto findReward();

    String createReward(Reward reward);

    String updateReward(Long rewardId, Reward reward    );

     String deleteReward(Long rewardId );

}
