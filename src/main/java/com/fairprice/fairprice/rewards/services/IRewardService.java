package com.fairprice.fairprice.rewards.services;

import com.fairprice.fairprice.rewards.dto.RewardDto;
import com.fairprice.fairprice.rewards.model.Reward;

import java.util.List;

public interface IRewardService {

    List<Reward> findRewards();

    String createReward(RewardDto reward);

//    String updateReward(Long rewardId, RewardDto reward    );

     String deleteReward(Long rewardId );

}

