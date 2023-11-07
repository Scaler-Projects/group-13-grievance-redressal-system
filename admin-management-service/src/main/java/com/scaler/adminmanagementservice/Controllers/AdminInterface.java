package com.scaler.adminmanagementservice.Controllers;



import com.scaler.commonservice.models.AdminDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/admin")
public interface AdminInterface {
    @GetMapping("/")
    List<AdminDto> getAllAdmin();

    @GetMapping("/{id}")
    AdminDto getAdminById(@PathVariable int id);

    @PostMapping("/create")
    AdminDto createAdmin(@RequestBody AdminDto adminDto);

    @PutMapping("/{id}")
    AdminDto updateAdmin(@RequestBody AdminDto updatedAdminDto , @PathVariable int id);

    @DeleteMapping("/{id}")
    AdminDto deleteAdmin(@PathVariable int id);
}
