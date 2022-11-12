import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public CircularLinkedList() {
	     last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T t= null;
		if (this.last != null){
			t=last.next.data;
			this.last.next = this.last.next.next;
		}
		return t;
	}
	//coste: O(1)

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node act = this.last;
		T t= null;
		if (this.last != this.last.next){
			while (act.next != this.last){
				act = act.next;
			}
			t = this.last.data;
			act.next = this.last.next;
			this.last = act;

		} else {
			t = this.last.data;
			this.last = null;
		}
		return t;
	}


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node <T> act= this.last;
		Node <T> ant= this.last;
		boolean salir = false;
		T t= null;

		if (this.last != null){
			act = act.next;

			while (act != this.last && !salir){
				if (act.data == elem){
					t = act.data;
					ant.next = act.next;
					salir = true;
                    count --;
				}
				ant = act;
				act = act.next;
			}
		}
		return t;
	}
	//coste: O (n)
	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
		boolean encontrado = false;
		Node act = this.last;

		if (this.last != null){
			act = act.next;
			while  (act != this.last && !encontrado){
				if (act.data.equals(elem)){
					encontrado = true;
				}
				act = act.next;
			}
			if (last.data.equals(elem)){encontrado = true;}
		}
		return encontrado;
	}
	// coste: O (n)
//h
	public T find(T elem) { //TODO preguntar si hay que devolver la posi o el elemento
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		boolean enc=false;
		Node<T> act=last;
		Node<T> ant=last;
		if (last!=null){
			if (act.data==elem){
				enc=true;
				return ant.data;
			}
			else{
				act=act.next;
				while (act!=last && enc==false){
					if (act.data==elem){
						enc=true;
						return ant.data;
					}
					else{
						ant=act;
						act=act.next;
					}
				}
				if (enc==false){
					return null;
				}
			}
		}
		return ant.data;
	}
	//coste: O(n)

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); }

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
		   private Node<T> act = last.next;
		   private int i = 0;
		   public boolean hasNext(){ return i < count;}
		   public T next(){
			   T item= act.data;
			   act=act.next;
			   i++;
			   return item;
		   }
		   //Coste lineal (O(1))

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
