package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

import static ru.job4j.ood.srp.currency.Currency.RUB;

public class AccountantReport implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private Currency currency;

    public AccountantReport(MemoryStore store, DateTimeParser<Calendar> parser, Currency currency) {
        this.store = store;
        this.dateTimeParser = parser;
        this.currency = currency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ").append(currency)
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(new InMemoryCurrencyConverter().convert(RUB, 100, currency)).append(" ")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}