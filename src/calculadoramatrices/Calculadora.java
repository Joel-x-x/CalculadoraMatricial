/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadoramatrices;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Joel
 */
public class Calculadora extends javax.swing.JFrame {

    // Intanciamos las matrices
    JTextField matrizA[][], matrizB[][];
    // Variables dimensiones de las matrices A y B
    int cA = 2, fA = 2, cB = 2, fB = 2;

    // Variables para movimiento del JFrame
    int mouseX, mouseY;

    // Declaración de la fuente para los campos de cada matriz
    Font font = new Font("Arial", Font.BOLD, 14);

    public Calculadora() {
        initComponents();
        // Ocultar los paneles de procesos al iniciar la calculadora
        panelsumaresta.setVisible(false);
        panelmultiplicacion.setVisible(false);
        panelrespuestamultiplicacion.setVisible(false);

        // Posicionar y dimensionar el JFrame
        this.setBounds(0, 0, 1410, 729);
        this.setLocationRelativeTo(null);

        // Agregar padding a los cuadros que ingresan los datos a la matriz
        txtnumeroa.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtnumerob.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 1));

        // Generar Matriz A y B por defecto 2 x 2
        generarMatA(2, 2);
        generarMatB(2, 2);
    }
    // Variables Matriz A Matriz B Matriz Reusltante C y Matrices Resultante númerador y denominador
    String a[][] = new String[fA][cA];
    String b[][] = new String[fB][cB];
    String c[][] = new String[fA][cA];
    int n[][] = new int[fA][cA];
    int d[][] = new int[fA][cA];

    // Iteradores para Matriz A Matriz B
    int contadori = 0, contadorj = 0;
    int bcontadori = 0, bcontadorj = 0;

    // Proceso para generar Matriz A
    public void generarMatA(int f, int c) {
        // El padding de la izquierda cambia conforme la dimension de las columnas
        int espaciadoX = 0, espaciadoY = 0;
        int setX = 0, setY = 0;

        switch (c) {
            case 2 -> {
                espaciadoX = 120;
                espaciadoY = 30;
            }
            case 3 -> {
                espaciadoX = 100;
                espaciadoY = 10;
            }
            case 4 -> {
                espaciadoX = 80;
                espaciadoY = 10;
            }
        }

        switch (f) {
            case 2:
                espaciadoY = 30;
                break;
            case 3:
                espaciadoY = 10;
                break;
            case 4:
                espaciadoY = 0;
                break;
        }

        setX = espaciadoX;
        setY = espaciadoY;

        matrizA = new JTextField[f][c];

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matrizA[i][j] = new JTextField("1");
                matrizA[i][j].setBounds(setX, setY, 50, 30);
                matrizA[i][j].setHorizontalAlignment(JTextField.CENTER);
                matrizA[i][j].setBackground(new Color(100, 100, 100));
                matrizA[i][j].setFont(font);;
                matrizA[i][j].setForeground(new Color(244, 244, 244));
                matrizA[i][j].setBorder(null);
                setX += 53;
            }
            setX = espaciadoX;
            setY += 33;
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                jpanelma.add(matrizA[i][j]);
                matrizA[i][j].setVisible(false);
            }
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matrizA[i][j].setVisible(true);
            }
        }

    }

    // Proceso para generar Matriz B
    public void generarMatB(int f, int c) {
        // El padding de la izquierda cambia conforme la dimension de las columnas
        int espaciadoX = 0, espaciadoY = 0;
        int setX = 0, setY = 0;

        switch (c) {
            case 2:
                espaciadoX = 90;
                espaciadoY = 30;
                break;
            case 3:
                espaciadoX = 70;
                espaciadoY = 10;
                break;
            case 4:
                espaciadoX = 50;
                espaciadoY = 10;
                break;
        }

        switch (f) {
            case 2:
                espaciadoY = 30;
                break;
            case 3:
                espaciadoY = 10;
                break;
            case 4:
                espaciadoY = 0;
                break;
        }

        setX = espaciadoX;
        setY = espaciadoY;

        matrizB = new JTextField[f][c];

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matrizB[i][j] = new JTextField("1");
                matrizB[i][j].setBounds(setX, setY, 50, 30);
                matrizB[i][j].setHorizontalAlignment(JTextField.CENTER);
                matrizB[i][j].setBackground(new Color(100, 100, 100));
                matrizB[i][j].setFont(font);;
                matrizB[i][j].setForeground(new Color(244, 244, 244));
                matrizB[i][j].setBorder(null);
                setX += 53;
            }
            setX = espaciadoX;
            setY += 33;
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                jpanelmb.add(matrizB[i][j]);
                matrizB[i][j].setVisible(false);
            }
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matrizB[i][j].setVisible(true);
            }
        }

    }

    // Borrar Matriz A
    public void borrarMatrizA() {
        for (int i = 0; i < fA; i++) {
            for (int j = 0; j < cA; j++) {
                jpanelma.add(matrizA[i][j]);
                matrizA[i][j].setVisible(false);
            }
        }
        txtindicea.setText("00");
        contadori = 0;
        contadorj = 0;
    }

    // Borrar Matriz A
    public void borrarMatrizB() {
        for (int i = 0; i < fB; i++) {
            for (int j = 0; j < cB; j++) {
                jpanelmb.add(matrizB[i][j]);
                matrizB[i][j].setVisible(false);
            }
        }
        txtindiceb.setText("00");
        bcontadori = 0;
        bcontadorj = 0;
    }

    // Extraer Datos matrizA
    public void extraerMatrizA() {
        // Resetear los arrays  
        a = new String[fA][cA];
        c = new String[fA][cA];
        n = new int[fA][cA];
        d = new int[fA][cA];

        for (int i = 0; i < fA; i++) {
            for (int j = 0; j < cA; j++) {
                a[i][j] = "0";
                c[i][j] = "0";
                n[i][j] = 0;
                d[i][j] = 0;
            }
        }

        for (int i = 0; i < fA; i++) {
            for (int j = 0; j < cA; j++) {
                a[i][j] = matrizA[i][j].getText();
            }
        }
    }

    // Extraer Datos matrizB
    public void extraerMatrizB() {
        // Resetear los arrays 
        b = new String[fB][cB];
        c = new String[fA][cA];
        n = new int[fA][cA];
        d = new int[fA][cA];
        for (int i = 0; i < fB; i++) {
            for (int j = 0; j < cB; j++) {
                b[i][j] = "0";
                c[i][j] = "0";
                n[i][j] = 0;
                d[i][j] = 0;
            }
        }

        for (int i = 0; i < fB; i++) {
            for (int j = 0; j < cB; j++) {
                b[i][j] = matrizB[i][j].getText();
            }
        }
    }

    // Validar campo para ingresar datos para matrizA
    public boolean validarCampoA() {
        boolean van = true;
        String numeroCampo;
        numeroCampo = txtnumeroa.getText();

        if (numeroCampo.contains("/")) {
            int c = 0, i = 0;

            // Valida que no ingrese un "/" unicamente, ya que si ingresa asi en el siguiente if al sacar "/" dara error al validar 
            // porque no hay más datos entonces van = false para que el siguiente if de false y tambien agregamos 1
            // para que el el siguiente if no de error al intentar usar el split en un "/" unicamente
            if (numeroCampo.equals("/")) {
                van = false;
                txtnumeroa.setText("1");
                numeroCampo = txtnumeroa.getText();
            }

            // Recorre la cadena e itera c por cada "/" que encuentre
            while (i < numeroCampo.length()) {
                if (numeroCampo.charAt(i) == '/') {
                    c++;
                }
                i++;
            }

            // Validamos si hay más de 1 "/" es decir si c > 1 van = false
            if (c > 1) {
                van = false;
                txtnumeroa.setText("1");
                numeroCampo = txtnumeroa.getText();

                // Comparamos que no ingrese la cadena así: "24/", "/52"
            } else if (numeroCampo.substring(numeroCampo.length() - 1).equals("/") || numeroCampo.substring(0, 1).equals("/")) {
                van = false;
                txtnumeroa.setText("1");
                numeroCampo = txtnumeroa.getText();
                // Si el divisor es 0 lo coloco aquí porque da error cuando hay muchos "/////"
            } else if (numeroCampo.length() > 2) {
                if (numeroCampo.split("/")[1].equals("0")) {
                    van = false;
                    txtnumeroa.setText("1");
                    numeroCampo = txtnumeroa.getText();
                }
            }

        }

        // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
        if (numeroCampo.split("/")[0].matches(".*[0-9].*") && van) {
            return true;
        } else {
            return false;
        }

    }

    // Validar campo b
    public boolean validarCampoB() {
        boolean van = true;
        String numeroCampo;
        numeroCampo = txtnumerob.getText();

        if (numeroCampo.contains("/")) {
            int c = 0, i = 0;

            // Valida que no ingrese un "/" solo, ya que si ingresa asi en el siguiente if al sacar "/" dara error al validar 
            // porque no hay más datos entonces van = false para que el siguiente if de false y tambien agregamos 1
            // para que el el siguiente if no de error al intentar usar el split en un "/" solo
            if (numeroCampo.equals("/")) {
                van = false;
                txtnumerob.setText("1");
                numeroCampo = txtnumerob.getText();
            }

            // Recorre la cadena e itera c por cada "/" que encuentre
            while (i < numeroCampo.length()) {
                if (numeroCampo.charAt(i) == '/') {
                    c++;
                }
                i++;
            }

// Validamos si hay más de 1 "/" es decir si c > 1 que de error
            if (c > 1) {
                van = false;
                txtnumerob.setText("1");
                numeroCampo = txtnumerob.getText();

                // Comparamos que no ingrese la cadena así: "24/", "/52"
            } else if (numeroCampo.substring(numeroCampo.length() - 1).equals("/") || numeroCampo.substring(0, 1).equals("/")) {
                van = false;
                txtnumerob.setText("1");
                numeroCampo = txtnumerob.getText();
                // Si el divisor es 0 lo coloco aquí porque da error cuando hay muchos "/////"
            } else if (numeroCampo.length() > 2) {
                if (numeroCampo.split("/")[1].equals("0")) {
                    van = false;
                    txtnumerob.setText("1");
                    numeroCampo = txtnumerob.getText();
                }
            }

        }

        // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
        if (numeroCampo.split("/")[0].matches(".*[0-9].*") && van) {
            return true;
        } else {
            return false;
        }
    }

    // Validar matriz a
    public boolean validarMatrizA() {
        extraerMatrizA();
        boolean van = true, van2 = true, vanFinal = true;
        for (int m = 0; m < fA; m++) {
            for (int n = 0; n < cA; n++) {
                String numeroCampo;
                numeroCampo = a[m][n];
                if (numeroCampo.contains("/")) {
//                System.out.println("Contiene");
                    int c = 0, i = 0;

                    // Valida que no ingrese un "/" solo, ya que si ingresa asi en el siguiente if al sacar "/" dara error al validar 
                    // porque no hay más datos entonces van = false para que el siguiente if de false y tambien agregamos 1
                    // para que el el siguiente if no de error al intentar usar el split en un "/" solo
                    if (numeroCampo.equals("/")) {
//                    System.out.println("equals");
                        van = false;
//                        txtnumerob.setText("1");
                        a[m][n] = "1";
                        numeroCampo = a[m][n];
                    }

                    // Recorre la cadena e itera c por cada "/" que encuentre
                    while (i < numeroCampo.length()) {
                        if (numeroCampo.charAt(i) == '/') {
//                        System.out.println(numeroCampo.charAt(i));
                            c++;
                        }
                        i++;
                    }

                    // Validamos si hay más de 1 "/" es decir si c > 1 que de error
                    if (c > 1) {
                        van = false;
                        a[m][n] = "1";
                        numeroCampo = a[m][n];

                        // Comparamos que no ingrese la cadena así: "24/", "/52"
                    } else if (numeroCampo.substring(numeroCampo.length() - 1).equals("/") || numeroCampo.substring(0, 1).equals("/")) {
                        van = false;
                        a[m][n] = "1";
                        numeroCampo = a[m][n];
                        // Si el divisor es 0 lo coloco aquí porque da error cuando hay muchos "/////"
                    } else if (numeroCampo.length() > 2) {
                        if (numeroCampo.split("/")[1].equals("0")) {
                            van = false;
                            a[m][n] = "1";
                            numeroCampo = a[m][n];
                        }
                    }

                }
                // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
                if (numeroCampo.split("/")[0].matches(".*[0-9].*") && van) {
                    van2 = true;
                } else {
                    van2 = false;
                }
                if (!van2) {
                    vanFinal = false;
                }
            }
        }
        return vanFinal;
    }

    // Validar matriz b
    public boolean validarMatrizB() {
        extraerMatrizB();
        boolean van = true, van2 = true, vanFinal = true;
        for (int m = 0; m < fB; m++) {
            for (int n = 0; n < cB; n++) {
                String numeroCampo;
                numeroCampo = b[m][n];
                if (numeroCampo.contains("/")) {
//                System.out.println("Contiene");
                    int c = 0, i = 0;

                    // Valida que no ingrese un "/" solo, ya que si ingresa asi en el siguiente if al sacar "/" dara error al validar 
                    // porque no hay más datos entonces van = false para que el siguiente if de false y tambien agregamos 1
                    // para que el el siguiente if no de error al intentar usar el split en un "/" solo
                    if (numeroCampo.equals("/")) {
//                    System.out.println("equals");
                        van = false;
                        b[m][n] = "1/1";
                        numeroCampo = b[m][n];
                    }

                    // Recorre la cadena e itera c por cada "/" que encuentre
                    while (i < numeroCampo.length()) {
                        if (numeroCampo.charAt(i) == '/') {
//                        System.out.println(numeroCampo.charAt(i));
                            c++;
                        }
                        i++;
                    }

                    // Validamos si hay más de 1 "/" es decir si c > 1 que de error
                    if (c > 1) {
                        van = false;
                        b[m][n] = "1/1";
                        numeroCampo = b[m][n];

                        // Comparamos que no ingrese la cadena así: "24/", "/52"
                    } else if (numeroCampo.substring(numeroCampo.length() - 1).equals("/") || numeroCampo.substring(0, 1).equals("/")) {
                        van = false;
                        b[m][n] = "1/1";
                        numeroCampo = b[m][n];
                        // Si el divisor es 0 lo coloco aquí porque da error cuando hay muchos "/////"
                    } else if (numeroCampo.length() > 2) {
                        if (numeroCampo.split("/")[1].equals("0")) {
                            van = false;
                            b[m][n] = "1/1";
                            numeroCampo = b[m][n];
                        }
                    }

                }
                // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
                if (numeroCampo.split("/")[0].matches(".*[0-9].*") && van) {
                    van2 = true;
                } else {
                    van2 = false;
                }
                if (!van2) {
                    vanFinal = false;
                }
            }
        }
        return vanFinal;
    }

    // Mostrar mensaje de error
    public void mensajeError(String mensaje) {
        new Mensaje(mensaje).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        n4 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpanelma = new javax.swing.JPanel();
        btnpor = new javax.swing.JButton();
        btnmenos = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnmas = new javax.swing.JButton();
        jpanelmb = new javax.swing.JPanel();
        btnmenosmatriz = new javax.swing.JButton();
        btnmasmatriz = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        panelsumaresta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtprocesof0 = new javax.swing.JLabel();
        txtprocesof1 = new javax.swing.JLabel();
        txtprocesof3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bracketresultadosuma = new javax.swing.JLabel();
        txtresultadof0 = new javax.swing.JLabel();
        txtresultadof1 = new javax.swing.JLabel();
        txtresultadof3 = new javax.swing.JLabel();
        txtprocesof2 = new javax.swing.JLabel();
        txtresultadof2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bracketprocesosuma = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnumeroa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtindicea = new javax.swing.JLabel();
        panelrespuestamultiplicacion = new javax.swing.JPanel();
        txtresultadosf3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bracketresultadomult = new javax.swing.JLabel();
        txtresultadosf0 = new javax.swing.JLabel();
        txtresultadosf1 = new javax.swing.JLabel();
        txtresultadosf2 = new javax.swing.JLabel();
        txtnumerob = new javax.swing.JTextField();
        txtindiceb = new javax.swing.JLabel();
        panelmultiplicacion = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bracketprocesomult = new javax.swing.JLabel();
        txtprocesosf0 = new javax.swing.JLabel();
        txtprocesosf1 = new javax.swing.JLabel();
        txtprocesosf3 = new javax.swing.JLabel();
        txtprocesosf2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelsuperior = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();
        btnminimizar = new javax.swing.JButton();

        n4.setBackground(new java.awt.Color(102, 102, 102));
        n4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        n4.setForeground(new java.awt.Color(204, 204, 204));
        n4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelma.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jpanelmaLayout = new javax.swing.GroupLayout(jpanelma);
        jpanelma.setLayout(jpanelmaLayout);
        jpanelmaLayout.setHorizontalGroup(
            jpanelmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jpanelmaLayout.setVerticalGroup(
            jpanelmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jPanel2.add(jpanelma, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 12, -1, 176));
        jpanelma.getAccessibleContext().setAccessibleName("");

        btnpor.setBackground(new java.awt.Color(204, 204, 204));
        btnpor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnpor.setForeground(new java.awt.Color(0, 0, 0));
        btnpor.setText("x");
        btnpor.setBorder(null);
        btnpor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpor.setPreferredSize(new java.awt.Dimension(15, 22));
        btnpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnporActionPerformed(evt);
            }
        });
        jPanel2.add(btnpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 101, 48, -1));

        btnmenos.setBackground(new java.awt.Color(204, 204, 204));
        btnmenos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnmenos.setForeground(new java.awt.Color(0, 0, 0));
        btnmenos.setText("-");
        btnmenos.setBorder(null);
        btnmenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmenos.setPreferredSize(new java.awt.Dimension(15, 22));
        btnmenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenosActionPerformed(evt);
            }
        });
        jPanel2.add(btnmenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 61, 48, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Matriz B");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 83, -1));

        btnmas.setBackground(new java.awt.Color(204, 204, 204));
        btnmas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnmas.setForeground(new java.awt.Color(0, 0, 0));
        btnmas.setText("+");
        btnmas.setBorder(null);
        btnmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmas.setPreferredSize(new java.awt.Dimension(15, 22));
        btnmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasActionPerformed(evt);
            }
        });
        jPanel2.add(btnmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 21, 48, -1));

        jpanelmb.setBackground(new java.awt.Color(51, 51, 51));
        jpanelmb.setPreferredSize(new java.awt.Dimension(327, 243));

        javax.swing.GroupLayout jpanelmbLayout = new javax.swing.GroupLayout(jpanelmb);
        jpanelmb.setLayout(jpanelmbLayout);
        jpanelmbLayout.setHorizontalGroup(
            jpanelmbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        jpanelmbLayout.setVerticalGroup(
            jpanelmbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jPanel2.add(jpanelmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 12, 329, 176));

        btnmenosmatriz.setBackground(new java.awt.Color(204, 204, 204));
        btnmenosmatriz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnmenosmatriz.setForeground(new java.awt.Color(0, 0, 0));
        btnmenosmatriz.setText("-");
        btnmenosmatriz.setBorder(null);
        btnmenosmatriz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmenosmatriz.setPreferredSize(new java.awt.Dimension(15, 22));
        btnmenosmatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenosmatrizActionPerformed(evt);
            }
        });
        jPanel2.add(btnmenosmatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 184, 30, -1));

        btnmasmatriz.setBackground(new java.awt.Color(204, 204, 204));
        btnmasmatriz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnmasmatriz.setForeground(new java.awt.Color(0, 0, 0));
        btnmasmatriz.setText("+");
        btnmasmatriz.setBorder(null);
        btnmasmatriz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmasmatriz.setPreferredSize(new java.awt.Dimension(15, 22));
        btnmasmatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasmatrizActionPerformed(evt);
            }
        });
        jPanel2.add(btnmasmatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 184, 30, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Matriz A");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 83, -1));

        panelsumaresta.setBackground(new java.awt.Color(102, 102, 102));
        panelsumaresta.setPreferredSize(new java.awt.Dimension(650, 130));
        panelsumaresta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("[");
        panelsumaresta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 150));

        txtprocesof0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesof0.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesof0.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtprocesof0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 710, 24));

        txtprocesof1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesof1.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesof1.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtprocesof1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 710, 24));

        txtprocesof3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesof3.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesof3.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtprocesof3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 710, 24));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("=");
        panelsumaresta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, 29));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("[");
        panelsumaresta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        bracketresultadosuma.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        bracketresultadosuma.setForeground(new java.awt.Color(204, 204, 204));
        bracketresultadosuma.setText("]");
        panelsumaresta.add(bracketresultadosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 30, -1, -1));

        txtresultadof0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadof0.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadof0.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtresultadof0, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, 400, 24));

        txtresultadof1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadof1.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadof1.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtresultadof1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 400, 24));

        txtresultadof3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadof3.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadof3.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtresultadof3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 400, 24));

        txtprocesof2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesof2.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesof2.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtprocesof2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 710, 24));

        txtresultadof2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadof2.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadof2.setPreferredSize(new java.awt.Dimension(22, 15));
        panelsumaresta.add(txtresultadof2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 400, 24));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Proceso:");
        panelsumaresta.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 83, -1));

        bracketprocesosuma.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        bracketprocesosuma.setForeground(new java.awt.Color(204, 204, 204));
        bracketprocesosuma.setText("]");
        panelsumaresta.add(bracketprocesosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, 150));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Resultado:");
        panelsumaresta.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 83, -1));

        txtnumeroa.setBackground(new java.awt.Color(102, 102, 102));
        txtnumeroa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtnumeroa.setForeground(new java.awt.Color(204, 204, 204));
        txtnumeroa.setBorder(null);
        txtnumeroa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroaActionPerformed(evt);
            }
        });
        txtnumeroa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeroaKeyPressed(evt);
            }
        });

        txtindicea.setBackground(new java.awt.Color(51, 51, 51));
        txtindicea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtindicea.setForeground(new java.awt.Color(204, 204, 204));
        txtindicea.setText("00");

        panelrespuestamultiplicacion.setBackground(new java.awt.Color(102, 102, 102));
        panelrespuestamultiplicacion.setPreferredSize(new java.awt.Dimension(650, 130));
        panelrespuestamultiplicacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtresultadosf3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadosf3.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadosf3.setPreferredSize(new java.awt.Dimension(22, 15));
        panelrespuestamultiplicacion.add(txtresultadosf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 400, 24));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Resultado:");
        panelrespuestamultiplicacion.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 83, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("=");
        panelrespuestamultiplicacion.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 29));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("[");
        panelrespuestamultiplicacion.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        bracketresultadomult.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        bracketresultadomult.setForeground(new java.awt.Color(204, 204, 204));
        bracketresultadomult.setText("]");
        panelrespuestamultiplicacion.add(bracketresultadomult, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        txtresultadosf0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadosf0.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadosf0.setPreferredSize(new java.awt.Dimension(22, 15));
        panelrespuestamultiplicacion.add(txtresultadosf0, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 400, 24));

        txtresultadosf1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadosf1.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadosf1.setPreferredSize(new java.awt.Dimension(22, 15));
        panelrespuestamultiplicacion.add(txtresultadosf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 400, 24));

        txtresultadosf2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtresultadosf2.setForeground(new java.awt.Color(204, 204, 204));
        txtresultadosf2.setPreferredSize(new java.awt.Dimension(22, 15));
        panelrespuestamultiplicacion.add(txtresultadosf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 400, 24));

        txtnumerob.setBackground(new java.awt.Color(102, 102, 102));
        txtnumerob.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtnumerob.setForeground(new java.awt.Color(204, 204, 204));
        txtnumerob.setBorder(null);
        txtnumerob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumerobActionPerformed(evt);
            }
        });
        txtnumerob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumerobKeyPressed(evt);
            }
        });

        txtindiceb.setBackground(new java.awt.Color(51, 51, 51));
        txtindiceb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtindiceb.setForeground(new java.awt.Color(204, 204, 204));
        txtindiceb.setText("00");

        panelmultiplicacion.setBackground(new java.awt.Color(102, 102, 102));
        panelmultiplicacion.setMinimumSize(new java.awt.Dimension(1409, 170));
        panelmultiplicacion.setPreferredSize(new java.awt.Dimension(650, 130));
        panelmultiplicacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("[");
        panelmultiplicacion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        bracketprocesomult.setFont(new java.awt.Font("Arial", 0, 130)); // NOI18N
        bracketprocesomult.setForeground(new java.awt.Color(204, 204, 204));
        bracketprocesomult.setText("]");
        panelmultiplicacion.add(bracketprocesomult, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 20, -1, -1));

        txtprocesosf0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesosf0.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesosf0.setPreferredSize(new java.awt.Dimension(22, 15));
        panelmultiplicacion.add(txtprocesosf0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 1260, 24));

        txtprocesosf1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesosf1.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesosf1.setPreferredSize(new java.awt.Dimension(22, 15));
        panelmultiplicacion.add(txtprocesosf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 1260, 24));

        txtprocesosf3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesosf3.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesosf3.setPreferredSize(new java.awt.Dimension(22, 15));
        panelmultiplicacion.add(txtprocesosf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 1260, 24));

        txtprocesosf2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtprocesosf2.setForeground(new java.awt.Color(204, 204, 204));
        txtprocesosf2.setPreferredSize(new java.awt.Dimension(22, 15));
        panelmultiplicacion.add(txtprocesosf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 1260, 24));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Proceso:");
        panelmultiplicacion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 83, -1));

        panelsuperior.setBackground(new java.awt.Color(102, 102, 102));
        panelsuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelsuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelsuperiorMouseDragged(evt);
            }
        });
        panelsuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelsuperiorMousePressed(evt);
            }
        });
        panelsuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsalir.setBackground(new java.awt.Color(102, 102, 102));
        btnsalir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(204, 204, 204));
        btnsalir.setText("×");
        btnsalir.setBorder(null);
        btnsalir.setBorderPainted(false);
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.setFocusPainted(false);
        btnsalir.setPreferredSize(new java.awt.Dimension(15, 22));
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsalirMouseExited(evt);
            }
        });
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        panelsuperior.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 45, -1));

        btnminimizar.setBackground(new java.awt.Color(102, 102, 102));
        btnminimizar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnminimizar.setForeground(new java.awt.Color(204, 204, 204));
        btnminimizar.setText("—");
        btnminimizar.setBorder(null);
        btnminimizar.setBorderPainted(false);
        btnminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnminimizar.setFocusPainted(false);
        btnminimizar.setPreferredSize(new java.awt.Dimension(15, 22));
        btnminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnminimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnminimizarMouseExited(evt);
            }
        });
        btnminimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminimizarActionPerformed(evt);
            }
        });
        panelsuperior.add(btnminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 45, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsumaresta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelrespuestamultiplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelsuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1181, 1181, 1181)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelmultiplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txtnumeroa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtindicea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(325, 325, 325)
                                .addComponent(txtnumerob, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtindiceb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnumeroa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtindicea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumerob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtindiceb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelsumaresta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmultiplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelrespuestamultiplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 930));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void n4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n4ActionPerformed

    }//GEN-LAST:event_n4ActionPerformed

    private void btnporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnporActionPerformed
        extraerMatrizA();
        extraerMatrizB();

        // Verifica si los campos pasaron las validaciones
        if (validarMatrizA() && validarMatrizB()) {
            // Mostramos los paneles de procesos
            panelmultiplicacion.setVisible(true);
            panelrespuestamultiplicacion.setVisible(true);
            panelsumaresta.setVisible(false);

            int filasA = a.length;
            int columnasA = a[0].length;
            int columnasB = b[0].length;

            String procesosMult[] = new String[fA];
            String resultadosMult[] = new String[cA];

            // Declarar los arrays para poder autosumar
            for (int i = 0; i < fA; i++) {
                procesosMult[i] = "( ";
                resultadosMult[i] = "";
            }

            // Limipiamos los labes que contienen los procesos
            txtprocesosf0.setText("");
            txtprocesosf1.setText("");
            txtprocesosf2.setText("");
            txtprocesosf3.setText("");

            txtresultadosf0.setText("");
            txtresultadosf1.setText("");
            txtresultadosf2.setText("");
            txtresultadosf3.setText("");

            // Multiplicación
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    for (int k = 0; k < columnasA; k++) {
                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int numerador = 0, denominador = 0, divisor = 1;

                        // Fracciones
                        if (a[i][k].contains("/") && b[k][j].contains("/")) {
//                            System.out.println("Fraccion");
                            // Separamos Numerador y Denominador
                            anumerador = Integer.parseInt(a[i][k].split("/")[0]);
                            adenominador = Integer.parseInt(a[i][k].split("/")[1]);

                            bnumerador = Integer.parseInt(b[k][j].split("/")[0]);
                            bdenominador = Integer.parseInt(b[k][j].split("/")[1]);

                            // Multiplicamospanelmaones
                            numerador = anumerador * bnumerador;
                            denominador = bdenominador * adenominador;

                            // Autosuma de numerador y denominador, primera vuelta solo asignar valores
                            if (n[i][j] == 0 && d[i][j] == 0) {
                                n[i][j] = numerador;
                                d[i][j] = denominador;
                            } else {
                                // Numerador = numerador anterior + numerador acutal igual en denominador
                                n[i][j] = ((numerador * ((d[i][j] * denominador) / denominador)) + (n[i][j] * ((d[i][j] * denominador) / d[i][j])));
                                d[i][j] = (d[i][j] * denominador);

                                // Covertir la fracción en positiva si n y d son negativos
                                if (n[i][j] < 0 && d[i][j] < 0) {
                                    n[i][j] = n[i][j] * -1;
                                    d[i][j] = d[i][j] * -1;

                                }

                                // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                                if (n[i][j] == d[i][j]) {
                                    n[i][j] = 1;
                                    d[i][j] = 1;
                                } else if (n[i][j] == 0) {
                                    d[i][j] = 0;
                                    // Negativos 
                                } else if (n[i][j] < 0 || d[i][j] < 0) {
                                    if (n[i][j] > d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }
                                    // Positivos
                                } else if (n[i][j] > 0 && d[i][j] > 0) {

                                    if (n[i][j] < d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }

                                }

                                for (int s = divisor; s >= 1; s--) {
                                    if (n[i][j] % s == 0 && d[i][j] % s == 0) {
                                        n[i][j] = n[i][j] / s;
                                        d[i][j] = d[i][j] / s;
                                    }
                                }

                                // Eliminar denominador si vale panelma                           
                                if (d[i][j] == 1) {
                                    c[i][j] = String.valueOf(n[i][j]);

                                } else {
                                    c[i][j] = String.valueOf(n[i][j] + "/" + d[i][j]);
                                }

                            }

                            // Declaramos proceso a cada fila
                            if (k == fA - 1) {
                                procesosMult[i] += anumerador + "/" + adenominador + " x " + bnumerador + "/" + bdenominador + ")       (";
                            } else {
                                procesosMult[i] += anumerador + "/" + adenominador + " x " + bnumerador + "/" + bdenominador + "   +   ";
                            }

                            // a Fracción
                        } else if (a[i][k].contains("/")) {
                            System.out.println("Fraccion a");
                            // Separamos Numerador y Denominador
                            anumerador = Integer.parseInt(a[i][k].split("/")[0]);
                            adenominador = Integer.parseInt(a[i][k].split("/")[1]);

                            bnumerador = Integer.parseInt(b[k][j]);
                            bdenominador = 1;

                            // Multiplicamos fracciones
                            numerador = anumerador * bnumerador;
                            denominador = bdenominador * adenominador;

                            // Autosuma de numerador y denominador
                            if (n[i][j] == 0 && d[i][j] == 0) {
                                n[i][j] = numerador;
                                d[i][j] = denominador;

                            } else {
                                // Numerador = numerador anterior + numerador acutal igual en denominador
                                n[i][j] = ((numerador * ((d[i][j] * denominador) / denominador)) + (n[i][j] * ((d[i][j] * denominador) / d[i][j])));
                                d[i][j] = (d[i][j] * denominador);

                                // Covertir la fracción en positiva si n y d son negativos
                                if (n[i][j] < 0 && d[i][j] < 0) {
                                    n[i][j] = n[i][j] * -1;
                                    d[i][j] = d[i][j] * -1;

                                }

                                // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                                if (n[i][j] == d[i][j]) {
                                    n[i][j] = 1;
                                    d[i][j] = 1;
                                } else if (n[i][j] == 0) {
                                    d[i][j] = 0;
                                    // Negativos 
                                } else if (n[i][j] < 0 || d[i][j] < 0) {
                                    if (n[i][j] > d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }
                                    // Positivos
                                } else if (n[i][j] > 0 && d[i][j] > 0) {

                                    if (n[i][j] < d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }

                                }

                                for (int s = divisor; s >= 1; s--) {
                                    if (n[i][j] % s == 0 && d[i][j] % s == 0) {
                                        n[i][j] = n[i][j] / s;
                                        d[i][j] = d[i][j] / s;
                                    }
                                }

                                // Eliminar denominador si vale 1
                                if (d[i][j] == 1) {
                                    // Sumamos las matrices
                                    c[i][j] = String.valueOf(n[i][j]);

                                    // Si el númerador es 0
                                } else if (d[i][j] == 0 || n[i][j] == 0) {
                                    c[i][j] = String.valueOf(n[i][j]);

                                } else {
                                    c[i][j] = String.valueOf(n[i][j] + "/" + d[i][j]);
                                }

                            }

                            // Declaramos proceso a cada fila
                            if (k == fA - 1) {
                                procesosMult[i] += (int) anumerador + "/" + (int) adenominador + " x " + (int) bnumerador + "/" + (int) bdenominador + ")       (";
                            } else {
                                procesosMult[i] += (int) anumerador + "/" + (int) adenominador + " x " + (int) bnumerador + "/" + (int) bdenominador + "   +   ";
                            }
                            // Fracción B
                        } else if (b[k][j].contains("/")) {
                            // Separamos Numerador y Denominador
                            anumerador = Integer.parseInt(a[i][k]);
                            adenominador = 1;

                            bnumerador = Integer.parseInt(b[k][j].split("/")[0]);
                            bdenominador = Integer.parseInt(b[k][j].split("/")[1]);

                            // Multiplicamos fracciones
                            numerador = anumerador * bnumerador;
                            denominador = bdenominador * adenominador;

                            // Autosuma de numerador y denominador
                            if (n[i][j] == 0 && d[i][j] == 0) {
                                n[i][j] = numerador;
                                d[i][j] = denominador;
                            } else {
                                // Numerador = numerador anterior + numerador acutal igual en denominador
                                n[i][j] = ((numerador * ((d[i][j] * denominador) / denominador)) + (n[i][j] * ((d[i][j] * denominador) / d[i][j])));
                                d[i][j] = (d[i][j] * denominador);

                                // Covertir la fracción en positiva si n y d son negativos
                                if (n[i][j] < 0 && d[i][j] < 0) {
                                    n[i][j] = n[i][j] * -1;
                                    d[i][j] = d[i][j] * -1;

                                }

                                // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                                if (n[i][j] == d[i][j]) {
                                    n[i][j] = 1;
                                    d[i][j] = 1;
                                } else if (n[i][j] == 0) {
                                    d[i][j] = 0;
                                    // Negativos 
                                } else if (n[i][j] < 0 || d[i][j] < 0) {
                                    if (n[i][j] > d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }
                                    // Positivos
                                } else if (n[i][j] > 0 && d[i][j] > 0) {

                                    if (n[i][j] < d[i][j]) {
                                        divisor = n[i][j];
                                    } else {
                                        divisor = d[i][j];
                                    }

                                }

                                for (int s = divisor; s >= 1; s--) {
                                    if (n[i][j] % s == 0 && d[i][j] % s == 0) {
                                        n[i][j] = n[i][j] / s;
                                        d[i][j] = d[i][j] / s;
                                    }
                                }

                                // Eliminar denominador si vale 1
                                if (d[i][j] == 1) {
                                    // Sumamos las matrices
                                    c[i][j] = String.valueOf(n[i][j]);

                                } else {
                                    c[i][j] = String.valueOf(n[i][j] + "/" + d[i][j]);
                                }

                            }

                            // Declaramos proceso a cada fila
                            if (k == fA - 1) {
                                procesosMult[i] += (int) anumerador + "/" + (int) adenominador + " x " + (int) bnumerador + "/" + (int) bdenominador + ")       (";
                            } else {
                                procesosMult[i] += (int) anumerador + "/" + (int) adenominador + " x " + (int) bnumerador + "/" + (int) bdenominador + "   +   ";
                            }
                            // Enteros
                        } else {
                            anumerador = Integer.parseInt(a[i][k]);
                            adenominador = 1;

                            bnumerador = Integer.parseInt(b[k][j]);
                            bdenominador = 1;

                            // Multiplicamos fracciones
                            numerador = anumerador * bnumerador;
                            denominador = bdenominador * adenominador;

                            // Autosuma de numerador y denominador
                            if (n[i][j] == 0 && d[i][j] == 0) {
                                n[i][j] = numerador;
                                d[i][j] = denominador;
                            } else {
                                // Numerador = numerador anterior + numerador acutal igual en denominador
                                n[i][j] = ((numerador * ((d[i][j] * denominador/*( ﾉ ﾟｰﾟ)ﾉ*/) / denominador)) + (n[i][j] * ((d[i][j] * denominador) / d[i][j])));
                                d[i][j] = (d[i][j] * denominador);

                                // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                                if (n[i][j] == d[i][j]) {
                                    n[i][j] = 1;
                                    d[i][j] = 1;
                                } else if (n[i][j] < d[i][j]) {
                                    divisor = n[i][j];
                                } else {
                                    divisor = d[i][j];
                                }

                                for (int s = divisor; s >= 1; s--) {
                                    if (n[i][j] % s == 0 && d[i][j] % s == 0) {
                                        n[i][j] = n[i][j] / s;
                                        d[i][j] = d[i][j] / s;
                                    }
                                }

                                // Eliminar denominador si vale 1
                                if (d[i][j] == 1) {
                                    // Sumamos las matrices
                                    c[i][j] = String.valueOf(n[i][j]);

                                } else {
                                    c[i][j] = String.valueOf(n[i][j] + "/" + d[i][j]);
                                }

                            }

                            // Imprimir proceso
                            if (k == fA - 1) {
                                procesosMult[i] += a[i][k] + " x " + b[k][j] + ")       (";
                            } else {
                                procesosMult[i] += a[i][k] + " x " + b[k][j] + "   +   ";
                            }

                        }
                    }
                }
            }
            for (int i = 0; i < fA; i++) {
                System.out.println("");
                for (int j = 0; j < cA; j++) {
                    resultadosMult[i] += c[i][j] + "       ";

                }
            }

            // Definir la posición x del bracket en base a la longitud del proceso
            int posicionX = 0, pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, longitud = 0;
            // Definir la posición x del bracket en base a la longitud del resultado
            int posicionXResultado = 0, rf1 = 0, rf2 = 0, rf3 = 0, rf4 = 0, longitudResultado = 0;

            // Mostramos los procesos y resultados ENCUENTA
            if (fA == 2 && cA == 2) {
                txtprocesosf1.setText(procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8));
                txtprocesosf2.setText(procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8));

                txtresultadosf1.setText(resultadosMult[0].trim());
                txtresultadosf2.setText(resultadosMult[1].trim());

                pf1 = procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8).length();
                pf2 = procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8).length();
                pf3 = 0;
                pf4 = 0;

                rf1 = resultadosMult[0].trim().length();
                rf2 = resultadosMult[1].trim().length();
                rf3 = 0;
                rf4 = 0;
            } else if (fA == 3 && cA == 3) {
                txtprocesosf0.setText(procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8));
                txtprocesosf1.setText(procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8));
                txtprocesosf2.setText(procesosMult[2].trim().substring(0, procesosMult[2].trim().length() - 8));

                txtresultadosf0.setText(resultadosMult[0].trim());
                txtresultadosf1.setText(resultadosMult[1].trim());
                txtresultadosf2.setText(resultadosMult[2].trim());

                pf1 = procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8).length();
                pf2 = procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8).length();
                pf3 = procesosMult[2].trim().substring(0, procesosMult[2].trim().length() - 8).length();
                pf4 = 0;

                rf1 = resultadosMult[0].trim().length();
                rf2 = resultadosMult[1].trim().length();
                rf3 = resultadosMult[2].trim().length();

            } else if (fA == 4 && cA == 4) {
                txtprocesosf0.setText(procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8));
                txtprocesosf1.setText(procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8));
                txtprocesosf2.setText(procesosMult[2].trim().substring(0, procesosMult[2].trim().length() - 8));
                txtprocesosf3.setText(procesosMult[3].trim().substring(0, procesosMult[3].trim().length() - 8));

                txtresultadosf0.setText(resultadosMult[0].trim());
                txtresultadosf1.setText(resultadosMult[1].trim());
                txtresultadosf2.setText(resultadosMult[2].trim());
                txtresultadosf3.setText(resultadosMult[3].trim());

                pf1 = procesosMult[0].trim().substring(0, procesosMult[0].trim().length() - 8).length();
                pf2 = procesosMult[1].trim().substring(0, procesosMult[1].trim().length() - 8).length();
                pf3 = procesosMult[2].trim().substring(0, procesosMult[2].trim().length() - 8).length();
                pf4 = procesosMult[3].trim().substring(0, procesosMult[3].trim().length() - 8).length();

                rf1 = resultadosMult[0].trim().length();
                rf2 = resultadosMult[1].trim().length();
                rf3 = resultadosMult[2].trim().length();
                rf4 = resultadosMult[3].trim().length();
            }

            // Obtenemos la longitud del proceso más largo
            if (pf1 >= pf2 && pf1 >= pf3 && pf1 >= pf4) {
                longitud = pf1;
            } else if (pf2 >= pf1 && pf2 >= pf3 && pf2 >= pf4) {
                longitud = pf2;
            } else if (pf3 >= pf2 && pf3 >= pf4) {
                longitud = pf3;
            } else if (pf4 >= pf3) {
                longitud = pf4;
            }
            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionX = longitud * 9;
                    break;
                case 3:
                    posicionX = longitud * 7;
                    break;
                case 4:
                    posicionX = longitud * 6 + 50;
                    break;
                default: ;
            }

            panelmultiplicacion.add(bracketprocesomult, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionX, 20, -1, -1));

            // Obtenemos la longitud del resultado más largo
            if (rf1 >= rf2 && rf1 >= rf3 && rf1 >= rf4) {
                longitudResultado = rf1;
            } else if (rf2 >= rf1 && rf2 >= rf3 && rf2 >= rf4) {
                longitudResultado = rf2;
            } else if (rf3 >= rf2 && rf3 >= rf4) {
                longitudResultado = rf3;
            } else if (rf4 >= rf3) {
                longitudResultado = rf4;
            }

            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionXResultado = longitudResultado * 5 + 100;
                    break;
                case 3:
                    posicionXResultado = longitudResultado * 6 + 100;
                    break;
                case 4:
                    posicionXResultado = longitudResultado * 9;
                    break;
                default: ;
            }

            // Declaramos la posicion en x del elemento
            panelrespuestamultiplicacion.add(bracketresultadomult, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionXResultado, 30, -1, -1));

        } else {
            mensajeError("Error: Campos incorrectos");
        }

    }//GEN-LAST:event_btnporActionPerformed

    private void btnmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasActionPerformed
        // TODO add your handling code here:
        extraerMatrizA();
        extraerMatrizB();
