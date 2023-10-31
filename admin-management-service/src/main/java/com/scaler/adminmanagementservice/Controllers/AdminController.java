package com.scaler.adminmanagementservice.Controllers;

import com.scaler.adminmanagementservice.Services.AdminServices;
import com.scaler.adminmanagementservice.models.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/admin")
public class AdminController implements AdminInterface {
    @Autowired
    private AdminServices adminServices;

    @Override
    public List<AdminDto> getAllAdmin() {
        return adminServices.getAllAdmins();
    }

    @Override
    public AdminDto getAdminById(int id) {
        return adminServices.getAdminById(id);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        return adminServices.createAdmin(adminDto);
    }

    @Override
    public Optional<AdminDto> updateAdmin(AdminDto updatedAdminDto) {
        return Optional.ofNullable(adminServices.updateAdmin(updatedAdminDto));
    }

    @Override
    public AdminDto deleteAdmin(int id) {
        return adminServices.deleteAdmin(id);
    }
}

