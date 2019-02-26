package no.experis.academy;


import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Family;
import no.experis.academy.Model.Person;
import no.experis.academy.SqlHelper.FamilyQuery;
import no.experis.academy.SqlHelper.PersonQuery;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        //CreateTable.createTables();
        /*
        Person p1 = new Person(1, "Thinh", "To", LocalDate.of(1995, Month.JULY, 10));
        Person p2 = new Person(2, "Billy", "To", LocalDate.of(1995, Month.JULY, 10));

        new PersonQuery().add(p1);
        */

        Family f1 = new Family(1, 2, 1 );

        new FamilyQuery().add(f1);
    }
}
