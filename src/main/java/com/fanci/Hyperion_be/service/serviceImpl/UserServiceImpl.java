package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewUserRequest;
import com.fanci.Hyperion_be.dto.request.UpdateUserRequest;
import com.fanci.Hyperion_be.dto.response.UserResponse;
import com.fanci.Hyperion_be.entity.User;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.RoleMapper;
import com.fanci.Hyperion_be.mapper.UserMapper;
import com.fanci.Hyperion_be.repository.RoleRepository;
import com.fanci.Hyperion_be.repository.UserRepository;
import com.fanci.Hyperion_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    private final UploadService uploadService;

    private final PasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public List<UserResponse> findAllUser() {
        return userRepository.findAll().stream().map(this::toUserResponse).toList();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_ID_NOT_FOUND));
        return toUserResponse(user);
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public UserResponse addNewUser(CreateNewUserRequest request) throws IOException {
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new AppException(ErrorCode.PASSWORD_NOT_MATCH);
        }

        if (userRepository.findUserByUsername(request.getUsername()).isPresent()) {
            throw new AppException(ErrorCode.USERNAME_DUPLICATED);
        }

        String password = passwordEncoder.encode(request.getPassword());

        User user = userMapper.toUser(request);
        user.setPassword(password);

        user.setIsActive(true);


        uploadService.uploadThumbnail(user, request.getImage());


        user.setRoles(request.getRoleId().stream().map(roleId -> roleRepository.findById(roleId).orElseThrow(() -> new AppException(ErrorCode.ROLE_ID_NOT_FOUND))).collect(Collectors.toSet()));
        return toUserResponse(userRepository.save(user));
    }
    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public UserResponse updateUser(UpdateUserRequest request, Long id) throws IOException {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_ID_NOT_FOUND));
        userMapper.updateUser(request, user);
        user.setRoles(request.getRoleId().stream().map(roleId -> roleRepository.findById(roleId).orElseThrow(() -> new AppException(ErrorCode.ROLE_ID_NOT_FOUND))).collect(Collectors.toSet()));

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            uploadService.uploadThumbnail(user, request.getImage());

        }
        return toUserResponse(userRepository.save(user));
    }
    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_ID_NOT_FOUND));
        user.setIsActive(false);
        userRepository.save(user);
    }

    private UserResponse toUserResponse(User user) {
        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setRoleDtos(user.getRoles().stream().map(roleMapper::toRoleDto).collect(Collectors.toSet()));
        return userResponse;
    }


}