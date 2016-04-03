package auto_BSA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Main {
	static String  NameOfFunc = null;
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0) {
			System.out.println("Command line arguments:");
			System.out.print("nameOfFileToRead nameOfFunction ");
			System.out.println("[json | fromjson filename]");
			System.out.println("if nameOfFunction is missing, reading 1st function in the file");
		}
		if (args.length > 0) {
			FileReader file = new FileReader(args[0]);
			Scanner scanner = new Scanner(file);
			StringBuilder code = new StringBuilder();
			while (scanner.hasNextLine()) {
				code.append(scanner.nextLine() + '\n');
			}
			Interpreter icpp = new Interpreter(code.toString());
			icpp.deleteComments();
			Block[] b;
			if (args.length > 1) {
				NameOfFunc = args[1];
				b = icpp.analyze(args[1]).toArray(new Block[0]);
				if (args.length > 2) {
					if (args[2].equals("json")) {
						try (BufferedWriter writer = new BufferedWriter(new FileWriter(NameOfFunc + ".json"))) {
							String json = Interpreter.toJson(b[0]);
							writer.write(json);
						} catch (JsonProcessingException e) {
							System.err.println("An error has been occured:");
							e.printStackTrace();
						} catch (IOException e) {
							System.err.println("An I/O error has been occured:");
							e.printStackTrace();
						}
					} else if (args[2].equals("fromjson") && args.length > 3) {
						String jsonFilename = args[3];
						try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilename))) {
							StringBuilder json = new StringBuilder();
							String line;
							do {
								line = reader.readLine();
								if (line != null) {
									json.append(line);
								}
							} while (line != null);
							b = Interpreter.fromJson(json.toString()).toArray(new Block[0]);
						} catch (JsonParseException e) {
							System.err.println("Parsing JSON error:");
							e.printStackTrace();
						} catch (JsonMappingException e) {
							System.err.println("An error has been occured:");
							e.printStackTrace();
						} catch (IOException e) {
							System.err.println("An I/O error has been occured:");
							e.printStackTrace();
						}
					}
				}
			} else {
				b = icpp.analyze().toArray(new Block[0]);				
			}
			scanner.close();
			new DrawerSimple(b[0]).setVisible(true);
		}
	}

}
