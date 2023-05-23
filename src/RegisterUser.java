import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class RegisterUser extends JFrame implements ActionListener {

    JLabel label = new JLabel("Prašome įvesti registracijos duomenis.");
    JLabel labelEmail, labelPass;
    JButton buttonRegister;
    JTextField emailField;
    JPasswordField passField;
    JButton backBtn;

    RegisterUser() throws IOException {
        URL beaverURL = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110163259291602996/Bobr.png");
        Image imageBeaver = ImageIO.read(beaverURL);
        this.setIconImage(new ImageIcon(imageBeaver).getImage()); //nustato programos ikoną
        this.setTitle("Vartotojo registracija");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //registracijos mygtukas

        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN,25));

        buttonRegister = new JButton();
        buttonRegister.setBounds(250,250,250,75); //mygtuko pozicija ir dydžio parametrai
        this.add(buttonRegister); //Prideda mygtuka į lentelę
        buttonRegister.setVisible(true);
        buttonRegister.setText("Prisiregistruoti");
        buttonRegister.setFont(new Font("Serif", Font.BOLD,25));
        buttonRegister.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        buttonRegister.setBackground(Color.darkGray);
        buttonRegister.setForeground(Color.white);

        buttonRegister.setHorizontalTextPosition(JButton.RIGHT);
        buttonRegister.setVerticalTextPosition(JButton.CENTER);
        buttonRegister.setIconTextGap(10);

        buttonRegister.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //el. pašto įvedimo laukas

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

        //slaptažodžio įvedimo laukas

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

        //atgal mygtukas

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

        if(e.getSource()==buttonRegister){
            if(emailField.getText().equals("")){
                label.setText("Prašome įvesti el. pašto adresą!");
                label.setForeground(new Color(255,188,188));
            }
            else if(passField.getText().equals("")){
                label.setText("Prašome įvesti slaptažodį!");
                label.setForeground(new Color(255,188,188));
            }
            else{

                Logins.addLogin(1, emailField.getText(),passField.getText()); //Priregistruoja naują paskyrą (Laikinam)

                try {
                    new LoginUser(); //Atidaro vartotojo prisijungimo ekraną
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();
            }



        }
        else if(e.getSource() == backBtn){ //siunčia vartotoją atgal į prisijungimo ekraną

            try {
                new Programa();
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}
