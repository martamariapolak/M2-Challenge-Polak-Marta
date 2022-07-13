package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static java.lang.Float.NaN;

@RestController
public class MathSolutionController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)

    public MathSolution add(@Valid @RequestBody  MathSolution addSolution)
        {
            addSolution.setOperation("add");
    addSolution.setAnswer();
    if(addSolution.getOperand1()==NaN || addSolution.getOperand2()==NaN){
        throw new IllegalArgumentException("you didn t put your number");
            }
    if(addSolution.getOperation()!="add"){
        throw new IllegalArgumentException("put right operation");
    }
     return addSolution;
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtract( @Valid @RequestBody MathSolution addSolution){addSolution.setOperation("subtract");

    addSolution.setAnswer();
        if(addSolution.getOperand1()==NaN || addSolution.getOperand2()==NaN){
            throw new IllegalArgumentException("you didn t put your number");
        }
        if(addSolution.getOperation()!="subtract"){
            throw new IllegalArgumentException("put right operation");
        }
     return addSolution;
    }
    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiply(@Valid @RequestBody MathSolution addSolution){addSolution.setOperation("multiply");

     addSolution.setAnswer();
        if(addSolution.getOperand1()==NaN || addSolution.getOperand2()==NaN){
            throw new IllegalArgumentException("you didn t put your number");
        }
        if(addSolution.getOperation()!="multiply"){
            throw new IllegalArgumentException("put right operation");
        }
     return addSolution;
    }
    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)

    public MathSolution divide(@Valid @RequestBody MathSolution addSolution){addSolution.setOperation("divide");

        addSolution.setOperation("divide");
        addSolution.setAnswer();
        if(addSolution.getOperand1()==NaN || addSolution.getOperand2()==NaN){
            throw new IllegalArgumentException("you didn t put your number");
        }
         else if(addSolution.getOperation()!="divide"){
            throw new IllegalArgumentException("put right operation");
        }
         else if(addSolution.getOperand2()==0 && addSolution.getOperation()=="divide") {
            throw new IllegalArgumentException("no divide by 0");
        }
        return addSolution;
    }

}
