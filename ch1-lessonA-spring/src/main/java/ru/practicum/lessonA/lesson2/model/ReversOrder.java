package ru.practicum.lessonA.lesson2.model;

public enum ReversOrder {
    NOT_REVERSE, REVERSE;
    public static ReversOrder from(String order) {
        return switch (order.toLowerCase()) {
            case "notreverse" -> NOT_REVERSE;
            case "reverse" -> REVERSE;
            default -> null;
        };
    }

}
