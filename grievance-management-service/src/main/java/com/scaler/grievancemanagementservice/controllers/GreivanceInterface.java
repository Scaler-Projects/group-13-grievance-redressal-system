package com.scaler.grievancemanagementservice.controllers;

import com.scaler.commonservice.models.GreivanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/greivances")
public interface GreivanceInterface {
    @GetMapping("/")
    List<GreivanceDto> getAllGreivances();

    @GetMapping("/{id}")
    GreivanceDto getById(@PathVariable int id);

    @PostMapping("/create")
    GreivanceDto createGreivance(@RequestBody GreivanceDto greivanceDto);

    @PutMapping("/{id}")
    Optional<GreivanceDto> updateGreivance(@PathVariable int id , @RequestBody GreivanceDto greivanceDto );

    @DeleteMapping("/{id}")
    ResponseEntity<GreivanceDto> deleteGreivance(@PathVariable int id);


}
