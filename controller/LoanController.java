package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.dto.LoanInfoDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.service.LoanService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    //get method
    @GetMapping("/{memberId}")
    public ResponseEntity<LoanInfoDto> getLoanInfo(@PathVariable("memberId") Long memberId){
        try {
            LoanInfoDto loanInfoDto=loanService.getLoanInfo(memberId);
            return ResponseEntity.ok(loanInfoDto);
        }catch (DataNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> updateLoan(@PathVariable Long memberId, @RequestBody LoanCreateRequestDto loanDto){
        try {
            loanService.updateLoan(memberId,loanDto);
            return ResponseEntity.ok("Loan 업데이트 성공");
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}