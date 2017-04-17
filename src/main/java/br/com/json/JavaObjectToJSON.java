package br.com.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJSON {

	public static void main(String[] args) {
		JavaObjectToJSON obj = new JavaObjectToJSON();
		obj.run();
	}
	
	private void run(){
		ObjectMapper mapeamento = new ObjectMapper();
		List<Pessoa> listaPessoas = criarObjeto();
		
		try {
			//Convertendo o JSON para String e salvando em um diretório.
			mapeamento.writeValue(new File("C:\\Users\\luisb\\Desktop\\Pessoa.json"), listaPessoas);
						
			//Convertendo o objeto para JSON String.
			for(Pessoa pessoa: listaPessoas){
				String jsonEmString = mapeamento.writeValueAsString(pessoa);
				System.out.println(jsonEmString);
			}
			
			//Adicionando espaço na impressão.
			System.out.println("\n");
			
			//Convertendo o objeto para JSON String em outra impressão.
			for(Pessoa pessoa: listaPessoas){
				String jsonEmString = mapeamento.writerWithDefaultPrettyPrinter().writeValueAsString(pessoa);
				System.out.println(jsonEmString);
			}
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	private List<Pessoa> criarObjeto() {
		Pessoa pessoa = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		List<Pessoa> listaPessoas = new ArrayList<>();
		
		pessoa.setIdPessoa(1);
		pessoa.setNome("Luís");
		pessoa.setIdade(25);
		
		listaPessoas.add(pessoa);
		
		pessoa2.setIdPessoa(2);
		pessoa2.setNome("Roberto");
		pessoa2.setIdade(32);
		
		listaPessoas.add(pessoa2);
		
		return listaPessoas;
	}
}
