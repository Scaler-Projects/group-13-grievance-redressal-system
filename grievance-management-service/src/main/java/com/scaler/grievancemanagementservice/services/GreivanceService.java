package com.scaler.grievancemanagementservice.services;

import com.scaler.commonservice.models.GreivanceDto;

import java.util.List;
import java.util.Optional;

public interface GreivanceService {

    GreivanceDto createGreivance(GreivanceDto greivanceDto);

    Optional<GreivanceDto> updateGreivance(int id , GreivanceDto greivanceDto);

    GreivanceDto deleteGreivance(int id);

    List<GreivanceDto> getAllGreivances();

    GreivanceDto getGreivanceById(int id);



}
