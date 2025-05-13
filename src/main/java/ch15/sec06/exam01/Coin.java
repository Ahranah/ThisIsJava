package ch15.sec06.exam01;

import lombok.Data;

@Data
public class Coin {
    private int value;

    Coin(int value) {
        this.value = value;
    }
}
