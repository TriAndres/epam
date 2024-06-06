package ru.practicum.menu;

import ru.practicum.console.Console;
import ru.practicum.factory.FactoryA;
import ru.practicum.factory.FactoryB;
import ru.practicum.factory.NumberFactory;
import ru.practicum.number.NumberMeneger;

public class MenuMain implements Menu {
    private final Menu menuA;
    private final NumberMeneger numberMeneger;
    private final Menu menuB;
    private final NumberMenu numberMenu;

    public MenuMain() {
        menuA = new MenuA(new FactoryA());
        numberMeneger = new NumberMeneger();
        menuB = new MenuB(new FactoryB(numberMeneger));
        numberMenu = new NumberMenu(new NumberFactory(numberMeneger));
    }

    @Override
    public void game() {
        while (true) {
            menu();
            int num = Console.getInteger();
            if (num == 0) break;
            select(num);
        }
    }

    @Override
    public void menu() {
        System.out.println("""
                \nВведите действие:
                \t1 - менюА
                \t2 - меню цифр
                \t3 - менюВ
                """);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                menuA.game();
                break;
            case 2:
                numberMenu.game();
                break;
            case 3:
                menuB.game();
                break;
            default:
                System.out.println("Введите верное действие");
                break;
        }
    }
}
