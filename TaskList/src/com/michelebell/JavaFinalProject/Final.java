package com.michelebell.JavaFinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Final {
	public static void main(String[] args) {
		//Initialize Scanner
		Scanner input = new Scanner(System.in);
		
		//Initialize new ArrayList
		ArrayList<String> tasks = new ArrayList<String>();
		
		//create initial list items
		tasks.add("Do homework");
		tasks.add("Read programming blog");
		tasks.add("Spend time with family");
		tasks.add("Watch new season of cool new show");
	
		//Menu listing
		menuItems();
		
		//Menu selection
		menuSelection(tasks, input);
	}
	
	public static void menuItems() {
		//Display menu options
				System.out.println("MENU:");
				System.out.println("1. Add a task");
				System.out.println("2. Remove a task");
				System.out.println("3. Mark a task complete");
				System.out.println("4. List the tasks"); 

				//Prompt user selection
				System.out.println("What would you like to do?");
	}
	
	private static void menuSelection(ArrayList<String>tasks, Scanner input) {	
		//Select case using user selection
		int selection = input.nextInt();
		
			switch(selection) {
			//Add task
			case 1:
				addTask(tasks, input);
				displayTasks(tasks);
				returnToMenu(tasks, input);
				break;
			//Remove task
			case 2:
				removeTasks(tasks, input);
				displayTasks(tasks);
				returnToMenu(tasks, input);
				break;
			//Mark complete
			case 3:
				isNotComplete(tasks);
				taskComplete(tasks, input);
				displayTasks(tasks);
				returnToMenu(tasks, input);
				break;
			//List all tasks
			case 4:
				displayTasks(tasks);
				returnToMenu(tasks, input);
				break;
			//Error catch
			default:
				System.out.println("Invalid selection");
		} 
		
	}
	//Mark task complete
	private static void taskComplete(ArrayList<String>tasks, Scanner input) {
		System.out.println("Enter number of completed task: ");
		int num = input.nextInt();
		num = num - 1;
		
		String task = tasks.get(num);
		task = task + "(COMPLETED)";			
		tasks.set(num, task);
		
	}
	//Return to menu
	private static void returnToMenu(ArrayList<String> tasks, Scanner input) {
		menuItems();
		menuSelection(tasks, input);
		}
	//Remove tasks from list
	private static void removeTasks(ArrayList<String>tasks, Scanner input) {
		System.out.println("Enter number of item to remove: ");
		int index = input.nextInt();
		index = index - 1;
		tasks.remove(index);
		}
	//Add task to ArrayList
	private static void addTask(ArrayList<String>tasks, Scanner input) {
		//Obtain user input
		System.out.println("Add your task: ");
		//Clear buffer
		input.nextLine();
		//Add to ArrayList
		String task = input.nextLine();
		tasks.add(task);
	}
	//Display all tasks in ArrayList
	private static void displayTasks(ArrayList<String>tasks) {
	//display list 
	int index = 1;
		for (String i : tasks) {
			System.out.println((index++)+": "+i);		
		}
	}
	//Hide items marked complete
	private static void isNotComplete(ArrayList<String>tasks) {
		int index = 1;
		
		for (String string : tasks) {
			if(!string.contains("(COMPLETED)")) {
				System.out.println(index++ + ". " + string);
			}
		}
	}
}
	
	
	
	

