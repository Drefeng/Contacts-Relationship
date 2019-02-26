package no.experis.academy;

import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Person;
import no.experis.academy.Model.Phonenumber;
import no.experis.academy.SqlHelper.PersonQuery;
import no.experis.academy.SqlHelper.PhoneQuery;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        //CreateTable.createPhoneTable();
        Person person1 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));
        Phonenumber phonenumber = new Phonenumber("98003059", "231234","2342344");

        new PersonQuery().add(person1);

        new PhoneQuery().add(phonenumber);

        Iterator <Person> iterator = new PersonQuery().getAll().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }








    }
}
