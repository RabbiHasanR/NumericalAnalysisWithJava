package Com.math.falsepostionmethod;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// declear variable
		double xl, xu, xr = 0, ea = 1000, es, prevXr;
		// create Scanner object
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Xl:");
		xl = input.nextDouble();
		System.out.println("Enter Xu:");
		xu = input.nextDouble();
		System.out.println("Enter es:");
		es = input.nextDouble();
		// check f(xl)==0
		if (function(xl) == 0) {
			System.out.println("Root is:" + xl);
		}
		// check f(xu)==0
		else if (function(xu) == 0) {
			System.out.println("Root is:" + xu);
		}
		// check f(xl)*f(xu)>0
		else if (function(xl) * function(xu) > 0) {
			System.out.println("The are not bisectionMethod");
		} else {
			// first iteration root calculation
			xr = (xu - (function(xu) * (xl - xu)) / (function(xl) - function(xu)));
			System.out.println(
					"Iteration:" + 1 + " " + "xr:" + xr + " " + "xl:" + xl + " " + "xu:" + xu + " " + "error:" + null);
			for (int i = 2; es <= ea; i++) {
				prevXr = xr;
				// chech function(root) equal 0
				if (function(xr) == 0) {
					System.out.println("Root is:" + xr);
					// check f(xl)*f(xu)<0
				} else if (function(xl) * function(xr) < 0) {
					xu = xr;
					// root calculation
					xr = (xu - (function(xu) * (xl - xu)) / (function(xl) - function(xu)));
					// error calculation
					double result = (prevXr - xr) / xr;
					ea = Math.abs(result) * 100;
					// print xl,xu,xr and error
					System.out.println("Iteration:" + i + " " + "xr:" + xr + " " + "xl:" + xl + " " + "xu:" + xu + " "
							+ "error:" + ea);
				} else {
					xl = xr;
					// root calculation
					xr = (xu - (function(xu) * (xl - xu)) / (function(xl) - function(xu)));
					// error calculation
					double result = (prevXr - xr) / xr;
					ea = Math.abs(result) * 100;
					// print xl,xu,xr and error
					System.out.println(
							"Iteration:" + i + " " + "xr:" + xr + " " + "xl:" + xl + " " + "xu:" + xu + "error:" + ea);
				}
			}
			// print final approximate root and error
			System.out.println("Approximate root:" + xr);
			System.out.println("Approximate error:" + ea);
		}

	}

	// create function() method for calculate function value
	// f(x)=4x^3-6x^2+7x-2.3
	public static double function(double x) {
		return (-26 + (85 * x) - (91 * Math.pow(x, 2)) + (44 * Math.pow(x, 3)) - (8 * Math.pow(x, 4)) + Math.pow(x, 5));
	}

}
