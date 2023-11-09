package com.scaler.grievancemanagementservice.controllers;

import com.scaler.grievancemanagementservice.services.GreivanceService;
import com.scaler.commonservice.models.GreivanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GreivanceController implements GreivanceInterface {
    @Autowired
    private GreivanceService greivanceService;
    @Override
    public List<GreivanceDto> getAllGreivances() {
        return greivanceService.getAllGreivances();
    }

    @Override
    public GreivanceDto getById(int id) {
       return greivanceService.getGreivanceById(id);
    }

    @Override
    public GreivanceDto createGreivance(@RequestBody GreivanceDto greivanceDto) {
        return greivanceService.createGreivance(greivanceDto);
    }

    @Override
    public Optional<GreivanceDto> updateGreivance(@PathVariable int id , @RequestBody GreivanceDto greivanceDto) {
        return greivanceService.updateGreivance(id , greivanceDto);
    }

    @Override
    public ResponseEntity<GreivanceDto> deleteGreivance(int id) {
        return new ResponseEntity<>(greivanceService.deleteGreivance(id), HttpStatus.OK);
    }
}
