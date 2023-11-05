package com.scaler.adminmanagementservice.Services.impl;

import com.scaler.adminmanagementservice.Services.AdminServices;
import com.scaler.adminmanagementservice.repository.AdminRepository;
import com.scaler.adminmanagementservice.entity.UsersEntity;
import com.scaler.adminmanagementservice.models.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    private AdminDto convertAdminEntityToAdminDto(UsersEntity admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setEmail(admin.getEmail());
        adminDto.setPhone(admin.getPhone_number());
        adminDto.setPassword(admin.getPassword());
        adminDto.setUserid(admin.getUser_id());
        adminDto.setUsername(admin.getUsername());
        adminDto.setTimeCreated(admin.getTimeCreated());
        adminDto.setTimeUpdated(admin.getTimeUpdated());
        return adminDto;

    }

    @Override
    public AdminDto updateAdmin(AdminDto updatedAdminDto , int id) {
        UsersEntity admin = adminRepository.findById(id).orElse(null);
        if (admin==null) return null;
        UsersEntity updatedAdmin = admin;
        if(updatedAdminDto.getEmail()!=null)
            updatedAdmin.setEmail(updatedAdminDto.getEmail());
        if(updatedAdminDto.getPassword()!=null)
            updatedAdmin.setPassword(updatedAdminDto.getPassword());
        if(updatedAdminDto.getUsername()!=null)
            updatedAdmin.setUsername(updatedAdminDto.getUsername());
        if(updatedAdminDto.getPhone()!=null)
            updatedAdmin.setPhone_number(updatedAdminDto.getPhone());
        updatedAdmin.setTimeUpdated(new Date().toString());

        adminRepository.save(updatedAdmin);
        return convertAdminEntityToAdminDto(updatedAdmin);

    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        UsersEntity admin = new UsersEntity();
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setTimeCreated(new Date().toString());
        admin.setUsername(adminDto.getUsername());
        admin.setTimeUpdated(new Date().toString());
        admin.setPhone_number(adminDto.getPhone());
        admin.setRole_id(1);

        adminRepository.save(admin);
        return convertAdminEntityToAdminDto(admin);
    }

    @Override
    public AdminDto deleteAdmin(int id) {
        Optional<UsersEntity> admin = adminRepository.findById(id);
        if (!admin.isPresent()) return null;
        adminRepository.deleteById(id);
        return convertAdminEntityToAdminDto(admin.get());
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<UsersEntity> admins = adminRepository.findUsersEntityByRole_idEquals(0);
        List<AdminDto> adminDtos = new ArrayList<>();

        for (UsersEntity admin : admins) {
            adminDtos.add(convertAdminEntityToAdminDto(admin));
        }
        return adminDtos;
    }

    @Override
    public AdminDto getAdminById(int id) {
        Optional<UsersEntity> admin = adminRepository.findById(id);
        if (!admin.isPresent()) return null;
        return convertAdminEntityToAdminDto(admin.get());
    }
}
