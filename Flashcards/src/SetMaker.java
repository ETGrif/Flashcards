import java.io.*;
import java.util.Scanner;

public class SetMaker
	{
		
		static String setName;

		public static void createNewSet(String setName_)
			{
				setName = setName_;

				// create file
				createFile(setName);

				// TODO fill file with data
				addFlashcardsToFile();
			}

		private static void addFlashcardsToFile()
			{
				Scanner userString = new Scanner(System.in);
				
				
				String fileName = setName + "Data.txt";

				try
					{
						// Assume default encoding.
						FileWriter fileWriter = new FileWriter(fileName, true);

						// Always wrap FileWriter in BufferedWriter.
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

						// Note that write() does not automatically
						// append a newline character.
						boolean addingCards = true;
						while(addingCards) {
							System.out.println("New flashcard:");
							//Q
							System.out.println("Question:");
							String question = userString.nextLine();
							bufferedWriter.write("Q:"+question);
							bufferedWriter.newLine();;
							//A
							System.out.println("Answer:");
							String answer = userString.nextLine();
							bufferedWriter.write("A:"+answer);
							bufferedWriter.newLine();
							//blank line
							bufferedWriter.newLine();
							
							//ask to write another question
							boolean asking = true;
							Scanner userInt = new Scanner(System.in);
							while(asking) {
								System.out.println("Added Flashcard.\n"
										+ "Add another card[1], or finish the set[2]?");
								int response = userInt.nextInt();
								if(response >=1 && response <=2) {
									if(response == 2) {
										System.out.println("Set finished!");
										addingCards = false;
									}
									asking = false;
								}else {
									System.out.println("That's an invalid response.");
								}
							}
							userInt.close();
							
						}

						// Always close files.
						bufferedWriter.close();
					} catch (IOException ex)
					{
						System.out.println("Error writing to file '" + fileName + "'");
						// Or we could just do this:
						// ex.printStackTrace();
					}
				userString.close();
				
			}

		public static void createFile(String setName)
			{

				File setFile = new File(setName + "Data.txt");

				try
					{
						if (setFile.createNewFile())
							{
								System.out.println("Created new set, '" + setName + "'.");
								writeNewDataIndex(setName);
							}
						else
							{
								System.out.println("Set '" + setName + "' already exists.");
							}
					} catch (IOException e)
					{

						e.printStackTrace();
					}

			}
		
		public static void writeNewDataIndex(String topicName)
			{

				String fileName = "IndexFile.txt";

				try
					{
						// Assume default encoding.
						FileWriter fileWriter = new FileWriter(fileName, true);

						// Always wrap FileWriter in BufferedWriter.
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

						// Note that write() does not automatically
						// append a newline character.
						bufferedWriter.write(topicName);
						bufferedWriter.newLine();
						bufferedWriter.write(topicName + "Data.txt");
						bufferedWriter.newLine();

						// Always close files.
						bufferedWriter.close();
					} catch (IOException ex)
					{
						System.out.println("Error writing to file '" + fileName + "'");
						// Or we could just do this:
						// ex.printStackTrace();
					}

			}

		public static void writeFlashcard(String question, String answer){
			
			
		}
		
	}
