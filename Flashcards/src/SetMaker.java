import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SetMaker
	{

		public static void createNewSet(String setName)
			{

				// TODO create file
				File setFile = new File(setName+"Data.txt");

				try
					{
						if (setFile.createNewFile())
							{
								System.out.println("Created new set, '" + setName +"'.");
								writeNewDataIndex(setName);
							}else{
								System.out.println("Set '"+setName+"' already exists.");
							}
					} catch (IOException e)
					{
						
						e.printStackTrace();
					}
				
				
				// TODO fill file with data

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

	}
