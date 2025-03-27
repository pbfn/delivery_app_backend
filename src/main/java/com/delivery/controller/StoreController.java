package com.delivery.controller;

import com.delivery.dto.CreateStoreDTO;
import com.delivery.service.StoreService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<?> createStore(@RequestBody CreateStoreDTO data) throws Exception {
        var store = storeService.createStore(data);

        return ResponseEntity.ok().body(store);
    }
}
