package no.experis.academy;

import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Email;
import no.experis.academy.Model.Person;
import no.experis.academy.Model.Phonenumber;
import no.experis.academy.SqlHelper.EmailQuery;
import no.experis.academy.SqlHelper.PersonQuery;
import no.experis.academy.SqlHelper.PhoneQuery;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        //CreateTable.createTables();
            //Person person1 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));
            Email email = new Email("ralf@gmail.com", "dust@hotmail.com");

            new EmailQuery().add(email);



        //new PersonQuery().add(person1);

        //new PhoneQuery().add(phonenumber);

            //System.out.println(phone.toString());


        /*Iterator <Phonenumber> iterator = new PhoneQuery().getById(1);
        while (iterator.hasNext()){
           System.out.println(iterator.next().toString());
        }*/



        //CreateTable.createTables();

        Person p1 = new Person("Thinh", "To", LocalDate.of(1995, Month.JULY, 10));
        Person p2 = new Person("Ralf", "Fajardo", LocalDate.of(1988, Month.NOVEMBER, 1));

        //new PersonQuery().updateById(5, new Person("", "", LocalDate.of(1988, Month.NOVEMBER, 2)));

}
}
