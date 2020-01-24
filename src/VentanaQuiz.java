import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaQuiz extends JFrame implements ActionListener {
    JLabel titulo,jugador1,jugador2,NombreJugador1,NombreJugador2;
    JTextField nJugador1,nJugador2;
    JButton bEmpezarQuiz;
    JRadioButton bA,bB,bC;
    ButtonGroup grupoBotones;

    Container container;
    CardLayout cardLayout;
    JPanel panelPrincipal,panelJugador1,panelJugador2,panelResultado;
    JPanel panelPrincArriba,panelPrincAbajo,panelPrincCenter,panelBotones,panelNombreJ1;


    public VentanaQuiz() {

        initGUI();
    }

    private void initGUI() {
        this.setSize(new Dimension(350, 400));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Counter Strike Trivial");
        this.setVisible(true);
        instancias();
        acciones();
        configurarContainer();
    }

    private void configurarContainer(){
        container.setLayout(cardLayout);
        container.add(configurarPrincipal(), "Principal");
        container.add(configurarJugador1(),"Jugador 1");

    }

    private JPanel configurarBotones(){
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(bA);
        panelBotones.add(bB);
        panelBotones.add(bC);
        return panelBotones;
    }

    private JPanel configurarNJ1(){
        panelNombreJ1.setLayout(new GridBagLayout());
        panelNombreJ1.add(NombreJugador1);
        return panelNombreJ1;
    }

    private JPanel configurarJugador1() {
        panelJugador1.setLayout(new GridLayout(2,1));
        panelJugador1.add(configurarNJ1());
        panelJugador1.add(configurarBotones());
        return panelJugador1;
    }

    private JPanel configurarPrincipal() {
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(configurarArriba(),BorderLayout.NORTH);
        panelPrincipal.add(configurarCentro(),BorderLayout.CENTER);
        panelPrincipal.add(configurarAbajo(),BorderLayout.SOUTH);

        return panelPrincipal;
    }

    private JPanel configurarAbajo() {
        //panelPrincAbajo.setBackground(Color.BLACK);
        panelPrincAbajo.setLayout(new GridBagLayout());
          panelPrincAbajo.add(bEmpezarQuiz);

        return panelPrincAbajo;
    }

    private JPanel configurarArriba() {
        panelPrincArriba.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPrincArriba.add(titulo);
        return  panelPrincArriba;
    }

    private JPanel configurarCentro(){
        panelPrincCenter.setLayout(new GridLayout(4,1));
        panelPrincCenter.add(jugador1);
        panelPrincCenter.add(nJugador1);
        panelPrincCenter.add(jugador2);
        panelPrincCenter.add(nJugador2);
        return panelPrincCenter;
    }

    private void acciones() {
           bEmpezarQuiz.addActionListener(this);
    }

    private void instancias() {
        container = this.getContentPane();
        titulo =  new JLabel("Counter Strike Trivial");
        jugador1 = new JLabel("Jugador 1: ");
        jugador2 = new JLabel("Jugador 2: ");
        NombreJugador1 = new JLabel("");
        NombreJugador2 = new JLabel("");
        bEmpezarQuiz = new JButton("Empezar");
        nJugador1 = new JTextField();
        nJugador2 = new JTextField();
        bA = new JRadioButton();
        bB = new JRadioButton();
        bC = new JRadioButton();
        grupoBotones = new ButtonGroup();
        grupoBotones.add(bA);
        grupoBotones.add(bB);
        grupoBotones.add(bC);
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel();
        panelPrincCenter = new JPanel();
        panelJugador1 = new JPanel();
        panelJugador1.setToolTipText("Jugador 1");
        panelJugador2 = new JPanel();
        panelResultado = new JPanel();
        panelPrincAbajo = new JPanel();
        panelBotones = new JPanel();
        panelNombreJ1 = new JPanel();
        panelPrincArriba = new JPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bEmpezarQuiz){
            String nombreJ1 = nJugador1.getText();
            NombreJugador1.setText(nombreJ1);
            cardLayout.show(container,"Jugador 1");
        }
    }
}