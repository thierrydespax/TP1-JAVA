 
package tp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
 /**
 * @author Despax Thierry
 * @version 2.0
 */
public class Authentification extends JFrame implements ActionListener {
/**
 *  2 zones implémentées Nom et mot de passe avec leurs labels
 *  launt nom label avec la zone Anom
 *  lautp Mot de passe avec la zone Apre
 *  et un bouton Valid pour se connecter
 */
private JLabel Lautn  = new JLabel ("Nom");
private JTextField Anom = new JTextField();    
private JLabel Lautp = new JLabel ("Mot de Passe");
private JTextField Apre = new JTextField();
    
private JButton Valid = new JButton ("Se connecter");
static int cpt=0; 
    
/**
 * definition de la fenetre d'affichage
 */
Authentification () {
setVisible(true); /* affichage */
setTitle("Authenfication"); /* titre */
setSize(700,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);

/**
 * Position des zones sur la fenetre
 */
Lautn.setBounds(20,20,150,20);
Anom.setBounds(180,20,150,20);    
Lautp.setBounds(20,40,150,20);
Apre.setBounds(180,40,150,20);   
Valid.setBounds(180,60,150,20);

/**
 * Mise en place d'un écouteur sur le bouton
 */
Valid.addActionListener(this);

/**
* Affectation des zones et des boutons sur la fenêtre
*/
getContentPane().add(Lautn);
getContentPane().add(Anom);
getContentPane().add(Lautp);    
getContentPane().add(Apre);
getContentPane().add(Valid);

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */

}
/**
 * 
 * @param ae = contient la source de l'évenement
 * Elle permet de tester le login et mot de passe avec une gestion de 3 essais(message d'erreur à chaque fois)
 * Si ok elle affiche le fenêtre Gestioneleve sinon on sort de la fenêtre
 */
public void actionPerformed (ActionEvent ae){
        
Object source = ae.getSource();

if (source == Valid)
          
    if((Anom.getText().compareTo ("Thierry")==0) && (Apre.getText().compareTo("Thierry")==0)){
    
     Gestioneleve aff = new Gestioneleve();
     this.dispose();
    }
    else{
        
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null,"Nom d'utilisateur ou mot de passe erronné(s) ","Message",JOptionPane.INFORMATION_MESSAGE);
        cpt++;
        if (cpt >= 3){
            this.dispose();}
    }
}     
}









