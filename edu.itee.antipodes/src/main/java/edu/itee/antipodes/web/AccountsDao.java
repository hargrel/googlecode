package edu.itee.antipodes.web;

import edu.itee.antipodes.web.account.Account;

public interface AccountsDao {
    public Account readAccount(Long id);
    public void createOrUpdateAccount(Account account);
    public Account[] findAccounts();

}
