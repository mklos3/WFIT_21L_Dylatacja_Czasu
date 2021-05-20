package pl.edu.pw.elka.wfit;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * @version 0.1
 */

public class Main implements ActionListener{
    private JFrame f;
    private JMenuBar menuBar;
    private JMenu wybierzSymulacje;
    private JMenuItem dylatacjaMenuItem, skrocenieMenuItem;
    private JLabel wybierzLabel;
    private JPanel init;
    private JPanel pasek;
    public static JFrame okno_dylatacja = new JFrame("Dylatacja czasu");
    public static JFrame okno_skrocenie = new JFrame("Skrócenie Lorentza");

    /**
     * Wizualizacja dylatacji czasu i skrócenia Lorentza
     * @author Mikołaj Kłos
     * @since 14.05.2021
     */

    Main(){
        // Stworzenie okna
        f = new JFrame("Dylatacja czasu i skrócenie Lorentza");
        f.setSize(600,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());

        // Ustawienie elementów okna init
        init = new JPanel();
        pasek = new JPanel();
        init.setLayout(new BorderLayout());
        dylatacjaMenuItem = new JMenuItem("Dylatacja czasu");
        skrocenieMenuItem = new JMenuItem("Skrócenie Lorentza");
        dylatacjaMenuItem.addActionListener(this);
        skrocenieMenuItem.addActionListener(this);
        menuBar = new JMenuBar();
        wybierzSymulacje = new JMenu("Wybierz symulację");
        wybierzSymulacje.add(dylatacjaMenuItem);
        wybierzSymulacje.add(skrocenieMenuItem);
        menuBar.add(wybierzSymulacje);
        wybierzLabel = new JLabel("Wybierz symulację z pasku powyżej", SwingConstants.CENTER);

        // Dodanie elementów do okien
        pasek.add(menuBar, BorderLayout.NORTH);
        init.add(wybierzLabel, BorderLayout.CENTER);

        f.add(pasek, BorderLayout.NORTH);
        f.add(init, BorderLayout.CENTER);
        f.setResizable(false);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    // Wybór symulacji
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==dylatacjaMenuItem){
            okno_dylatacja.setContentPane(new Dylatacja().All);
            okno_dylatacja.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            okno_dylatacja.pack();
            okno_dylatacja.setLocationRelativeTo(null);
            okno_dylatacja.setVisible(true);
        }
        if(e.getSource()==skrocenieMenuItem){
            okno_skrocenie.setContentPane(new Skrocenie().All);
            okno_skrocenie.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            okno_skrocenie.pack();
            okno_skrocenie.setLocationRelativeTo(null);
            okno_skrocenie.setVisible(true);
        }
    }
}
