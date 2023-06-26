package com.educandoweb.course.entities.enums;

public enum OrderStatus {
    // Cada um é representado no banco como um valor número (0+). Para evitar problemas quando for adicionado mais no futuro, setamos alguns
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // Se for setar default code nos ENUMS:
    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        // Percorre todos OrderStatus e retorna o OrderStatus do code passado
        for(OrderStatus value : OrderStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        // Se o return não foi acionado nenhuma vez, o código não existe
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}
