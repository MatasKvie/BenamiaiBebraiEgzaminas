import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class EmployeeInterface extends JFrame implements ActionListener {

    JButton mapBtn, messageBtn, listBtn, visibilityBtn, editBtn, stateBtn;
    JLabel mapLabel, messageLabel, listLabel, addLabel, editLabel, stateLabel;
    JButton backBtn;

    EmployeeInterface() throws IOException {

        URL beaverURL = new URL("https://cdn.discordapp.com/attachments/1109783351818199090/1110163259291602996/Bobr.png");
        Image imageBeaver = ImageIO.read(beaverURL);
        this.setIconImage(new ImageIcon(imageBeaver).getImage()); //nustato programos ikoną
        this.setTitle("Benamiai Bebrai programėlė");


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Žemėlapio mygtukas

        mapBtn = new JButton();
        mapBtn.setBounds(75,75,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(mapBtn); //Prideda mygtuka į lentelę
        mapBtn.setVisible(true);
        mapBtn.setText("\uD83C\uDF0E");
        mapBtn.setFont(new Font("Serif", Font.BOLD,62));
        mapBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        mapBtn.setBackground(Color.darkGray);
        mapBtn.setForeground(Color.white);

        mapBtn.setHorizontalTextPosition(JButton.CENTER);
        mapBtn.setVerticalTextPosition(JButton.CENTER);
        mapBtn.setIconTextGap(10);

        mapBtn.addActionListener(this);

        mapLabel = new JLabel("Žemėlapis");
        mapLabel.setFont(new Font("Serif", Font.BOLD,18));
        mapLabel.setBounds(95,50,125,25);
        mapLabel.setForeground(Color.white);
        this.add(mapLabel);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Žinučių mygtukas

        messageBtn = new JButton();
        messageBtn.setBounds(287,75,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(messageBtn); //Prideda mygtuka į lentelę
        messageBtn.setVisible(true);
        messageBtn.setText("✉");
        messageBtn.setFont(new Font("Serif", Font.BOLD,62));
        messageBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        messageBtn.setBackground(Color.darkGray);
        messageBtn.setForeground(Color.white);

        messageBtn.setHorizontalTextPosition(JButton.CENTER);
        messageBtn.setVerticalTextPosition(JButton.CENTER);
        //messageBtn.setIconTextGap(10);

        messageBtn.addActionListener(this);

        messageLabel = new JLabel("Žinutės");
        messageLabel.setFont(new Font("Serif", Font.BOLD,18));
        messageLabel.setBounds(320,50,125,25);
        messageLabel.setForeground(Color.white);
        this.add(messageLabel);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Sąrašo mygtukas

        listBtn = new JButton();
        listBtn.setBounds(500,75,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(listBtn); //Prideda mygtuka į lentelę
        listBtn.setVisible(true);
        listBtn.setText("📒");
        listBtn.setFont(new Font("Serif", Font.BOLD,62));
        listBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        listBtn.setBackground(Color.darkGray);
        listBtn.setForeground(Color.white);

        listBtn.setHorizontalTextPosition(JButton.CENTER);
        listBtn.setVerticalTextPosition(JButton.CENTER);
        //listBtn.setIconTextGap(10);

        listBtn.addActionListener(this);

        listLabel = new JLabel("Pranešimų Sąrašas");
        listLabel.setFont(new Font("Serif", Font.BOLD,18));
        listLabel.setBounds(490,50,175,25);
        listLabel.setForeground(Color.white);
        this.add(listLabel);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Matomumo mygtukas

        visibilityBtn = new JButton();
        visibilityBtn.setBounds(75,250,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(visibilityBtn); //Prideda mygtuka į lentelę
        visibilityBtn.setVisible(true);
        visibilityBtn.setText("\uD83D\uDC41\uFE0F");
        visibilityBtn.setFont(new Font("Serif", Font.BOLD,62));
        visibilityBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        visibilityBtn.setBackground(Color.darkGray);
        visibilityBtn.setForeground(Color.white);

        visibilityBtn.setHorizontalTextPosition(JButton.CENTER);
        visibilityBtn.setVerticalTextPosition(JButton.CENTER);
        //visibilityBtn.setIconTextGap(10);

        visibilityBtn.addActionListener(this);

        addLabel = new JLabel("Pranešimų Matomumas");
        addLabel.setFont(new Font("Serif", Font.BOLD,18));
        addLabel.setBounds(50,225,200,25);
        addLabel.setForeground(Color.white);
        this.add(addLabel);


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Redagavimo mygtukas

        editBtn = new JButton();
        editBtn.setBounds(287,250,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(editBtn); //Prideda mygtuka į lentelę
        editBtn.setVisible(true);
        editBtn.setText("\uD83D\uDCDD");
        editBtn.setFont(new Font("Serif", Font.BOLD,62));
        editBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        editBtn.setBackground(Color.darkGray);
        editBtn.setForeground(Color.white);

        editBtn.setHorizontalTextPosition(JButton.CENTER);
        editBtn.setVerticalTextPosition(JButton.CENTER);
        //editBtn.setIconTextGap(10);

        editBtn.addActionListener(this);

        editLabel = new JLabel("Redaguoti Pranešimus");
        editLabel.setFont(new Font("Serif", Font.BOLD,18));
        editLabel.setBounds(265,225,175,25);
        editLabel.setForeground(Color.white);
        this.add(editLabel);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Būsenos mygtukas

        stateBtn = new JButton();
        stateBtn.setBounds(500,250,125,125); //mygtuko pozicija ir dydžio parametrai
        this.add(stateBtn); //Prideda mygtuka į lentelę
        stateBtn.setVisible(true);
        stateBtn.setText("\uD83D\uDD0E");
        stateBtn.setFont(new Font("Serif", Font.BOLD,62));
        stateBtn.setFocusable(false); //nuimamos punktyrinės linijos, kurios atsiranda aplink mygtuko tekstą
        stateBtn.setBackground(Color.darkGray);
        stateBtn.setForeground(Color.white);

        stateBtn.setHorizontalTextPosition(JButton.RIGHT);
        stateBtn.setVerticalTextPosition(JButton.CENTER);
        //stateBtn.setIconTextGap(10);

        stateBtn.addActionListener(this);

        stateLabel = new JLabel("Būsenos keitimas");
        stateLabel.setFont(new Font("Serif", Font.BOLD,18));
        stateLabel.setBounds(495,225,175,25);
        stateLabel.setForeground(Color.white);
        this.add(stateLabel);


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

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stabdomas programos darbas ją uždarius
        this.setLayout(null);
        this.setResizable(false); //Neleidžia ranka keisti lango dydžio
        this.setSize(750,450); //Nustato Lango plotį ir ilgį
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(52, 73, 94));


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backBtn){ //siuncia vartotoja atgal į prisijungimo ekraną

            try {
                new Programa();
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}
