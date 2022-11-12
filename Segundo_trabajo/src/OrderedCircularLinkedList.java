public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node  <T> act = super.last;
		Node  <T> ant = super.last;
		Node  <T> nuevo = new Node(elem);
		boolean añadido = false;

		if (last != null){
			act = last.next;
			while (!añadido){ // no lo va a hacer porque cuando hay un elemento act = last
				if (elem.compareTo(act.data) < 0){
					if (act == last.next){
						nuevo.next = act;
						last.next = nuevo;

					}else{
						nuevo.next = act;
						ant.next = nuevo;
					}
					count++;
					añadido = true;

				}else if (act == last){
					nuevo.next = last.next;
					act.next = nuevo;
					last = nuevo;
					count ++;
					añadido = true;
				}else {
					ant = act;
					act = act.next;
				}
			}
		}else{
			last= nuevo;
			last.next = nuevo;
			count ++;
		}
	}

}
