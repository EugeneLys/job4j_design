package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.currency.Currency.EUR;
import static ru.job4j.ood.srp.currency.Currency.USD;

class AccountantReportTest {

    @Test
    public void whenCorrectUSDReportGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new AccountantReport(store, parser, USD);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary; USD")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(worker.getSalary() * 0.0162).append(" ")
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void whenCorrectEURReportGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new AccountantReport(store, parser, EUR);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary; EUR")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(worker.getSalary() * 0.0166).append(" ")
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}