//        System.out.println(a[0][1]);
//        System.out.println(b[0][1]);

        if (validarMatrizA() && validarMatrizB()) {
            panelsumaresta.setVisible(true);
            panelmultiplicacion.setVisible(false);
            panelrespuestamultiplicacion.setVisible(false);

            String procesosSuma[] = new String[fA];
            String resultadosSuma[] = new String[fA];

            // Declarar los arrays para poder autosumar 
            for (int i = 0; i < fA; i++) {
                procesosSuma[i] = "";
                resultadosSuma[i] = "";
            }
            // Resetear Proceso y Resultado de Impresión ENCUENTA
            txtprocesof0.setText("");
            txtprocesof1.setText("");
            txtprocesof2.setText("");
            txtprocesof3.setText("");

            txtresultadof0.setText("");
            txtresultadof1.setText("");
            txtresultadof2.setText("");
            txtresultadof3.setText("");

            // Suma
            for (int i = 0; i < fA; i++) {
                for (int j = 0; j < cA; j++) {
                    // Fracciones
                    if (a[i][j].contains("/") && b[i][j].contains("/")) {
                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = Integer.parseInt(a[i][j].split("/")[1]);

                        bnumerador = Integer.parseInt(b[i][j].split("/")[0]);
                        bdenominador = Integer.parseInt(b[i][j].split("/")[1]);

                        // Sumar Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador + bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 + suma2;
                        }

                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosSuma[i] += anumerador + "/" + adenominador + " + " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar denominador si vale 1
                        if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);
                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "          ";
                        }

                        // a Fracción
                    } else if (a[i][j].contains("/")) {

                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = Integer.parseInt(a[i][j].split("/")[1]);

                        bnumerador = Integer.parseInt(b[i][j]);
                        bdenominador = 1;

                        // Sumar Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador + bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 + suma2;
                        }

                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosSuma[i] += anumerador + "/" + adenominador + " + " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar denominador si vale 1
                        if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);

                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "          ";
                        }

                        // b fracción
                    } else if (b[i][j].contains("/")) {

                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = 1;

                        bnumerador = Integer.parseInt(b[i][j].split("/")[0]);
                        bdenominador = Integer.parseInt(b[i][j].split("/")[1]);

                        // Sumar Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador + bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 + suma2;
                        }

                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosSuma[i] += anumerador + "/" + adenominador + " + " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar denominador si vale 1
                        if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);

                            // Declaramos resultados de cada fila
                            resultadosSuma[i] += c[i][j] + "          ";
                        }

                    } else {
                        int arrayauxa = Integer.parseInt(a[i][j]), arrayauxb = Integer.parseInt(b[i][j]);
                        // Sumamos las matrices
                        c[i][j] = String.valueOf(arrayauxa + arrayauxb);
                        // Declaramos proceso a cada fila
                        procesosSuma[i] += a[i][j] + " + " + b[i][j] + "                ";
                        // Declaramos resultados de cada fila
                        resultadosSuma[i] += c[i][j] + "                ";
                    }

                }
            }
            // Definir la posición x del bracket en base a la longitud del proceso
            int posicionX = 0, pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, longitud = 0;
            // Definir la posición x del bracket en base a la longitud del resultado
            int posicionXResultado = 0, rf1 = 0, rf2 = 0, rf3 = 0, rf4 = 0, longitudResultado = 0;

            // Mostramos los procesos y resultados ENCUENTA
            if (fA == 2 && cA == 2) {
                txtprocesof1.setText(procesosSuma[0].trim());
                txtprocesof2.setText(procesosSuma[1].trim());

                txtresultadof1.setText(resultadosSuma[0].trim());
                txtresultadof2.setText(resultadosSuma[1].trim());

                pf1 = procesosSuma[0].trim().length();
                pf2 = procesosSuma[1].trim().length();
                pf3 = 0;
                pf4 = 0;

                rf1 = resultadosSuma[0].trim().length();
                rf2 = resultadosSuma[1].trim().length();
                rf3 = 0;
                rf4 = 0;
            } else if (fA == 3 && cA == 3) {
                txtprocesof0.setText(procesosSuma[0].trim());
                txtprocesof1.setText(procesosSuma[1].trim());
                txtprocesof2.setText(procesosSuma[2].trim());

                txtresultadof0.setText(resultadosSuma[0].trim());
                txtresultadof1.setText(resultadosSuma[1].trim());
                txtresultadof2.setText(resultadosSuma[2].trim());

                pf1 = procesosSuma[0].trim().length();
                pf2 = procesosSuma[1].trim().length();
                pf3 = procesosSuma[2].trim().length();
                pf4 = 0;

                rf1 = resultadosSuma[0].trim().length();
                rf2 = resultadosSuma[1].trim().length();
                rf3 = resultadosSuma[2].trim().length();
                rf4 = 0;
            } else if (fA == 4 && cA == 4) {
                txtprocesof0.setText(procesosSuma[0].trim());
                txtprocesof1.setText(procesosSuma[1].trim());
                txtprocesof2.setText(procesosSuma[2].trim());
                txtprocesof3.setText(procesosSuma[3].trim());

                txtresultadof0.setText(resultadosSuma[0].trim());
                txtresultadof1.setText(resultadosSuma[1].trim());
                txtresultadof2.setText(resultadosSuma[2].trim());
                txtresultadof3.setText(resultadosSuma[3].trim());

                pf1 = procesosSuma[0].trim().length();
                pf2 = procesosSuma[1].trim().length();
                pf3 = procesosSuma[2].trim().length();
                pf4 = procesosSuma[3].trim().length();

                rf1 = resultadosSuma[0].trim().length();
                rf2 = resultadosSuma[1].trim().length();
                rf3 = resultadosSuma[2].trim().length();
                rf4 = resultadosSuma[3].trim().length();
            }

            // Obtenemos la longitud del proceso más largo
            if (pf1 >= pf2 && pf1 >= pf3 && pf1 >= pf4) {
                longitud = pf1;
            } else if (pf2 >= pf1 && pf2 >= pf3 && pf2 >= pf4) {
                longitud = pf2;
            } else if (pf3 >= pf2 && pf3 >= pf4) {
                longitud = pf3;
            } else if (pf4 >= pf3) {
                longitud = pf4;
            }
            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionX = longitud * 10;
                    break;
                case 3:
                    posicionX = longitud * 8;
                    break;
                case 4:
                    posicionX = longitud * 7;
                    break;
                default: ;
            }

            // Declaramos la posicion en x del elemento
            panelsumaresta.add(bracketprocesosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionX, 30, -1, 150));

            // Obtenemos la longitud del resultado más largo
            if (rf1 >= rf2 && rf1 >= rf3 && rf1 >= rf4) {
                longitudResultado = rf1;
            } else if (rf2 >= rf1 && rf2 >= rf3 && rf2 >= rf4) {
                longitudResultado = rf2;
            } else if (rf3 >= rf2 && rf3 >= rf4) {
                longitudResultado = rf3;
            } else if (rf4 >= rf3) {
                longitudResultado = rf4;
            }
            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionXResultado = longitudResultado * 9 + 870;
                    break;
                case 3:
                    posicionXResultado = longitudResultado * 7 + 870;
                    break;
                case 4:
                    posicionXResultado = longitudResultado * 6 + 870;
                    break;
                default: ;
            }
            // Declaramos la posicion en x del elemento
            panelsumaresta.add(bracketresultadosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionXResultado, 30, -1, -1));

        } else {
            mensajeError("Error: Campos incorrectos");
        }

    }//GEN-LAST:event_btnmasActionPerformed

    private void btnmenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenosActionPerformed
        // TODO add your handling code here:
        extraerMatrizA();
        extraerMatrizB();

        if (validarMatrizA() && validarMatrizB()) {
            panelsumaresta.setVisible(true);
            panelmultiplicacion.setVisible(false);
            panelrespuestamultiplicacion.setVisible(false);

            String procesosResta[] = new String[fA];
            String resultadosResta[] = new String[fA];

            // Declarar los arrays para poder autosumar
            for (int i = 0; i < fA; i++) {
                procesosResta[i] = "";
                resultadosResta[i] = "";
            }

            // Resetear Proceso y Resultado de Impresión ENCUENTA
            txtprocesof0.setText("");
            txtprocesof1.setText("");
            txtprocesof2.setText("");
            txtprocesof3.setText("");

            txtresultadof0.setText("");
            txtresultadof1.setText("");
            txtresultadof2.setText("");
            txtresultadof3.setText("");

            // Resta
            for (int i = 0; i < fA; i++) {
                for (int j = 0; j < cA; j++) {
                    // Fracciones
                    if (a[i][j].contains("/") && b[i][j].contains("/")) {
                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = Integer.parseInt(a[i][j].split("/")[1]);

                        bnumerador = Integer.parseInt(b[i][j].split("/")[0]);
                        bdenominador = Integer.parseInt(b[i][j].split("/")[1]);

                        // Resta Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador - bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 - suma2;
                        }

                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosResta[i] += anumerador + "/" + adenominador + " - " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar si 0/23 mostrar solo 0
                        if (numerador == 0) {
                            // Sumamos las matrices
                            c[i][j] = "0";

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                            // Eliminar denominador si vale 1
                        } else if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "          ";
                        }

                        // a Fracción
                    } else if (a[i][j].contains("/")) {

                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = Integer.parseInt(a[i][j].split("/")[1]);

                        bnumerador = Integer.parseInt(b[i][j]);
                        bdenominador = 1;

                        // Resta Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador + bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 - suma2;
                        }
                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosResta[i] += anumerador + "/" + adenominador + " - " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar si 0/23 mostrar solo 0
                        if (numerador == 0) {
                            // Sumamos las matrices
                            c[i][j] = "0";

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                            // Eliminar denominador si vale 1
                        } else if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "          ";
                        }

                        // b fracción
                    } else if (b[i][j].contains("/")) {

                        int anumerador = 0, adenominador = 0, bnumerador = 0, bdenominador = 0;
                        int divisor = 0, numerador = 0, denominador = 0;

                        // Separamos Numerador y Denominador
                        anumerador = Integer.parseInt(a[i][j].split("/")[0]);
                        adenominador = 1;

                        bnumerador = Integer.parseInt(b[i][j].split("/")[0]);
                        bdenominador = Integer.parseInt(b[i][j].split("/")[1]);

                        // Resta Fracciones 
                        if (adenominador == bdenominador) {
                            numerador = anumerador - bnumerador;
                            denominador = adenominador;
                        } else {
                            int suma1 = 0, suma2 = 0;
                            denominador = adenominador * bdenominador;
                            suma1 = (denominador / adenominador) * anumerador;
                            suma2 = (denominador / bdenominador) * bnumerador;
                            numerador = suma1 - suma2;
                        }
                        // Covertir la fracción en positiva si n y d son negativos
                        if (numerador < 0 && d[i][j] < 0) {
                            numerador = numerador * -1;
                            denominador = denominador * -1;

                        }

                        // Reducir las fracciones tomando como inicio del bucle de divisores al número menor de la fracción
                        if (numerador == denominador) {
                            numerador = 1;
                            denominador = 1;
                        } else if (numerador == 0) {
                            denominador = 0;
                            // Negativos 
                        } else if (numerador < 0 || denominador < 0) {
                            if (numerador > denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }
                            // Positivos
                        } else if (numerador > 0 && denominador > 0) {

                            if (numerador < denominador) {
                                divisor = numerador;
                            } else {
                                divisor = denominador;
                            }

                        }

                        for (int s = divisor; s >= 1; s--) {
                            if (numerador % s == 0 && denominador % s == 0) {
                                numerador = numerador / s;
                                denominador = denominador / s;
                            }
                        }

                        // Declaramos proceso a cada fila
                        procesosResta[i] += anumerador + "/" + adenominador + " - " + bnumerador + "/" + bdenominador + "          ";

                        // Eliminar si 0/23 mostrar solo 0
                        if (numerador == 0) {
                            // Sumamos las matrices
                            c[i][j] = "0";

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                            // Eliminar denominador si vale 1
                        } else if (denominador == 1) {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "                ";
                        } else {
                            // Sumamos las matrices
                            c[i][j] = String.valueOf(numerador + "/" + denominador);

                            // Declaramos resultados de cada fila
                            resultadosResta[i] += c[i][j] + "          ";
                        }

                    } else {
                        int arrayauxa = Integer.parseInt(a[i][j]), arrayauxb = Integer.parseInt(b[i][j]);
                        // Sumamos las matrices
                        c[i][j] = String.valueOf(arrayauxa - arrayauxb);
                        // Declaramos proceso a cada fila
                        procesosResta[i] += a[i][j] + " - " + b[i][j] + "                ";
                        // Declaramos resultados de cada fila
                        resultadosResta[i] += c[i][j] + "                ";
                    }

                }
            }

            // Definir la posición x del bracket en base a la longitud del proceso
            int posicionX = 0, pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, longitud = 0;
            // Definir la posición x del bracket en base a la longitud del resultado
            int posicionXResultado = 0, rf1 = 0, rf2 = 0, rf3 = 0, rf4 = 0, longitudResultado = 0;

            // Mostramos los procesos y resultados ENCUENTA
            if (fA == 2 && cA == 2) {
                txtprocesof1.setText(procesosResta[0].trim());
                txtprocesof2.setText(procesosResta[1].trim());

                txtresultadof1.setText(resultadosResta[0].trim());
                txtresultadof2.setText(resultadosResta[1].trim());

                pf1 = procesosResta[0].trim().length();
                pf2 = procesosResta[1].trim().length();
                pf3 = 0;
                pf4 = 0;

                rf1 = resultadosResta[0].trim().length();
                rf2 = resultadosResta[1].trim().length();
                rf3 = 0;
                rf4 = 0;
            } else if (fA == 3 && cA == 3) {
                txtprocesof0.setText(procesosResta[0].trim());
                txtprocesof1.setText(procesosResta[1].trim());
                txtprocesof2.setText(procesosResta[2].trim());

                txtresultadof0.setText(resultadosResta[0].trim());
                txtresultadof1.setText(resultadosResta[1].trim());
                txtresultadof2.setText(resultadosResta[2].trim());

                pf1 = procesosResta[0].trim().length();
                pf2 = procesosResta[1].trim().length();
                pf3 = procesosResta[2].trim().length();
                pf4 = 0;

                rf1 = resultadosResta[0].trim().length();
                rf2 = resultadosResta[1].trim().length();
                rf3 = resultadosResta[2].trim().length();
                rf4 = 0;
            } else if (fA == 4 && cA == 4) {
                txtprocesof0.setText(procesosResta[0].trim());
                txtprocesof1.setText(procesosResta[1].trim());
                txtprocesof2.setText(procesosResta[2].trim());
                txtprocesof3.setText(procesosResta[3].trim());

                txtresultadof0.setText(resultadosResta[0].trim());
                txtresultadof1.setText(resultadosResta[1].trim());
                txtresultadof2.setText(resultadosResta[2].trim());
                txtresultadof3.setText(resultadosResta[3].trim());

                pf1 = procesosResta[0].trim().length();
                pf2 = procesosResta[1].trim().length();
                pf3 = procesosResta[2].trim().length();
                pf4 = procesosResta[3].trim().length();

                rf1 = resultadosResta[0].trim().length();
                rf2 = resultadosResta[1].trim().length();
                rf3 = resultadosResta[2].trim().length();
                rf4 = resultadosResta[3].trim().length();
            }

            // Obtenemos la longitud del proceso más largo
            if (pf1 >= pf2 && pf1 >= pf3 && pf1 >= pf4) {
                longitud = pf1;
            } else if (pf2 >= pf1 && pf2 >= pf3 && pf2 >= pf4) {
                longitud = pf2;
            } else if (pf3 >= pf2 && pf3 >= pf4) {
                longitud = pf3;
            } else if (pf4 >= pf3) {
                longitud = pf4;
            }

            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionX = longitud * 10;
                    break;
                case 3:
                    posicionX = longitud * 8;
                    break;
                case 4:
                    posicionX = longitud * 7;
                    break;
                default: ;
            }

            // Declaramos la posicion en x del elemento
            panelsumaresta.add(bracketprocesosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionX, 30, -1, 150));

            // Obtenemos la longitud del resultado más largo
            if (rf1 >= rf2 && rf1 >= rf3 && rf1 >= rf4) {
                longitudResultado = rf1;
            } else if (rf2 >= rf1 && rf2 >= rf3 && rf2 >= rf4) {
                longitudResultado = rf2;
            } else if (rf3 >= rf2 && rf3 >= rf4) {
                longitudResultado = rf3;
            } else if (rf4 >= rf3) {
                longitudResultado = rf4;
            }
            // El posionamiento es diferente segun la dimensión por eso el switch
            switch (fA) {
                case 2:
                    posicionXResultado = longitudResultado * 9 + 870;
                    break;
                case 3:
                    posicionXResultado = longitudResultado * 7 + 870;
                    break;
                case 4:
                    posicionXResultado = longitudResultado * 6 + 870;
                    break;
                default: ;
            }
            // Declaramos la posicion en x del elemento
            panelsumaresta.add(bracketresultadosuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionXResultado, 30, -1, -1));

        } else {
            mensajeError("Error: Campos incorrectos");
        }
    }//GEN-LAST:event_btnmenosActionPerformed

    private void txtnumeroaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            String numeroCampo;
            numeroCampo = txtnumeroa.getText();
            a = new String[fA][cA];
            b = new String[fB][cB];
            c = new String[fA][cA];

            // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
            if (validarCampoA()) {
                // Si es Fracción
//                if (numeroCampo.contains("/")) {
                // Comprobamos que el array no se ha llenado
                if (contadori != fA) {
                    // Insertar elemento en array a
                    a[contadori][contadorj] = numeroCampo;
                    // Mostramos elemento dependiendo de su indice
                    matrizA[contadori][contadorj].setText(a[contadori][contadorj]);
                    // Limpiamos el campo textfield
                    txtnumeroa.setText(null);

                    // Incrementamos contadores el if controla que no pasen de 2 porque es una matriz
                    if (contadorj == cA - 1) {
                        contadori++;
                        contadorj = 0;
                    } else {
                        contadorj++;
                    }
                    // Mostramos la posicion en la que ingresara el elemento
                    txtindicea.setText(contadori + "" + contadorj);
                    // Contador para comparar en que campo textfield insertamos el elemnto con un switch
                }
                // Reiniciar el label indice cuando llegue a la ultima posicion
                if (contadori == fA) {
                    txtindicea.setText("00");
                    contadori = 0;
                    contadorj = 0;
                }

                // Una vez lleno el array cambios el color del ultimo indice
                if (contadori == fA - 1 && contadorj == cA - 1) {
                    txtindicea.setForeground(Color.YELLOW);
                } else {
                    txtindicea.setForeground(Color.LIGHT_GRAY);
                }
                // Si es Entero    

                // Final fracción, entero
            } else {
                txtnumeroa.setText(null);
                numeroCampo = txtnumeroa.getText();
                mensajeError("Error: Campos incorrectos");
            }
        } // Key code


    }//GEN-LAST:event_txtnumeroaKeyPressed

    private void txtnumeroaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroaActionPerformed

    private void txtnumerobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumerobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumerobActionPerformed

    private void txtnumerobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerobKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            String numeroCampo;
            numeroCampo = txtnumerob.getText();
            a = new String[fA][cA];
            b = new String[fB][cB];
            c = new String[fA][cA];

            // Valida si una vez sacando el "/" el valor es un número - Validar que ingrese texto
            if (validarCampoB()) {
                // Si es Fracción
//                if (numeroCampo.contains("/")) {
                // Comprobamos que el array no se ha llenado
                if (bcontadori != fB) {
                    // Insertar elemento en array a
                    b[bcontadori][bcontadorj] = numeroCampo;
                    // Mostramos elemento dependiendo de su indice
                    matrizB[bcontadori][bcontadorj].setText(b[bcontadori][bcontadorj]);
                    // Limpiamos el campo textfield
                    txtnumerob.setText(null);

                    // Incrementamos contadores el if controla que no pasen de 2 porque es una matriz
                    if (bcontadorj == cB - 1) {
                        bcontadori++;
                        bcontadorj = 0;
                    } else {
                        bcontadorj++;
                    }
                    // Mostramos la posicion en la que ingresara el elemento
                    txtindiceb.setText(bcontadori + "" + bcontadorj);
                    // Contador para comparar en que campo textfield insertamos el elemnto con un switch
                }
                // Reiniciar el label indice cuando llegue a la ultima posicion
                if (bcontadori == fB) {
                    txtindiceb.setText("00");
                    bcontadori = 0;
                    bcontadorj = 0;
                }

                // Una vez lleno el array cambios el color del ultimo indice
                if (bcontadori == fB - 1 && bcontadorj == cB - 1) {
                    txtindiceb.setForeground(Color.YELLOW);
                } else {
                    txtindiceb.setForeground(Color.LIGHT_GRAY);
                }
                // Si es Entero    

                // Final fracción, entero
            } else {
                txtnumerob.setText(null);
                numeroCampo = txtnumerob.getText();
                mensajeError("Error: Campos incorrectos");
            }
        } // Key code

    }//GEN-LAST:event_txtnumerobKeyPressed

    private void btnmasmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasmatrizActionPerformed
        // TODO add your handling code here:
        if (fA < 4) {
            borrarMatrizA();
            borrarMatrizB();
            fA++;
            cA++;
            fB++;
            cB++;
            generarMatB(fB, cB);
            generarMatA(fA, cA);
            panelsumaresta.setVisible(false);
            panelmultiplicacion.setVisible(false);
            panelrespuestamultiplicacion.setVisible(false);
        }
    }//GEN-LAST:event_btnmasmatrizActionPerformed

    private void btnmenosmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenosmatrizActionPerformed
        // TODO add your handling code here:
        if (fA > 2) {
            borrarMatrizA();
            borrarMatrizB();
            fA--;
            cA--;
            fB--;
            cB--;
            generarMatB(fB, cB);
            generarMatA(fA, cA);
            panelsumaresta.setVisible(false);
            panelmultiplicacion.setVisible(false);
            panelrespuestamultiplicacion.setVisible(false);
        }
    }//GEN-LAST:event_btnmenosmatrizActionPerformed

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
        // TODO add your handling code here:
        btnsalir.setBackground(new java.awt.Color(240, 0, 0));
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
        // TODO add your handling code here:
        btnsalir.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_btnsalirMouseExited

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
        //System.exit(0);
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void panelsuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsuperiorMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_panelsuperiorMouseDragged

    private void panelsuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsuperiorMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_panelsuperiorMousePressed

    private void btnminimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminimizarMouseEntered
        // TODO add your handling code here:
        btnminimizar.setBackground(new java.awt.Color(120, 120, 120));
    }//GEN-LAST:event_btnminimizarMouseEntered

    private void btnminimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminimizarMouseExited
        // TODO add your handling code here:
        btnminimizar.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_btnminimizarMouseExited

    private void btnminimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminimizarActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(1);
    }//GEN-LAST:event_btnminimizarActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bracketprocesomult;
    private javax.swing.JLabel bracketprocesosuma;
    private javax.swing.JLabel bracketresultadomult;
    private javax.swing.JLabel bracketresultadosuma;
    private javax.swing.JButton btnmas;
    private javax.swing.JButton btnmasmatriz;
    private javax.swing.JButton btnmenos;
    private javax.swing.JButton btnmenosmatriz;
    private javax.swing.JButton btnminimizar;
    private javax.swing.JButton btnpor;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpanelma;
    private javax.swing.JPanel jpanelmb;
    private javax.swing.JTextField n4;
    private javax.swing.JPanel panelmultiplicacion;
    private javax.swing.JPanel panelrespuestamultiplicacion;
    private javax.swing.JPanel panelsumaresta;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JLabel txtindicea;
    private javax.swing.JLabel txtindiceb;
    private javax.swing.JTextField txtnumeroa;
    private javax.swing.JTextField txtnumerob;
    private javax.swing.JLabel txtprocesof0;
    private javax.swing.JLabel txtprocesof1;
    private javax.swing.JLabel txtprocesof2;
    private javax.swing.JLabel txtprocesof3;
    private javax.swing.JLabel txtprocesosf0;
    private javax.swing.JLabel txtprocesosf1;
    private javax.swing.JLabel txtprocesosf2;
    private javax.swing.JLabel txtprocesosf3;
    private javax.swing.JLabel txtresultadof0;
    private javax.swing.JLabel txtresultadof1;
    private javax.swing.JLabel txtresultadof2;
    private javax.swing.JLabel txtresultadof3;
    private javax.swing.JLabel txtresultadosf0;
    private javax.swing.JLabel txtresultadosf1;
    private javax.swing.JLabel txtresultadosf2;
    private javax.swing.JLabel txtresultadosf3;
    // End of variables declaration//GEN-END:variables
}
