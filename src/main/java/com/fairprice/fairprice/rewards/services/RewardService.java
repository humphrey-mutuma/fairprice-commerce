package com.fairprice.fairprice.rewards.services;

import com.fairprice.fairprice.exceptions.ResourceNotFoundException;
import com.fairprice.fairprice.rewards.dto.RewardDto;
import com.fairprice.fairprice.rewards.model.Reward;
import com.fairprice.fairprice.rewards.repo.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardService implements IRewardService {
    private final RewardRepository rewardRepository;

    @Override
    public List<Reward> findRewards() {
        return  rewardRepository.findAll();
    }

    @Override
    public String createReward(RewardDto reward) {

        Reward newReward = new Reward();
        newReward.setPoints(reward.getPoints());
        newReward.setAmount(reward.getAmount());

        rewardRepository.save(newReward);
        return "Reward created successfully";
    }

//    @Override
//    public String updateReward(Long rewardId, RewardDto reward) {
//        return "";
//    }
    @Override
    public String deleteReward(Long rewardId) {
       rewardRepository.findById(rewardId)
                .orElseThrow(()-> new ResourceNotFoundException("Reward not found!"));

        rewardRepository.deleteById(rewardId);
        return "Reward deleted successfully";
    }
}
