package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Basic_04_Collections {

	public static void main(String[] args) {
		
		// List - permite repeti??o
		List<String> alunos = new ArrayList<>();
		alunos.add("Gustavo");
		alunos.add("Gustavo");
		alunos.add("Raphael");
		
		//List<String> alunos2 = new ArrayList<>(List.of("Gustavo", "Kris", "Raphael"));
		List<String> alunos2 = List.of("Gustavo", "Kris", "Raphael");
		
		alunos2.forEach(aluno -> System.out.println(aluno));
		alunos2.forEach(aluno -> showAluno(aluno));
		alunos2.forEach(System.out::println);
		
		// Set - N?o permite repeti??o
		Set<String> alunosSet = Set.of("Gustavo", "Kris", "Raphael");
		
		// Map - Key : Value
		Map<Integer, String> alunosKeyValue = new HashMap<>();
		alunosKeyValue.put(1, "Gustavo");
		alunosKeyValue.put(2, "Kris");
		
		Map<Integer, String> alunosKeyValue2 = new HashMap<>() {{
			put(1, "Gustavo");
			put(2, "Kris");
			put(3, "Raphael");
		}};
		
		// entrySet() - Retornar uma visualiza??o do map
		// keySet() - Retorna uma view das keys
		// values() - Retorna uma view dos valores
		
		for(Map.Entry<Integer, String> aluno : alunosKeyValue2.entrySet()) {
			System.out.println(aluno.getKey() + " - " + aluno.getValue());
		}
		
		alunosKeyValue2.forEach((key, value) -> System.out.println(key + " - " + value));
		
		for(Integer key : alunosKeyValue2.keySet()) {
			System.out.println(key);
		}
		
		alunosKeyValue2.keySet().forEach(System.out::println);
		
		for(String value : alunosKeyValue2.values()) {
			System.out.println(value);
		}
		
		alunosKeyValue2.values().forEach(System.out::println);
		
		Queue<String> myQueue = new LinkedList<>();
		myQueue.add("Gustavo");
		myQueue.add("Kris");
		myQueue.add("Diego");
		
		System.out.println("queue size: " + myQueue.size());
		myQueue.remove("Gustavo");
		
		System.out.println("queue size: " + myQueue.size());
		
		//System.out.println("peek item: " + myQueue.peek());
		
		String listItem = myQueue.poll(); 
		
		System.out.println(listItem);
		System.out.println("queue size: " + myQueue.size());
		
		listItem = myQueue.poll();
		System.out.println(listItem);
		System.out.println("queue size: " + myQueue.size());
		
	}
	
	private static void showAluno(String texto) {
		System.out.println(texto);
	}
}



