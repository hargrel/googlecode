package edu.itee.antipodes.web;

public interface AccountsDao {
    public Account readAccount(Long id);
    public void createOrUpdateAccount(Account account);
    public Account[] findAccounts();

}
