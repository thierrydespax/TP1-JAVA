
 package tp1;

/**
 * @author Despax Thierry
 * @version 2.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.StringTokenizer;
 
public class Gestioneleve extends JFrame implements ActionListener,KeyListener {
/**
 * zones à déclarer: 3 boutons Chercher(but1) Ajouter(But2) et effacer(But3)
 * 3 zones avec leurs labels numero nom prenom et une combo box pour le sexe
 */    
private JButton But1 = new JButton ("Chercher"); 
private JButton But2 = new JButton ("Ajouter");
private JButton But3 = new JButton("Effacer"); 
private JLabel Lab1  = new JLabel ("Numero");
private JTextField Num = new JTextField();    
private JLabel Lab2 = new JLabel ("Nom");
private JTextField Nom = new JTextField();
private JLabel Lab3 = new JLabel ("Prenom");
private JTextField Prenom = new JTextField();
private JLabel Lab4 = new JLabel ("Sexe");
private JComboBox  Comb = new JComboBox();

/**
 * Définition de la fenêtre Gestioneleve
 */
Gestioneleve (){
setVisible(true); /* affichage */
setTitle("Gestion Eleve"); /* titre */
setSize(700,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);
But1.setEnabled(false); 
But2.setEnabled(false);

/**
 * Position des zones sur la fenêtre
 */
Lab1.setBounds(20,20,150,20);
Num.setBounds(180,20,150,20);    
Lab2.setBounds(20,40,150,20);
Nom.setBounds(180,40,150,20);   
Lab3.setBounds(20,60,150,20);
Prenom.setBounds(180,60,150,20);   
Lab4.setBounds(20,80,150,20);
Comb.setBounds(180,80,150,20);

But1.setBounds(20,100,150,20);
But2.setBounds(140,100,150,20);
But3.setBounds(20,130,150,20);

/**
 * Mise en place d'écouteurs sur les zones numero nom et prenom
 * ainsi que sur les boutons
 */
Num.addKeyListener(this);
Nom.addKeyListener(this);
Prenom.addKeyListener(this);

But1.addActionListener(this);
But2.addActionListener(this);
But3.addActionListener(this);

/**
* Affectation des zones et des boutons sur la fenêtre
*/
 getContentPane().add(Lab1);
 getContentPane().add(Num);
 getContentPane().add(But1);    
 getContentPane().add(Lab2);
 getContentPane().add(Nom);
 getContentPane().add(Lab3);
 getContentPane().add(Prenom);
 getContentPane().add(But2);
 getContentPane().add(But3);
 getContentPane().add(Comb);
 getContentPane().add(Lab4);
 Comb.addItem("Masculin");
 Comb.addItem("Feminin");
    
 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */   
    
}

/**
 * 
 * Test sur la zone numéro si celle-ci est saisie on active le bouton Chercher
 * Test sur les trois zones de saisie si celles-ci sont remplies on active le bouton Ajouter
 * Les trois méthodes concernant l'action des touches sont identiques
 */
public void keyReleased (KeyEvent ae){
        
 JOptionPane jop = new JOptionPane();
        
 if(!Num.getText().isEmpty()) 
    But1.setEnabled(true); 
 else {
    But1.setEnabled(false);  
 }
   
 if(!Num.getText() .isEmpty()&& !Nom.getText() .isEmpty() && !Prenom.getText() .isEmpty()) 
    But2.setEnabled(true); 
 else {
    But2.setEnabled(false);  
 }

}
public void keyPressed (KeyEvent ae){
        
 JOptionPane jop = new JOptionPane();
        
 if(!Num.getText().isEmpty()) 
    But1.setEnabled(true); 
 else {
    But1.setEnabled(false);  
 }
   
 if(!Num.getText() .isEmpty()&& !Nom.getText() .isEmpty() && !Prenom.getText() .isEmpty()) 
    But2.setEnabled(true); 
 else {
    But2.setEnabled(false);  
 }

}
public void keyTyped (KeyEvent ae){
        

JOptionPane jop = new JOptionPane();
        
 if(!Num.getText().isEmpty()) 
    But1.setEnabled(true); 
 else {
    But1.setEnabled(false);  
 }
   
 if(!Num.getText() .isEmpty()&& !Nom.getText() .isEmpty() && !Prenom.getText() .isEmpty()) 
    But2.setEnabled(true); 
 else {
    But2.setEnabled(false);  
 }

}

