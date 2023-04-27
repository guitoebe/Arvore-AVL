package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import ArvoreHandle.AVLTree;
import javax.swing.JButton;
import java.awt.event.*; 

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame("Arvore Binária");
        frame.setSize(500,300);

        JPanel panel = new JPanel();
        panel.setSize(300, 300);

        JLabel valueLabel = new JLabel("Valor");
        JTextArea valueInput = new JTextArea(1,10);
        JLabel resultLabel = new JLabel("Resultado:");
        JLabel resultValueLabel = new JLabel();
        JButton insertButton = new JButton("Inserir");
        JButton removeButton = new JButton("Remover");
        JButton printButton = new JButton("Imprimir");
        AVLTree tree = new AVLTree();
        JTextArea printTextArea = new JTextArea (5,30);
        ActionListener insertAction = new ActionListener() {
                public void actionPerformed(ActionEvent A){
                if (valueInput.getText() == null || valueInput.getText().equals("") || !isNumber(valueInput.getText())) {
                    resultValueLabel.setText("Valor inválido");
                    valueInput.setText("");
                } else {
                    resultValueLabel.setText(valueInput.getText());
                    tree.insert(Integer.valueOf(resultValueLabel.getText()));
                }
            }
        };

        ActionListener removeAction = new ActionListener() {
            public void actionPerformed(ActionEvent A){
                if (valueInput.getText() == null || valueInput.getText().equals("")) {
                    resultValueLabel.setText("Valor inválido");
                } else {
                    resultValueLabel.setText(valueInput.getText());
                }
            }
        };
        ActionListener printAction = new ActionListener() {
            public void actionPerformed(ActionEvent A){
                tree.print();
            }
        };
        insertButton.addActionListener(insertAction);
        removeButton.addActionListener(removeAction);
        printButton.addActionListener(printAction);

        // conecta los componentes JLabel y JTextField en JPanel
        panel.add(valueLabel);
        panel.add(valueInput);
        panel.add(insertButton);
        panel.add(removeButton);
        panel.add(printButton);
        panel.add(resultLabel);
        panel.add(resultValueLabel);
        panel.add(printTextArea);

        // conectar Jpanel a JFrame
        frame.add(panel);

        // hacer visible JFrame
        frame.setVisible(true);        
    }

    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}