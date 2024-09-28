package ru.job4j.ood.lsp;

public class SuperHero {

    String name;
    Boolean good;

    public SuperHero(String name, Boolean good) {
        this.name = name;
        this.good = good;
    }

    public String aboutMe() {
        String truth = "My 'good' is TRUE.";
        if (!good) {
            truth = "My 'good' is FALSE.";
        }
        return truth;
    }

    static class UnknownHero extends SuperHero {

        public UnknownHero(String name, Boolean good) {
            super(name, good);
        }

        /*
        Метод (см. ниже) не содержит условие ("'"if (!good)"), имеющееся в "родительском" методе.
        Таким образом, ПОСТУСЛОВИЯ ОСЛАБЛЕНЫ, что является нарушением SLP.
         */
        public String aboutMe() {
            return "My 'good' is TRUE";
        }
    }

    public static void main(String[] args) {
        SuperHero falseHero = new SuperHero("False", false);
        SuperHero unknown = new UnknownHero("False", false);
        System.out.println(falseHero.aboutMe());
        System.out.println(unknown.aboutMe()); //объект unknown сообщает, что его поле "good" == true, хотя это не так
    }
}
