package aplicacao;

import utilitarios.tratamentoDeTexto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto[] = new String[4];
		texto[0] = "oo ratoato roeuoeu aa roupaoupa dodo reiei dee romaoma";
		texto[1] = "a batata baba";
		texto[2] = "osos xuxusxus naoo temtem ossoso";
		texto[3] = "mas que caca aconteceu aqui";
		
		String textoTratado[] = new String[texto.length];
		
		//trata a lista de frases
		textoTratado = tratamentoDeTexto.LimparFrasesQuePossuemRepeticoesNoFinal(texto);
		
		exibirComparacao(texto,textoTratado);
	}
	
	public static void exibirComparacao(String frasesAntes[], String frasesDepois[])
	{
		for (int i = 0; i < frasesAntes.length; i++) {
			System.out.println("Antes: " + frasesAntes[i]);
			System.out.println("Depois: " + frasesDepois[i] + "\n");	
		}
	}

}
