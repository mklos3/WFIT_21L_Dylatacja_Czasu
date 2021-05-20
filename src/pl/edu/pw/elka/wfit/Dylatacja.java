package pl.edu.pw.elka.wfit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Dylatacja extends Main{
    JPanel All;
    private JPanel gora;
    private JPanel dol;
    private JSlider slider;
    private JTextField textFieldV;
    private JLabel label_v;
    private JLabel label_equals;
    private JTextField textFieldVdoC;
    private JLabel label_c;
    private JTextField textFieldK;
    private JLabel kmh;
    private JPanel leweOkno;
    private JPanel praweOkno;
    private JPanel srodek;
    private JButton symulujButton;
    private JPanel zegarWMiejscu;
    private JPanel zegarWRuchu;
    private static final long c = 299792458;
    private double alfa = 0;
    private double v = 0;
    private double k = 0;

    Dylatacja(){
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double x = slider.getValue();
                alfa = x/10000;
                v = alfa * c;
                BigDecimal v_out = new BigDecimal(v);
                k = v *3.6;
                BigDecimal v_kmh = new BigDecimal(k);
                textFieldK.setText(v_kmh.toPlainString());
                textFieldV.setText(v_out.toPlainString());
                textFieldVdoC.setText(String.valueOf(alfa));
            }
        });

        symulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.setEnabled(false);
                //TODO Rysowanie
                slider.setEnabled(true);
            }
        });
    }
}
