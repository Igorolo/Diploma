package com.aplication.controller;

import com.aplication.controller.dto.RepairAccountRequestDTO;
import com.aplication.controller.dto.RepairAccountResponseDTO;
import com.aplication.service.RepairAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepairAccountController {
    private final RepairAccountService repairAccountService;

    @Autowired
    public RepairAccountController(RepairAccountService repairAccountService) {
        this.repairAccountService = repairAccountService;
    }

    @PostMapping("/repair-accounts")
    public Long createRepairAccount(@RequestBody RepairAccountRequestDTO repairAccountRequestDTO) {
        return repairAccountService.createRepairAccount(
                repairAccountRequestDTO.getRepairId(),
                repairAccountRequestDTO.getAccountId(),
                repairAccountRequestDTO.getDate(),
                repairAccountRequestDTO.getRepairName()
        );
    }

    @GetMapping("/repair-accounts/{repairAccountId}")
    public RepairAccountResponseDTO getById(@PathVariable Long repairAccountId) {
        return new RepairAccountResponseDTO(repairAccountService.getById(repairAccountId));
    }

    @DeleteMapping("/repair-accounts/{repairAccountId}")
    public void deleteRepairAccount(@PathVariable Long repairAccountId) {
        repairAccountService.deleteById(repairAccountId);
    }
}
