package com.example.teste.domainenum;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum SexoPaciente {
    M(1, "M"),
    F(2, "F");

    private int index;
    private String value;

    SexoPaciente(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public static int getIndexByValue(String pValue) throws NoSuchElementException {
        return Arrays.stream(SexoPaciente.values())
                .filter(oEnum -> oEnum.value.equals(pValue))
                .findFirst().get().index;
    }

    public static String getValueByIndex(int index) throws NoSuchElementException {
        return Arrays.stream(SexoPaciente.values())
                .filter(oEnum -> oEnum.index == index)
                .findFirst().get().value;
    }
}
