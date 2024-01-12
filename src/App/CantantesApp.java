/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

/**
 *
 * @author juanf
 * 
 */
import Cantante.CantanteFamoso;
import Lista.ListaCantantesFamosos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;




public class CantantesApp {
    private JFrame frame;
    private ListaCantantesFamosos listaCantantes;
    private JTextField nombreTextField;
    private JTextField discoTextField;
    private JTextArea outputArea;
    private JTextField reproduccionesTextField;


    public CantantesApp() {
        frame = new JFrame("Cantantes Famosos");
        listaCantantes = new ListaCantantesFamosos();
        outputArea = new JTextArea(50, 50);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        JButton agregarButton = new JButton("Agregar Cantante");
        JButton mostrarListaButton = new JButton("Mostrar Lista");
        JButton eliminarButton = new JButton("Eliminar Cantante");
        JButton modificarButton = new JButton("Modificar Cantante");
        JButton salirButton = new JButton("Salir");
        // botones definidos 
        
        Color backgroundColor = new Color(200, 230, 255);  // Puedes ajustar estos valores según tus preferencias
        frame.getContentPane().setBackground(backgroundColor);
       
        Color buttonColor = new Color(144, 238, 144);  // Verde claro
        agregarButton.setBackground(buttonColor);
        mostrarListaButton.setBackground(buttonColor);
        eliminarButton.setBackground(buttonColor);
        modificarButton.setBackground(buttonColor);
        salirButton.setBackground(buttonColor);
        
        // Inicializar elementos de la GUI, como botones, campos de texto, menús, etc.
        nombreTextField = new JTextField(20);
        discoTextField = new JTextField(20);    
        reproduccionesTextField = new JTextField(10);
        
     
        JMenuBar menuBar = new JMenuBar();
        JMenu opcionesMenu = new JMenu("Opciones");
        JMenuItem ordenarItem = new JMenuItem("Ordenar por ventas");
        opcionesMenu.add(ordenarItem);
        menuBar.add(opcionesMenu);
        frame.setJMenuBar(menuBar);
        
        
        // Agregar ActionListener para los botones y elementos de menú
        
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String disco = discoTextField.getText();
                // prueba
               
                String reproduccionesText = reproduccionesTextField.getText();

                if (nombre.isEmpty() || disco.isEmpty() || reproduccionesText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor complete toda la información para agregar el cantante.", "Campos Incompletos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int reproducciones;
                    try {
                        reproducciones = Integer.parseInt(reproduccionesText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Error: Ingrese un valor válido para reproducciones.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Detener la ejecución del actionPerformed
                    }
                

                // Agregar una confirmación antes de agregar al cantante
                int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres agregar este cantante? (recuerda opimir mostrar lista para actualizar)", "Confirmar Agregar", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    CantanteFamoso cantante = new CantanteFamoso(nombre, disco, reproducciones);
                    listaCantantes.agregarCantante(cantante);
                    nombreTextField.setText("");
                    discoTextField.setText("");
                }
            }
        }
        });
            
            
            
            

        // metodo para mostra la lista ordenada 
        mostrarListaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                
                Collections.sort(listaCantantes.listacantantesFamosos, (c1, c2) -> Integer.compare(c2.getReproducciones(), c1.getReproducciones())); //ordeno la lista 
                
                Iterator<CantanteFamoso> iterator = listaCantantes.getIterator();
                while (iterator.hasNext()) {
                    CantanteFamoso cantante = iterator.next();
                    outputArea.append("Nombre: " + cantante.getNombre() + ", Disco más vendido: " + cantante.getDiscoconmasVentas() + ", Reproducciones: " + cantante.getReproducciones() + "\n");
                }
            }
        });

        // metodo para eliminarde la lista
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                // Agregar una confirmación antes de eliminar al cantante
                int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres eliminar este cantante? (recuerda opimir mostrar lista para actualizar)", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    Iterator<CantanteFamoso> iterator = listaCantantes.getIterator();
                    while (iterator.hasNext()) {
                        CantanteFamoso cantante = iterator.next();
                        if (cantante.getNombre().equals(nombre)) {
                            iterator.remove();
                        }
                    }
                    nombreTextField.setText("");
                }
            }
        });
        // metodo para modificar las reproducciones o la cancion del artista 
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String nuevoDisco = discoTextField.getText();
                int nuevasReproducciones = Integer.parseInt(reproduccionesTextField.getText());

                // Agregar una confirmación antes de modificar el cantante
                int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres modificar este cantante? (recuerda oprimir mostrar lista para actualizar)", "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    Iterator<CantanteFamoso> iterator = listaCantantes.getIterator();
                    while (iterator.hasNext()) {
                        CantanteFamoso cantante = iterator.next();
                        if (cantante.getNombre().equals(nombre)) {
                            cantante.setDiscoconmasVentas(nuevoDisco);
                            cantante.setReproducciones(nuevasReproducciones); // Actualizar las reproducciones
                        }
                    }
                    nombreTextField.setText("");
                    discoTextField.setText("");
                    reproduccionesTextField.setText("");
                }
            }
        });
        // metodo parasalir del programa. 
        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Cierra la ventana principal
                }
            }
        });

        // Configurar el diseño y disposición de los componentes en el JFrame
        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Artista:"));
        frame.add(nombreTextField);
        frame.add(new JLabel("Disco más vendido:"));
        frame.add(discoTextField);
        frame.add(new JLabel("Reproducciones:"));
        frame.add(reproduccionesTextField);
        frame.add(agregarButton);
        frame.add(mostrarListaButton);
        frame.add(eliminarButton);
        frame.add(modificarButton);
        frame.add(scrollPane);
        frame.add(salirButton);

        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CantantesApp());
    }
}