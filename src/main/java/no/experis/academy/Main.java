package no.experis.academy;

import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Person;
import no.experis.academy.SqlHelper.PersonQuery;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        CreateTable.createTables();
        Person person1 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));

        //new PersonQuery().add(person1);

        person1 = new PersonQuery().getById(1);

        System.out.println(person1.getId());



    }
}
