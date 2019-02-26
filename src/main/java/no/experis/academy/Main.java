package no.experis.academy;

import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Person;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        CreateTable.createTables();
        Person person1 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));



    }
}
