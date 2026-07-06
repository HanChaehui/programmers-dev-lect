package com.example.spring.basicboard.controller;

import com.example.spring.basicboard.dto.MemberJoinRequestDto;
import com.example.spring.basicboard.dto.MemberJoinResponseDto;
import com.example.spring.basicboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApiController {

    private MemberService memberService;

    @PostMapping("/join")
    // json의 ajax가 requestDto에 사용자 입력값 자동 매핑해줌
    public MemberJoinResponseDto join(@RequestBody MemberJoinRequestDto dto) {
        memberService.join(dto);
        // 회원가입 성공 시 로그인 페이지로 이동
        return new MemberJoinResponseDto("/members/login");
    }
}
