package org.edu.fpm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.


 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.

 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> withR = filterDatesWithR(unsortedDates);
        List<LocalDate> withoutR = filterDatesWithoutR(unsortedDates);

        sortAscending(withR);
        sortDescending(withoutR);

        return combineLists(withR, withoutR);
    }

    private List<LocalDate> filterDatesWithR(List<LocalDate> dates) {
        List<LocalDate> withR = new ArrayList<>();
        for (LocalDate date : dates) {
            if (hasRInMonth(date)) {
                withR.add(date);
            }
        }
        return withR;
    }

    private List<LocalDate> filterDatesWithoutR(List<LocalDate> dates) {
        List<LocalDate> withoutR = new ArrayList<>();
        for (LocalDate date : dates) {
            if (!hasRInMonth(date)) {
                withoutR.add(date);
            }
        }
        return withoutR;
    }

    private boolean hasRInMonth(LocalDate date) {
        return date.getMonth().toString().toLowerCase().contains("r");
    }

    private void sortAscending(List<LocalDate> datesWithR) {
        Collections.sort(datesWithR);
    }

    private void sortDescending(List<LocalDate> datesWithoutR) {
        datesWithoutR.sort(Collections.reverseOrder());
    }

    private Collection<LocalDate> combineLists(List<LocalDate> list1, List<LocalDate> list2) {
        List<LocalDate> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);
        return combinedList;
    }
}
