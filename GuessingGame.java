import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField field = new JTextField(10);;
  JButton guess = new JButton("Guess");;
  JButton playagain = new JButton("Play Again");
  JLabel highlow = new JLabel(""); 
  JLabel lastguess = new JLabel("");
  JLabel correct = new JLabel("Correct!");
  JLabel enterguess = new JLabel("Enter your guess: ");

  Random r = new Random();
  int randomInt = r.nextInt(100)+1;

  GuessingGame() {
  JFrame frame = new JFrame("Guessing Game"); 
  frame.setLayout(new FlowLayout()); 
  frame.setSize(240, 120); 

  field.setActionCommand("myTF"); 

  field.addActionListener(this);
  guess.addActionListener(this);
  playagain.addActionListener(this);

  frame.add(enterguess); 
  frame.add(field); 
  frame.add(guess); 
  frame.add(highlow); 
  frame.add(lastguess);
  frame.add(playagain); 
  frame.setVisible(true); 
  }

  public void actionPerformed(ActionEvent ae) { 
  if(field.getText()== ""){
      highlow.setText("Bad");
      return;
    }
  if(ae.getActionCommand().equals("Guess")) { 
    int guesscheck = Integer.parseInt(field.getText());
    if (guesscheck > randomInt) {
      highlow.setText("Too High");
      lastguess.setText("Last guess was: "+guesscheck);
    } else if(guesscheck < randomInt) {
      highlow.setText("Too Low");
      lastguess.setText("Last guess was: "+guesscheck);
    } else {
      highlow.setText("Correct!");
      lastguess.setText("Last guess was: "+guesscheck);
    }
  } else if (ae.getActionCommand().equals("Play Again")){
    int randomInt = r.nextInt(100) + 1;
    highlow.setText("");
    lastguess.setText("");
  } else {
    highlow.setText("You pressed Enter. Please press the Guess Button");
  }

  }
}



        




  
      