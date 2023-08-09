package ar.com.lbr.patientApi.mappers;


import java.util.Arrays;

public enum Gender {
    MALE("male", "Masculino"),
    FEMALE("female", "Femenino"),
    OTHER("other", "Otro"),
    UNKNOWN("unknown", "Desconocido");

    String english;
    String spanish;

    Gender(String english, String spanish) {
        this.english = english;
        this.spanish = spanish;
    }

    static String fromString(String english) {
        return Arrays.stream(Gender.values()).filter(it -> it.english.equals(english)).findFirst().get().spanish;
    }
}
