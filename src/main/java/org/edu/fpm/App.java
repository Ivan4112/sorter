package org.edu.fpm;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        List<LocalDate> unsortedDates = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );

        DateSorter dateSorter = new DateSorter();
        Collection<LocalDate> sortDates = dateSorter.sortDates(unsortedDates);
        System.out.println(sortDates);
    }
}
