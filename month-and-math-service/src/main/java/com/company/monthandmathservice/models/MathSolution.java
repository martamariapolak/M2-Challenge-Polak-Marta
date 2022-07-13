package com.company.monthandmathservice.models;

import com.sun.istack.internal.NotNull;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class MathSolution {
    @NotNull
    private int operand1;
    @NotNull
    private int operand2;
    private int answer;
    private String operation;

    public MathSolution(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MathSolution() {
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return operand1 == that.operand1 && operand2 == that.operand2 && answer == that.answer && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, answer, operation);
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int getAnswer() {
        return answer;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", answer=" + answer +
                ", operation='" + operation + '\'' +
                '}';
    }

    public void setAnswer() {
//if(operand2 == 0 & operation=="divide")
//{
  //  throw new IllegalArgumentException("give a valid number");}
        switch (this.operation) {
            case "add":
                this.answer = this.operand1 + this.operand2;
                break;
            case "subtract":
                this.answer = this.operand1 - this.operand2;
                break;
            case "multiply":
                this.answer = this.operand1 * this.operand2;
                break;
            case "divide":
                this.answer = this.operand1 / this.operand2;
                break;
            // catch (ArithmeticException e){e.getMessage();}        }
        }}


    }
