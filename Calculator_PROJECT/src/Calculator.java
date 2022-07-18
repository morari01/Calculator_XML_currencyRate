import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Calculator extends JFrame {
    private final JPanel panel = new JPanel();
    private final Parser parser;

    Calculator(Parser parser){
        this.parser = parser;
        init();
    }

    public void init(){
        JLabel label = new JLabel("Podaj kwotę w EURO");
        JLabel label1 = new JLabel("Wybierz walutę");
        label.setFont(new Font("Serif", Font.PLAIN + Font.BOLD, 16));
        label1.setFont(new Font("Serif", Font.PLAIN + Font.BOLD, 16));
        JTextField textField = new JTextField("\t");
        JTextField textField1 = new JTextField("\t");
        JButton button = new JButton("Oblicz kwotę");

        JComboBox<String> box = new JComboBox<>(parser.CurrencyList.toArray(new String[0]));

        button.addActionListener(e -> {
            String kwota = textField.getText();
            String CurrencyItem = Objects.requireNonNull(box.getSelectedItem()).toString();
            int index = parser.CurrencyList.indexOf(CurrencyItem); // index elementu z listy walut
            Double rate = parser.RateList.get(index); //element z listy rate ktory odpowiada obranej walucie
            Double result = Double.parseDouble(kwota) * rate;
            textField1.setText(String.valueOf(result));
        });

        panel.add(Box.createRigidArea(new Dimension(0, 60)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(box);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(textField1);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setTitle("Currency Rate");
        this.setLayout(new FlowLayout());
        this.add(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
