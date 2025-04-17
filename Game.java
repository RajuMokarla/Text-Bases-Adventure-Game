package project1;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game {
	JFrame window;//for creation of seperate window
	Container con;
	JPanel titleNamePanel,startButtonPanel,mainTextPanel,choiceButtonPanel,playerPanel;
	JLabel titleNameLabel,hpLabel,hpLabelNumber,weaponLabel,weaponLabelName;
	Font titleFont=new Font("Times New Roman",Font.PLAIN,90);//customized font,font size
	Font normalFont=new Font("Times New Roman",Font.PLAIN,28);
	JButton startButton,choice1,choice2,choice3,choice4;
	JTextArea mainTextArea;
	int playerHP,monsterHP,silverRing;
	String weapon,position;
	
	TitleScreenHandler tsHandler=new TitleScreenHandler();
	ChoiceHandler choiceHandler=new ChoiceHandler(); 

	public static void main(String[] args) {
		new Game();

	}
	public Game() {
		window =new JFrame();//initializing the Jframe
		window.setSize(800,600);//size of the window(it takes values in px)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//it used to close the window
		window.getContentPane().setBackground(Color.black);//it sets the color of the window
		window.setLayout(null);//default layout
		window.setVisible(true);//it helps to apper on the screen
		con=window.getContentPane();
		
		titleNamePanel=new JPanel();//initialization
		titleNamePanel.setBounds(100,100,600,150);//space for creation the Title
		titleNamePanel.setBackground(Color.black);//color of the space
		titleNameLabel=new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);//inserting it to label
		
		
		startButtonPanel=new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		
		startButton=new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusable(false);
		
		titleNamePanel.add(titleNameLabel);	//inserting it to panel
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);//space for the printing
		con.add(startButtonPanel);
		
	}
	//creating the game play screen
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		mainTextPanel =new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		
		mainTextArea =new JTextArea("This is the main text area..This Game is going to be great..I'm sure of it!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);//it is used to change text to the next line
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel=new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));//4 represents the vertical and 1 represents the horizontal
		con.add(choiceButtonPanel);
		
		choice1=new JButton("Choice_1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusable(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2=new JButton("Choice_2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusable(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3=new JButton("Choice_3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusable(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4=new JButton("Choice_4");
		choice4.setBackground(Color.BLACK);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusable(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel =new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		hpLabel=new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		
		hpLabelNumber=new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel=new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		
		weaponLabelName=new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
		
	}
	
	public void  playerSetup() {
		playerHP=15;
		monsterHP=20;
		weapon="Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText(""+playerHP);
		townGate();
	}
	public void townGate() {
		position="townGate";
		mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\n\nWhat do you do?");
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
		
		
	}
	public void talkGuard() {
		position="talkGuard";
		mainTextArea.setText("Guard:Hello stranger.I have never seen your face.\nI'm sorry but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void attackGuard() {
		position ="attackGuard";
		mainTextArea.setText("Guard:Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You received 3 damage)");
		playerHP=playerHP-3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad() {
		position="crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south,you will go  back to the town.");
		choice1.setText("Go North");
		choice2.setText("Go East");
		choice3.setText("Go South");
		choice4.setText("Go west");
	}
	public void north() {
		position ="north";
		mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside.\n\n(your HP is recovered by 2)");
		playerHP=playerHP+2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
    public void east() {
		position ="east";
		mainTextArea.setText("You walked into a forest and found a long sword!\n\n(you obtained a long sword)");
		weapon="Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go West");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
    public void west() {
    	position ="west";
    	monsterHP=20;
    	mainTextArea.setText("You encounter a goblin!");
    	choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	
   }
    public void fight() {
    	position ="fight";
    	mainTextArea.setText("Monster HP: "+monsterHP+ "\n\nWhat do you do?");
    	choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
    }
    public void playerAttack() {
    	position ="playerAttack";
    	
    	int playerDamage=0;
    	if(weapon.equals("Knife")) {
    		playerDamage=new java.util.Random().nextInt(3);//damage will be 0,1 or 2.
    	}
    	else if(weapon.equals("Long Sword")) {
    		playerDamage=new java.util.Random().nextInt(9);//damage will be 0,1,2,3,4,5,6,7..
    	
    	}
    	
    	mainTextArea.setText("You attacked the monster and gave "+playerDamage+"damage!");
    	
    	monsterHP =monsterHP-playerDamage;
    	
    	choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
    }
    public void monsterAttack() {
    	position="monsterAttack";
    	
    	int monsterDamage=0;
    	monsterDamage =new java.util.Random().nextInt(6);
    	mainTextArea.setText("The monster attacked you and gave "+monsterDamage+"damage!");
    	playerHP=playerHP-monsterDamage;
    	hpLabelNumber.setText(""+playerHP);
    	choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
    }
    public void win() {
    	position="win";
    	mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
    	silverRing=1;
    	choice1.setText("Go East ");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
    }
    public void lose() {
    	position="lose";
    	
    	mainTextArea.setText("You are dead!\n\n<GAME OVER>");
    	choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
    }
    public void ending() {
    	position ="ending";
    	mainTextArea.setText("Guard: oh you killed that goblin!?\nThank you so much.You are a true hero!\nWelcome to our town!\n\n<THE END>)");
    	
    	choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
    }
    
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
			
		}
	}
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String yourChoice=event.getActionCommand();
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1":
					if(silverRing==1) {
						ending();
					}
					else {
						talkGuard();
					}
				break;
				case "c2":attackGuard();break;
				case "c3":crossRoad();break;
				
				}break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate();
				break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1":townGate();break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1":north();break;
				case "c2":east();break;
				case "c3":townGate();break;
				case "c4":west();break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1":crossRoad();break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1":crossRoad();break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1":fight();break;
				case "c2":crossRoad();break;
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1":playerAttack();break;
				case "c2":crossRoad();break;
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c1":
					if(monsterHP<1) {
						win();
					}
					else {
					monsterAttack();
			
				}
					break;
		}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c1":
					if(playerHP<1) {
						lose();
					}
					else {
					fight();break;
				}
					break;
				}	
				break;
			case "win":
				switch(yourChoice) {
				case "c1":crossRoad();
				}break;
				
				
			}
		}
	}

}