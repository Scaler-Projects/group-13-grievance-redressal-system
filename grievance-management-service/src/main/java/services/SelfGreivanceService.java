package services;

import dtos.GreivanceDto;
import entities.Greivance;
import repositories.GreivanceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SelfGreivanceService implements GrevienceService{

    private GreivanceRepository greivanceRepository;

    private GreivanceDto convertGreivanceToGreivanceDto(Greivance greivancee) {
        GreivanceDto greivance = new GreivanceDto();
        greivance.setDescription(greivancee.getDescription());
        greivance.setAssignee(greivancee.getAssignee());
        greivance.setCreatedBy(greivancee.getCreatedBy());
        greivance.setUpdatedBy(greivancee.getUpdatedBy());
        greivance.setTimeCreated(greivancee.getTimeCreated());
        greivance.setTimeUpdated(greivancee.getTimeUpdated());

        return greivance;

    }

    public GreivanceDto deleteGreivance(int id) {
        GreivanceDto greivanceDto = new GreivanceDto();
        Optional<Greivance> greivance = greivanceRepository.findById(id);
        if(greivance.isEmpty()) return null;
        greivanceRepository.deleteById(id);

        return convertGreivanceToGreivanceDto(greivance.get());
    }

    @Override
    public List<GreivanceDto> getAllGreivances() {
        List<Greivance> greivances = greivanceRepository.findAll().stream().collect(Collectors.toList());
        List<GreivanceDto> greivanceDtos = new ArrayList<>();

        for(Greivance greivance:greivances){
            greivanceDtos.add(convertGreivanceToGreivanceDto(greivance));
        }
        return greivanceDtos;
    }

    @Override
    public GreivanceDto getGreivanceById(int id) {
        Optional<Greivance> greivance = greivanceRepository.findById(id);
        if(greivance.isEmpty()) return null;
        return convertGreivanceToGreivanceDto(greivance.get());
    }

    @Override
    public GreivanceDto createGreivance(GreivanceDto greivanceDto) {
        Greivance newGreivance = new Greivance();
        newGreivance.setDescription(greivanceDto.getDescription());
        newGreivance.setAssignee(greivanceDto.getAssignee());
        newGreivance.setCreatedBy(greivanceDto.getCreatedBy());
        newGreivance.setUpdatedBy(greivanceDto.getUpdatedBy());
        newGreivance.setTimeCreated(greivanceDto.getTimeCreated());
        newGreivance.setTimeUpdated(greivanceDto.getTimeUpdated());

        greivanceRepository.save(newGreivance);

        return convertGreivanceToGreivanceDto(newGreivance);
    }
}
