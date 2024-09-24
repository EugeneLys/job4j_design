package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class JSONReport implements Report {

    private final Store store;

    public JSONReport(MemoryStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var library = new GsonBuilder().registerTypeAdapter(Employee.class, new EmployeeJsonSerializer())
                .setPrettyPrinting().create();
        return library.toJson(store.findBy(filter));
    }
}
