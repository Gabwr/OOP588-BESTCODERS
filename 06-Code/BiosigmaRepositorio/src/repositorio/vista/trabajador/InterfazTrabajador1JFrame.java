package repositorio.vista.trabajador;

import repositorio.vista.proyecto.AbrirProyecto;
import repositorio.vista.proyecto.ActualizarProyecto;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import repositorio.controlador.ProyectoServicio;
import repositorio.controlador.ServicioPersonas;
import repositorio.modelo.Personas;
import repositorio.modelo.Proyecto;
import repositorio.vista.InterfazLogin;

public class InterfazTrabajador1JFrame extends javax.swing.JFrame {

    private int contador = 1;
    public int fila = -1;
    int filaseleccionadaAdmin = -1;
    int filaseleccionadaCliente = -1;
    int filaseleccionadaTrabajador = -1;
    private static String codigoProyecto = "";
    public static String codigoUsuario = "";
    private DefaultTableModel dtm = null;

    public static String getCodigoProyecto() {
        return codigoProyecto;
    }

    public InterfazTrabajador1JFrame() {
        initComponents();
        llenarTablaProyectos();
        this.setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27));
        cargarDatosLogin();
        PanelBiosigmaLogo.setBackground(new Color(0, 0, 0, 160));
        panelDescripcion.setBackground(new Color(0, 0, 0, 100));
        panelOpciones.setBackground(new Color(0, 0, 0, 160));
        panelOpciones.setVisible(false);
        setIconImage(getIconImage());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resource/colibri_png.png"));
        return retValue;
    }

    public void cargarDatosLogin() {
        Personas login = ServicioPersonas.BuscarPorCodigoClienteyAdmin(InterfazLogin.idPersona);
        txtNombreIngreso.setText(login.getNombre());
        txtCorreoIngreso.setText(login.getCorreo());
    }

    public static void llenarTablaProyectos() {
        DefaultTableModel dtm = (DefaultTableModel) tbProyecto.getModel();
        dtm.setRowCount(0);
        for (Proyecto proyecto : ProyectoServicio.listaProyectos()) {
            String fechaaInicio, fechaFinal, permisoAmbiental, permisoAgua, auditoria, monitoreo;

            fechaaInicio = new SimpleDateFormat("dd/MM/yyyy").format(proyecto.getFechaInicio());

            if (proyecto.getFechaFinal() == null) {
                fechaFinal = "En progreso";
            } else {
                fechaFinal = new SimpleDateFormat("dd/MM/yyyy").format(proyecto.getFechaFinal());
            }
            if (proyecto.getPermisoAmbiental() == null) {
                permisoAmbiental = "Por cargar";
            } else {
                permisoAmbiental = "Cargado";
            }
            if (proyecto.getPermisoAgua() == null) {
                permisoAgua = "Por cargar";
            } else {
                permisoAgua = "Cargado";
            }
            if (proyecto.getAuditoria() == null) {
                auditoria = "Por cargar";
            } else {
                auditoria = "Cargado";
            }
            if (proyecto.getMonitoreo() == null) {
                monitoreo = "Por cargar";
            } else {
                monitoreo = "Cargado";
            }

            dtm.addRow(new Object[]{proyecto.getIdProyecto(), proyecto.getNombreProyecto(), fechaaInicio, fechaFinal, permisoAmbiental, permisoAgua, auditoria, monitoreo});
        }
    }


    private static int recuperarAnioNacimiento(Date anioNacimiento) {
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy");
        String anioNacimientoCadena = f1.format(anioNacimiento);
        int anio = Integer.parseInt(anioNacimientoCadena);
        return anio;
    }

    private static int calcularEdad(int anioNacimiento) {
        LocalDate actual = LocalDate.now();

        int anioActual = actual.getYear();

        int edad = anioActual - anioNacimiento;
        return edad;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        panelBotones1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        PanelBiosigmaLogo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreoIngreso = new javax.swing.JTextField();
        txtNombreIngreso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotonProyectos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        panelPestañas = new javax.swing.JPanel();
        tbPaneles = new javax.swing.JTabbedPane();
        panelPresentacion = new javax.swing.JPanel();
        panelDescripcion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelProyectos = new javax.swing.JPanel();
        panelTablaProyectos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProyecto = new javax.swing.JTable();
        btnAbrirProyecto = new javax.swing.JButton();
        btnActualizarProyecto = new javax.swing.JButton();
        btnRegresarProyectos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        BotonOpciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btInfoProgramador = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotones1.setBackground(new java.awt.Color(0, 204, 153));
        panelBotones1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(101, 206, 97));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel41.setBackground(new java.awt.Color(102, 255, 51));
        jLabel41.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBotones1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 40));

        PanelBiosigmaLogo.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N

        javax.swing.GroupLayout PanelBiosigmaLogoLayout = new javax.swing.GroupLayout(PanelBiosigmaLogo);
        PanelBiosigmaLogo.setLayout(PanelBiosigmaLogoLayout);
        PanelBiosigmaLogoLayout.setHorizontalGroup(
            PanelBiosigmaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBiosigmaLogoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(55, 55, 55))
        );
        PanelBiosigmaLogoLayout.setVerticalGroup(
            PanelBiosigmaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBiosigmaLogoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBotones1.add(PanelBiosigmaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 60));

        txtCorreoIngreso.setEditable(false);
        txtCorreoIngreso.setBackground(new java.awt.Color(204, 255, 204));
        txtCorreoIngreso.setFont(new java.awt.Font("Sitka Banner", 1, 21)); // NOI18N
        txtCorreoIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoIngreso.setBorder(null);
        panelBotones1.add(txtCorreoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 30));

        txtNombreIngreso.setEditable(false);
        txtNombreIngreso.setBackground(new java.awt.Color(204, 255, 204));
        txtNombreIngreso.setFont(new java.awt.Font("Sitka Banner", 1, 21)); // NOI18N
        txtNombreIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreIngreso.setBorder(null);
        panelBotones1.add(txtNombreIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 30));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoBienvenidos.png"))); // NOI18N
        panelBotones1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 230, 100));

        BotonProyectos.setBackground(new java.awt.Color(0, 204, 153));
        BotonProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(51, 0, 51));
        jLabel5.setFont(new java.awt.Font("Sitka Display", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Proyectos");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonProyectos.png"))); // NOI18N

        javax.swing.GroupLayout BotonProyectosLayout = new javax.swing.GroupLayout(BotonProyectos);
        BotonProyectos.setLayout(BotonProyectosLayout);
        BotonProyectosLayout.setHorizontalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        BotonProyectosLayout.setVerticalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonProyectosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        panelBotones1.add(BotonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/colibri_png.png"))); // NOI18N
        panelBotones1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 160, 170));

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Cerrar Sesión");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBotones1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        jLabel29.setBackground(new java.awt.Color(255, 51, 51));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoBienvenidos.png"))); // NOI18N
        panelBotones1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 100));

        jPanel5.add(panelBotones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 720));

        panelPestañas.setBackground(new java.awt.Color(0, 153, 102));

        tbPaneles.setBackground(new java.awt.Color(255, 255, 255));
        tbPaneles.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        panelPresentacion.setBackground(new java.awt.Color(190, 249, 132));
        panelPresentacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDescripcion.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/oso5 (1).png"))); // NOI18N

        javax.swing.GroupLayout panelDescripcionLayout = new javax.swing.GroupLayout(panelDescripcion);
        panelDescripcion.setLayout(panelDescripcionLayout);
        panelDescripcionLayout.setHorizontalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescripcionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        panelDescripcionLayout.setVerticalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        panelPresentacion.add(panelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 183, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 153, 102));
        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("BIOSIGMA REPOSITORIO");
        panelPresentacion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 22, -1, -1));

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Sitka Banner", 1, 16)); // NOI18N
        jTextArea5.setForeground(new java.awt.Color(0, 51, 0));
        jTextArea5.setRows(5);
        jTextArea5.setText("Nace de la unión de palabras que enfocan nuestro \ntrabajo y filosofía: Biología, Sistemas Integrados de Gestión y Medio \nAmbiente.\n\nConceptualmente la letra griega Sigma significa la suma o unión \nde un todo y el conocimiento, por tanto, con nuestro trabajo\npretendemos “Sumar y generar conocimiento”.\n\nNuestro símbolo es el BUHO, animal que tiene un significado de \nconocimiento y sabiduría y que enfoca gráficamente nuestro \nobjetivo de crecimiento y mejoramiento continuo.");
        jTextArea5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane11.setViewportView(jTextArea5);

        panelPresentacion.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 97, 470, 254));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenHidroabanico.jpg"))); // NOI18N
        panelPresentacion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 363, 470, 230));

        jLabel37.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 0, 51));
        jLabel37.setText("¿Qué significa Biosigma?");
        panelPresentacion.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoPresentacion.png"))); // NOI18N
        panelPresentacion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        tbPaneles.addTab("tab1", panelPresentacion);

        panelProyectos.setBackground(new java.awt.Color(51, 0, 51));
        panelProyectos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTablaProyectos.setBackground(new java.awt.Color(204, 204, 255));

        tbProyecto.setBackground(new java.awt.Color(234, 221, 218));
        tbProyecto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbProyecto.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        tbProyecto.setForeground(new java.awt.Color(51, 0, 51));
        tbProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre ", "Fecha Inicio", "Fecha Final", "Permiso Ambiental", "Permiso de Agua", "Auditoria", "Monitoreo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbProyectoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbProyecto);

        btnAbrirProyecto.setFont(new java.awt.Font("Sitka Banner", 0, 14)); // NOI18N
        btnAbrirProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3643772-archive-archives-document-folder-open_113445.png"))); // NOI18N
        btnAbrirProyecto.setText("Abrir Proyecto");
        btnAbrirProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirProyectoActionPerformed(evt);
            }
        });

        btnActualizarProyecto.setFont(new java.awt.Font("Sitka Banner", 0, 14)); // NOI18N
        btnActualizarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        btnActualizarProyecto.setText("Actualizar Proyecto");
        btnActualizarProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProyectoActionPerformed(evt);
            }
        });

        btnRegresarProyectos.setFont(new java.awt.Font("Sitka Banner", 0, 14)); // NOI18N
        btnRegresarProyectos.setText("Regresar");
        btnRegresarProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarProyectosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Haga click en el proyecto que desee en la siguiente tabla para poder abrirlo");

        jButton2.setFont(new java.awt.Font("Sitka Banner", 0, 14)); // NOI18N
        jButton2.setText("Limpiar Selección");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaProyectosLayout = new javax.swing.GroupLayout(panelTablaProyectos);
        panelTablaProyectos.setLayout(panelTablaProyectosLayout);
        panelTablaProyectosLayout.setHorizontalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnRegresarProyectos)
                        .addGap(18, 18, 18))
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(btnAbrirProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(btnActualizarProyecto)))
                        .addContainerGap(109, Short.MAX_VALUE))))
        );
        panelTablaProyectosLayout.setVerticalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarProyectos)
                    .addComponent(jLabel9)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarProyecto)
                    .addComponent(btnAbrirProyecto))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        panelProyectos.add(panelTablaProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 71, 910, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 204));
        jLabel16.setText("PROYECTOS REGISTRADOS");
        panelProyectos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 6, -1, 59));

        tbPaneles.addTab("tab4", panelProyectos);

        javax.swing.GroupLayout panelPestañasLayout = new javax.swing.GroupLayout(panelPestañas);
        panelPestañas.setLayout(panelPestañasLayout);
        panelPestañasLayout.setHorizontalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPestañasLayout.createSequentialGroup()
                .addComponent(tbPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPestañasLayout.setVerticalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPestañasLayout.createSequentialGroup()
                .addComponent(tbPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 950, 610));

        panelSuperior.setBackground(new java.awt.Color(102, 255, 204));
        panelSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelSuperiorMouseEntered(evt);
            }
        });
        panelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonOpciones.setBackground(new java.awt.Color(102, 255, 204));
        BotonOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonOpciones.png"))); // NOI18N

        javax.swing.GroupLayout BotonOpcionesLayout = new javax.swing.GroupLayout(BotonOpciones);
        BotonOpciones.setLayout(BotonOpcionesLayout);
        BotonOpcionesLayout.setHorizontalGroup(
            BotonOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonOpcionesLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        BotonOpcionesLayout.setVerticalGroup(
            BotonOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonOpcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelSuperior.add(BotonOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 50, -1));

        panelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btInfoProgramador.setBackground(new java.awt.Color(51, 51, 51));
        btInfoProgramador.setForeground(new java.awt.Color(204, 255, 255));
        btInfoProgramador.setText("Información del Programador");
        btInfoProgramador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btInfoProgramador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoProgramadorActionPerformed(evt);
            }
        });
        panelOpciones.add(btInfoProgramador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        panelSuperior.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 290, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Vólcan_Cotopaxi.jpg"))); // NOI18N
        panelSuperior.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 6, 600, 180));

        jPanel5.add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 950, 130));

        escritorio.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInfoProgramadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoProgramadorActionPerformed
        JOptionPane.showMessageDialog(null, "=============================================="
                + "\n\tProgramadores:"
                + "\n1.- Gabriel López"
                + "\n2.- Mateo Medranda"
                + "\n3.- Alejandro Obando"
                + "\n==============================================");
    }//GEN-LAST:event_btInfoProgramadorActionPerformed

    private void BotonOpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseExited
        BotonOpciones.setBackground(new Color(102, 255, 204));
    }//GEN-LAST:event_BotonOpcionesMouseExited

    private void BotonOpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseEntered
        BotonOpciones.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonOpcionesMouseEntered

    private void BotonOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseClicked
        if (contador == 1) {
            panelOpciones.setVisible(true);
            contador = 2;
        } else if (contador == 2) {
            panelOpciones.setVisible(false);
            contador = 1;
        }
    }//GEN-LAST:event_BotonOpcionesMouseClicked

    private void btnRegresarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarProyectosActionPerformed
        tbPaneles.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegresarProyectosActionPerformed

    private void btnActualizarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProyectoActionPerformed
        fila = tbProyecto.getSelectedRow();

        if (fila != -1) {
            codigoProyecto = tbProyecto.getValueAt(fila, 0).toString();
            ActualizarProyecto actualizar = new ActualizarProyecto();
            escritorio.add(actualizar);
            actualizar.show();
            fila = -1;
            codigoProyecto = "";
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Seleccione una proyecto para poder abrir");
        }
    }//GEN-LAST:event_btnActualizarProyectoActionPerformed

    private void btnAbrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirProyectoActionPerformed
        fila = tbProyecto.getSelectedRow();

        if (fila != -1) {
            codigoProyecto = tbProyecto.getValueAt(fila, 0).toString();
            AbrirProyecto abrir = new AbrirProyecto();
            escritorio.add(abrir);
            abrir.show();
            fila = -1;
            codigoProyecto = "";
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Seleccione una proyecto para poder abrir");
        }
    }//GEN-LAST:event_btnAbrirProyectoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InterfazLogin login = new InterfazLogin();
        login.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonProyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseExited
        BotonProyectos.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_BotonProyectosMouseExited

    private void BotonProyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseEntered
        BotonProyectos.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonProyectosMouseEntered

    private void BotonProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseClicked
        tbPaneles.setSelectedIndex(1);
    }//GEN-LAST:event_BotonProyectosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ListSelectionModel tablamodelo = tbProyecto.getSelectionModel();
        tablamodelo.clearSelection();
        fila = -1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbProyectoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProyectoMouseEntered
        llenarTablaProyectos();
    }//GEN-LAST:event_tbProyectoMouseEntered

    private void panelSuperiorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSuperiorMouseEntered
        llenarTablaProyectos();
    }//GEN-LAST:event_panelSuperiorMouseEntered

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazTrabajador1JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonOpciones;
    private javax.swing.JPanel BotonProyectos;
    private javax.swing.JPanel PanelBiosigmaLogo;
    private javax.swing.JButton btInfoProgramador;
    private javax.swing.JButton btnAbrirProyecto;
    private javax.swing.JButton btnActualizarProyecto;
    private javax.swing.JButton btnRegresarProyectos;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JPanel panelBotones1;
    private javax.swing.JPanel panelDescripcion;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPestañas;
    private javax.swing.JPanel panelPresentacion;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelTablaProyectos;
    private javax.swing.JTabbedPane tbPaneles;
    private static javax.swing.JTable tbProyecto;
    private javax.swing.JTextField txtCorreoIngreso;
    private javax.swing.JTextField txtNombreIngreso;
    // End of variables declaration//GEN-END:variables
}
