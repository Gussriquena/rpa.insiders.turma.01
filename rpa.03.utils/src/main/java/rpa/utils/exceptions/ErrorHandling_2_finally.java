package rpa.utils.exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ErrorHandling_2_finally {
	
	private static final String FILE_PATH = "C:\\Projetos\\rpa-turma-01\\arquivos\\myfile.txt";
	private List<String> textList;
	
	public void errorHandling() {
		try {
			textList.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getClass() + " - " + e.getMessage());
		} finally {
			System.out.println("Entra aqui de qualquer jeito");
		}
		
		System.out.println("Chegou ao final do código");
	}
	
	public void writeFile_1() {
		try {
			File file = new File(FILE_PATH);
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());	
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Texto à ser escrito no arquivo");
			
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + " - " + e.getMessage());
		}
	}
	
	public void writeFile_finally() {
		try {
			File file = new File(FILE_PATH);
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());	
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			try {
				bufferedWriter.write("Texto à ser escrito no arquivo");
			} catch (Exception e) {
				System.out.println(e.getClass() + " - " + e.getMessage());
			} finally {
				bufferedWriter.close();
				fileWriter.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.getClass() + " - " + e.getMessage());
		}
	}
	
	public void writeFile_Try_resources() {
		// try with resources
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(FILE_PATH).getAbsoluteFile()))) {
			bufferedWriter.write("Texto à ser escrito no arquivo");
		} catch (Exception e) {
			System.out.println(e.getClass() + " - " + e.getMessage());
		}
	}
	
	public void readFile() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
			System.out.println(content);
		} catch (Exception e) {
			System.out.println(e.getClass() + " - " + e.getMessage());
		}
	}
}





