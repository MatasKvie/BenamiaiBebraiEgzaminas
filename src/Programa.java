import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class Programa extends JFrame implements ActionListener {

    JButton userBtnLogin;
    JButton employeeBtnLogin;
    JLabel mainMenuLabel, mainMenuUnderline, mainMenuUnderlineText;
    Programa() throws IOException {

        URL beaverURL = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110163259291602996/Bobr.png");
        Image imageBeaver = ImageIO.read(beaverURL);
        Image imageBeaver2 = imageBeaver.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ; //sumažinama nuotrauka
        ImageIcon iconBeaver = new ImageIcon(imageBeaver2); //nuotrauka paverčiama į ikoną

        this.setTitle("Benamiai Bebrai"); //Programos lango titulas

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Vartotojo prisijungimo mygtukas

        userBtnLogin = new JButton();
        userBtnLogin.setBounds(100,250,250,75); //mygtuko pozicija ir dydžio parametrai
        this.add(userBtnLogin); //Prideda mygtuka į lentelę
        userBtnLogin.setVisible(true);
        userBtnLogin.setText("\uD83D\uDC64 Vartotojas");
        userBtnLogin.setFont(new Font("Serif", Font.BOLD,25));
        userBtnLogin.setFocusable(false);
        userBtnLogin.setBackground(Color.darkGray);
        userBtnLogin.setForeground(Color.white);

        userBtnLogin.setHorizontalTextPosition(JButton.RIGHT);
        userBtnLogin.setVerticalTextPosition(JButton.CENTER);
        userBtnLogin.setIconTextGap(10);

        userBtnLogin.addActionListener(this);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Gaudytojo prisijungimo mygtukas

        employeeBtnLogin = new JButton();
        employeeBtnLogin.setBounds(400,250,250,75); //mygtuko pozicija ir dydžio parametrai
        this.add(employeeBtnLogin); //Prideda mygtuka į lentelę
        employeeBtnLogin.setVisible(true);
        employeeBtnLogin.setText("\uD83D\uDD75\uFE0F\u200D Darbuotojas");
        employeeBtnLogin.setFont(new Font("Serif", Font.BOLD,25));
        employeeBtnLogin.setFocusable(false);
        employeeBtnLogin.setBackground(Color.darkGray);
        employeeBtnLogin.setForeground(Color.white);

        employeeBtnLogin.setHorizontalTextPosition(JButton.RIGHT);
        employeeBtnLogin.setVerticalTextPosition(JButton.CENTER);
        employeeBtnLogin.setIconTextGap(10);

        employeeBtnLogin.addActionListener(this);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        mainMenuLabel = new JLabel();
        mainMenuLabel.setText("Benamiai Bebrai");
        mainMenuLabel.setBounds(100, 15, 650, 100);
        mainMenuLabel.setFont(new Font("Serif", Font.BOLD ,62));
        mainMenuLabel.setForeground(new Color(255, 255, 255));
        mainMenuLabel.setIcon(iconBeaver);
        this.add(mainMenuLabel);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        mainMenuUnderline = new JLabel();
        mainMenuUnderline.setText("__________________");
        mainMenuUnderline.setBounds(100, 15, 650, 100);
        mainMenuUnderline.setFont(new Font("Serif", Font.BOLD ,62));
        mainMenuUnderline.setForeground(new Color(255, 255, 255));
        this.add(mainMenuUnderline);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        mainMenuUnderlineText = new JLabel();
        mainMenuUnderlineText.setText("Prisijungimas");
        mainMenuUnderlineText.setBounds(100, 80, 650, 100);
        mainMenuUnderlineText.setFont(new Font("Serif", Font.BOLD ,32));
        mainMenuUnderlineText.setForeground(new Color(255, 255, 255));
        this.add(mainMenuUnderlineText);

        /*
        URL buttonURL1 = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110182142274711633/crown1.png");
        Image btnImageOld1 = ImageIO.read(buttonURL1); //paimama nuotrauka iš URL adreso
        Image btnImage1 = btnImageOld1.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ; //sumažinama nuotrauka
        ImageIcon btnIcon1 = new ImageIcon(btnImage1); //Paverčiama nuotrauka į ikoną
        userBtnLogin.setIcon(btnIcon1); //uždedama ikona ant mygtuko
        */

        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Stabdomas programos darbas ją uždarius
        this.setLayout(null);
        this.setResizable(false); //Neleidžia ranka keisti lango dydžio
        this.setSize(750,450); //Nustato Lango plotį ir ilgį
        this.setVisible(true);

        this.setIconImage(new ImageIcon(imageBeaver).getImage()); //nustato programos ikoną

        this.getContentPane().setBackground(new Color(52, 73, 94));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userBtnLogin){
            try {
                new LoginUser();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }

        if(e.getSource() == employeeBtnLogin){
            try {
                new LoginEmployee();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
    }
}
