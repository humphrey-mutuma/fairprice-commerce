package com.fairprice.fairprice.rewards.repo;

 import com.fairprice.fairprice.rewards.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
}
