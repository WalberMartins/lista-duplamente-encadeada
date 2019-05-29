package listaEncadeada;

public class ListaEncadeada<T> 
{
	private Celula primeira;
	private Celula ultima;
	private int tamanho;
	
	public ListaEncadeada()
	{
		primeira = null;
		ultima = null;
		tamanho = 0;
	}
	
	public boolean add(T elemento)
	{
		Celula nova = new Celula(elemento);
		if(tamanho == 0)
			primeira = nova;
		else {
			ultima.setProxima(nova);
			nova.setAnterior(ultima);
		}
		ultima = nova;
		tamanho++;
		return true;
	}
	
	public void addFirst(T elemento) throws Exception
	{
		if(tamanho == 0)
			add(elemento);
		else
		{
			try
			{
				Celula nova = new Celula(elemento);
				nova.setProxima(primeira);
				primeira.setAnterior(nova);
				primeira = nova;
				tamanho++;
			}
			catch(Exception e) {throw e;}
		}
		
	}
	
	public void add(int posicao, T elemento) throws Exception
	{
		if(!posicaoOcupada(posicao))
			throw new IllegalArgumentException("posicao inv�lida!");
		if(posicao == 0)
		{
			try
			{
				addFirst(elemento);
			} catch (Exception e) {throw e;}
		}
		else if(posicao == tamanho - 1)
			add(elemento);
		else
		{
			Celula nova = new Celula(elemento);
			Celula atual = getCelula(posicao);
			Celula anterior = getCelula(posicao - 1);
			atual.setAnterior(nova);
			nova.setAnterior(anterior);
			nova.setProxima(atual);
			anterior.setProxima(nova);
			tamanho++;
		}
		
	}
	
	public int indexOf(T elemento)
	{
		Celula celula = primeira;
		int posicao = 0;
		while(celula != null)
		{
			if(celula.getElemento().equals(elemento))
				return posicao;
			posicao++;
			celula = celula.getProxima();
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int posicao) throws IllegalArgumentException
	{
		try
		{
			Celula celula = getCelula(posicao);
			return (T) celula.getElemento();
		}
		catch (IllegalArgumentException e) {throw e;}
	}
	
	private Celula getCelula(int posicao) throws IllegalArgumentException
	{
		if(!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posi��o inv�lida!");
		Celula atual = primeira;
		for(int i = 0; i < posicao; i++)
			atual = atual.getProxima();
		return atual;
	}
	
	public void set(int posicao, T elemento) throws IllegalArgumentException
	{
		try
		{
			Celula celula = getCelula(posicao);
			celula.setElemento(elemento);
		}
		catch(IllegalArgumentException e) {throw e;}
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int posicao)
	{
		if(!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posi��o inv�lida!");
		if(posicao == 0)
			return removeFirst();
		Celula anterior = getCelula(posicao - 1);
		Celula excluida = getCelula(posicao);
		T excluido = (T) excluida.getElemento();
		if(!(excluida == ultima)) {
			Celula proxima = getCelula(posicao + 1);
			proxima.setAnterior(excluida.getAnterior());
		}
		anterior.setProxima(excluida.getProxima());
		tamanho--;
		if(tamanho == posicao)
			ultima = anterior;
		return excluido;	
	}
	
	public Boolean remove(T elemento)
	{
		int posicao = indexOf(elemento);
		if(posicao != -1)
		{
			try
			{
				remove(posicao);
				return true;
			}
			catch(Exception e) {return false;}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T removeFirst() throws IllegalArgumentException
	{
		if(tamanho == 0)
			throw new IllegalArgumentException("Lista vazia!");
		else
		{
			T excluido = (T) primeira.getElemento();
			primeira = primeira.getProxima();
			primeira.setAnterior(null);
			tamanho--;
			if(tamanho == 0)
				ultima = primeira;
			return excluido;
		}
	
	}
	
	public int size()
	{
		return tamanho;
	}
	
	private Boolean posicaoOcupada(int posicao)
	{
		
		return (posicao >= 0 && posicao < tamanho ? true:false); 
	}

	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < tamanho; i++)
			s.append(getCelula(i)+"\n");
		return s.toString();
	}
		
}
