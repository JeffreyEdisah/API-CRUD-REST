package com.example.demo.controller;


import com.example.demo.entity.CommissionEntity;
import com.example.demo.repository.CommissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(value = "commissions")
@AllArgsConstructor
public class CommissionController {

    @Autowired
    private CommissionRepository commissionRepository;

    @GetMapping(value =  "/{id}")
    public CommissionEntity getCommission(@PathVariable long id) {
        return commissionRepository.findById(id).get();
    }

    @GetMapping(value = "/all")
    public Iterable<CommissionEntity> getAllCommission(){
        return commissionRepository.findAll();
    }

    @PostMapping(value = "/add")
    public Optional<CommissionEntity> addCommission(@RequestBody CommissionEntity commission){
        commission.setDate(LocalDate.now());
        commissionRepository.save(commission);
        return commissionRepository.findById(commission.getId());
    }


    @DeleteMapping(value = "delete/{id}")
    public void deleteCommission(@PathVariable long id){
        commissionRepository.deleteById(id);
    }

    @PutMapping(value = "update/{id}")
    public void updateCommission(@RequestBody CommissionEntity commission, @PathVariable long id){
        commission.setId(id);
        commissionRepository.save(commission);
    }

}
