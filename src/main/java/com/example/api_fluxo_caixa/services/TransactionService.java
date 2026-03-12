package com.example.api_fluxo_caixa.services;

import com.example.api_fluxo_caixa.dto.BalanceResponse;
import com.example.api_fluxo_caixa.model.Transaction;
import com.example.api_fluxo_caixa.model.TransactionType;
import com.example.api_fluxo_caixa.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction createTransaction(Transaction transaction){
        return repository.saveAndFlush(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada."));
    }

    public void deleteTransaction(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Transação não encontrada com o id: " + id
            );
        }

        repository.deleteById(id);
    }

    public List<Transaction> getByType(TransactionType type) {
        return repository.findByType(type);
    }

    public List<Transaction> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Transaction> getByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    public BalanceResponse getBalance() {

        BigDecimal totalEntries = repository.sumByType(TransactionType.ENTRY);
        BigDecimal totalExits = repository.sumByType(TransactionType.EXIT);

        BigDecimal balance = totalEntries.subtract(totalExits);

        return new BalanceResponse(totalEntries, totalExits, balance);
    }
}
