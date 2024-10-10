package com.example.restapihomework.controller;
import java.util.List;

import com.example.restapihomework.dto.MemberDto;
import com.example.restapihomework.service.MemberService;

//http 200 대신에 201 상태 반환을 해보기 위해 추가함
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Swagger 어노테이션 추가를 위한 임포트
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@OpenAPIDefinition(info = @Info(title = "QWER Fitness API 명세서",
        description = "QWER 피트니스 센터에 오신것을 환영합니다.",
        version = "v1.0.0",
        contact = @Contact(name = "junseok0304", email = "devjunseok0304@gmail.com")
)
)

@Tag(name="QWER Fitness", description = "QWER 헬스장 회원을 관리하는 Api 입니다.")
@RestController
@RequestMapping("/member") // Base URL 설정
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping // 회원 저장
    @Operation(summary = "헬스장 회원정보 저장", description = "JSON Params example : " +
            "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"김계란\",\n" +
            "  \"phoneNumber\": \"01012345678\",\n" +
            "  \"isEnrolled\": true,\n" +
            "  \"ptTeacherName\": \"핑크덤벨\"\n" +
            "} " )
    //@ApiResponse(responseCode = "200", description = "회원정보 추가 성공") 현재는 201을 사용하므로 주석처리
    public ResponseEntity<Void> save(@RequestBody MemberDto memberDto) {
        memberService.saveMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
    }

    @GetMapping("/{id}") // 회원 찾기
    @Operation(summary = "헬스장 회원 찾기{id}", description = "id에 해당하는 회원정보를 불러옵니다.")
    public ResponseEntity<MemberDto> findMemberById(@PathVariable Long id) {
        MemberDto memberDto = memberService.findMemberById(id);
        return ResponseEntity.ok(memberDto); // 200 OK
    }

    @GetMapping("/list") // 회원 리스트 찾기
    @Operation(summary = "헬스장 회원 리스트 불러오기", description = "현재 저장된 회원 리스트를 불러옵니다.")
    public ResponseEntity<List<MemberDto>> findAllMembers() {
        List<MemberDto> memberList = memberService.findAllMembers();
        return ResponseEntity.ok(memberList); // 200 OK
    }

    @PatchMapping("/{id}") // 회원 수정
    @Operation(summary = "헬스장 회원정보 수정{id}", description = "JSON Params example : " +
            "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"김완숙\",\n" +
            "  \"phoneNumber\": \"01012345688\",\n" +
            "  \"isEnrolled\": false,\n" +
            "  \"ptTeacherName\": \"승현쓰\"\n" +
            "} " )
    public ResponseEntity<Void> updateMemberById(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        memberDto.setId(id); // DTO에 ID 설정
        memberService.updateMemberById(id, memberDto);
        return ResponseEntity.ok().build(); // 200 OK
    }

    @DeleteMapping("/{id}") // 회원 삭제
    @Operation(summary = "헬스장 회원 삭제{id}", description = "id에 해당하는 회원정보를 삭제합니다.")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
