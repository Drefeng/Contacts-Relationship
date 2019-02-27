package no.experis.academy;

import no.experis.academy.Model.*;

import no.experis.academy.SqlHelper.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){

        try {
            new PostgresConnection().getConnection();
            System.out.println("passed");
        }catch(Exception e){
            e.getStackTrace();
        }
    }




}


