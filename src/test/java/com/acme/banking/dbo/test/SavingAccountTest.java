package com.acme.banking.dbo.test;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import com.acme.banking.dbo.exception.saving_account.SavingAccountClientNullException;
import com.acme.banking.dbo.exception.saving_account.SavingAccountNegativeAmountException;
import com.acme.banking.dbo.exception.saving_account.SavingAccountInvalidIdException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {

    private final int accountId = 1;
    private final double accountAmount = 1.0;
    private final int clientId = 2;
    private final String clientName = "ClientName";
    private final Client client = new Client(clientId, clientName);

    @Test
    public void shouldReturnIdWhenGetId() {
        SavingAccount sut = new SavingAccount(accountId, client, accountAmount);

        assertEquals(accountId, sut.getId());
    }

    @Test
    public void shouldReturnAmountWhenGetAmount() {
        SavingAccount sut = new SavingAccount(accountId, client, accountAmount);

        assertEquals(accountAmount, sut.getAmount());
    }

    @Test
    public void shouldReturnClientWhenGetClient() {
        SavingAccount sut = new SavingAccount(accountId, client, accountAmount);

        assertEquals(client, sut.getClient());
    }

    @Test
    public void shouldNotCreateSavingAccountWhenNegativeId() {
        assertThrows(SavingAccountInvalidIdException.class, () -> new SavingAccount(-1, client, accountAmount));
    }

    @Test
    public void shouldNotCreateSavingAccountWhenNullClient() {
        assertThrows(SavingAccountClientNullException.class, () -> new SavingAccount(accountId, null, accountAmount));
    }

    @Test
    public void shouldNotCreateSavingAccountWhenNegativeAmount() {
        assertThrows(SavingAccountNegativeAmountException.class, () -> new SavingAccount(accountId, client, -1.0));
    }
}
