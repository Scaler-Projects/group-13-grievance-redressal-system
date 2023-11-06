package com.scaler.grievancemanagementservice.controllers;

import com.scaler.grievancemanagementservice.entities.Greivance;
import com.scaler.grievancemanagementservice.services.GrevienceService;
import com.scaler.grievancemanagementservice.dtos.GreivanceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greivances")
public class GreivanceController implements GreivanceOperations{

    private GrevienceService grevienceService;
    @Override
    public List<GreivanceDto> getAllGreivances() {
        return grevienceService.getAllGreivances();
    }

    @Override
    public GreivanceDto getById(int id) {

       return grevienceService.getGreivanceById(id);
    }

    @Override
    public GreivanceDto createGreivance(@RequestBody GreivanceDto greivanceDto) {
        System.out.println("this is post mapping...");
        return grevienceService.createGreivance(greivanceDto);
    }

    @Override
    public Optional<Greivance> updateGreivance(int id) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<GreivanceDto> deleteGreivance(int id) {
        return new ResponseEntity<>(grevienceService.deleteGreivance(id), HttpStatus.OK);
    }
}
