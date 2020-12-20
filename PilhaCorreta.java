/**Fonte 1: aulas de AED 1 - EACH USP - Professor Marcio Moretto
 * Link: https://github.com/marciomr/AED1/blob/master/Capitulo%205.2/ArrayQueue.java
 * Fonte 2: algoritmo de fila implementado University of Washington
 * Link: http://faculty.washington.edu/moishe/javademos/ArrayQueue.java
 * Obs.: alterações apenas nos comentários 
*/

public class PilhaCorreta<T>{
    
   private final int DEFAULT_CAPACITY = 100;
   private int rear;
   private T[] queue; 

   /******************************************************************
   Cria uma fila vazia com capacidade default
   ******************************************************************/
   public PilhaCorreta(){
      rear = 0;
      queue = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   /******************************************************************
   Cria uma fila com capacidade específica
   ******************************************************************/
   public PilhaCorreta (int initialCapacity){
      rear = 0;
      queue = (T[])(new Object[initialCapacity]);
   }

   /******************************************************************
   Adiciona elemento específico para o iníci oda fila, expandindo a 
   capacidade da fila se necessário
   ******************************************************************/
   public void enqueue (T element){
      if (size() == queue.length) expandCapacity();

      queue[rear] = element;
      rear++;
   }

   /******************************************************************
   Remove o elemento inicial da fila e retorna uma referência a ele.
   Chama EmptyQueueException se a fila está vazia
   ******************************************************************/
   public T dequeue() throws EmptyQueueException{
      if (isEmpty()) throw new EmptyQueueException("queue");

      T result = queue[0];
      rear--;

      for (int scan=0; scan < rear; scan++) queue[scan] = queue[scan+1];
      
      queue[rear] = null;
 
      return result;
   }
   
   /******************************************************************
   Retorna uma referência ao elemento da frente da fila.
   O elemento não é removido da fila.
   Chama EmptyQueueException se a fila está vazia.  
   ******************************************************************/
   public T first() throws EmptyQueueException{
      if (isEmpty()) throw new EmptyQueueException ("queue"); 

      return queue[0];
   }

   /******************************************************************
   Retorna true se a fila está vazia e falso se não está 
   ******************************************************************/
   public boolean isEmpty(){
      return (rear == 0);
   }
 
   /******************************************************************
   Retorna o número de elementos atualmente na fila
   ******************************************************************/
   public int size(){
      return rear;
   }

   /******************************************************************
   Retorna uma string que representa a fila
   ******************************************************************/
   public String toString(){
      String result = "";

      for (int scan=0; scan < rear; scan++) result = result + queue[scan].toString() + "\n";

      return result;
   }

   /******************************************************************
   Cria uma novo array para armazenar os elementos da fila com
   duas vezes a capacidade da primeira
   ******************************************************************/
   private void expandCapacity(){
      T[] larger = (T[])(new Object[queue.length*2]);

      for (int scan=0; scan < queue.length; scan++) larger[scan] = queue[scan];

      queue = larger;
   }

}