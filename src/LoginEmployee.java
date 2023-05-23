import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LoginEmployee extends JFrame implements ActionListener {

    JLabel label = new JLabel("Prašome įvesti prisijungimo duomenis.");
    JLabel labelEmail, labelPass;
    JButton buttonLogin;
    JTextField emailField;
    JPasswordField passField;
    JButton backBtn;

    LoginEmployee() throws IOException {
        URL beaverURL = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110163259291602996/Bobr.png");
        Image imageBeaver = ImageIO.read(beaverURL);
        this.setIconImage(new ImageIcon(imageBeaver).getImage()); //nustato programos ikoną
        this.setTitle("Gaudytojo prisijungimas");


        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN,25));

        buttonLogin = new JButton();
        buttonLogin.setBounds(250,250,250,75); //mygtuko pozicija ir dydžio parametrai
        this.add(buttonLogin); //Prideda mygtuka į lentelę
        buttonLogin.setVisible(true);
        buttonLogin.setText("Prisijungti");
        buttonLogin.setFont(new Font("Serif", Font.BOLD,25));
        buttonLogin.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        buttonLogin.setBackground(Color.darkGray);
        buttonLogin.setForeground(Color.white);

        buttonLogin.setHorizontalTextPosition(JButton.RIGHT);
        buttonLogin.setVerticalTextPosition(JButton.CENTER);
        buttonLogin.setIconTextGap(10);

        buttonLogin.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        emailField = new JTextField();
        emailField.setBounds(100, 100, 550, 25);
        emailField.setVisible(true);

        this.add(emailField);

        labelEmail = new JLabel("Įveskite el. pašto adresą:");
        labelEmail.setBounds(100, 75, 550, 25);
        labelEmail.setVisible(true);
        labelEmail.setForeground(Color.white);

        this.add(labelEmail);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        passField = new JPasswordField();
        passField.setBounds(100, 160, 550, 25);
        passField.setVisible(true);

        labelPass = new JLabel("Įveskite slaptažodį:");
        labelPass.setBounds(100, 135, 550, 25);
        labelPass.setForeground(Color.white);
        labelPass.setVisible(true);

        this.add(passField);
        this.add(labelPass);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stabdomas programos darbas ją uždarius
        this.setLayout(null);
        this.setResizable(false); //Neleidžia ranka keisti lango dydžio
        this.setSize(750,450); //Nustato Lango plotį ir ilgį
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(52, 73, 94));

        label.setBounds(100,15,750,50);
        label.setForeground(Color.white);
        this.add(label);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        backBtn = new JButton();
        backBtn.setBounds(10,10,50,50);
        backBtn.setVisible(true);
        this.add(backBtn);

        backBtn.setText("↩");
        backBtn.setFont(new Font("Serif", Font.BOLD,16));
        backBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        backBtn.setBackground(Color.darkGray);
        backBtn.setForeground(Color.white);

        backBtn.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==buttonLogin){
            if(emailField.getText().equals("")){
                label.setText("Prašome įvesti el. pašto adresą!");
                label.setForeground(new Color(255,188,188));
            }
            else if(passField.getText().equals("")){
                label.setText("Prašome įvesti slaptažodį!");
                label.setForeground(new Color(255,188,188));
            }
            else {
                boolean isCorrect;
                isCorrect = Logins.checkLogin(2, emailField.getText(), passField.getText());

                if (isCorrect == true) {
                    try {
                        new EmployeeInterface();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    this.dispose();
                }
            }

            //Įterpti prisijungimo funkciją, kuri tikrina ar el. paštas ir slaptažodis teisingi

        }
        else if(e.getSource() == backBtn){ //siunčia vartotoją atgal į prisijungimo ekraną

            try {
                new Programa();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();

        }

    }
}
