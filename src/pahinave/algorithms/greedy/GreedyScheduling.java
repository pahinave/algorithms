package pahinave.algorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GreedyScheduling {
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<Job>();
		Random r = new Random();
		for(int i=0; i<10; i++) {
			jobs.add(new Job(r.nextDouble() * 100, r.nextDouble() * 100));
		}
		
		jobs.forEach(System.out::println);
		schedulingCost(jobs);
		
		List<Job> greedySchedule = jobs.stream().sorted(Comparator.comparing(Job::weightToLengthRatio).reversed()).collect(Collectors.toList());
		
		System.out.println(">>> After greedy scheduling <<<<");
		greedySchedule.forEach(System.out::println);
		schedulingCost(greedySchedule);
		
	}
	
	static private void schedulingCost(List<Job> jobs) {
		double completionTime = 0;
		double cost = 0;
		for(Job j : jobs) {
			completionTime += j.getLength();
			cost += (j.getWeight() * completionTime);
		}
		System.out.println("Cost:" + cost);
	}
}


class Job {
	double weight;
	double length;
	public Job(double weight, double length) {
		super();
		this.weight = weight;
		this.length = length;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
	public double weightToLengthRatio() {
		return weight / length;
	}
	
	@Override
	public String toString() {
		return "Job [weight=" + weight + ", length=" + length + ", ratio=" + weightToLengthRatio() + "]";
	}
	
}