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
    private JPanel dylatacja;
    private JPanel skrocenie;
    private boolean initInt = true;

    /**
     * Wizualizacja dylatacji czasu i skrócenia Lorentza
     * @author Mikołaj Kłos
     * @since 14.05.2021
     */

    Main(){
        // Stworzenie okna
        f = new JFrame("Dylatacja czasu i skrócenie Lorentza");
        f.setSize(1200,650);
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

        // Ustawienie panelu dylatacji
        dylatacja = new JPanel();

        // Ustawienie panelu skrócenia
        skrocenie = new JPanel();

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
            if(initInt){
                f.remove(init);
                initInt = false;
            }
            else{
                f.remove(skrocenie);
            }
            f.add(dylatacja, BorderLayout.CENTER);
        }
        if(e.getSource()==skrocenieMenuItem){
            if(initInt){
                f.remove(init);
                initInt = false;
            }
            else{
                f.remove(dylatacja);
            }
            f.add(skrocenie, BorderLayout.CENTER);
        }
        f.validate();
        f.repaint();
    }
}
