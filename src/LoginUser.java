import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class LoginUser extends JFrame implements ActionListener{

    JLabel label = new JLabel("Prašome įvesti prisijungimo duomenis.");

    JLabel labelEmail, labelPass;

    JButton buttonLogin, buttonRegister;
    JTextField emailField;
    JPasswordField passField;
    JButton backBtn;

    LoginUser() throws IOException {

        URL beaverURL = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110163259291602996/Bobr.png");
        Image imageBeaver = ImageIO.read(beaverURL);
        this.setIconImage(new ImageIcon(imageBeaver).getImage()); //nustato programos ikoną
        this.setTitle("Vartotojo prisijungimas");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Vartotojo prisijungimo mygtukas

        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN,25));

        buttonLogin = new JButton();
        buttonLogin.setBounds(100,250,250,75); //mygtuko pozicija ir dydžio parametrai
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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Vartotojo registracijos mygtukas

        buttonRegister = new JButton();
        buttonRegister.setBounds(400,250,250,75); //mygtuko pozicija ir dydžio parametrai
        this.add(buttonRegister); //Prideda mygtuka į lentelę
        buttonRegister.setVisible(true);
        buttonRegister.setText("Registracija");
        buttonRegister.setFont(new Font("Serif", Font.BOLD,25));
        buttonRegister.setFocusable(false);
        buttonRegister.setBackground(Color.darkGray);
        buttonRegister.setForeground(Color.white);

        buttonRegister.setHorizontalTextPosition(JButton.RIGHT);
        buttonRegister.setVerticalTextPosition(JButton.CENTER);
        buttonRegister.setIconTextGap(10);

        buttonRegister.addActionListener(this);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //El. pašto laukas ir tekstas virš jo

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

        //Slaptažodžio laukas ir tekstas virš jo

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

        //"Atgal" Mygtukas

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

        if(e.getSource()==buttonLogin) { //Prisijungimo mygtukas
            if (emailField.getText().equals("")) { //jei neįvestas el. pašto adresas
                label.setText("Prašome įvesti el. pašto adresą!");
                label.setForeground(new Color(255, 188, 188)); //teksto spalva pakeičiama į raudoną
            } else if (passField.getText().equals("")) { //jei neįvestas slaptažodis
                label.setText("Prašome įvesti slaptažodį!");
                label.setForeground(new Color(255, 188, 188)); //teksto spalva pakeičiama į raudoną
            } else {
                boolean isCorrect;
                isCorrect = Logins.checkLogin(1, emailField.getText(), passField.getText()); //tikrina prisijungimo duomenis

                if (isCorrect == true) { //Jei el. paštas ir slaptažodis atitinka
                    try {
                        new UserInterface(); //Atidaro vartotojo sąsają
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    this.dispose(); //uždaro dabar atidaryta langą
                }
                else{
                    JOptionPane.showMessageDialog(null, "Neteisingi prisijungimo duomenys.");
                }
            }
        }

            //Įterpti prisijungimo funkciją, kuri tikrina ar el. paštas ir slaptažodis teisingi
        if(e.getSource()==buttonRegister){ //registracijos mygtukas

            try {
                new RegisterUser();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();

        }
        if(e.getSource() == backBtn){ //Atgal mygtukas, kuris siunčia vartotoją atgal į prisijungimo ekraną

            try {
                new Programa();
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }


    }
}

