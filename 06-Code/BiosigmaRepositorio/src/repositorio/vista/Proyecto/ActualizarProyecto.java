package repositorio.vista.Proyecto;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import repositorio.modelo.Proyecto;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.controlador.ProyectoServicio;
import repositorio.vista.Admin.InterfazAdminJFrame;
import repositorio.vista.trabajador.InterfazTrabajadorJFrame;

public class ActualizarProyecto extends javax.swing.JInternalFrame {

    Proyecto proyecto;

    public ActualizarProyecto() {
        initComponents();
        consultarDatos();
    }

    private String obtenercodigointerfacez() {
        String codigo = "";
        if (InterfazAdminJFrame.getCodigoProyecto() != "") {
            codigo = InterfazAdminJFrame.getCodigoProyecto();

        } else if (InterfazTrabajadorJFrame.getCodigoProyecto() != "") {
            codigo = InterfazTrabajadorJFrame.getCodigoProyecto();

        }
        return codigo;
    }

    private boolean validarDatos() {
        if ((txtNombreProyecto.getText().length() > 0) && (txtDescripcionProyecto.getText().length() > 0) && (dcFechaInicioProyecto.getDate() != null) && (rdEnProgreso.isSelected() || dcFechaFinalProyecto != null)) {
            return true;
        } else {
            if (txtNombreProyecto.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puede dejar el Nombre vacío");
            }
            if (txtDescripcionProyecto.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puede dejar la descipción vacía");
            }
            if (dcFechaInicioProyecto.getDate() == null) {
                JOptionPane.showMessageDialog(null, "No puede dejar la fecha de inicio vacía");
            }
            if (!rdEnProgreso.isSelected() && dcFechaFinalProyecto == null) {
                JOptionPane.showMessageDialog(null, "Si aun no ha finalizado el proyecto, sleccione en progreso");
            }
            return false;
        }
    }

    private void abrirArchivoProyecto(byte[] archivo) {
        if (archivo != null) {
            try {
                Path tempPdf = Files.createTempFile("Archivo Guardado", ".pdf");
                Files.copy(new ByteArrayInputStream(archivo), tempPdf, StandardCopyOption.REPLACE_EXISTING);

                Desktop.getDesktop().open(tempPdf.toFile());
            } catch (IOException ex) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado el documento aún");
        }
    }

    private byte[] seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo");

