package controllers;

import dtos.GreivanceDto;
import entities.Greivance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/default")
public interface GreivanceOperations {
    @GetMapping("/")
    List<GreivanceDto> getAllGreivances();

    @GetMapping("/{id}")
    GreivanceDto getById(@PathVariable int id);

    @PostMapping("/create")
    GreivanceDto createGreivance(@RequestBody GreivanceDto greivanceDto);

    @PutMapping("/{id}")
    Optional<Greivance> updateGreivance(@PathVariable int id);

    @DeleteMapping("/{id}")
    ResponseEntity<GreivanceDto> deleteGreivance(@PathVariable int id);


}
