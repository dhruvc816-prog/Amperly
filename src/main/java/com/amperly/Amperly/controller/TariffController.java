package com.amperly.Amperly.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.amperly.Amperly.dto.TariffRequest;
import com.amperly.Amperly.dto.TariffResponse;
import com.amperly.Amperly.service.TariffService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tariffs")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    // Only ADMIN can add this
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TariffResponse> addTariff(@RequestBody TariffRequest request) {
        return ResponseEntity.ok(tariffService.addTariff(request));
    }

    // Anybody can authenticate to get this
    @GetMapping("/{stateName}")
    public ResponseEntity<List<TariffResponse>> getTariffs(@PathVariable String stateName) {
        return ResponseEntity.ok(tariffService.getTariffsByState(stateName));
    }

}
