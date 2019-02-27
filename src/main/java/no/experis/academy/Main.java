package no.experis.academy;

import no.experis.academy.Model.*;

import no.experis.academy.SqlHelper.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){

        /*try {
            CreateTable.createTables();
            System.out.println("passed");
        }catch(Exception e){
            e.getStackTrace();
        }*/

        new AddressQuery().add(new Address( 1, "noroffveien 3234", "experisveien 1401" ));


    }

}


