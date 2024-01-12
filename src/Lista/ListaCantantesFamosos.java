/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

/**
 *
 * @author juanf
 */
import Cantante.CantanteFamoso;
import java.util.ArrayList;
import java.util.Iterator;
// se define el linkest llist de los catnatnres famosos 


public class ListaCantantesFamosos {
    public ArrayList<CantanteFamoso> listacantantesFamosos = new ArrayList<>();

    public void agregarCantante(CantanteFamoso cantante) {
        listacantantesFamosos.add(cantante);
    }

    public Iterator<CantanteFamoso> getIterator() {
        return listacantantesFamosos.iterator();
    }
}


