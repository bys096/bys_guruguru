package com.fenrir.guruguru_spring.domain.admin.service;

import com.fenrir.guruguru_spring.domain.admin.dto.AdminOwnerResponseDto;
import com.fenrir.guruguru_spring.domain.admin.repository.AdminRepositoryCustom;
import com.fenrir.guruguru_spring.domain.admin.dto.AdminUserPaginationRequestDto;
import com.fenrir.guruguru_spring.domain.admin.dto.AdminUserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepositoryCustom adminRepositoryCustom;

    public Page<AdminUserResponseDto> getAllMember(AdminUserPaginationRequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage(), requestDto.getLimit());
        return adminRepositoryCustom.getAllMember(pageable, requestDto);
    }

    public Page<AdminOwnerResponseDto> getAllOwner(AdminUserPaginationRequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage(), requestDto.getLimit());
        return adminRepositoryCustom.getAllOwner(pageable, requestDto);
    }
}