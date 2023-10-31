package com.scaler.adminmanagementservice.Controllers;



import com.scaler.adminmanagementservice.models.AdminDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/default")
public interface AdminInterface {
    @GetMapping("/")
    List<AdminDto> getAllAdmin();

    @GetMapping("/{id}")
    AdminDto getAdminById(@PathVariable int id);

    @PostMapping("/create")
    AdminDto createAdmin(@RequestBody AdminDto adminDto);

    @PutMapping("/")
    Optional<AdminDto> updateAdmin(@RequestBody AdminDto updatedAdminDto);

    @DeleteMapping("/{id}")
    AdminDto deleteAdmin(@PathVariable int id);
}
