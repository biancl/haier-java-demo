package com.cloudtogo.demo.haier.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Compute {

    @Value("${baseValue}")
    private double baseValue;

    @RequestMapping(method = RequestMethod.GET ,value="/density")
    public String getPlusValue(@RequestParam double x, @RequestParam double y){
        if(x<16|x>25){
            return "A材料温度异常，请重新输入，温度范围16~25";
        }
        if(y<16|y>25){
            return "B材料温度异常，请重新输入，温度范围16~25";
        }
        double z=Math.round((y-x)* Math.random()*100)/100.00+baseValue;

        return "A料料温为"+x+"℃</br>" +"B材料料温为"+y+"℃</br>"+
                ""+"密度值为："+String.format("%.2f", z)+"g/cm³";
    }

}
