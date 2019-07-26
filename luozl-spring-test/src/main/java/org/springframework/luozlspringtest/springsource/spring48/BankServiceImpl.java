package org.springframework.luozlspringtest.springsource.spring48;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BankServiceImpl implements  BankService{
    private PersonService personService;
    private AccountService accountService;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save() throws RuntimeException {
        System.out.println("==调用BankService的save方法\n");
        personService.save();
        accountService.save();
        throw new RuntimeException("==BankServiceImpl的save方法手动抛出异常");
    }
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
