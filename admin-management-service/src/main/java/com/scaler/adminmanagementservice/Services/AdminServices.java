package com.scaler.adminmanagementservice.Services;

import com.scaler.commonservice.models.AdminDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdminServices {
    AdminDto updateAdmin(AdminDto updatedAdminDto , int id);
    AdminDto createAdmin(AdminDto adminDto);

    AdminDto deleteAdmin(int id);

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(int id);
}
