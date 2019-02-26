package no.experis.academy;

import no.experis.academy.Model.*;

import no.experis.academy.SqlHelper.EmailQuery;
import no.experis.academy.SqlHelper.FamilyQuery;

import no.experis.academy.SqlHelper.PersonQuery;
import no.experis.academy.SqlHelper.PhoneQuery;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){

        Email f = new Email("hei@gmail.com", "odasdadask@gmail.com");






        new EmailQuery().updateEmailById(1,f );
}
}
