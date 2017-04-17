package br.com.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONToJavaObject {

	public static void main(String[] args) {
		JSONToJavaObject obj = new JSONToJavaObject();
		obj.run();
	}
	
	private void run(){
		ObjectMapper mapeador = new ObjectMapper();
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		try {
			//Convertendo String JSON de um arquivo para um Objeto
				listaPessoas= mapeador.readValue(new File("C:\\Users\\luisb\\Desktop\\Pessoa.json"), ArrayList.class);
				System.out.println(listaPessoas);
			
			//Adicionando espaço na impressão.
			System.out.println("\n");
				
			//Convertendo String JSON para um Objeto
			String jsonEmString = "[{\"idPessoa\":1, \"nome\":\"Luís\", \"idade\":25}, {\"idPessoa\":2, \"nome\":\"Roberto\", \"idade\":32}]";
			
			List<Pessoa> listaPessoas2 = new ArrayList<Pessoa>();
			listaPessoas2.addAll(mapeador.readValue(jsonEmString, ArrayList.class));
			System.out.println(listaPessoas2);
			
			//Adicionando espaço na impressão.
			System.out.println("\n");
			
			//Convertendo String JSON para um Objeto em outra impressão
			String jsonEmString2 = mapeador.writerWithDefaultPrettyPrinter().writeValueAsString(listaPessoas2);
			System.out.println(jsonEmString2);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
