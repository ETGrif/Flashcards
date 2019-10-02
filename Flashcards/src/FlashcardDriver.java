import java.io.*;

import java.util.ArrayList;
public class FlashcardDriver
	{

		static ArrayList<String> setNames = new ArrayList<String>();
		static ArrayList<String> dataFileNames = new ArrayList<String>();
		
		
		public static void main(String[] args)
			{
				
				//creates the Trivia Data if not created already
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
				
				
				SetMaker.createNewSet("Trivia");
				
				//TODO print current sets
				loadSets();
				
				for(String s: setNames){
					System.out.println(s);
				}
				
				
				//TODO ask to either study a set or make a new one
				
//				
//				TriviaData.loadData();
//				System.out.println(TriviaData.triva.get(0).getQuestion());
//				System.out.println(TriviaData.triva.get(0).getAnswer());
//				
				
				
				

			}

		private static void loadSets()
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
