//all the necessary imports
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.DoubleStream;

class OlympicFrame extends JFrame implements ActionListener {
	
	private JButton [ ] jbArray;
	private final String [] countryArray = {"USA", "Spain", "China", "Japan", "Italy", 
											"Germany", "France", "Brazil", "Netherland",
											"Poland", "Russia", "Ukraine"};
	
	private ArrayList<Olympic> alist = new ArrayList<Olympic>();
	double [] scoreArray = new double [countryArray.length];
	
	
	public OlympicFrame() {
		super("Olympic 2020");
		setLayout (new GridLayout (4,3));
		constructAList();
		
		int a = 0;
		for(int i = 0; i < alist.size(); i++) {
			scoreArray[a] = alist.get(i).totalScores();
			a++;
		}
		
		//sort the score from highest to lowest
		scoreArray = Arrays.stream(scoreArray).boxed().
				sorted(Collections.reverseOrder()).
				mapToDouble(Double::doubleValue).toArray();

		//initialize the array
		jbArray = new JButton [countryArray.length];
		
		//initialize each of the buttons
		for (int i = 0; i < countryArray.length; i++ ) {
			Icon ic =new ImageIcon (String.valueOf(i + 1) + ".jpg");
			jbArray[i] = new JButton(ic);
		}
		
		//add buttons to JFrame
		for (JButton jb : jbArray) {
			add(jb);
			
		}
		//register the events to each buttons
		for (JButton jb : jbArray) {
			jb.addActionListener(this);
		}
	}
	
	private void constructAList() {
		for(int i = 0; i < countryArray.length; i++ ) {
			alist.add(new Olympic(countryArray[i]));
		}
	}
	
	private int getRank(double[] scoreArray, double d) {
		int rank = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			if(scoreArray[i] == d) {
				rank = i+1;
			}
		}
		return rank;
	}
	
	private String getFinalRanking() {
		String header = "FINAL RANKING\n";
		String ranking = "\n";
		
		for (int i = 0; i < scoreArray.length; i++ ) {
			ranking += String.format("Rank %d: %s(%.2f)%n", i+1, 
					getCountry(alist, i).toUpperCase(), getScores(alist, getCountry(alist,i)));
		}
		return header + ranking;
	}
	
	private String getCountry(ArrayList<Olympic> alist, int n) {
		String country = "";
		for (int i = 0; i < alist.size(); i++ ) {
			for(int k = 0; k < scoreArray.length; k++ ) {
				if(scoreArray[n] == alist.get(i).totalScores()) {
					country = alist.get(i).getName();
				}
			}
		}
		return country;
	}

	private double getScores(ArrayList<Olympic> alist, String name) {
		double score = 0;
		for (int i = 0; i < alist.size(); i++ ) {
			if(alist.get(i).getName() == name) {
				score = alist.get(i).totalScores();
			}
		}
		return score;
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		
		int k = 0;
		for (int i = 0; i < jbArray.length; i++ ) {
			
			if(e.getSource() == jbArray[i]) {
				Icon ic = new ImageIcon ("trophy.jpg");
				jbArray[i].setText("Rank: " + getRank(scoreArray, getScores(alist, countryArray[k]) ));
				JOptionPane.showMessageDialog(null, getFinalRanking(), "Miss World 2020", JOptionPane.PLAIN_MESSAGE, ic);
			}
			k++;
		}	
	}
}
	
class Olympic {
	private int NO;
	private String country;
	private double[] score;
	private int rank;
	
	public Olympic(String country) {
		this.country = country;
		this.rank = 0;
		this.NO = 10;
		this.score = new double[NO];
		processScores();
	}
	
	public Olympic(Olympic oly) {
		this.country = oly.country;
	}
	
	//get random scores
	public void processScores() {
		Random rand = new Random();
		for (int i = 0; i < score.length; i++) {
			score[i] = rand.nextDouble() * 100.0;
		}
	}
	
	//total scores
	public double totalScores() {
		return DoubleStream.of(score).sum();
	}
	
	public void set(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getName() {
		return country;
	}
	
	private double[] getScoreArray() {
		return score;
	}
	
	public String toString() {
		return String.format("Rank %d:%s(%.2f)%n", getRank(), getName(), totalScores());
	}
}

public class A3 {

	public static void main(String[] args) {
		OlympicFrame of = new OlympicFrame();
		of.setSize(600,550);
		of.setVisible(true);
		of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
