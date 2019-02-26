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


     //   Person p1 = new Person("Thinh", "To", LocalDate.of(1995, Month.JULY, 10));
     //  Person p2 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));
        // new PersonQuery().updateById(5, new Person("", "", LocalDate.of(1988, Month.NOVEMBER, 2)));

        Family f = new Family(2,2,2);

        for(Family hi : new FamilyQuery().getAll()){
          //  System.out.println(hi);
        }



        System.out.println(new FamilyQuery().getById(1));

}
}