        int result = fileChooser.showOpenDialog(null);
        byte[] pdfBytes = null;

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pdfBytes;
    }

    private void consultarDatos() {

        try {
            proyecto = ProyectoServicio.BuscarProyecto(obtenercodigointerfacez());
            txtCodigo.setText(proyecto.getIdProyecto());
            txtNombreProyecto.setText(proyecto.getNombreProyecto());
            dcFechaInicioProyecto.setDate(proyecto.getFechaInicio());
            lbPermisoAmbiental.setVisible(false);
            lbPermisoAgua.setVisible(false);
            lbAuditoria.setVisible(false);
            lbMonitoreo.setVisible(false);

            if (proyecto.getFechaFinal() != null) {
                dcFechaFinalProyecto.setDate(proyecto.getFechaFinal());
                rdEnProgreso.setSelected(false);
            } else {
                rdEnProgreso.setSelected(true);
                dcFechaFinalProyecto.setEnabled(false);
            }
            txtDescripcionProyecto.setText(proyecto.getDescripcionProyecto());
            String recordatorio;
            if (proyecto.getRecordatorioProyecto() != null) {
                recordatorio = proyecto.getRecordatorioProyecto();
            } else {
                recordatorio = "No existen recordatorios";
            }
            txtRecordatorio.setText(recordatorio);

            if (proyecto.getPermisoAmbiental() != null) {
                lbPermisoAmbiental.setVisible(true);
            }
            if (proyecto.getPermisoAgua() != null) {
                lbPermisoAgua.setVisible(true);
            }
            if (proyecto.getAuditoria() != null) {
                lbAuditoria.setVisible(true);
            }
            if (proyecto.getMonitoreo() != null) {
                lbMonitoreo.setVisible(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar la información del proyecto");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelActualizarProyecto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnRegresarPanelTabla = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDescripcionProyecto = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRecordatorio = new javax.swing.JTextArea();
        dcFechaInicioProyecto = new com.toedter.calendar.JDateChooser();
        dcFechaFinalProyecto = new com.toedter.calendar.JDateChooser();
        rdEnProgreso = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        btPermisoAmbiental = new javax.swing.JButton();
        btPermisoAgua = new javax.swing.JButton();
        btAuditorias = new javax.swing.JButton();
        btMonitoreo = new javax.swing.JButton();
        cambiarMonitoreo = new javax.swing.JButton();
        cambiarAmbiental = new javax.swing.JButton();
        cambiarAgua = new javax.swing.JButton();
        cambiarAuditoria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lbPermisoAmbiental = new javax.swing.JLabel();
        lbPermisoAgua = new javax.swing.JLabel();
        lbAuditoria = new javax.swing.JLabel();
        lbMonitoreo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PanelActualizarProyecto.setBackground(new java.awt.Color(255, 255, 204));
        PanelActualizarProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("Actualizar Proyecto");
        PanelActualizarProyecto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 37));

        btnRegresarPanelTabla.setText("Regresar");
        btnRegresarPanelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTablaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btnRegresarPanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jLabel31.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 0, 51));
        jLabel31.setText("Fecha de Finalización:");
        PanelActualizarProyecto.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 136, -1));

        jLabel23.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 51));
        jLabel23.setText("Nombre Del Proyecto:");
        PanelActualizarProyecto.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 136, -1));
        PanelActualizarProyecto.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 136, -1));

        jLabel32.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 0, 51));
        jLabel32.setText("Fecha de Inicio:");
        PanelActualizarProyecto.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 136, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(153, 153, 153));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        PanelActualizarProyecto.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 136, -1));

        jLabel33.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 0, 51));
        jLabel33.setText("Código de Proyecto:");
        PanelActualizarProyecto.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel34.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 0, 51));
        jLabel34.setText("Descripción del proyecto:");
        PanelActualizarProyecto.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 156, -1));

        txtDescripcionProyecto.setColumns(20);
        txtDescripcionProyecto.setRows(5);
        jScrollPane8.setViewportView(txtDescripcionProyecto);

        PanelActualizarProyecto.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 277, 133));

        jLabel35.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 0, 51));
        jLabel35.setText("Recordatorios:");
        PanelActualizarProyecto.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 156, -1));

        txtRecordatorio.setColumns(20);
        txtRecordatorio.setRows(5);
        jScrollPane9.setViewportView(txtRecordatorio);

        PanelActualizarProyecto.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 270, 130));
        PanelActualizarProyecto.add(dcFechaInicioProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 136, -1));
        PanelActualizarProyecto.add(dcFechaFinalProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 136, -1));

        rdEnProgreso.setForeground(new java.awt.Color(51, 0, 51));
        rdEnProgreso.setText("En progreso");
        rdEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEnProgresoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(rdEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel40.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 0, 51));
        jLabel40.setText("Actividad");

        jButton9.setText("Agregar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar actividad", jPanel3);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel38.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 0, 51));
        jLabel38.setText("Actividad");

        jButton11.setText("Actualizar");

        jRadioButton1.setText("Completada");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("En progreso");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Evidencia");

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Cambiar archivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Actualizar actividad", jPanel1);

        PanelActualizarProyecto.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 280, 230));

        jButton10.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jButton10.setText("Actualizar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, -1, 45));

        tbActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividades", "Completado", "Fecha realizada", "Evidencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(tbActividades);

        PanelActualizarProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 480, 230));

        btPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ecoicon01_122073.png"))); // NOI18N
        btPermisoAmbiental.setText("Permiso Ambiental");
        btPermisoAmbiental.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 170, -1));

        btPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/water_23838.png"))); // NOI18N
        btPermisoAgua.setText("Permiso de Agua");
        btPermisoAgua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 170, -1));

        btAuditorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/audit_icon_155782.png"))); // NOI18N
        btAuditorias.setText("Auditoria");
        btAuditorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 170, -1));

        btMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/monitoring-icon_icon-icons.com_55736.png"))); // NOI18N
        btMonitoreo.setText("Monitoreo");
        btMonitoreo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 170, -1));

        cambiarMonitoreo.setBackground(new java.awt.Color(204, 204, 255));
        cambiarMonitoreo.setText("Cambiar archivo");
        cambiarMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarMonitoreoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, -1, -1));

        cambiarAmbiental.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAmbiental.setText("Cambiar archivo");
        cambiarAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAmbientalActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, -1));

        cambiarAgua.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAgua.setText("Cambiar archivo");
        cambiarAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAguaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, -1, -1));

        cambiarAuditoria.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAuditoria.setText("Cambiar archivo");
        cambiarAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAuditoriaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/jaguar_prueba_3_742563 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 261, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 280, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));
        PanelActualizarProyecto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 1080, -1));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("(Si aun no finaliza el proyecto seleccione en progreso)");
        PanelActualizarProyecto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, -1));

        lbPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        lbPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));

        lbAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        lbMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        jLabel22.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setText("Plan de Manejo Ambiental");
        PanelActualizarProyecto.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoActualizarProyecto.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarPanelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTablaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarPanelTablaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isLetter(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente numeros");

        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void rdEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEnProgresoActionPerformed
        if (rdEnProgreso.isSelected()) {
            dcFechaFinalProyecto.setEnabled(false);
            dcFechaFinalProyecto.setDate(null);
        } else {
            dcFechaFinalProyecto.setEnabled(true);
        }
    }//GEN-LAST:event_rdEnProgresoActionPerformed

    private void btPermisoAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAmbientalActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAmbiental());
    }//GEN-LAST:event_btPermisoAmbientalActionPerformed

    private void btPermisoAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAguaActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAgua());
    }//GEN-LAST:event_btPermisoAguaActionPerformed

    private void btAuditoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuditoriasActionPerformed
        abrirArchivoProyecto(proyecto.getAuditoria());
    }//GEN-LAST:event_btAuditoriasActionPerformed

    private void btMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoreoActionPerformed
        abrirArchivoProyecto(proyecto.getMonitoreo());
    }//GEN-LAST:event_btMonitoreoActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (validarDatos()) {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de actualizar el proyecto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                proyecto.setNombreProyecto(txtNombreProyecto.getText());
                proyecto.setDescripcionProyecto(txtDescripcionProyecto.getText());
                proyecto.setFechaInicio(dcFechaInicioProyecto.getDate());

                if (rdEnProgreso.isSelected()) {
                    proyecto.setFechaFinal(null);
                } else {
                    proyecto.setFechaFinal(dcFechaFinalProyecto.getDate());
                }
                ProyectoServicio.ActualizarProyecto(proyecto);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cambiarAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAmbientalActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAmbiental(pdfBytes);
            lbPermisoAmbiental.setVisible(true);
        }
    }//GEN-LAST:event_cambiarAmbientalActionPerformed

    private void cambiarAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAguaActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAgua(pdfBytes);
            lbPermisoAgua.setVisible(true);
        }
    }//GEN-LAST:event_cambiarAguaActionPerformed

    private void cambiarAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAuditoriaActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setAuditoria(pdfBytes);
        }
    }//GEN-LAST:event_cambiarAuditoriaActionPerformed

    private void cambiarMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarMonitoreoActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setMonitoreo(pdfBytes);
        }
    }//GEN-LAST:event_cambiarMonitoreoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelActualizarProyecto;
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla;
    private javax.swing.JButton cambiarAgua;
    private javax.swing.JButton cambiarAmbiental;
    private javax.swing.JButton cambiarAuditoria;
    private javax.swing.JButton cambiarMonitoreo;
    private com.toedter.calendar.JDateChooser dcFechaFinalProyecto;
    private com.toedter.calendar.JDateChooser dcFechaInicioProyecto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbAuditoria;
    private javax.swing.JLabel lbMonitoreo;
    private javax.swing.JLabel lbPermisoAgua;
    private javax.swing.JLabel lbPermisoAmbiental;
    private javax.swing.JRadioButton rdEnProgreso;
    private javax.swing.JTable tbActividades;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcionProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextArea txtRecordatorio;
    // End of variables declaration//GEN-END:variables
}