package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test  //ctrl + shift + f10
    @Disabled
    public void crud() throws Exception {
        //1.insert
        //Account 객체생성
        Account account = new Account();
        //값을 저장
        account.setUsername("spring");
        account.setPassword("1234");
        //등록요청
        Account savedAccount = accountRepository.save(account);
        System.out.println("ID = " + savedAccount.getId());
        System.out.println("username = " + savedAccount.getUsername());
    }

    @Test @Disabled
    public void finder() throws  Exception {
        Optional<Account> optional = accountRepository.findById(1L);
        if(optional.isPresent()) {
            Account account = optional.get();
            System.out.println("Account " + account.getUsername());
        }

        Account acct = accountRepository.findById(1L).orElse(new Account());
        System.out.println("Account " + acct.getUsername());

        //orElseGet(Supplier sup)
        //Supplier 의 추상메서드 T get()
        Account acct2 = accountRepository.findById(2L).orElseGet(() -> new Account(""));
        System.out.println("acct2.getUsername() = " + acct2.getUsername());

        //Account acct3 = accountRepository.findById(3L).orElseThrow(() -> new RuntimeException("Account Not Found"));
    }
}
