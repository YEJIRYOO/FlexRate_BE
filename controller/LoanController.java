package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.service.LoanService;
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
    @GetMapping("/{creditId}")
    public ResponseEntity<?> getLoanByCreditId(@PathVariable Long creditId){
        try {
            return ResponseEntity.ok(loanService.findMyLoan(creditId));
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{creditId}")
    public ResponseEntity<?> updateLoan(@PathVariable Long creditId, @RequestBody LoanCreateRequestDto loanDto){
        try {
            loanService.updateLoan(creditId,loanDto);
            return ResponseEntity.ok("Loan updated successfully");
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}