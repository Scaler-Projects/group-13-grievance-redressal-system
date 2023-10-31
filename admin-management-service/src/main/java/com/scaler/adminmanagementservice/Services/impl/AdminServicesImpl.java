package com.scaler.adminmanagementservice.Services.impl;

import com.scaler.adminmanagementservice.Services.AdminServices;
import com.scaler.adminmanagementservice.repository.AdminRepository;
import com.scaler.adminmanagementservice.entity.UsersEntity;
import com.scaler.adminmanagementservice.models.AdminDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminServicesImpl implements AdminServices {

    private AdminRepository adminRepository ;

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
    public AdminDto updateAdmin(AdminDto updatedAdminDto) {
        Optional<UsersEntity> admin = adminRepository.findById(updatedAdminDto.getUserid().intValue());
        if(!admin.isPresent()) return null;
        UsersEntity updatedAdmin = admin.get();
        updatedAdmin.setEmail(updatedAdminDto.getEmail());
        updatedAdmin.setUser_id(updatedAdminDto.getUserid());
        updatedAdmin.setPassword(updatedAdminDto.getPassword());
        updatedAdmin.setTimeCreated(updatedAdminDto.getTimeCreated());
        updatedAdmin.setUsername(updatedAdminDto.getUsername());
        updatedAdmin.setTimeUpdated(updatedAdminDto.getTimeUpdated());
        updatedAdmin.setPhone_number(updatedAdminDto.getPhone());

        adminRepository.save(updatedAdmin);

        return updatedAdminDto;

    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        UsersEntity admin = new UsersEntity();
        admin.setEmail(adminDto.getEmail());
        admin.setUser_id(adminDto.getUserid());
        admin.setPassword(adminDto.getPassword());
        admin.setTimeCreated(adminDto.getTimeCreated());
        admin.setUsername(adminDto.getUsername());
        admin.setTimeUpdated(adminDto.getTimeUpdated());
        admin.setPhone_number(adminDto.getPhone());
        admin.setRole_id(1);
        adminRepository.save(admin);

        return adminDto;
    }

    @Override
    public AdminDto deleteAdmin(int id) {
        AdminDto adminDto = new AdminDto();
        Optional<UsersEntity> admin = adminRepository.findById(id);
        if(!admin.isPresent()) return null;
        adminRepository.deleteById(id);

        return convertAdminEntityToAdminDto(admin.get());
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<UsersEntity> admins = adminRepository.findAll().stream().collect(Collectors.toList());
        List<AdminDto> adminDtos = new ArrayList<>();

        for(UsersEntity admin:admins){
            adminDtos.add(convertAdminEntityToAdminDto(admin));
        }
        return adminDtos;
    }

    @Override
    public AdminDto getAdminById(int id) {
        Optional<UsersEntity> admin = adminRepository.findById(id);
        if(!admin.isPresent()) return null;
        return convertAdminEntityToAdminDto(admin.get());
    }
}
