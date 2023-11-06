package com.scaler.adminmanagementservice;

import com.scaler.adminmanagementservice.Services.impl.AdminServicesImpl;
import com.scaler.adminmanagementservice.entity.UsersEntity;
import com.scaler.adminmanagementservice.models.AdminDto;
import com.scaler.adminmanagementservice.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdminServicesImplTests {
    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServicesImpl adminServices;

    private UsersEntity createMockUserEntity(int userId, String username, String email, String password, String phone) {
        UsersEntity user = new UsersEntity();
        user.setUser_id(userId);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone_number(phone);
        user.setTimeCreated(new Date().toString());
        user.setTimeUpdated(new Date().toString());
        return user;
    }

    @BeforeEach
    public void setup() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAdmin() {
        AdminDto adminDto = new AdminDto();
        adminDto.setUsername("TestUser");
        adminDto.setEmail("test@test.com");
        adminDto.setPassword("password");
        adminDto.setPhone("1234567890");

        UsersEntity mockUserEntity = createMockUserEntity(1, "TestUser", "test@test.com", "password", "1234567890");

        when(adminRepository.save(Mockito.any(UsersEntity.class))).thenReturn(mockUserEntity);

        AdminDto result = adminServices.createAdmin(adminDto);

        assertEquals("TestUser", result.getUsername());
        assertEquals("test@test.com", result.getEmail());
        assertEquals("1234567890", result.getPhone());
    }
    @Test
    public void testUpdateAdmin() {
        // Create a sample admin entity
        UsersEntity adminEntity = new UsersEntity();
        adminEntity.setUser_id(1);
        adminEntity.setEmail("old@example.com");
        adminEntity.setPassword("oldPassword");
        adminEntity.setUsername("OldUser");
        adminEntity.setPhone_number("123456789");
        adminEntity.setTimeCreated(new Date().toString());

        // Create a sample admin DTO with updated values
        AdminDto updatedAdminDto = new AdminDto();
        updatedAdminDto.setEmail("new@example.com");
        updatedAdminDto.setPassword("newPassword");
        updatedAdminDto.setUsername("NewUser");
        updatedAdminDto.setPhone("987654321");

        // Mock the behavior of the adminRepository
        when(adminRepository.findById(1)).thenReturn(Optional.of(adminEntity));
        when(adminRepository.save(Mockito.any(UsersEntity.class))).thenReturn(adminEntity);

        // Call the method to update the admin
        AdminDto updatedAdmin = adminServices.updateAdmin(updatedAdminDto, 1);

        // Verify that the admin has been updated
        assertEquals(updatedAdmin.getEmail(), "new@example.com");
        assertEquals(updatedAdmin.getPassword(), "newPassword");
        assertEquals(updatedAdmin.getUsername(), "NewUser");
        assertEquals(updatedAdmin.getPhone(), "987654321");
    }

    @Test
    public void testDeleteAdmin_ExistingId_ReturnsAdminDto() {
        UsersEntity mockAdmin = new UsersEntity();
        mockAdmin.setEmail("admin@example.com");
        mockAdmin.setPhone_number("1234567890");
        mockAdmin.setPassword("admin123");
        mockAdmin.setUser_id(1);
        mockAdmin.setUsername("admin");
        when(adminRepository.findById(1)).thenReturn(java.util.Optional.of(mockAdmin));
        when(adminRepository.findById(2)).thenReturn(java.util.Optional.empty());

        List<UsersEntity> mockAdminList = new ArrayList<>();
        mockAdminList.add(mockAdmin);
        when(adminRepository.findUsersEntityByRole_idEquals(0)).thenReturn(mockAdminList);
        AdminDto adminDto = adminServices.deleteAdmin(1);
        assertNotNull(adminDto);
        assertEquals("admin@example.com", adminDto.getEmail());
        assertEquals("admin", adminDto.getUsername());
    }


    @Test
    public void testDeleteAdmin_NonExistentId_ReturnsNull() {
        UsersEntity mockAdmin = new UsersEntity();
        mockAdmin.setEmail("admin@example.com");
        mockAdmin.setPhone_number("1234567890");
        mockAdmin.setPassword("admin123");
        mockAdmin.setUser_id(1);
        mockAdmin.setUsername("admin");
        when(adminRepository.findById(1)).thenReturn(java.util.Optional.of(mockAdmin));
        when(adminRepository.findById(2)).thenReturn(java.util.Optional.empty());
        AdminDto adminDto = adminServices.deleteAdmin(2);
        assertNull(adminDto);
    }

    @Test
    public void testGetAdminById_ExistingId_ReturnsAdminDto() {
        UsersEntity mockAdmin = new UsersEntity();
        mockAdmin.setEmail("admin@example.com");
        mockAdmin.setPhone_number("1234567890");
        mockAdmin.setPassword("admin123");
        mockAdmin.setUser_id(1);
        mockAdmin.setUsername("admin");
        when(adminRepository.findById(1)).thenReturn(java.util.Optional.of(mockAdmin));
        when(adminRepository.findById(2)).thenReturn(java.util.Optional.empty());
        AdminDto adminDto = adminServices.getAdminById(1);
        assertNotNull(adminDto);
        assertEquals("admin@example.com", adminDto.getEmail());
        assertEquals("admin", adminDto.getUsername());
    }

    @Test
    public void testGetAdminById_NonExistentId_ReturnsNull() {
        UsersEntity mockAdmin = new UsersEntity();
        mockAdmin.setEmail("admin@example.com");
        mockAdmin.setPhone_number("1234567890");
        mockAdmin.setPassword("admin123");
        mockAdmin.setUser_id(1);
        mockAdmin.setUsername("admin");
        when(adminRepository.findById(1)).thenReturn(java.util.Optional.of(mockAdmin));
        when(adminRepository.findById(2)).thenReturn(java.util.Optional.empty());
        AdminDto adminDto = adminServices.getAdminById(2);
        assertNull(adminDto);
    }

    @Test
    public void testGetAllAdmins_ReturnsAdminDtoList() {
        UsersEntity mockAdmin = new UsersEntity();
        mockAdmin.setEmail("admin@example.com");
        mockAdmin.setPhone_number("1234567890");
        mockAdmin.setPassword("admin123");
        mockAdmin.setUser_id(1);
        mockAdmin.setRole_id(0);
        mockAdmin.setUsername("admin");
        UsersEntity mockUserEntity = createMockUserEntity(1, "TestUser", "test@test.com", "password", "1234567890");
        when(adminRepository.findById(1)).thenReturn(java.util.Optional.of(mockAdmin));
        when(adminRepository.save(Mockito.any(UsersEntity.class))).thenReturn(mockUserEntity);
        when(adminRepository.findById(2)).thenReturn(java.util.Optional.empty());
        List<AdminDto> adminDtos = adminServices.getAllAdmins();
        assertNotNull(adminDtos);
        assertEquals(1, adminDtos.size());
    }


}
