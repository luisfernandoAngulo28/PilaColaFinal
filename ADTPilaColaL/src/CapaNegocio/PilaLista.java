/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author fernando Angulo
 */
/*
L->[0|]->[1|]->[3|]->[5|]->[7|]-> null  cantidad
  L->
[0|]->
[1|]->
[3|]->
[5|]->
[7|]-> null  

*/
public class PilaLista {
       //atributos
    
     Nodo cima;
     int cantidad;
    //constructor
    public PilaLista(){
        cima=null;
        cantidad=0;
    }
     /* 3|____| 
        2|____|
        1|____|
        0|____|
        -1       <- cima
     */
    public boolean vacia(){
        return cima==null;
    }
    
    
    public int cantidad(){
        return cantidad;
    }
     /* 3|__5__|<- cima 
        2|__4__|
        1|__3__|
        0|__2__|
           P       solo aqui estara llena
            p.length - 1
     */
    
    //meter              23
    public void push(int elemento){
       Nodo p=new Nodo();
       p.setDato(elemento);
       p.setEnlace(cima);
       cima=p;
       cantidad++;
    }
    
    
    public void push2(int elemento){
       Nodo nuevo=new Nodo(elemento,cima);
       //p.setDato(elemento);
      // p.setEnlace(cima);
       cima=nuevo;
       cantidad++;
    }
    //sacar
    public int pop(){
      int x=cima.getDato();
  //    Nodo a=cima;
  //    a=null;
      cima=cima.getEnlace();
      cantidad--;
      return x;
    }
     //sacar
    public int get(){   
     return cima.getDato();
    }
    
   
    
     @Override
    public String toString(){
        String S="";
        Nodo Aux=cima;
        while (Aux!=null) {            
             S=S+"|_"+Integer.toString(Aux.getDato())+"_|";
              S=S+"\n";
          Aux=Aux.getEnlace();
        }
         
           
     //   }
        return S;
               // +"->null";
    }
    
    
    
    
    
    
    
    
    public void invertirExtremos(PilaLista p,Cola_Lista c){
        if (!p.vacia()) {
            if (!c.vacia()) {
                int tamcola=c.cantidad();
                int tampila=p.cantidad()-2;
                int dato1=c.decolar();
                for (int i = 0; i < c.cantidad()-1; i++) {
                    int a=c.decolar();
                    c.encolar(a);
                }
                c.encolar(dato1);
                
                int dato2=p.pop();
                int iteracion=p.cantidad-1;
                for (int i = 0; i < iteracion; i++) {
                    c.encolar(p.pop());
                }
                 //System.out.println("colaaa"+c.toString());
                for (int i = 0; i < tamcola; i++) {
                    c.encolar(c.decolar());
                }
                for (int i = 0; i < tampila; i++) {//3
                    p.push(c.decolar());
                }
                p.push(dato2);
                tampila=p.cantidad();//5
                for (int i = 0; i < tampila; i++) {
                    c.encolar(p.pop());
                }
                for (int i = 0; i < tamcola; i++) {//6
                    c.encolar(c.decolar());
                }
                for (int i = 0; i < tampila; i++) {
                    p.push(c.decolar());
                }
                
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        PilaLista pilaDePrueba=new PilaLista();
        PilaLista p=new PilaLista();
        for (int i = 1; i < 6; i++) {
            p.push(i);
        }
        System.out.println(p.toString());
        Cola_Lista c=new Cola_Lista();
        for (int i = 6; i < 12; i++) {
             c.encolar(i);
        }
          System.out.println(c.toString());
       
          System.out.println("-----------------salida");
          p.invertirExtremos(p, c);
        
        
         System.out.println(c.toString());
          System.out.println(p.toString());
    }
    
    
}
