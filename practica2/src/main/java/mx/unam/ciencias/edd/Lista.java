package mx.unam.ciencias.edd;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import mx.unam.ciencias.edd.MeteSaca.Nodo;

/**
 * <p>
 * Clase genérica para listas doblemente ligadas.
 * </p>
 *
 * <p>
 * Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.
 * </p>
 *
 * <p>
 * Las listas no aceptan a <code>null</code> como elemento.
 * </p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> implements Coleccion<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            // Aquí va su código.
            this.elemento = elemento;
        }
    }

    /* Clase interna privada para iteradores. */
    private class Iterador implements IteradorLista<T> {
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nuevo iterador. */
        private Iterador() {
            // Aquí va su código.
            anterior = null;
            siguiente = cabeza;
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            // Aquí va su código.
            return siguiente != null;
        }

        /* Nos da el elemento siguiente. */
        @Override
        public T next() {
            // Aquí va su código.
            if (siguiente == null)
                throw new NoSuchElementException();

            T e = siguiente.elemento;
            anterior = siguiente;
            siguiente = siguiente.siguiente;
            return e;

        }

        /**
         * <p>
         * Clase genérica para listas doblemente ligadas.
         * </p>
         *
         * <p>
         * Las listas nos permiten agregar elementos al inicio o final de la lista,
         * eliminar elementos de la lista, comprobar si un elemento está o no en la
         * lista, y otras operaciones básicas.
         * </p>
         *
         * <p>
         * Las listas no aceptan a <code>null</code> como elemento.
         * </p>
         *
         * @param <T> El tipo de los elementos de la lista.
         */
        public class Lista<T> implements Coleccion<T> {

            /* Clase interna privada para nodos. */
            private class Nodo {
                /* El elemento del nodo. */
                private T elemento;
                /* El nodo anterior. */
                private Nodo anterior;
                /* El nodo siguiente. */
                private Nodo siguiente;

                /* Construye un nodo con un elemento. */
                private Nodo(T elemento) {
                    // Aquí va su código.
                    this.elemento = elemento;
                }
            }

            /* Clase interna privada para iteradores. */
            private class Iterador implements IteradorLista<T> {
                /* El nodo anterior. */
                private Nodo anterior;
                /* El nodo siguiente. */
                private Nodo siguiente;

                /* Construye un nuevo iterador. */
                private Iterador() {
                    // Aquí va su código.
                    anterior = null;
                    siguiente = cabeza;
                }

                /* Nos dice si hay un elemento siguiente. */
                @Override
                public boolean hasNext() {
                    // Aquí va su código.
                    return siguiente != null;
                }

                /* Nos da el elemento siguiente. */
                @Override
                public T next() {
                    // Aquí va su código.
                    if (siguiente == null)
                        throw new NoSuchElementException();

                    T e = siguiente.elemento;
                    anterior = siguiente;
                    siguiente = siguiente.siguiente;
                    return e;

                }

                /* Nos dice si hay un elemento anterior. */
                @Override
                public boolean hasPrevious() {
                    // Aquí va su código.

                    return anterior != null;
                }

                /* Nos da el elemento anterior. */
                @Override
                public T previous() {
                    // Aquí va su código.
                    if (anterior == null)
                        throw new NoSuchElementException();

                    T e = anterior.elemento;
                    siguiente = anterior;
                    anterior = anterior.anterior;

                    return e;

                }

                /* Mueve el iterador al inicio de la lista. */
                @Override
                public void start() {
                    // Aquí va su código.
                    anterior = null;
                    siguiente = cabeza;
                }

                /* Nos dice si hay un elemento anterior. */
                @Override
                public boolean hasPrevious() {
                    // Aquí va su código.

                    return anterior != null;
                }

                /* Nos da el elemento anterior. */
                @Override
                public T previous() {
                    // Aquí va su código.
                    if (anterior == null)
                        throw new NoSuchElementException();

                    T e = anterior.elemento;
                    siguiente = anterior;
                    anterior = anterior.anterior;

                    return e;

                }

                /* Mueve el iterador al final de la lista. */
                @Override
                public void end() {
                    // Aquí va su código.
                    siguiente = null;
                    anterior = rabo;
                }
            }

            /* Primer elemento de la lista. */
            private Nodo cabeza;
            /* Último elemento de la lista. */
            private Nodo rabo;
            /* Número de elementos en la lista. */
            private int longitud;

            /**
             * Regresa la longitud de la lista. El método es idéntico a {@link
             * #getElementos}.
             * 
             * @return la longitud de la lista, el número de elementos que contiene.
             */
            public int getLongitud() {
                // Aquí va su código.
                return longitud;
            }

            /**
             * Regresa el número elementos en la lista. El método es idéntico a {@link
             * #getLongitud}.
             * 
             * @return el número elementos en la lista.
             */
            @Override
            public int getElementos() {
                // Aquí va su código.
                return longitud;
            }

            /**
             * Nos dice si la lista es vacía.
             * 
             * @return <code>true</code> si la lista es vacía, <code>false</code> en
             *         otro caso.
             */
            @Override
            public boolean esVacia() {
                // Aquí va su código.
                return longitud == 0;
            }

            /**
             * Agrega un elemento a la lista. Si la lista no tiene elementos, el
             * elemento a agregar será el primero y último. El método es idéntico a
             * {@link #agregaFinal}.
             * 
             * @param elemento el elemento a agregar.
             * @throws IllegalArgumentException si <code>elemento</code> es
             *                                  <code>null</code>.
             */
            @Override
            public void agrega(T elemento) {

                // Aquí va su código.
                if (elemento == null)
                    throw new IllegalArgumentException();

                agregaFinal(elemento);
            }

            /**
             * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
             * el elemento a agregar será el primero y último.
             * 
             * @param elemento el elemento a agregar.
             * @throws IllegalArgumentException si <code>elemento</code> es
             *                                  <code>null</code>.
             */
            public void agregaFinal(T elemento) {
                // Aquí va su código.
                if (elemento == null)
                    throw new IllegalArgumentException();

                Nodo p = new Nodo(elemento);
                longitud++;
                if (esVacia()) {
                    cabeza = rabo = p;
                } else {
                    rabo.siguiente = p;
                    p.anterior = rabo;
                    rabo = p;
                }
            }

            /**
             * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
             * el elemento a agregar será el primero y último.
             * 
             * @param elemento el elemento a agregar.
             * @throws IllegalArgumentException si <code>elemento</code> es
             *                                  <code>null</code>.
             */
            public void agregaInicio(T elemento) {
                // Aquí va su código.

                if (elemento == null)
                    throw new IllegalArgumentException();

                Nodo p = new Nodo(elemento);
                longitud++;
                if (esVacia()) {
                    cabeza = rabo = p;
                } else {
                    cabeza.anterior = p;
                    p.siguiente = cabeza;
                    cabeza = p;
                }

            }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * 
     * @param i        el índice dónde insertar el elemento. Si es menor que 0 el
     *                 elemento se agrega al inicio de la lista, y si es mayor o
     *                 igual
     *                 que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
        public void inserta(int i, T elemento) {
        // Aquí va su código.

        if (i < 0 || i > longitud)
        throw new ExcepcionIndiceInvalido();

    if (elemento == null)
        throw new IllegalArgumentException();
    if (i == 0) {
        agregaInicio(elemento);
    } else if (i == longitud) {
        agregaFinal(elemento);
    } else {
        Nodo a = getNodo(i);
        longitud++;
        Nodo b = new Nodo(elemento);
        Nodo c = a.anterior;
        a.anterior = b;
        b.siguiente = a;
        b.anterior = c;
        c.siguiente = b;
    }

        }

            private void eliminaNodo(Nodo nodo) {
                longitud--;
                if (cabeza == rabo) {
                    cabeza = rabo = null;
                } else if (nodo == cabeza) {
                    Nodo s = nodo.siguiente;
                    s.anterior = null;
                    cabeza = s;
                } else if (nodo == rabo) {
                    Nodo a = nodo.anterior;
                    a.siguiente = null;
                    rabo = a;
                } else {
                    Nodo s = nodo.siguiente;
                    Nodo a = nodo.anterior;
                    s.anterior = a;
                    a.siguiente = s;
                }
            }

            private Nodo buscaNodo(T elemento) {
                Nodo n = cabeza;
                while (n != null) {
                    if (n.elemento.equals(elemento))
                        return n;
                    n = n.siguiente;
                }
                return null;
            }

            /**
             * Elimina un elemento de la lista. Si el elemento no está contenido en la
             * lista, el método no la modifica.
             * 
             * @param elemento el elemento a eliminar.
             */
            @Override
            public void elimina(T elemento) {
                // Aquí va su código.
                if (elemento == null)
                    throw new IllegalArgumentException();

                Nodo r = buscaNodo(elemento);
                if (r != null)
                    eliminaNodo(r);
            }

            /**
             * Elimina el primer elemento de la lista y lo regresa.
             * 
             * @return el primer elemento de la lista antes de eliminarlo.
             * @throws NoSuchElementException si la lista es vacía.
             */
            public T eliminaPrimero() {
                // Aquí va su código.
                if (esVacia())
                    throw new NoSuchElementException();

                T e = cabeza.elemento;
                eliminaNodo(cabeza);
                return e;
            }

            /**
             * Elimina el último elemento de la lista y lo regresa.
             * 
             * @return el último elemento de la lista antes de eliminarlo.
             * @throws NoSuchElementException si la lista es vacía.
             */
            public T eliminaUltimo() {
                // Aquí va su código.
                if (esVacia())
                    throw new NoSuchElementException();

                T e = rabo.elemento;
                eliminaNodo(rabo);
                return e;
            }

            /**
             * Nos dice si un elemento está en la lista.
             * 
             * @param elemento el elemento que queremos saber si está en la lista.
             * @return <code>true</code> si <code>elemento</code> está en la lista,
             *         <code>false</code> en otro caso.
             */
            @Override
            public boolean contiene(T elemento) {
                // Aquí va su código.
                return buscaNodo(elemento) != null;
            }

            /**
             * Regresa la reversa de la lista.
             * 
             * @return una nueva lista que es la reversa la que manda llamar el método.
             */
            public Lista<T> reversa() {
                // Aquí va su código.
                Lista<T> lista = new Lista<>();
                Nodo p = rabo;
                while (p != null) {
                    lista.agregaFinal(p.elemento);
                    p = p.anterior;
                }
                return lista;
            }

            /**
             * Regresa una copia de la lista. La copia tiene los mismos elementos que la
             * lista que manda llamar el método, en el mismo orden.
             * 
             * @return una copiad de la lista.
             */
            public Lista<T> copia() {
                // Aquí va su código.
                Lista<T> lista = new Lista<>();
                Nodo p = cabeza;
                while (p != null) {
                    lista.agregaFinal(p.elemento);
                    p = p.siguiente;
                }
                return lista;
            }

            /**
             * Limpia la lista de elementos, dejándola vacía.
             */
            @Override
            public void limpia() {
                // Aquí va su código.
                cabeza = rabo = null;
                longitud = 0;
            }

            /**
             * Regresa el primer elemento de la lista.
             * 
             * @return el primer elemento de la lista.
             * @throws NoSuchElementException si la lista es vacía.
             */
            public T getPrimero() {
                // Aquí va su código.
                if (esVacia())
                    throw new NoSuchElementException();

                return cabeza.elemento;
            }

            /**
             * Regresa el último elemento de la lista.
             * 
             * @return el primer elemento de la lista.
             * @throws NoSuchElementException si la lista es vacía.
             */
            public T getUltimo() {
                // Aquí va su código.
                if (esVacia())
                    throw new NoSuchElementException();

                return rabo.elemento;
            }

            /**
             * Regresa el <em>i</em>-ésimo elemento de la lista.
             * 
             * @param i el índice del elemento que queremos.
             * @return el <em>i</em>-ésimo elemento de la lista.
             * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
             *                                 igual que el número de elementos en la lista.
             */
            public T get(int i) {
                // Aquí va su código.
                if (i < 0 || i >= longitud)
                    throw new ExcepcionIndiceInvalido();

                Nodo x = getNodo(i);
                return x.elemento;
            }

            /**
             * Regresa el índice del elemento recibido en la lista.
             * 
             * @param elemento el elemento del que se busca el índice.
             * @return el índice del elemento recibido en la lista, o -1 si el elemento
             *         no está contenido en la lista.
             */
            public int indiceDe(T elemento) {
                // Aquí va su código.
                int contador = 0;
                Nodo z = cabeza;
                while (z != null) {
                    if (elemento.equals(z.elemento))
                        return contador;
                    contador++;
                    z = z.siguiente;
                }
                return -1;
            }

            /**
             * Regresa una representación en cadena de la lista.
             * 
             * @return una representación en cadena de la lista.
             */
            @Override
            public String toString() {
                // Aquí va su código.
                if (esVacia())
                    return "[]";
                String cadena = "[" +
                        cabeza.elemento.toString();
                Nodo x = cabeza.siguiente;
                while (x != null) {
                    cadena = cadena.concat(", ").concat(x.elemento.toString());
                    x = x.siguiente;
                }
                cadena = cadena.concat("]");
                return cadena;
            }

            /**
             * Nos dice si la lista es igual al objeto recibido.
             * 
             * @param objeto el objeto con el que hay que comparar.
             * @return <code>true</code> si la lista es igual al objeto recibido;
             *         <code>false</code> en otro caso.
             */
            @Override
            public boolean equals(Object objeto) {
                if (objeto == null || getClass() != objeto.getClass())
                    return false;
                @SuppressWarnings("unchecked")
                Lista<T> lista = (Lista<T>) objeto;
                // Aquí va su código.
                if (longitud != lista.getLongitud())
                    return false;
                Nodo a1 = cabeza;
                Nodo a2 = lista.cabeza;
                while (a1 != null) {
                    if (!a1.elemento.equals(a2.elemento))
                        return false;
                    a1 = a1.siguiente;
                    a2 = a2.siguiente;
                }
                return true;
            }

            /**
             * Regresa un iterador para recorrer la lista en una dirección.
             * 
             * @return un iterador para recorrer la lista en una dirección.
             */
            @Override
            public Iterator<T> iterator() {
                return new Iterador();
            }

            /**
             * Regresa un iterador para recorrer la lista en ambas direcciones.
             * 
             * @return un iterador para recorrer la lista en ambas direcciones.
             */
            public IteradorLista<T> iteradorLista() {
                return new Iterador();
            }

            private Lista<T> mezcla(Lista<T> l, Lista<T> m,
                    Comparator<T> comparador) {
                Lista<T> ordenada = new Lista<T>();

                while (!l.esVacia() && !m.esVacia()) {
                    if (comparador.compare(l.getPrimero(), m.getPrimero()) <= 0) {
                        ordenada.agregaFinal(l.getPrimero());
                        l.eliminaPrimero();
                    } else {
                        ordenada.agregaFinal(m.getPrimero());
                        m.eliminaPrimero();
                    }
                }

                while (!l.esVacia()) {
                    ordenada.agregaFinal(l.getPrimero());
                    l.eliminaPrimero();
                }

                while (!m.esVacia()) {
                    ordenada.agregaFinal(m.getPrimero());
                    m.eliminaPrimero();
                }

                return ordenada;
            }

            private Lista<T> mergesort(Lista<T> l, Comparator<T> comparador) {
                if (l.longitud <= 1)
                    return l;

                int mitad = l.longitud / 2;
                Lista<T> o = new Lista<T>();

                while (l.longitud > mitad) {
                    o.agregaFinal(l.getPrimero());
                    l.eliminaPrimero();
                }

                o = mergesort(o, comparador);
                l = mergesort(l, comparador);

                return mezcla(o, l, comparador);
            }

            /**
             * Regresa una copia de la lista, pero ordenada. Para poder hacer el
             * ordenamiento, el método necesita una instancia de {@link Comparator} para
             * poder comparar los elementos de la lista.
             * 
             * @param comparador el comparador que la lista usará para hacer el
             *                   ordenamiento.
             * @return una copia de la lista, pero ordenada.
             */
            public Lista<T> mergeSort(Comparator<T> comparador) {
                // Aquí va su código.
                return mergesort(copia(), comparador);
            }

            /**
             * Regresa una copia de la lista recibida, pero ordenada. La lista recibida
             * tiene que contener nada más elementos que implementan la interfaz {@link
             * Comparable}.
             * 
             * @param <T>   tipo del que puede ser la lista.
             * @param lista la lista que se ordenará.
             * @return una copia de la lista recibida, pero ordenada.
             */
            public static <T extends Comparable<T>> Lista<T> mergeSort(Lista<T> lista) {
                return lista.mergeSort((a, b) -> a.compareTo(b));
            }

            /**
             * Busca un elemento en la lista ordenada, usando el comparador recibido. El
             * método supone que la lista está ordenada usando el mismo comparador.
             * 
             * @param elemento   el elemento a buscar.
             * @param comparador el comparador con el que la lista está ordenada.
             * @return <code>true</code> si el elemento está contenido en la lista,
             *         <code>false</code> en otro caso.
             */
            public boolean busquedaLineal(T elemento, Comparator<T> comparador) {
                // Aquí va su código.
                Nodo n = cabeza;

                while (n != null) {
                    if (comparador.compare(n.elemento, elemento) == 0)
                        return true;
                    n = n.siguiente;
                }

                return false;
            }

            /**
             * Busca un elemento en una lista ordenada. La lista recibida tiene que
             * contener nada más elementos que implementan la interfaz {@link
             * Comparable}, y se da por hecho que está ordenada.
             * 
             * @param <T>      tipo del que puede ser la lista.
             * @param lista    la lista donde se buscará.
             * @param elemento el elemento a buscar.
             * @return <code>true</code> si el elemento está contenido en la lista,
             *         <code>false</code> en otro caso.
             */
            public static <T extends Comparable<T>> boolean busquedaLineal(Lista<T> lista, T elemento) {
                return lista.busquedaLineal(elemento, (a, b) -> a.compareTo(b));
            }
}
}

}
