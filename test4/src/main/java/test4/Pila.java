package test4;

import java.util.Stack;
	
public class Pila {
	private Stack<Integer> pila = new Stack<Integer>();
	// A�ade el numero solo si es mayor que 2 y menor que 20
	public void push (Integer num) {
		if (num > 2 && num < 20)
			pila.push(num);
	}
	/*
	 Si la pila esta vacia devolvemos null, sino se devuelve el
	 ultimo numero a�adido a la pila sacandolo de la pila
	*/
	public Integer pop() {
		if (pila.isEmpty())
			return null;
		else
			return pila.pop();
	}
	//Devuelve true si la pila está vacía, false caso contrario
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	/*
	 Si la pila está vacía devolvemos null, sino se devuelve el
	 primer número añadido a la pila sin sacarlo
	*/
	public Integer top() {
		if (pila.isEmpty())
			return null;
		else
			return pila.peek();
	}
}
