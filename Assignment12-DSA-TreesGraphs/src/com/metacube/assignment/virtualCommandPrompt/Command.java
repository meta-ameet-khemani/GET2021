package com.metacube.assignment.virtualCommandPrompt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command class represents that single command entered by user
 * @author ameet.khemani_metacu
 *
 */
public class Command {
	
	Folder currentFolder;
	List<String> folders = new ArrayList<String>();
	
	public Command () {
		this.currentFolder = new Folder("M");
	}
	
	/**
	 * Used to show the virutal command prompt
	 */
	public void commandPrompt () {
		
		String commands;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while (true) {
			
			// show default path
			showPath ();
			
			// get command from user
			commands = input.nextLine();
			
			String commandArray[] = commands.split(" ");
			Integer commLength = commandArray.length;
			
			if (commLength == 2) {
				switch (commandArray[0]) {
					case "mkdir":
						if (mkdir(commandArray[1])) {
							System.out.println("New folder created");
						} else {
							System.out.println("Folder already exists");
						}
						break;
					case "cd":
						if (!(cd(commandArray[1]))) {
							System.out.println("Folder does not exists");
						}
						break;
					case "find":
						String path = find (commandArray[1]);
						System.out.println(path);
						break;
					default:
						System.out.println("No command found");
						break;
				}
			}
			if (commLength == 1) {
				switch (commandArray[0]) {
					case "bk":
						if (!bk()) {
							System.out.println("This is root directory");
						}
						break;
					case "ls":
						ls();
						break;
					case "tree":
						tree();
						break;
					case "exit":
						System.exit(0);
						break;
					default:
						System.out.println("Command not found");
						break;
				}
			}
		}
	}
	
	/**
	 * Creating new directory/folder
	 * @param folderName name of directory/folder to be created
	 * @return true if successfully created else false
	 */
	public boolean mkdir (String folderName) {
		
		// checking if folder is already present
		if (findFolder (folderName)) {
			Folder newFolder = new Folder (folderName);
			newFolder.setParent(this.currentFolder);
			this.currentFolder.subfolder.add(newFolder);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Used to find the folder 
	 * @param folderName name of folder to find
	 * @return true if found else false
	 */
	public boolean findFolder (String folderName) {
		List<Folder> subfolders = this.currentFolder.getSubfolder();
		for (Folder currentFolder : subfolders) {
			if (currentFolder.getFolderName().equals(folderName)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Change the directory
	 * @param folderName
	 * @return
	 */
	private boolean cd (String folderName) {
		if (!findFolder(folderName)) {
			List<Folder> subfolders = this.currentFolder.getSubfolder();
			for (Folder currentFolders : subfolders) {
				if (currentFolders.getFolderName().equals(folderName)) {
					this.currentFolder = currentFolders;
					folders.add(this.currentFolder.getFolderName());
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Go back to parent directory
	 * @return true
	 */
	private boolean bk () {
		Folder parent = this.currentFolder.getParent();
		if (parent == null)
			return false;
		this.currentFolder = parent;
		this.folders.remove(this.folders.size() - 1);
		return true;
	}
	
	/**
	 * List of all files
	 * @return true
	 */
	private boolean ls () {
		List<Folder> subFolders = this.currentFolder.getSubfolder();
		for (Folder folder : subFolders) {
			System.out.println(folder.getFolderName() + " " + folder.getDatetime());
		}
		return true;
	}
	
	/**
	 * Serach for given folder
	 * @param folderName
	 * @return
	 */
	private String find (String folderName) {
		return search (this.currentFolder, folderName);
	}
	
	/**
	 * Search the folder
	 * @param folder
	 * @param folderName
	 * @return
	 */
	private String search (Folder folder, String folderName) {
		if (folder.getFolderName().equals(folderName)) {
			return folderName;
		}
		if (folder.getSubfolder().size() < 1) {
			return "";
		}
		String path = "";
		for (Folder subfold : folder.getSubfolder()) {
			path = "";
			path = path + folder.getFolderName() + "/" + search(subfold, folderName);
		}
		return path;
	}
	
	/**
	 * Show the tree structure
	 */
	public void tree () {
		treeView (this.currentFolder, 0);
	}
	
	/**
	 * Show the tree view of all folder
	 * @param folder
	 * @param nesting
	 */
	public void treeView (Folder folder, Integer nesting) {
		for (Folder subDirectory : folder.getSubfolder()) {
			for (int i = 0; i < nesting; i++) {
				System.out.println("\u2502");
			}
			if (subDirectory.getSubfolder().size() != 0) {
				System.out.println("\u251c\u2500" + subDirectory.getFolderName());
				treeView(subDirectory, nesting + 1);
			} else {
				System.out.println("\u2514\u2500" + subDirectory.getFolderName());
			}
		}
	}
	
	/**
	 * Used to show the paths of folders
	 */
	public void showPath () {
		
		// default folder
		System.out.println("M:");
		
		// iterate through folders and print their names
		for (String folderName : this.folders) {
			System.out.println("\\" + folderName);
		}
		System.out.println(">");
	}
	
}
