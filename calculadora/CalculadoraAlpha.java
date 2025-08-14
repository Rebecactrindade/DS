import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraAlpha extends JFrame implements ActionListener {

    private JTextField txtNum1, txtNum2, txtDia, txtMes;
    private JTextArea txtResult;
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnSqrt, btnSigno;

    public CalculadoraAlpha() {
        setTitle("Calculadora Alpha");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Numero 1:"));
        txtNum1 = new JTextField(10);
        add(txtNum1);

        add(new JLabel("Numero 2:"));
        txtNum2 = new JTextField(10);
        add(txtNum2);

        add(new JLabel("Dia nascimento:"));
        txtDia = new JTextField(5);
        add(txtDia);

        add(new JLabel("Mes nascimento:"));
        txtMes = new JTextField(5);
        add(txtMes);

        btnAdd = new JButton("Somar");
        btnSub = new JButton("Subtrair");
        btnMul = new JButton("Multiplicar");
        btnDiv = new JButton("Dividir");
        btnSqrt = new JButton("Raiz Quadrada (Numero 1)");
        btnSigno = new JButton("Descobrir Signo");

        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);
        add(btnSqrt);
        add(btnSigno);

        txtResult = new JTextArea(8, 35);
        txtResult.setEditable(false);
        txtResult.setLineWrap(true);
        txtResult.setWrapStyleWord(true);
        add(new JScrollPane(txtResult));

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnSqrt.addActionListener(this);
        btnSigno.addActionListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraAlpha().setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnSigno) {
                int dia = Integer.parseInt(txtDia.getText().trim());
                int mes = Integer.parseInt(txtMes.getText().trim());
                String signo = getSigno(dia, mes);
                txtResult.setText("Seu signo zodiacal e: " + signo);
            } else if (e.getSource() == btnSqrt) {
                double num = Double.parseDouble(txtNum1.getText().trim());
                if (num < 0) {
                    txtResult.setText("Erro: nao e possivel calcular raiz quadrada de numero negativo.");
                } else {
                    txtResult.setText("Raiz quadrada de " + num + " = " + Math.sqrt(num));
                }
            } else {
                double num1 = Double.parseDouble(txtNum1.getText().trim());
                double num2 = Double.parseDouble(txtNum2.getText().trim());
                if (e.getSource() == btnAdd) {
                    txtResult.setText("Resultado da soma: " + (num1 + num2));
                } else if (e.getSource() == btnSub) {
                    txtResult.setText("Resultado da subtracao: " + (num1 - num2));
                } else if (e.getSource() == btnMul) {
                    txtResult.setText("Resultado da multiplicacao: " + (num1 * num2));
                } else if (e.getSource() == btnDiv) {
                    if (num2 == 0) {
                        txtResult.setText("Erro: divisao por zero nao permitida.");
                    } else {
                        txtResult.setText("Resultado da divisao: " + (num1 / num2));
                    }
                }
            }
        } catch (NumberFormatException ex) {
            txtResult.setText("Erro: Insira valores numericos validos nos campos.");
        }
    }

    private String getSigno(int dia, int mes) {
        if (mes == 1) return (dia >= 20) ? "Aquario" : "Capricornio";
        if (mes == 2) return (dia >= 19) ? "Peixes" : "Aquario";
        if (mes == 3) return (dia >= 21) ? "Aries" : "Peixes";
        if (mes == 4) return (dia >= 20) ? "Touro" : "Aries";
        if (mes == 5) return (dia >= 21) ? "Gemeos" : "Touro";
        if (mes == 6) return (dia >= 21) ? "Cancer" : "Gemeos";
        if (mes == 7) return (dia >= 23) ? "Leao" : "Cancer";
        if (mes == 8) return (dia >= 23) ? "Virgem" : "Leao";
        if (mes == 9) return (dia >= 23) ? "Libra" : "Virgem";
        if (mes == 10) return (dia >= 23) ? "Escorpiao" : "Libra";
        if (mes == 11) return (dia >= 22) ? "Sagitario" : "Escorpiao";
        if (mes == 12) return (dia >= 22) ? "Capricornio" : "Sagitario";
        return "Data invalida";
    }
}
