package nanogram;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static boolean checkAnswer(boolean[][] a,boolean[][] b)
	{
		 for (int i = 0; i < a.length; i++)
		    {
		        

		        for (int j = 0; j < a[i].length; j++)
		        {
		            if (a[i][j] != b[i][j])
		                return false;
		        }
		    }
		return true;
	}
	public static void main(String[] args) {
		boolean[][] solution = {
			    {false, false, true , false, false},
			    {false, true , true , true , false},
			    {true , true , true , true , true },
			    {false, true , true , true , false},
			    {false, false, true , false, false}
			};
		boolean[][] actual = new boolean[5][5];
	    String[] rowHints= {"1",
	    	    "3",
	    	    "5",
	    	    "3",
	    	    "1"};
		String[] colHints= { "1",
			    "3",
			    "5",
			    "3",
			    "1"};
		JButton[][] cells = new JButton[5][5];
		JFrame frame = new JFrame("Centered Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        JPanel gridPanel = new JPanel(new GridLayout(6, 6));
        gridPanel.setPreferredSize(new Dimension(250, 250));

        for (int i = 0; i < 6; i++) {
        	for(int j=0;j<6;j++) 
        	{
        		if(i==0 && j==0) {
        			gridPanel.add(new JPanel());
        			//continue;
        		}
        	else if(i==0 && j>=1) {
        			gridPanel.add(new JLabel(" "+colHints[j-1]));
        		}
        		else if(j==0)
        		{
        			gridPanel.add(new JLabel(rowHints[i-1]));
        		}
        		
        		else
        		{
        			int row = i-1;
        			int col = j-1;
        			JButton btn = new JButton();
        			cells[row][col] = btn;
        			gridPanel.add(btn);
        			btn.addActionListener(e->{
        				if(!solution[row][col])
        					System.out.println("You clicked the wrong button");
        				else
        				{
        					btn.setBackground(Color.black);
        					actual[row][col] = true;
        					if (checkAnswer(solution, actual))
        					{
        					    JOptionPane.showMessageDialog(frame,
        					            "Congratulations! You solved the Nonogram!");

        					    for (int r = 0; r < cells.length; r++)
        					    {
        					        for (int c = 0; c < cells[r].length; c++)
        					        {
        					            cells[r][c].setEnabled(false);
        					        }
        					    }
        					}
        				}
        			});
        		}
        	}
        }
        
        frame.add(gridPanel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
