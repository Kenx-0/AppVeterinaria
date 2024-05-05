/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appveterinaria;

import Entidad.VeterinariaClass;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSTIN
 */
public class VeterinariaFrame extends javax.swing.JFrame {

    /**
     * Creates new form VeterinariaFrame
     */
    private DefaultTableModel modeloTabla;
    private List<VeterinariaClass> listaMascotas;

    public VeterinariaFrame() {
        initComponents();
        inicializarTabla();
        agregarListeners();
        cargarDatosDesdeArchivo();
    }

    // Método para inicializar la tabla
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        tableVeterinaria.setModel(modeloTabla);
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("PROPIETARIO");
        modeloTabla.addColumn("RAZA");
        modeloTabla.addColumn("FECHA");
        modeloTabla.addColumn("SEXO");
        modeloTabla.addColumn("ESPECIE");

        // Inicializar la lista de mascotas
        listaMascotas = new ArrayList<>();
    }

    // Método para cargar los datos desde el archivo de texto y mostrarlos en la tabla
    private void cargarDatosDesdeArchivo() {
        try {
            File archivo = new File("veterinaria.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando la coma como separador
                String[] partes = linea.split(",");
                // Agregar los datos a la tabla
                modeloTabla.addRow(partes);
            }

            br.close();
        } catch (IOException ex) {
            System.out.println("Error al cargar datos desde el archivo: " + ex.getMessage());
        }
    }

    // Método para agregar listeners a los componentes
    private void agregarListeners() {
        tableVeterinaria.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tableVeterinaria.getSelectedRow() != -1) {
                        // Obtener los datos de la fila seleccionada
                        String nombre = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 0).toString();
                        String propietario = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 1).toString();
                        String raza = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 2).toString();
                        String fecha = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 3).toString();
                        String sexo = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 4).toString();
                        String especie = tableVeterinaria.getValueAt(tableVeterinaria.getSelectedRow(), 5).toString();

                        // Rellenar los campos con los datos de la fila seleccionada
                        txtNombre.setText(nombre);
                        txtPropietario.setText(propietario);
                        txtRaza.setText(raza);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date fechaDate = sdf.parse(fecha);
                            dtFecha.setDate(fechaDate);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                        if (sexo.equals("Macho")) {
                            rdbMacho.setSelected(true);
                        } else {
                            rdbHembra.setSelected(true);
                        }

                        if (especie.equals("Canino")) {
                            rdbCanino.setSelected(true);
                        } else {
                            rdbFelino.setSelected(true);
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgEspecie = new javax.swing.ButtonGroup();
        btgGenero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeterinaria = new javax.swing.JTable();
        btnSalida = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdbCanino = new javax.swing.JRadioButton();
        rdbFelino = new javax.swing.JRadioButton();
        rdbMacho = new javax.swing.JRadioButton();
        rdbHembra = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Veterinaria");

        jLabel1.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE VETERINARIA");

        tableVeterinaria.setBackground(new java.awt.Color(242, 242, 242));
        tableVeterinaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tableVeterinaria);

        btnSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        btnSalida.setText("SALIDA");
        btnSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalidaMouseClicked(evt);
            }
        });

        jLabel2.setText("NOMBRE");

        jLabel3.setText("PROPIETARIO");

        jLabel4.setText("RAZA");

        btgEspecie.add(rdbCanino);
        rdbCanino.setText("CANINO");

        btgEspecie.add(rdbFelino);
        rdbFelino.setText("FELINO");

        btgGenero.add(rdbMacho);
        rdbMacho.setText("MACHO");

        btgGenero.add(rdbHembra);
        rdbHembra.setText("HEMBRA");

        jLabel5.setText("SEXO:");

        txtPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPropietarioActionPerformed(evt);
            }
        });

        jLabel6.setText("FECHA DE NACIMIENTO");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carpeta.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eli.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("ESPECIE:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNombre)
                                    .addGap(67, 67, 67))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(txtPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(84, 84, 84)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rdbCanino)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdbFelino, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEliminar)
                                        .addComponent(rdbHembra)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(dtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rdbMacho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(94, 94, 94))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegistrar)
                            .addGap(149, 149, 149)
                            .addComponent(btnModificar)
                            .addGap(342, 342, 342)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalida)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbCanino)
                    .addComponent(rdbMacho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbFelino)
                    .addComponent(rdbHembra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalida)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalidaMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // Validar que todos los campos estén llenos
        if (txtNombre.getText().isEmpty() || txtPropietario.getText().isEmpty()
                || txtRaza.getText().isEmpty() || dtFecha.getDate() == null
                || (!rdbMacho.isSelected() && !rdbHembra.isSelected())
                || (!rdbCanino.isSelected() && !rdbFelino.isSelected())) {

            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si hay campos vacíos
        }
        // Obtener los datos de los campos de texto y botones de opción
        String nombre = txtNombre.getText();
        String propietario = txtPropietario.getText();
        String raza = txtRaza.getText();
        Date fecha = dtFecha.getDate();
        String sexo = rdbMacho.isSelected() ? "Macho" : "Hembra";
        String especie = rdbCanino.isSelected() ? "Canino" : "Felino";

        // Formatear la fecha en el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fecha);

        // Agregar una nueva fila a la tabla con los datos de la mascota
        Object[] fila = {nombre, propietario, raza, fechaFormateada, sexo, especie};
        modeloTabla.addRow(fila);

        // Limpiar los campos después de registrar la mascota
        limpiarCampos();
        // Guardar los datos en un archivo de texto
        guardarEnArchivo(nombre, propietario, raza, fechaFormateada, sexo, especie);

        JOptionPane.showMessageDialog(this, "Se registró a la mascota exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int filaSeleccionada = tableVeterinaria.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Verificar que todos los campos estén llenos
            if (txtNombre.getText().isEmpty() || txtPropietario.getText().isEmpty()
                    || txtRaza.getText().isEmpty() || dtFecha.getDate() == null
                    || (!rdbMacho.isSelected() && !rdbHembra.isSelected())
                    || (!rdbCanino.isSelected() && !rdbFelino.isSelected())) {

                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los nuevos datos de los campos de texto y botones de opción
            String nombre = txtNombre.getText();
            String propietario = txtPropietario.getText();
            String raza = txtRaza.getText();
            Date fecha = dtFecha.getDate();
            String sexo = rdbMacho.isSelected() ? "Macho" : "Hembra";
            String especie = rdbCanino.isSelected() ? "Canino" : "Felino";

            // Formatear la fecha en el formato deseado
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(fecha);

            // Actualizar los datos en la tabla
            tableVeterinaria.setValueAt(nombre, filaSeleccionada, 0);
            tableVeterinaria.setValueAt(propietario, filaSeleccionada, 1);
            tableVeterinaria.setValueAt(raza, filaSeleccionada, 2);
            tableVeterinaria.setValueAt(fechaFormateada, filaSeleccionada, 3);
            tableVeterinaria.setValueAt(sexo, filaSeleccionada, 4);
            tableVeterinaria.setValueAt(especie, filaSeleccionada, 5);

            // Actualizar los datos en el archivo de texto
            actualizarArchivoTexto();

            // Limpiar los campos después de modificar la mascota
            limpiarCampos();

            // Mostrar el mensaje de modificación exitosa
            JOptionPane.showMessageDialog(this, "Se modificó la información de la mascota exitosamente.", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tableVeterinaria.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Eliminar la fila seleccionada de la tabla
            modeloTabla.removeRow(filaSeleccionada);

            // Actualizar el archivo de texto
            actualizarArchivoTexto();

            // Limpiar los campos después de eliminar la mascota
            limpiarCampos();
            // Mostrar el mensaje de eliminación exitosa
            JOptionPane.showMessageDialog(this, "Se eliminó la mascota exitosamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void dtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtFechaPropertyChange

    }//GEN-LAST:event_dtFechaPropertyChange

    private void txtPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropietarioActionPerformed

    // Método para guardar los datos en un archivo txt
    private void guardarEnArchivo(String nombre, String propietario, String raza, String fecha, String sexo, String especie) {
        try {
            FileWriter fileWriter = new FileWriter("veterinaria.txt", true); // true para que se agreguen los datos al final del archivo
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Escribir los datos en el archivo en el orden de las columnas especificadas
            printWriter.println(nombre + "," + propietario + "," + raza + "," + fecha + "," + sexo + "," + especie);

            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar en el archivo: " + ex.getMessage());
        }
    }

    //Metodo para Actualizar el archivo txt
    private void actualizarArchivoTexto() {
        try {
            FileWriter fileWriter = new FileWriter("veterinaria.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Iterar sobre todas las filas de la tabla y escribir los datos en el archivo
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String nombre = modeloTabla.getValueAt(i, 0).toString();
                String propietario = modeloTabla.getValueAt(i, 1).toString();
                String raza = modeloTabla.getValueAt(i, 2).toString();
                String fecha = modeloTabla.getValueAt(i, 3).toString();
                String sexo = modeloTabla.getValueAt(i, 4).toString();
                String especie = modeloTabla.getValueAt(i, 5).toString();

                // Escribir los datos en una línea del archivo
                printWriter.println(nombre + "," + propietario + "," + raza + "," + fecha + "," + sexo + "," + especie);
            }

            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Error al actualizar el archivo de texto: " + ex.getMessage());
        }
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        txtNombre.setText("");
        txtPropietario.setText("");
        txtRaza.setText("");
        dtFecha.setDate(null);
        btgEspecie.clearSelection();
        btgGenero.clearSelection();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            // Configura el aspecto y la sensación de JTattoo TextureLookAndFeel
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VeterinariaFrame frame = new VeterinariaFrame();
                frame.setLocationRelativeTo(null); // Centrar la ventana
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgEspecie;
    private javax.swing.ButtonGroup btgGenero;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalida;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbCanino;
    private javax.swing.JRadioButton rdbFelino;
    private javax.swing.JRadioButton rdbHembra;
    private javax.swing.JRadioButton rdbMacho;
    private javax.swing.JTable tableVeterinaria;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
