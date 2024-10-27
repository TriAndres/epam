package ru.practicum.lessonA.lesson2.model;

public enum ReversOrder {
    NOT_REVERS, REVERS;
    public static ReversOrder from(String order) {
        return switch (order.toLowerCase()) {
            case "notrevers" -> NOT_REVERS;
            case "reverse" -> REVERS;
            default -> null;
        };
    }

}
