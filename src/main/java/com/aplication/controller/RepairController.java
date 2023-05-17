package com.aplication.controller;

import com.aplication.controller.dto.RepairRequestDTO;
import com.aplication.controller.dto.RepairResponseDTO;
import com.aplication.entity.Repair;
import com.aplication.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepairController {
    private final RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PostMapping("/repairs")
    public Long createRepair(@RequestBody RepairRequestDTO repairRequestDTO) {
        return repairService.save(
                repairRequestDTO.getName(),
                repairRequestDTO.getAddress(),
                repairRequestDTO.getWorkingSchedule(),
                repairRequestDTO.getRating(),
                repairRequestDTO.getCityId()
        );
    }

    @GetMapping("/repairs/{repairId}")
    public RepairResponseDTO getById(@PathVariable Long repairId) {
        return new RepairResponseDTO(repairService.getById(repairId));
    }


    @DeleteMapping("/repairs/{repairId}")
    public void deleteRepair(@PathVariable Long repairId) {
        repairService.deleteById(repairId);
    }

    @PostMapping("/repairs/{repairId}/accounts/{accountId}")
    public void addAccountToRepair(@PathVariable Long repairId, @PathVariable Long accountId) {
        repairService.addAccountToRepair(accountId, repairId);
    }

    @DeleteMapping("/repairs/{repairId}/accounts/{accountId}")
    public void removeAccountFromRepair(@PathVariable Long repairId, @PathVariable Long accountId) {
        repairService.removeAccountFromRepair(accountId, repairId);
    }
}
