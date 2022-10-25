package com.curady.lectureservice.domain.likes.controller;

import com.curady.lectureservice.domain.likes.service.LikesService;
import com.curady.lectureservice.global.result.Result;
import com.curady.lectureservice.global.result.SingleResult;
import com.curady.lectureservice.global.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikesController {
    private final ResponseService responseService;
    private final LikesService likesService;

    @Operation(summary = "강의 좋아요 등록", description = "강의 좋아요 등록")
    @PostMapping("/auth/{lectureId}/likes")
    public Result createLikes(@RequestHeader("X-Authorization-Id") String userId,
                              @PathVariable Long lectureId) {
        likesService.createLikes(userId, lectureId);
        return responseService.getSuccessResult();
    }

    @Operation(summary = "강의 좋아요 삭제", description = "강의 좋아요 삭제")
    @DeleteMapping("/auth/{lectureId}/likes")
    public Result deleteLikes(@RequestHeader("X-Authorization-Id") String userId,
                              @PathVariable Long lectureId) {
        likesService.deleteLikes(userId, lectureId);
        return responseService.getSuccessResult();
    }

    @Operation(summary = "강의 좋아요 여부 반환", description = "강의 좋아요 여부 반환")
    @GetMapping("/auth/{lectureId}/likes")
    public SingleResult<Boolean> isLiked(@RequestHeader("X-Authorization-Id") String userId,
                                         @PathVariable Long lectureId) {
        return responseService.getSingleResult(likesService.isLiked(userId, lectureId));
    }
}
