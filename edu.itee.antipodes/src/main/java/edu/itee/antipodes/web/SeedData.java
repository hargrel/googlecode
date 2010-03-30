package edu.itee.antipodes.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class SeedData implements InitializingBean{
    private AccountsDao accDao;

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(accDao);
        accDao.createOrUpdateAccount(new Account("admin"));
        accDao.createOrUpdateAccount(new Account("operator"));
    }

    public void setAccDao(AccountsDao accDao) {
        this.accDao = accDao;
    }

}
