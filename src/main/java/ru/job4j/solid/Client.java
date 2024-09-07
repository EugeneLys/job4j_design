package ru.job4j.solid;

public class Client {

    String name;
    int id;
    int accountNumber;
    int accountSum;
    /*
    Это класс для создания объектов - клинетов банка.
    поля accountNumber, accountSum и методы для управления ими -
    нарушают принцип единственной ответственности,
    так как для именения счета и суммы на счете нужно будет вносить изменения в
    класс Client.
    Следует создать отдельный класс Account для этих полей и их методов.
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountSum() {
        return accountSum;
    }

    public void setAccountSum(int accountSum) {
        this.accountSum = accountSum;
    }
}
