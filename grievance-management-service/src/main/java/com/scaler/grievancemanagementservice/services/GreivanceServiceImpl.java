package com.scaler.grievancemanagementservice.services;

import com.scaler.commonservice.entity.UsersEntity;
import com.scaler.commonservice.models.GreivanceDto;
import com.scaler.commonservice.repository.GreivanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scaler.commonservice.entity.GreivanceEntity;
import java.util.Date;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class GreivanceServiceImpl implements GreivanceService {

    @Autowired
    private GreivanceRepository greivanceRepository;

    private GreivanceDto convertGreivanceToGreivanceDto(GreivanceEntity greivanceEntity) {
        GreivanceDto greivance = new GreivanceDto();
        greivance.setGreivanceId(greivanceEntity.getGreivance_id());
        greivance.setDescription(greivanceEntity.getDescription());
        greivance.setAssignee(greivanceEntity.getAssignee());
        greivance.setCreatedBy(greivanceEntity.getCreatedBy());
        greivance.setUpdatedBy(greivanceEntity.getUpdatedBy());
        greivance.setTimeCreated(greivanceEntity.getTimeCreated());
        greivance.setTimeUpdated(greivanceEntity.getTimeUpdated());
        greivance.setStatus(greivanceEntity.getStatus());
        return greivance;

    }

    public GreivanceDto deleteGreivance(int id) {
        Optional<GreivanceEntity> greivance = greivanceRepository.findById(id);
        greivanceRepository.deleteById(id);
        return convertGreivanceToGreivanceDto(greivance.get());
    }

    @Override
    public List<GreivanceDto> getAllGreivances() {
        List<GreivanceEntity> greivances = greivanceRepository.findAll().stream().collect(Collectors.toList());
        List<GreivanceDto> greivanceDtos = new ArrayList<>();

        for(GreivanceEntity greivance:greivances){
            greivanceDtos.add(convertGreivanceToGreivanceDto(greivance));
        }
        return greivanceDtos;
    }

    @Override
    public GreivanceDto getGreivanceById(int id) {
        Optional<GreivanceEntity> greivance = greivanceRepository.findById(id);
        return convertGreivanceToGreivanceDto(greivance.get());
    }

    @Override
    public GreivanceDto createGreivance(GreivanceDto greivanceDto) {
        GreivanceEntity newGreivance = new GreivanceEntity();
        newGreivance.setDescription(greivanceDto.getDescription());
        newGreivance.setAssignee(greivanceDto.getAssignee());
        newGreivance.setCreatedBy(greivanceDto.getCreatedBy());
        newGreivance.setUpdatedBy(greivanceDto.getUpdatedBy());
        newGreivance.setStatus(greivanceDto.getStatus());
        newGreivance.setTimeCreated(new Date().toString());
        newGreivance.setTimeUpdated(new Date().toString());

        greivanceRepository.save(newGreivance);

        return convertGreivanceToGreivanceDto(newGreivance);
    }

    @Override
    public Optional<GreivanceDto> updateGreivance(int id, GreivanceDto greivanceDto) {
        GreivanceEntity greivance = greivanceRepository.findById(id).orElse(null);
        if (greivance==null) return null;
        GreivanceEntity updatedGreivane = greivance;
        if(greivanceDto.getAssignee()!=null)
            updatedGreivane.setAssignee(greivanceDto.getAssignee());
        if(greivanceDto.getUpdatedBy()!=null)
            updatedGreivane.setUpdatedBy(greivanceDto.getUpdatedBy());
        if(Optional.ofNullable(greivanceDto.getStatus())!=null)
            updatedGreivane.setStatus(greivanceDto.getStatus());
        updatedGreivane.setTimeUpdated(new Date().toString());

        greivanceRepository.save(updatedGreivane);
        return Optional.ofNullable(convertGreivanceToGreivanceDto(updatedGreivane));
    }

}
