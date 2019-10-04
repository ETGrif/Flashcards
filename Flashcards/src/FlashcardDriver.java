import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;
public class FlashcardDriver
	{

		static ArrayList<String> setNames = new ArrayList<String>();
		static ArrayList<String> dataFileNames = new ArrayList<String>();
		
		
		public static void main(String[] args)
			{
				System.out.println("Welcome to the ET Flashcard Study Tool(Patent Pending)!");
				
				//creates the Trivia Data if not created already
				makeStartingFiles();
				
				
				//print current sets
				loadSetOptions();
				if(setNames.size() == 0){
				System.out.println("You don't have any Study Sets. Let's make one!");
				//TODO make New set
				}else{
					System.out.println("Here are your current study sets:");
					
					for(int i = 0; i < setNames.size(); i++){
						System.out.println("["+(i+1)+"] "+setNames.get(i));
					}
				}
				
				
				
				//TODO ask to either study a set or make a new one
				ArrayList<Flashcard> set = new ArrayList<Flashcard>();
				
				
				System.out.println("Would you like to study a set, or make a new one?\n"
						+ "Type the number of the set, or 0 if you'd like to create a new one.");
				Scanner userInt = new Scanner(System.in);
				boolean givingResponse = true;
				while(givingResponse){
					int response = userInt.nextInt();
					
					if(response >=0 && response <= setNames.size()){
						if(response==0){
							//TODO create new set
						}else{
							set = loadChosenSet(response-1);
						}
						givingResponse = false;
						
					}else{
						System.out.println("That's am invalid response.");
					}
					
					
					
				}
				
				
	
				
				for(Flashcard f: set){
					System.out.println(f.getQuestion());
					System.out.println(f.getAnswer());
					System.out.println();


					
					
				}
				
				
				
				

			}

		private static ArrayList<Flashcard> loadChosenSet(int index)
			{
				
				ArrayList<Flashcard> set = new ArrayList<Flashcard>();
				System.out.println("Loading set '"+ setNames.get(index)+"'.");
				
				String fileName = dataFileNames.get(index);
				String line = null;
				
				try
					{
						FileReader fileReader = new FileReader(fileName);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						
						
						while((line = bufferedReader.readLine()) != null){
							//Q
							String question = line.substring(2);
							
							//A
							String answer = bufferedReader.readLine().substring(2);
							
							
							//blank line
							bufferedReader.readLine();
							
							//create the flashcard
							set.add(new Flashcard(question, answer));
							
							
						}
						
						bufferedReader.close();	
					} catch (FileNotFoundException ex)
					{
						System.out.println(
				                "Unable to open file '" + fileName + "'");			
					} catch (IOException ex)
					{
						System.out.println(
				                "Error reading file '" + fileName + "'");				
					}
				
				return set;
				
			}

		private static void makeStartingFiles(){
			File indexFile = new File("IndexFile.txt");
			
			try
				{
					if(indexFile.createNewFile()){
						System.out.println("Created initial file.");
					}
				} catch (IOException e)
				{
					
					e.printStackTrace();
				}
			
			
		}
		
		private static void loadSetOptions()
			{
				// The name of the file to open.
		        String fileName = "IndexFile.txt";

		        // This will reference one line at a time
		        String line = null;

		        try 
		        	{
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = new FileReader(fileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            int lineIndex = -1;
		            while((line = bufferedReader.readLine()) != null) 
		            	{
		            		lineIndex++;

		            		if(lineIndex%2==0){
		            			setNames.add(line);
		            		}else{
		            			dataFileNames.add(line);
		            		}
		            	}	

		            // Always close files.
		            bufferedReader.close();			
		        	}
		        catch(FileNotFoundException ex) 
		        	{
		            System.out.println(
		                "Unable to open file '" + fileName + "'");				
		        	}
		        catch(IOException ex) 
		        	{
		            System.out.println(
		                "Error reading file '" + fileName + "'");					
		            // Or we could just do this: ex.printStackTrace();
		        	}
				
			}
		
		

	}
