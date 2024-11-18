package com.fairprice.fairprice.user.services;

 import com.fairprice.fairprice.address.dto.UpdateAddressDto;
 import com.fairprice.fairprice.card.dto.UpdateCardDetailsDto;
 import com.fairprice.fairprice.exceptions.UnauthorizedException;
 import com.fairprice.fairprice.user.dto.UserProfileResDto;
 import com.fairprice.fairprice.address.entity.Address;
 import com.fairprice.fairprice.card.model.Card;
 import com.fairprice.fairprice.user.model.User;
 import com.fairprice.fairprice.address.repo.AddressRepository;
 import com.fairprice.fairprice.card.repo.CardRepository;
 import com.fairprice.fairprice.user.repo.UserRepository;
 import lombok.RequiredArgsConstructor;
 import org.modelmapper.ModelMapper;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.lang.module.ResolutionException;
 import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;
    private final CardRepository cardRepository;

    @Override
    public UserProfileResDto findUserProfile(UUID userId, UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new ResolutionException("User not found!"));

        if (!user.getId().equals(userId)){
            throw new UnauthorizedException("Not Authorized!");
        }
        return modelMapper.map(user, UserProfileResDto.class);
    }

    @Override
    @Transactional
    public String updateUserPoints(Double points, UserDetails userDetails) {

        User existing_user = userRepository.findByUsername(userDetails.getUsername())
                            .orElseThrow(()-> new ResolutionException("User Not found!"));
//
        existing_user.setPoints(points);

        userRepository.save(existing_user);

        return "User points updated successfully";
    }

    @Override
    @Transactional
    public String updateUserAddress( UpdateAddressDto updateAddress, UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(()-> new ResolutionException("User Not found!"));

//        create new address
        Address newAddress = new Address();
        newAddress.setFirstname(updateAddress.getFirstname());
        newAddress.setLastname(updateAddress.getLastname());
        newAddress.setAddress1(updateAddress.getAddress1());
        newAddress.setAddress2(updateAddress.getAddress2());
        newAddress.setCountry(updateAddress.getCountry());
        newAddress.setCity(updateAddress.getCity());
        newAddress.setState(updateAddress.getState());
        newAddress.setZipcode(updateAddress.getZipcode());
        newAddress.setPhoneNumber(updateAddress.getPhoneNumber());
        newAddress.setUser(user);

        addressRepository.save(newAddress);

        return "Shipping address updated successfully";
    }

    @Override
    @Transactional
    public String updateUserCards( UpdateCardDetailsDto  updateCardDetailsDto, UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(()-> new ResolutionException("User Not found!"));

//        update card
        Card newCard = new Card();
        newCard.setHolderName(updateCardDetailsDto.getHolderName());
        newCard.setCardNumber(updateCardDetailsDto.getCardNumber());
        newCard.setExpiry(updateCardDetailsDto.getExpiry());
        newCard.setCvv(updateCardDetailsDto.getCvv());

        newCard.setUser(user);

        cardRepository.save(newCard);

        return "Card details updated successfully";
    }

    @Override
    @Transactional
    public String deleteUser(UUID userId, UserDetails userDetails) {
       User user =  userRepository.findByUsername(userDetails.getUsername())
                                    .orElseThrow(()-> new ResolutionException("User Not found!"));

        if (!user.getId().equals(userId)) {
            throw new UnauthorizedException("Not authorized!");
        }

        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

}
