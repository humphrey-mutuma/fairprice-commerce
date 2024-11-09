package com.fairprice.fairprice.address;

import com.fairprice.fairprice.address.entity.Address;
import com.fairprice.fairprice.address.services.AddressService;
import com.fairprice.fairprice.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/address")

public class AddressController {
    private final AddressService addressService;

     @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Address>>> findAllAddresses() {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,addressService.findAllAddresses()));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<ApiResponse<String>> deleteAddress(
            @PathVariable("addressId") Long addressId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,addressService.deleteAddress(addressId)));
    }

}
