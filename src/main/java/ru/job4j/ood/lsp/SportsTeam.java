package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    List<String> members;

    public SportsTeam(List<String> members) {
        this.members = members;
    }

    public void addMember(String name) {
        members.add(name);
    }

    static class FootballTeam extends SportsTeam {

       public FootballTeam(List<String> members) {
            super(members);
        }

        /*
        В методе наследующего класса (см. ниже) ПРЕДУСЛОВИЕ УСИЛЕНО (добавлена проверка имени на длину).
        Это нарушение контракта LSP.
         */
        public void addMember(String name) {
            if (name.length() < 2) {
                throw new IllegalArgumentException("Wrong name");
            }
            members.add(name);
        }
    }

    public static void main(String[] args) {
        List<String> myTeam = new ArrayList();
        SportsTeam team2 = new FootballTeam(myTeam);
        team2.addMember("1");
        /*
        Мы ожидаем, что сможем добавить имя "1" в список members
        класса SportsTeam (он это позволяет), но получаем непредвиденное исключение
        ("не известное" базовому классу SportsTeam).
         */
    }
}
