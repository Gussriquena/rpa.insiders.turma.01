package rpa.utils.exceptions;

public class ErrorHandling_1_Basic {
	
	private String[] textList = {"Gustavo", "Diego"};
	
	public void errorHandling() {
		// StackTrace
		
		try {
			for(int index=0; index < textList.length; index++) {
				System.out.println(textList[index]);
			}
		} catch (Exception e) {
			if(e instanceof NullPointerException) {
				System.out.println("NÃO USA COISA NULAAAAAAAAAAA");
				System.out.println(e.getClass() + " - " + e.getMessage());
			} else if(e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("FAZ A CONTAGEM DE ELEMENTOS DENTRO DA ARRAAAAAAAAAAAAAY");
				System.out.println(e.getClass() + " - " + e.getMessage());
			}
		} 
		
		System.out.println("Cheguei no final do código");
	}
}


