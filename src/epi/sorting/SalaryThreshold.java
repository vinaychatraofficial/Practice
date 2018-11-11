package epi.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * 13.11 Compute a salary threshold
 */
public class SalaryThreshold {

	public static void main(String[] args) {
		List<Double> currentSalaries = new ArrayList<>();
		currentSalaries.add(90.0);
		currentSalaries.add(30.0);
		currentSalaries.add(100.0);
		currentSalaries.add(40.0);
		currentSalaries.add(20.0);
		/*currentSalaries.add(90.2);
		currentSalaries.add(30.4);
		currentSalaries.add(100.0);
		currentSalaries.add(40.8);
		currentSalaries.add(20.0);*/
		System.out.println(findSalaryCap(210.0, currentSalaries));
	}
	
	private static double findSalaryCap(double targetPayroll,List<Double> currentSalaries) {
		int n = currentSalaries.size();
		double avgCap = targetPayroll/n;
		double unutilizedCap=0;
		//count of salaries less than avgCap
		int count=0;
		//check no. of salaries less than avgCap.
		//Find unutlized cap
		for(int i=0;i<n;i++) {
			if(currentSalaries.get(i)<avgCap) {
				count++;
				unutilizedCap+=(avgCap - currentSalaries.get(i));
			}
		}
		
		//no. of salaries greater than avgCap
		int salariesToCap = n - count;
		double extraCap = unutilizedCap/salariesToCap;
		return avgCap+extraCap;
	}

}
