package ru.job4j.ood.isp.doctor;

public class Dentist implements Doctor {

    @Override
    public void dentistWork() {
        System.out.println("I am doing some dentist work.");
    }

    /*
    Методы ниже остаются нереализованными - объект класса Dantist не делает работу хирурга, терапевта и офтальмолога,
    но зависит от этих методов => ISP нарушается.
     */
    @Override
    public void surgeonsWork() {
    }

    @Override
    public void therapistWork() {
    }

    @Override
    public void ophthalmologistsWork() {
    }
}
