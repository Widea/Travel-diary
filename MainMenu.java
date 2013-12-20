
package mainframe;

   //Required packages
    import java.awt.*;
    import javax.swing.*;
    import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;
    
public class MainMenu extends JFrame implements ActionListener 
{
    
   private static final Dimension MAIN_SIZE = new Dimension(100, 100);
   private JPanel mainPanel = new JPanel();//The main panel

   public static String uname;
   private JButton submit;
   private JButton mainMenu;
   private JLabel name= new JLabel("ENTER THE USERNAME:");
   private JLabel pass= new JLabel("ENTER THE PASSWORD:");
   private JLabel conPass= new JLabel("RE-ENTER THE PASSWORD:");
   private JTextField username = new JTextField(10);
   private JPasswordField password = new JPasswordField( 10 );
   private JPasswordField conPassword = new JPasswordField(10);
   private JTextField comment= new JTextField("Fill the above to ceate account");
   itineraryDBManager IDBM = new itineraryDBManager();
    
    public MainMenu() throws SQLException{
        
    super("LOGIN");//The title bar display text

      submit = new JButton("SUBMIT");
      mainMenu = new JButton("BACK TO MAIN?");
      comment.setEditable(false);
      mainPanel.setLayout(new GridLayout(5,2,5,5));
      mainPanel.add(name);
      mainPanel.add(username);
      mainPanel.add(pass);
      mainPanel.add(password);
      mainPanel.add(conPass);
      mainPanel.add(conPassword);
      mainPanel.add(submit);
      mainPanel.add(mainMenu);
      mainPanel.add(comment);
      mainPanel.setPreferredSize(MAIN_SIZE);
   
   
     mainMenu.addActionListener(this);  
     submit.addActionListener(this);

          uname = username.getText();
     setLocation(200,200);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(mainPanel);
    setSize(400,400);
    setVisible(true);
    }
    
    
   //Function describing the various action events related to the different buttons
    public void actionPerformed(ActionEvent evt){
    
    /* the mainMenu button on being clicked
     * re directs the user to the main page
     */
        
    if(evt.getSource()==mainMenu){
    MainFrame mm= new MainFrame();
    mm.setVisible(true);
    this.setVisible(false);
    }
     
    /*the submit button analyses the input data 
     * and accordingly creates a new account
     * for the end user.It is kept in a try block to 
     * check for SQLException
     */
    
    try
         {
          
    if(evt.getSource()==submit)
    {
    String check;
    String uname;
    
    AudioPlayer MGP = AudioPlayer.player;
    AudioStream BGP;
    AudioData BP;
    
    ContinuousAudioDataStream loop = null;
                try {
                    BGP = new AudioStream(new FileInputStream("applause.wav"));
                    BP = BGP.getData();
                    loop = new ContinuousAudioDataStream(BP);
                 } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
    MGP.start(loop);
    
    char[] pass1 = password.getPassword();
    char[] pass2 = conPassword.getPassword();
    uname = username.getText();
    
    String newPass=new String(pass1);
    
    check = IDBM.userCheckTable(uname);
    
    if(!pass2.equals(pass1) && "***".equals(check))
    {
    IDBM.userTable(uname,newPass);    
    optionPanel op= new optionPanel(uname);
    op.setVisible(true);
    this.setVisible(false);
    JOptionPane.showMessageDialog(this, "WELCOME! YOUR ACCOUNT HAS BEEN SUCCESSFULLY SET UP.");
    }
    else if(pass2.equals(pass1) && check == "***")
    { 
    comment.setText("Passwords mis-match!!!");
    
    JOptionPane.showMessageDialog(this,"Passwords mis-match!!!");
    }
    else
    {
        comment.setText("Username already exists,please try some other!");
    JOptionPane.showMessageDialog(this, "Username already exists,please try some other!");
    
    }
         }}
    
     catch (SQLException ex)
         {
            ex.printStackTrace();
            System.exit(0);
         }
    
    }}
    
    
    
    

