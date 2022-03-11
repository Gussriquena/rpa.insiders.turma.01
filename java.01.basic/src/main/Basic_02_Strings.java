package main;

public class Basic_02_Strings {
	
	// digitar main, apertar CTRL + ESPAÇO
	public static void main(String[] args) {
		
		String nome = "";
		
		System.out.println("toUpperCase(): " + nome.toUpperCase());
		System.out.println("toLowerCase(): " + nome.toLowerCase());
		
		//System.out.println("substring(4, 5): " + nome.substring(4, 5));
		//System.out.println("substring(3): " + nome.substring(3));
		
		System.out.println("replace: " + nome.replace("i", ""));
		System.out.println("replaceFirst: " + nome.replaceFirst("O", ""));
		
		System.out.println("concat: " + nome.concat(" - RPA INSIDERS"));
		System.out.println("endsWith: " + nome.endsWith("o"));
		System.out.println("startsWith: " + nome.startsWith("GUS"));
		
		System.out.println("equals: " + nome.equals("Gustavo de Oliveira"));
		System.out.println("contains: " + nome.contains("Gustavo"));
		System.out.println("equalsIgnoreCase: " + nome.equalsIgnoreCase("GUSTAVO"));
		System.out.println("isEmpty: " + nome.isEmpty());
		System.out.println("isBlank: " + nome.isBlank());
		
		System.out.println("string: " + nome);
		System.out.println("trim: " + nome.trim());
		
		System.out.println("length: " + nome.length());
		System.out.println("indexOf: " + nome.indexOf("Kris"));
		
		System.out.println("repeat: " + nome.repeat(10));
		
		if(nome.trim().concat("ego").toUpperCase().equals("DIEGO")) {
			System.out.println("condition true");
		} else {
			System.out.println("condition false");
		}
		
		// check if string is empty, null or blank
		// OR = ||
		// AND = &&
		
		if(nome.length() == 0 || nome.isBlank() || nome.isEmpty() || nome == null || nome.equals("")) {
			System.out.println(true);
		}
		
		char[] charSequence = nome.toCharArray();
		String[] splitingStrin = nome.split(",");
	}
}




