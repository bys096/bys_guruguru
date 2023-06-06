package com.fenrir.guruguru_spring.domain.review.service;

import com.fenrir.guruguru_spring.domain.review.dto.ReviewCreateRequestDto;
import com.fenrir.guruguru_spring.domain.review.entity.Review;
import com.fenrir.guruguru_spring.domain.review.exception.ReviewDuplicateException;
import com.fenrir.guruguru_spring.domain.review.mapper.ReviewMapper;
import com.fenrir.guruguru_spring.domain.review.repository.ReviewRepository;
import com.fenrir.guruguru_spring.domain.user.entity.User;
import com.fenrir.guruguru_spring.domain.user.exception.UserNotFoundException;
import com.fenrir.guruguru_spring.domain.user.repository.UserRepository;
import com.fenrir.guruguru_spring.global.error.GlobalExceptionHandler;
import com.fenrir.guruguru_spring.global.error.exception.BusinessException;
import com.fenrir.guruguru_spring.global.error.exception.ErrorCode;
import com.fenrir.guruguru_spring.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    public void createReview(ReviewCreateRequestDto dto) throws BusinessException {
        User user = userRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        reviewRepository.findByUser_UserId(SecurityUtil.getCurrentMemberId())
                .ifPresentOrElse(
                        isReview -> {
                            throw new ReviewDuplicateException();
                        },
                        () -> {
                            reviewRepository.save(reviewMapper.toEntity(dto, user));
                        }
                );
    }

    public void deleteReview(Long rid) {
        User user = userRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new UserNotFoundException());

        reviewRepository.findById(rid)
                .orElseThrow(() -> new ReviewDuplicateException());

        reviewRepository.deleteById(rid);
    }

}
