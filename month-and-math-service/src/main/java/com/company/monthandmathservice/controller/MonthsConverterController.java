package com.company.monthandmathservice.controller;
import com.company.monthandmathservice.models.MonthsConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class MonthsConverterController {

    private List<MonthsConverter> MonthsConverters = Arrays.asList(
            new MonthsConverter(1, "January"),
            new MonthsConverter(2, "February"),
            new MonthsConverter(3, "March"),
            new MonthsConverter(4, "April"),
            new MonthsConverter(5, "May"),
            new MonthsConverter(6, "June"),
            new MonthsConverter(7, "July"),
            new MonthsConverter(8, "August"),
            new MonthsConverter(9, "September"),
            new MonthsConverter(10, "October"),
            new MonthsConverter(11, "November"),
            new MonthsConverter(12, "December"));

    /*@RequestMapping(value = "/months", method = RequestMethod.GET)
      @ResponseStatus(HttpStatus.OK)


      public List<MonthsConverter> getAllMonths(){
          return MonthsConverters;
      }
  */
    @RequestMapping(value = "/months/{number}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)

    public MonthsConverter getMonthById(@PathVariable int number) throws Exception {
        MonthsConverter returnVal = null;
if (number<1 || number>12){
    throw new IllegalArgumentException("give a valid month");
}

        for (MonthsConverter MonthsConverter : MonthsConverters) {
            if (MonthsConverter.getNumber() == number) {
                returnVal = MonthsConverter;
            }
        }
        return returnVal;
    }


    @RequestMapping(value = "/months", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)

     public MonthsConverter getMonthsRandom(){

            Random rand = new Random();
          int randomMonth=rand.nextInt(12)+1;

        List<MonthsConverter> List2= MonthsConverters.stream().filter(month->month.getNumber()==randomMonth).collect(Collectors.toList());
        return  List2.get(0);
    }




    }






