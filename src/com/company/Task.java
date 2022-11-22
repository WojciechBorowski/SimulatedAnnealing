package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Task {
    double t = 0.9;
    ArrayList<Double> points = new ArrayList<>();

    public void run() {
        double num = numberGenerator();
        double min = getMin(num);
        System.out.println("--------------------------------------------------");
        System.out.println("Min: " + min + " dla x: " + points.get(points.size() - 1));
        System.out.println("--------------------------------------------------");
    }

    public double getMin(double x) {
        double ans = 0;
        for (int i = 0; i < 1000; i++) {
            double f = function(x);
            double a = x + 0.2;
            double fMin = function(a);
            double delta = fMin - f;
            if (delta < 0) {
                ans = fMin;
                x = a;
                points.add(x);
            } else {
                if (new Random().nextDouble() < Math.exp((-delta / t))) {
                    ans = fMin;
                    x = a;
                    points.add(x);
                }
            }
            t -= 0.005;
        }
        return ans;
    }

    public double numberGenerator() {
        double max = 100;
        double min = -100;
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    double function(double x) {
        return x * Math.cos(Math.abs(x)) * Math.sin(Math.abs(x));
    }
}
