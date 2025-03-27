package com.delivery.service;

import com.delivery.dto.CreateStoreDTO;
import com.delivery.exceptions.EmailAlreadyRegisteredException;
import com.delivery.exceptions.ResourceNotFoundException;
import com.delivery.exceptions.UserWithInvalidTypeException;
import com.delivery.model.Store;
import com.delivery.model.TypeUser;
import com.delivery.model.Users;
import com.delivery.repository.StoreRepository;
import com.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    public Store createStore(CreateStoreDTO data) {

        Users user = userRepository.findById(data.shopkeeper_id())
                .orElseThrow(() -> new ResourceNotFoundException("There is no user with that ID"));

        if (!TypeUser.SHOPKEEPER.equals(user.getType())) {
            throw new UserWithInvalidTypeException("Only SHOPKEEPER type users can create stores.");
        }


        var store = new Store(
                data.name(),
                data.address(),
                data.latitude(),
                data.longitude(),
                user
        );

        return storeRepository.save(store);

    }
}
