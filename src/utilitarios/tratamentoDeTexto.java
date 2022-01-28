package utilitarios;

public class tratamentoDeTexto {
	public static String limparRepeticaoDoFinal(String texto)
	{
		String novoTexto = texto;
		//garante que não será analisado nenhuma palavra de um caracter só
		if (texto.length() > 1 ) 
		{
			String sequencia = "";
			String pedacoDeAnalise = "";
			int inicioPedacoDeAnalise = 0; 
			for (int i = texto.length() - 1; i >= 0 ; i--) {
				sequencia = texto.charAt(i) + sequencia;
				
				// limita a busca de sequencia para não pegar substring invalida (que escede o texto)
				if (sequencia.length() <= (texto.length()/2))
				{
					inicioPedacoDeAnalise =  texto.length() - (sequencia.length() * 2) ;			
					pedacoDeAnalise = texto.substring( inicioPedacoDeAnalise, inicioPedacoDeAnalise + sequencia.length());
					if (sequencia.equals(pedacoDeAnalise))
					{
						novoTexto = texto.substring( 0, inicioPedacoDeAnalise + sequencia.length());
						//saindo do loop
						i = -1;
					}
				}
				else
				{
					i = -1;
				}
			}
		}
		
		return novoTexto;
	}
	public static String limparRepeticaoDoFinalDePalavras(String texto)
	{
		String textoLimpo = "";
		String palavras[] = texto.split(" ");
		String palavrasLimpas[] = new String[palavras.length];
		//tratando as palavras
		for (int i = 0; i < palavras.length; i++) 
		{
			palavrasLimpas[i] = limparRepeticaoDoFinal(palavras[i]);
			textoLimpo += " " + palavrasLimpas[i];
		}
		
		
		boolean TodasPalavrasTinhamRepeticoes = true;
		//verificando se todas as palavras estavam alteradas
		for (int i = 0; i < palavras.length; i++) 
		{	
			TodasPalavrasTinhamRepeticoes = palavras[i].equals(palavrasLimpas[i]) ? false : TodasPalavrasTinhamRepeticoes;
		}
		
		return  TodasPalavrasTinhamRepeticoes? textoLimpo : texto;
	}
	
	public static String[] LimparFrasesQuePossuemRepeticoesNoFinal(String frases[])
	{
		String frasesLimpas[] = new String[frases.length];
		
		for (int i = 0; i < frases.length; i++) {
			frasesLimpas[i] = limparRepeticaoDoFinalDePalavras(frases[i]);
		}
		
		return frasesLimpas;
	}
	
}
