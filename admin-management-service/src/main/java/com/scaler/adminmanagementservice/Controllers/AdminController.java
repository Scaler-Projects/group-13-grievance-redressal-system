package com.scaler.adminmanagementservice.Controllers;

import com.scaler.adminmanagementservice.Services.AdminServices;
import com.scaler.adminmanagementservice.models.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public AdminDto updateAdmin(AdminDto updatedAdminDto, int id) {
        return adminServices.updateAdmin(updatedAdminDto , id);
    }

    @Override
    public AdminDto deleteAdmin(int id) {
        return adminServices.deleteAdmin(id);
    }
}

