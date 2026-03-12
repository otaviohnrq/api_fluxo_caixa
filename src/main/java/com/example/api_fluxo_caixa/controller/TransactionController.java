package com.example.api_fluxo_caixa.controller;

import com.example.api_fluxo_caixa.dto.BalanceResponse;
import com.example.api_fluxo_caixa.model.Transaction;
import com.example.api_fluxo_caixa.model.TransactionType;
import com.example.api_fluxo_caixa.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;
    private final TransactionService transactionService;

    public TransactionController(TransactionService service, TransactionService transactionService) {
        this.service = service;
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return service.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {

        transactionService.deleteTransaction(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Transação foi excluída com sucesso!");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public List<Transaction> filter(
            @RequestParam(required = false) TransactionType type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false)LocalDate date) {

        if (type != null) {
            return transactionService.getByType(type);
        }

        if (category != null) {
            return transactionService.getByCategory(category);
        }

        if (date != null) {
            return transactionService.getByDate(date);
        }

        return transactionService.getAllTransactions();
    }
    @GetMapping("/balance")
    public BalanceResponse getBalance() {
        return transactionService.getBalance();
    }
}
