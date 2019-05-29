package listaEncadeada;

public class Celula 
{
	private Object elemento;
	private Celula anterior;
	private Celula proxima;
	
	public Celula(Object elemento)
	{
		this.elemento = elemento; 
	}
	
	public Celula(Object elemento, Celula anterior, Celula proxima)
	{
		this.elemento = elemento;
		this.anterior = anterior;
		this.proxima = proxima;
	}
	
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
	
	public Celula getAnterior() {
		return anterior;
	}
	
	public void setProxima(Celula proxima)
	{
		this.proxima = proxima;
	}
	
	public Celula getProxima()
	{
		return proxima;
	}
	
	public void setElemento(Object elemento)
	{
		this.elemento = elemento;
	}
	
	public Object getElemento()
	{
		return elemento;
	}
	
	public String toString()
	{
		return ""+elemento;
	}

}
