package services;

import dtos.GreivanceDto;
import entities.Greivance;

import java.util.List;

public interface GrevienceService {

    GreivanceDto createGreivance(GreivanceDto greivanceDto);

    GreivanceDto deleteGreivance(int id);

    List<GreivanceDto> getAllGreivances();

    GreivanceDto getGreivanceById(int id);



}
