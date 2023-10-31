package com.scaler.adminmanagementservice.Services;

import com.scaler.adminmanagementservice.models.AdminDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdminServices {
    AdminDto updateAdmin(AdminDto updatedAdminDto);
    AdminDto createAdmin(AdminDto adminDto);

    AdminDto deleteAdmin(int id);

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(int id);
}
