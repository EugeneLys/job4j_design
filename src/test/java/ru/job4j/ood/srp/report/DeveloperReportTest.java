package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class DeveloperReportTest {

    @Test
    public void whenCorrectCSVStyleReportGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new DeveloperReport(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name;Hired;Fired;Salary;")
                .append("\r\n")
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary()).append("\r\n");
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}