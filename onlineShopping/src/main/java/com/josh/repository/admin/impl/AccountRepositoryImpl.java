package com.josh.repository.admin.impl;

import java.util.HashSet;
import java.util.Set;

import com.josh.domain.admin.Account;
import com.josh.repository.admin.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {
    private static AccountRepositoryImpl repository = null;
    private Set<Account> accounts;

    private AccountRepositoryImpl() {
        this.accounts = new HashSet<>();
    }

    private Account findAccount(String accountId) {
        return this.accounts.stream().filter(accounts -> accounts.getId().trim().equals(accountId)).findAny()
                .orElse(null);
    }

    public static AccountRepositoryImpl getRepository() {
        if (repository == null)
            repository = new AccountRepositoryImpl();
        return repository;

}

    @Override
    public Account create(Account account) {
        this.accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        Account toUpdate = findAccount(account.getId());
        if (toUpdate != null) {
            this.accounts.remove(toUpdate);
            return create(account);
        }
        return null;
    }

    @Override
    public void delete(String accountId) {
        Account account = findAccount(accountId);
        if (account != null)
            this.accounts.remove(account);
    }

    @Override
    public Account read(final String accountId) {
        Account account = findAccount(accountId);
        return account;
    }

    @Override
    public Set<Account> getAll() {

        return this.accounts;
    }
}