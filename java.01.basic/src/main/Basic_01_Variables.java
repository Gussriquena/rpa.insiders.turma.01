package main;

import java.math.BigDecimal;

public class Basic_01_Variables {

	public static void main(String[] args) {
		
		// TIPOS PRIMITIVOS
		int meuNumero = 10;
		char caractere = 'F';
		boolean isSomething = false;
		long meuNumeroGrande = 10000;
		
		// Mais preciso que o float
		// 15 a 16 casas decimais
		// 8 bytes
		double meuNumeroDouble = 10.10;
		
		// Menos preciso que o double
		// 6 a 7 casas decimais
		// 4 bytes
		float meuNumeroFloat = 10.10F;
		
		// Object é equivalente ao "var" do js
		Object randomType = 10.10;
		
		// Testar tipo de variável
		if(randomType instanceof Double) {
			//System.out.print("true");
		} else {
			//System.out.println("false");
		}
		
		// Classes Wrapper
		String meuTexto = "Gustavo Riquena"; 
		Double meuDoubleWrapper = 10.10;
		
		// Atalho para importar dependencias: CTRL + SHIFT + O
		BigDecimal myMonetaryValue = new BigDecimal(10.05);
	}
}