/**
 * 
 * @param ae contient la source de l'élement (choix du bouton) 
 * 
 * si le bouton Effacer est activé on remet à blanc les zones de l'écran
 * si le bonton Ajouter est activé on ecrit dans le fichier texte avec une gestion de message d'erreur ou de succes
 * si le bouton Chercher est activé on fait une recherche dans le fichier et on affiche les zones si trouve 
 */
public void actionPerformed(ActionEvent ae){
  Object source = ae.getSource();  
  
  if (source == But3){
      Num.setText("");
      Nom.setText("");
      Prenom.setText("");
      But1.setEnabled(false);
      But2.setEnabled(false);
  }  
  if (source ==But2)
     { 
        String zone;  
        String Sexe;
        boolean trouve =false;
        
    try{
        BufferedReader  br = new BufferedReader(new FileReader("Eleves.txt"));
    
   int indice =Comb.getSelectedIndex();
   if (indice ==0)
       Sexe = "masculin";
   else
       Sexe = "feminin";
          
   zone= Num.getText() + " " + Nom.getText()+ " " + Prenom.getText() + " "+Sexe;
   String ligne;
    while ((ligne=br.readLine()) !=null &&!trouve)
    {
              StringTokenizer s= new StringTokenizer(ligne);
              String numlu= s.nextToken();
               if (numlu.compareTo(Num.getText())==0){
                  trouve = true;

                 JOptionPane jop = new JOptionPane();
                 jop.showMessageDialog(null,"Erreur - Eleve déjà existant","Message",JOptionPane.INFORMATION_MESSAGE);
               }
   
   }
    br.close();
    if (!trouve){
        BufferedWriter  bw = new BufferedWriter(new FileWriter("Eleves.txt",true));

        bw.write(zone);
        bw.newLine(); /* pour ecrire à la ligne */
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null,"Ajout de l'éléve avec succés","Message",JOptionPane.INFORMATION_MESSAGE);
   
        bw.close() ;
    }
        Num.setText("");
        Nom.setText("");
        Prenom.setText("");  
        But1.setEnabled(false);
        But2.setEnabled(false);
     
  }
   catch(FileNotFoundException e) {}
   catch(IOException e) {}

    
}
    if( source ==But1){
       { 
        boolean trouve =false;
        
    try{
        BufferedReader  br = new BufferedReader(new FileReader("Eleves.txt"));
    
    
   String ligne = null;
   String numlu = null;
   StringTokenizer s =null;
    while ((ligne=br.readLine()) !=null &&!trouve)
    {
       s= new StringTokenizer(ligne);       
               numlu= s.nextToken();
               if (numlu.compareTo(Num.getText())==0){
                   trouve = true;
                
               }
                
   }
    if (trouve){
    String nomlu = s.nextToken();
    String prenomlu= s.nextToken();
    String sexelu=s.nextToken();
    
    if(sexelu.compareTo ("masculin")==0){
        Comb.setSelectedIndex(0);}
    else
        Comb.setSelectedIndex(1);
        
    Num.setText(numlu);
    Nom.setText(nomlu);
    Prenom.setText(prenomlu);
      
    But1.setEnabled(false);
    But2.setEnabled(false);
    br.close();
    }
    else {
       JOptionPane jop = new JOptionPane();
       jop.showMessageDialog(null,"Eleve non trouve","Message",JOptionPane.INFORMATION_MESSAGE);
       Num.setText("");
    }          
  }
   catch(FileNotFoundException e) {}
   catch(IOException e) {}
    
}     
}
}
}
