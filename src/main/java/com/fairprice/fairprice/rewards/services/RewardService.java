package com.fairprice.fairprice.rewards.services;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.dto.UpdateProductDto;
import com.fairprice.fairprice.products.services.IProductService;
import com.fairprice.fairprice.rewards.model.Reward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardService implements IRewardService {

    @Override
    public ProductDto findReward() {
        return null;
    }

    @Override
    public String createReward(Reward reward) {
        return "";
    }

    @Override
    public String updateReward(Long rewardId, Reward reward) {
        return "";
    }

    @Override
    public String deleteReward(Long rewardId) {
        return "";
    }
}
