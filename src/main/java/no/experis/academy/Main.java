package no.experis.academy;

import no.experis.academy.Model.Person;
import no.experis.academy.SqlHelper.PersonQuery;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        Iterator it = new PersonQuery().getAll().iterator();

        while (it.hasNext()) {
            Person p = (Person)it.next();
            System.out.printf("%s %s %s", p.getFirstName(), p.getLastName(), p.getBirthday());
            System.out.println();
        }
    }
}
