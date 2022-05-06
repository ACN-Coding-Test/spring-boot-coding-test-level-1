package com.codejam.demo.controller;

import com.codejam.demo.model.Revenue;
import com.codejam.demo.repository.RevenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class RevenueController {

    @Autowired
    private RevenueRepository revenueRepository;

    @GetMapping("/revenue/all")
    public List<Revenue> getAllRevenue() {
        return revenueRepository.findAll();
    }

    @GetMapping("/revenue/{id}")
    public Optional<Revenue> getRevenue(@PathVariable("id") Integer id) {
        return revenueRepository.findById(id);
    }

    @PostMapping("/revenue/save")
    public Revenue saveRevenue(@RequestBody Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @PostMapping("/revenue/update")
    public Revenue updateRevenue(@RequestBody Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @GetMapping("/revenue/{revenue_id}/delete")
    public String deleteRevenue(@PathVariable("revenue_id") Integer id) {
        try {
            revenueRepository.deleteById(id);
        } catch (Exception e) {
            return "Failed";
        }
        return "Successful";
    }
}
