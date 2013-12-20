//Required packages
package mainframe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class displayScreen extends JFrame implements ActionListener {
   
    
   private JPanel mainPanel = new JPanel();
   private JPanel panel_1 = new JPanel();
   private JPanel panel_2 = new JPanel();
   private JPanel mainPanel1 = new JPanel();
   private JPanel mainPanel2 = new JPanel();
   private JPanel mainPanel3 = new JPanel();
   private JPanel mainPanel4 = new JPanel();
   private JPanel mainPanel5 = new JPanel(); 
   private JPanel mainPanel6 = new JPanel();
   private JPanel mainPanel7 = new JPanel();
   private JPanel mainPanel8 = new JPanel();
   
   private JTabbedPane tabbedPane = new JTabbedPane();
   
   private static final Dimension MAIN_SIZE = new Dimension(400, 400);
   
   
   private JLabel textType;
   private JLabel text1;
   private JLabel text2;
   private JLabel text3;
   private JLabel text4;
   private JLabel text5;
   private JLabel text6;
   private JLabel text7;
   private JLabel comment;
   
   private JButton back;
   private JButton done;
   
   
   private JTextField scheduleTypeText = new JTextField(10);
   private JTextField number = new JTextField(10);
   private JTextField name = new JTextField(10);
   private JTextField destinationText = new JTextField(10);
   private JTextField departureText = new JTextField(10);
   private JTextField destinationDate = new JTextField(10);
   private JTextField departureDate = new JTextField(10);
   private JTextField seatNumber = new JTextField(10);
   private JTextField hotelName = new JTextField(10);
   private JTextField contact1 = new JTextField(10);
   private JTextField contact2 = new JTextField(10);


   public displayScreen(Integer id) {
     
       super("SCHEDULE DETAILS");
       
       
       ImageIcon icon = new ImageIcon("C:\\Users\\Win\\Documents\\NetBeansProjects\\mainFrame\\build\\aggarwal_Project\\icon.gif");

    
       tabbedPane.addTab("PAGE-1",icon, panel_1,
                  "SCHEDULE DETAILS - SCREEN 1");
       tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);  
 
       tabbedPane.addTab("PAGE-2", icon, panel_2,
                  "SCHEDULE DETAILS - SCREEN 1");
       tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
      
      textType = new JLabel("SCHEDULE TYPE:");
      text3 = new JLabel("DEPARTURE DATE:");
      text4 = new JLabel("ARRIVAL DATE:");
      text1 = new JLabel("TRAVELLING FROM :");
      text2 = new JLabel("TO");
      text5 = new JLabel ("SEAT NUMBER:");
      text6 = new JLabel ("STAYING AT");
      text7 = new JLabel("IMPORTANT CONTACTS");
      comment = new JLabel("PRESS -> OR CLICK ON THE NEXT TAB ON THE TOP TO TURN TO NEXT PAGE");
      back = new JButton("BACK");
      done = new JButton("DONE");
      
      
      scheduleTypeText.setEditable(false);
      number.setEditable(false);
      name.setEditable(false);
      destinationText.setEditable(false);
      departureText.setEditable(false);
      destinationDate.setEditable(false);
      departureDate.setEditable(false);
      seatNumber.setEditable(false);
      hotelName.setEditable(false);
      contact1.setEditable(false);
      contact2.setEditable(false);

      mainPanel.add(tabbedPane);

      
      mainPanel1.add(textType);
      mainPanel1.add(scheduleTypeText);
      
      mainPanel2.add(text1);
      mainPanel2.add(departureText);
      mainPanel2.add(text2);
      mainPanel2.add(destinationText);
      
      mainPanel3.add(text3);
      mainPanel3.add(departureDate);
      mainPanel3.add(text4);
      mainPanel3.add(destinationDate);
      
      mainPanel4.add(back);
      mainPanel4.add(comment);
      
      panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
      panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
      
      panel_1.add(mainPanel1);
      panel_1.add(mainPanel2);
      panel_1.add(mainPanel3);
      panel_1.add(mainPanel4);
      
      
      mainPanel5.add(text5);
      mainPanel5.add(seatNumber);
      mainPanel6.add(text6);
      mainPanel6.add(hotelName);
      mainPanel7.add(text7);
      mainPanel7.add(contact1);
      mainPanel7.add(contact2);
      mainPanel8.add(done);
      mainPanel8.add(back);
      
      panel_2.add(mainPanel5);
      panel_2.add(mainPanel6);
      panel_2.add(mainPanel7);
      panel_2.add(mainPanel8);
      
      mainPanel.setPreferredSize(MAIN_SIZE); 

      
      
      back.addActionListener(this);  
      done.addActionListener(this);

    
    
      
      
      
      /*This action listener defines the
       * action of the exit button
       * that closes the screen on being used
       */
      
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(mainPanel);
    setSize(500,230);
    setVisible(true); 
    setLocation(200,200);
    
    
    
   
   }

   
   //Function describing the various action events related to the different buttons
public void actionPerformed(ActionEvent evt){
   /*The back button direts the user 
     * back to the edit panel where 
     * they can enter a new schedule id
     * or a set of details
     * in order to edit
     * or view a schedule
     */
    if(evt.getSource()==back){
            try {
                editSchedule es= new editSchedule(null);
                es.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(displayScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /*The done button re directs 
     * the end user to the option panel
     * and is an indication that the 
     * user has viewed the scheule in
     * a satifactory manner
     */
    if(evt.getSource()==done){
            try {
                optionPanel op= new optionPanel(null);
                op.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(displayScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    }} 
