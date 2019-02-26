package no.experis.academy;

import no.experis.academy.Model.*;

import no.experis.academy.SqlHelper.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){

        Email f = new Email("hei@gmail.com", "odasdadask@gmail.com");

        Address ok = new Address(1, "ok", "dsa");

        new AddressQuery().add(ok);








    }

}


