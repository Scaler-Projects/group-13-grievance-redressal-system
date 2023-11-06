package com.scaler.grievancemanagementservice.services;

import com.scaler.grievancemanagementservice.dtos.GreivanceDto;

import java.util.List;

public interface GrevienceService {

    GreivanceDto createGreivance(GreivanceDto greivanceDto);

    GreivanceDto deleteGreivance(int id);

    List<GreivanceDto> getAllGreivances();

    GreivanceDto getGreivanceById(int id);



}
