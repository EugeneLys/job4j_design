package ru.job4j.ood.lsp;

class Access {

    /*
    устанавливает уровень допуска шпиона к документам
     */
    private int accessLevel;

    public Access(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}

class Spy {

    protected Access access;

    /*
    Нельзя создать шпиона с уровнем допуска меньше 1 (иными словами, не имеющего допуска к документам).
    Это ИНВАРИАНТ. Проверяется методом validate().
     */
    public Spy(Access access) {
        validate(access);
        this.access = access;
    }

    protected void validate(Access access) {
        if (access.getAccessLevel() < 1) {
            throw new IllegalArgumentException("No access!");
        }
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        validate(access);
        this.access = access;
    }
}

class JuniorSpy extends Spy {

    public JuniorSpy(Access access) {
        super(access);
    }

    @Override
    public void setAccess(Access access) {
        /* Проверки уровня допуска нет - можно создать шпиона с уровнем допуска меньше 1.
        НАРУШАЕТСЯ УСЛОВИЕ БАЗОВОГО КЛАССА. */
        this.access = access;
    }
}

class SpyWork {
    public static void main(String[] args) {
        Spy spy = new JuniorSpy(new Access(1));
        spy.setAccess(new Access(-1));
        /*
        программа работает, несмотря на нарушение ИНВАРИАНТА.
         */
    }
}