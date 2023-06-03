package com.fenrir.guruguru_spring.domain.user.service;

import com.fenrir.guruguru_spring.domain.user.dto.UserCreateRequestDto;
import com.fenrir.guruguru_spring.domain.user.dto.UserUpdateRequestDto;
import com.fenrir.guruguru_spring.domain.user.entity.User;
import com.fenrir.guruguru_spring.domain.user.exception.UserNotFoundException;
import com.fenrir.guruguru_spring.domain.user.mapper.UserMapper;
import com.fenrir.guruguru_spring.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public void createUser(UserCreateRequestDto dto) {
        userRepository.save(userMapper.toEntity(dto));
    }

    @Transactional
    public void updateUser(UserUpdateRequestDto dto, Long uid) {
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException());
        user.updateUser(dto);
    }

    @Transactional
    public void deleteUser(Long uid) {
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(uid);
    }
}
