package com.example.demo;

import java.util.List;

public class MathService {


    public static Integer calculateOperation(String operation, int x, int y){
        if(operation.equals("add")){ return x+y; }
        else if(operation.equals("subtract")){return x-y; }
        else if(operation.equals("multiply")){ return x*y; }
        else if(operation.equals("divide")){ return x/y; }
        else return 0;
    }

    public static Integer sum(List<String> intList){
        int result = 0;

        for(int i=0; i<intList.size(); i++){
            int number = Integer.parseInt(intList.get(i));
            result += number;
        }

        return result;
    }

    public static String getOperand(String operation) {
        if (operation.equals("add")) { return "+"; }
        else if(operation.equals("subtract")){return "-";}
        else if(operation.equals("multiply")){return "*";}
        else if(operation.equals("divide")){return "/";}
        else return "operation not valid";
    }

    public static int calculateVolume(int x, int y, int z) {
        return x*y*z;
    }
}
