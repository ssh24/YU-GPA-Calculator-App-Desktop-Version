import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class gpaGui extends JFrame
{
	private JLabel welcome;
	private JLabel option;

	private JRadioButton gpaCalcJRB;
	private JRadioButton reverseCalcJRB;
	private JRadioButton gradeSchemeJRB;
	
	
	private JTextField myOption;
	
	private JButton enterOption;
	
	
	public gpaGui()
	{
		this.setLayout(null);
		this.setTitle("YorkU GPA Calculator");
		this.setSize(550,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.getWelcome();
		this.getOption();
		this.getGPACalc();
		this.getReverseCalc();
		this.getGradeScheme();
		
		this.setLocation(330, 250);

		
		this.setVisible(true);
		
	}
	
	

	protected void getWelcome()
	{
		this.welcome = new JLabel("WELCOME TO YORK UNIVERSITY GPA CALCULATOR APP");
		Dimension size1 = this.welcome.getPreferredSize();
		this.welcome.setBounds(100, 20, size1.width, size1.height);
		this.add(welcome);
		
		Font f1 = this.welcome.getFont();
		Map attributes = f1.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		this.welcome.setFont(f1.deriveFont(attributes));
	}

	protected void getOption()
	{
		this.option = new JLabel("Please select an option:");
		Dimension size1 = this.option.getPreferredSize();
		this.option.setBounds(100, 60, size1.width, size1.height);
		this.add(option);
	}
	
	protected void getGPACalc()
	{
		MainHandlerClass handler = new MainHandlerClass();
		this.gpaCalcJRB = new JRadioButton("Calculate GPA");
		Dimension size1 = this.gpaCalcJRB.getPreferredSize();
		this.gpaCalcJRB.setBounds(200, 80, size1.width, size1.height);
		this.gpaCalcJRB.addActionListener(handler);
		this.add(gpaCalcJRB);
	}
	
	protected void getReverseCalc()
	{
		MainHandlerClass handler = new MainHandlerClass();
		this.reverseCalcJRB = new JRadioButton("Reverse GPA Calculator");
		Dimension size1 = this.reverseCalcJRB.getPreferredSize();
		this.reverseCalcJRB.setBounds(200, 100, size1.width, size1.height);
		this.reverseCalcJRB.addActionListener(handler);
		this.add(reverseCalcJRB);
	}
	
	protected void getGradeScheme()
	{
		MainHandlerClass handler = new MainHandlerClass();
		this.gradeSchemeJRB = new JRadioButton("Grading Scheme");
		Dimension size1 = this.gradeSchemeJRB.getPreferredSize();
		this.gradeSchemeJRB.setBounds(200, 120, size1.width, size1.height);
		this.gradeSchemeJRB.addActionListener(handler);
		this.add(gradeSchemeJRB);
	}
	
	public static void main(String[] args) 
	{
		gpaGui myGui = new gpaGui();
		
	
	}
	
	private class MainHandlerClass implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
		
			if(event.getSource() == gpaCalcJRB)
			{
				if(reverseCalcJRB.isSelected())
					reverseCalcJRB.setSelected(false);
				if(gradeSchemeJRB.isSelected())
					gradeSchemeJRB.setSelected(false);
				
				myGPA x = new myGPA();
			}
			if(event.getSource() == reverseCalcJRB)
			{
				if(gpaCalcJRB.isSelected())
					gpaCalcJRB.setSelected(false);
				if(gradeSchemeJRB.isSelected())
					gradeSchemeJRB.setSelected(false);
				
				ReverseCalc myReverse = new ReverseCalc();
			}	
			if(event.getSource() == gradeSchemeJRB)
			{
				if(gpaCalcJRB.isSelected())
					gpaCalcJRB.setSelected(false);
				if(reverseCalcJRB.isSelected())
					reverseCalcJRB.setSelected(false);
				
					GradeScheme myGS = new GradeScheme();
					myGS.myGradeScheme();
			}
				
		}
		
		/*******************CALCULATE GPA PART **************************/
		private class myGPA extends JFrame
		{
			private JLabel intro;
			private JTextField entry;
			private JButton goEntry;
			
			public myGPA()
			{
				this.setLayout(null);
				this.setTitle("Calculate GPA");
				Dimension d = new Dimension(600,75);
				this.setSize(d.width,d.height);
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				this.setResizable(false);
				
				this.getIntro();
				this.getEntry();
				this.getEntryButt();
				//this.setLocation(300, 300);
				
			}
			
			private void getIntro()
			{
				this.intro = new JLabel("Enter the number of courses you would like to calculate GPA for");
				Dimension size1 = this.intro.getPreferredSize();
				this.intro.setBounds(0, 10, size1.width, size1.height);
				this.add(intro);
			}
			
			private void getEntry()
			{
				this.entry = new JTextField(10);
				Dimension size2 = new Dimension(50, 20);
				this.entry.setBounds(400, 10, size2.width, size2.height);
				this.add(entry);
			}
			
			private void getEntryButt()
			{
				ChoiceHandlerClass ch = new ChoiceHandlerClass();
				this.goEntry = new JButton("Enter");
				
				Dimension x = new Dimension(75,20);
				this.goEntry.setBounds(470, 10, x.width, x.height);
				this.add(this.goEntry);
				this.goEntry.addActionListener(ch);
				
			}
			
			private class ChoiceHandlerClass implements ActionListener
			{
				public void actionPerformed(ActionEvent arg0)
				{
					int e = Integer.parseInt(entry.getText());
					if(arg0.getSource() == goEntry)
					{
						if(e <= 0 )
						{
							JOptionPane.showMessageDialog(new JFrame(), "Invalid number of courses. Cannot have 0 or less number of courses.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(e > 30)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Invalid number of courses. Can calculate GPA for at most 30 courses.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							GPACalc main = new GPACalc();
						}
				
					}
				}
				private class GPACalc extends JFrame
				{
					private int en;
					
					private JLabel number;
					
					private JTextField courseNameBoxes;
					private JTextField creditBoxes;
					private JTextField gradeBoxes;
					
					private JTextField[] jfCourse, jfCredit, jfGrade;

					private JLabel CourseName;
					private JLabel Credits;
					private JLabel Grade;
					
					private JButton Go;
					private JButton resetButt;
					private JButton save;
					private JButton load;
					private JButton localGPA;
					
					private Writer writer;
					
					private JFileChooser jfc;
					private double answer;
					
					public GPACalc()
					{
						this.setLayout(null);
						this.setTitle("Calculate GPA");
						Dimension d = this.getMaximumSize();
						this.setSize(d.width,d.height);
						this.setVisible(true);
						this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						this.setResizable(false);

						this.listNo();
					
						this.getCourseNameLabel();	
						this.getCourseNameBoxes();
						
						this.getCreditsLabel();
						this.getCreditBoxes();
						
						this.getGradeLabel();
						this.getGradeBoxes();
						
						this.calculateGPAButt();
						this.calLocalGpa();
						this.getReset();
						this.saveGPA();
						this.loadGPA();
						
						
						this.edit();
					}
					
					private void edit()
					{
						this.en = Integer.parseInt(entry.getText());
						for(int i = 0; i < en; i++)
						{
							jfCourse[i].setEditable(true);
							jfCredit[i].setEditable(true);
							jfGrade[i].setEditable(true);
						}
					}
					
					private void listNo()
					{
						for(int i = 0, j = 40; i < 30; i ++, j=j+22)
						{
							String s = "" + (i+1);
							if(i < 9)
							{
								this.number = new JLabel(s);
								Dimension size1 = this.number.getPreferredSize();
								this.number.setBounds(6, j, size1.width, size1.height);
								this.add(number);
							}
							else
							{
								this.number = new JLabel(s);
								Dimension size1 = this.number.getPreferredSize();
								this.number.setBounds(0, j, size1.width, size1.height);
								this.add(number);
							}
						}
					}
					
					/****COURSE BOXES **/
					private void getCourseNameLabel()
					{
						this.CourseName = new JLabel("Course Name");
						Dimension size1 = this.CourseName.getPreferredSize();
						this.CourseName.setBounds(150, 10, size1.width, size1.height);
						this.add(CourseName);
						Font f1 = this.CourseName.getFont();
						Map attributes = f1.getAttributes();
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						this.CourseName.setFont(f1.deriveFont(attributes));
					}
					
					private void getCourseNameBoxes()
					{
						this.jfCourse = new JTextField[30];
						for(int i = 0, j = 40; i < 30; i++, j=j+22)
						{
							this.courseNameBoxes = new JTextField(35);
							Dimension size2 = new Dimension(400,(int) 18.5);
							this.courseNameBoxes.setBounds(20, j, size2.width, size2.height);
							this.add(courseNameBoxes);
							this.jfCourse[i] = this.courseNameBoxes;
							this.courseNameBoxes.setEditable(false);
						}
					}
					
					private String getCourseBox(int i)
					{
						return this.jfCourse[i-1].getText();
					}
					
					//***CREDIT BOXES ****//*
					private void getCreditsLabel()
					{
						this.Credits = new JLabel("Credit Weight");
						Dimension size1 = this.Credits.getPreferredSize();
						this.Credits.setBounds(500, 10, size1.width, size1.height);
						this.add(Credits);
						Font f1 = this.Credits.getFont();
						Map attributes = f1.getAttributes();
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						this.Credits.setFont(f1.deriveFont(attributes));
					}
					
					private void getCreditBoxes()
					{
						this.jfCredit = new JTextField[30];
						for(int i = 0, j = 40; i < 30; i++, j=j+22)
						{
							this.creditBoxes = new JTextField(5);
							Dimension size2 = new Dimension(200,(int) 18.5);
							this.creditBoxes.setBounds(440, j, size2.width, size2.height);
							this.add(creditBoxes);
							this.jfCredit[i] = this.creditBoxes;
							this.creditBoxes.setEditable(false);
						}
					}
					
					private String getCreditBox(int i)
					{
						return this.jfCredit[i-1].getText();
					}
					
					//*** GRADE BOXES ***//*
					private void getGradeLabel()
					{
						this.Grade = new JLabel("Grade Achieved");
						Dimension size1 = this.Grade.getPreferredSize();
						this.Grade.setBounds(715, 10, size1.width, size1.height);
						this.add(Grade);
						Font f1 = this.Grade.getFont();
						Map attributes = f1.getAttributes();
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						this.Grade.setFont(f1.deriveFont(attributes));
					}
					
					private void getGradeBoxes()
					{
						this.jfGrade = new JTextField[30];
						for(int i = 0, j = 40; i < 30; i++, j=j+22)
						{
							this.gradeBoxes = new JTextField(5);
							Dimension size2 = new Dimension(200,(int) 18.5);
							this.gradeBoxes.setBounds(660, j, size2.width, size2.height);
							this.add(gradeBoxes);
							this.jfGrade[i] = this.gradeBoxes;
							this.gradeBoxes.setEditable(false);
						}
					}
					
					private String getGradeBox(int i)
					{
						return this.jfGrade[i-1].getText();
					}

					private void calculateGPAButt()
					{
						GPAHandlerClass gc = new GPAHandlerClass();
						this.Go =  new JButton("Calculate my YorkU Standard GPA (out of 9.0)");
						Dimension x = this.Go.getPreferredSize();
						this.Go.setBounds(920, 300, x.width, x.height);
						this.add(this.Go);
						this.Go.addActionListener(gc);
					}
					
					private void calLocalGpa()
					{
						GPAHandlerClass gc = new GPAHandlerClass();
						this.localGPA = new JButton("Calculate my Standard GPA (out of 4.0)");
						Dimension x = this.localGPA.getPreferredSize();
						this.localGPA.setBounds(940, 350, x.width, x.height);
						this.add(this.localGPA);
						this.localGPA.addActionListener(gc);
					}
					
					private void getReset()
					{
						GPAHandlerClass gc = new GPAHandlerClass();
						this.resetButt = new JButton("Reset");
						Dimension x = this.resetButt.getPreferredSize();
						this.resetButt.setBounds(1040, 400, x.width, x.height);
						this.add(this.resetButt);
						this.resetButt.addActionListener(gc);
					}
					
					private void saveGPA()
					{
						GPAHandlerClass gc = new GPAHandlerClass();
						this.save = new JButton("Save");
						Dimension x = this.save.getPreferredSize();
						this.save.setBounds(1040, 450, x.width, x.height);
						this.add(this.save);
						this.save.addActionListener(gc);
					}
					
					private void loadGPA()
					{
						GPAHandlerClass gc = new GPAHandlerClass();
						this.load = new JButton("Load");
						Dimension x = this.load.getPreferredSize();
						this.load.setBounds(1040, 500, x.width, x.height);
						this.add(this.load);
						this.load.addActionListener(gc);
					}
					
					private class GPAHandlerClass implements ActionListener
					{

						public void actionPerformed(ActionEvent arg0) 
						{
							if(arg0.getSource() == resetButt)
							{
								for(int i = 0; i < 30; i++)
								{
									jfCourse[i].setText("");
									jfCredit[i].setText("");
									jfGrade[i].setText("");
								}
							}
							else if(arg0.getSource() == save)
							{
								jfc = new JFileChooser();
								if(jfc.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION)
								{
									try 
									{
										writer = new PrintWriter(jfc.getSelectedFile()+"");
										writer.write("My grades: \r\n");
										for(int i = 0; i < en; i++)
										{
											writer.write(jfCourse[i].getText() 
													+ " "
													+ jfCredit[i].getText()
													+ " " + 
													jfGrade[i].getText() + "\r\n");
										}
										writer.write("\nCount = " + en);
										writer.close();
										JOptionPane.showMessageDialog(new JFrame(), "File saved.", "Calculate GPA", JOptionPane.INFORMATION_MESSAGE);
									} catch (Exception e) {
										System.exit(0);
									}
									
									
								}
							}
							else if(arg0.getSource() == load)
							{
								jfc = new JFileChooser();
								if(jfc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION)
								{
									try 
									{
										writer = new PrintWriter(new FileWriter(jfc.getSelectedFile()+"", true));
										File f = new File(jfc.getSelectedFile()+"");
										Scanner fs = new Scanner(f);
										int count = 0;
										String regex = "^[A-Z]{2}[/][A-Z]+[-][\\d]+[ ][\\d][ ][A-E][+]*$";
										
										while(fs.hasNextLine())
										{
											String line = fs.nextLine();
											if(line.matches(regex))
											{
												String[] fields = line.split(" ");
												jfCourse[count].setText(fields[0]);
												jfCredit[count].setText(fields[1]);
												jfGrade[count].setText(fields[2]);
												count++;
											}
											else
												continue;
											
										}
										writer.close();
										JOptionPane.showMessageDialog(new JFrame(), "File loaded.", "Calculate GPA", JOptionPane.INFORMATION_MESSAGE);
									} 
									
									catch (Exception e) {
										System.exit(0);
									}
								}
								else
								{
									System.exit(0);
								}
							}
							else if(arg0.getSource() == Go)
							{
								for(int i = 0; i < en; i++)
								{
									String s = jfCredit[i].getText();
									String t = jfGrade[i].getText();
									
									if(!(s.equalsIgnoreCase("3") || s.equalsIgnoreCase("4")
											|| s.equalsIgnoreCase("6") || s.equalsIgnoreCase("9")))
									{
										JOptionPane.showMessageDialog(null, "Invalid Credit Entry. Please try again.","Eror", 0);
										break;
									}
									
									if(!(t.equalsIgnoreCase("A+")
											||t.equalsIgnoreCase("A")
											||t.equalsIgnoreCase("B+")
											||t.equalsIgnoreCase("B")
											||t.equalsIgnoreCase("C+")
											||t.equalsIgnoreCase("C")
											||t.equalsIgnoreCase("D+")
											||t.equalsIgnoreCase("D")
											||t.equalsIgnoreCase("E")
											||t.equalsIgnoreCase("F")))
									{
										JOptionPane.showMessageDialog(null, "Invalid Grade Entry. Please try again.","Eror", 0);
										break;
									}
									else
									{
										String result = this.finalGPACalc();
										JOptionPane.showMessageDialog(new JFrame(), result, "Calculate GPA", JOptionPane.INFORMATION_MESSAGE);
										break;
									}
								}	
							}
							else if(arg0.getSource() == localGPA)
							{
								String result = this.finalStandardGPACalc();
								JOptionPane.showMessageDialog(new JFrame(), result, "Calculate GPA", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
						private double getGPA()
						{
							int[] arr = new int[en];
							double sum = 0;
							double sum2 = 0;

							for(int i = 0; i < en; i++)
							{
								String s = jfGrade[i].getText();
								int product = 0;
								product = Integer.parseInt(jfCredit[i].getText()) * GpaHelper.getGPA(s);
								arr[i] = product;
							}
							
							for(int i = 0; i < arr.length; i++)
							{
								sum = sum + arr[i];
							}
							
							for(int i = 0; i < en; i++)
							{
								sum2 = sum2 + Integer.parseInt(jfCredit[i].getText());
							}
							answer = sum / sum2;
							return answer;
						}
						private String finalStandardGPACalc()
						{
							DecimalFormat df = new DecimalFormat("0.00");
							double d = (this.getGPA() / 9.0) * 4.0;
							String result = "Your cumulative GPA out of 4.0 is " + df.format(d);
							return result;
						}
						private String finalGPACalc()
						{
							DecimalFormat df = new DecimalFormat("0.00");
							String result = "Your cumulative GPA out of 9.0 is " + df.format(this.getGPA());
							return result;
						}
					}
				}
			}
		}

		/****************** REVERSE GPA CALCLATOR PART ********************/
		private class ReverseCalc extends JFrame
		{
			private JButton reverseCalc;
			public JTextField aB, bB, cB, dB;
			private String e,f,g,h;
			private JLabel a,b,c,d;
			
			private JLabel result;

			public ReverseCalc()
			{
				this.setLayout(null);
				this.setTitle("Reverse GPA Calculator");
				this.setVisible(true);
				this.setSize(580, 200);
				this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				this.setResizable(false);
				
				this.label1();
				this.label2();
				this.label3();
				this.label4();
				
				this.calcButton();
				this.calcButtonHandler();
			}
			
			private void label1()
			{
				this.a = new JLabel("How many credits have you taken at York?");
				Dimension d1 = this.a.getPreferredSize();
				this.a.setBounds(40, 20, d1.width, d1.height);
				this.add(this.a);
				
				this.aB = new JTextField(5);
				Dimension d1B = this.aB.getPreferredSize();
				this.aB.setBounds(400, 20, d1B.width, d1B.height);
				this.add(this.aB);
			}
			
			private void label2()
			{
				b = new JLabel("What is your current cumulative GPA?");
				Dimension d2 = b.getPreferredSize();
				b.setBounds(40, 40, d2.width, d2.height);
				this.add(b);
				
				bB = new JTextField(5);
				Dimension d2B = bB.getPreferredSize();
				bB.setBounds(400, 40, d2B.width, d2B.height);
				this.add(bB);
			}
			
			private void label3()
			{
				c = new JLabel("How many credits are you planning to take in the next session?");
				Dimension d3 = c.getPreferredSize();
				c.setBounds(40, 60, d3.width, d3.height);
				this.add(c);
				
				cB = new JTextField(5);
				Dimension d3B = cB.getPreferredSize();
				cB.setBounds(400, 60, d3B.width, d3B.height);
				this.add(cB);
			}
			
			private void label4()
			{
				d = new JLabel("What is the GPA you would like to achieve?");
				Dimension d4 = d.getPreferredSize();
				d.setBounds(40, 80, d4.width, d4.height);
				this.add(d);
				
				dB = new JTextField(5);
				Dimension d4B = dB.getPreferredSize();
				dB.setBounds(400, 80, d4B.width, d4B.height);
				this.add(dB);
			}
			
			private void calcButton()
			{
				this.reverseCalc = new JButton("Calculate my reverse GPA");
				Dimension x = this.reverseCalc.getPreferredSize();
				this.reverseCalc.setBounds(360, 120, x.width, x.height);
				this.add(this.reverseCalc);
			}
			
			private void calcButtonHandler()
			{
				ReverseHandlerClass handler = new ReverseHandlerClass();
				this.reverseCalc.addActionListener(handler);
			}
			
			private class ReverseHandlerClass implements ActionListener
			{
				public void actionPerformed(ActionEvent e) 
				{
					String result = getResults();
					Object o = result;
					
					JOptionPane.showMessageDialog(new JFrame(), o, "Reverse GPA Calculator", JOptionPane.INFORMATION_MESSAGE);
				}
				
				protected double getTextA()
				{
					double d = Double.parseDouble(aB.getText());
					return d;
				}
				
				protected double getTextB()
				{
					double d = Double.parseDouble(bB.getText());
					return d;
				}
				
				protected double getTextC()
				{
					double d = Double.parseDouble(cB.getText());
					return d;
				}
				
				protected double getTextD()
				{
					double d = Double.parseDouble(dB.getText());
					return d;
				}
				
				private String getResults()
				{
					double credits_taken = getTextA();
					if (credits_taken >=3) 
					{
						double cumulative_gpa = getTextB();
						if(!(cumulative_gpa < 0 || cumulative_gpa > 9))
						{
							double grade_point = credits_taken * cumulative_gpa;
							double credits_next_session = getTextC();
							
							if(!(credits_next_session < 0))
							{
								double total_credits = credits_taken + credits_next_session;
								double desired_GPA = getTextD();
								
								if(!(desired_GPA <= 0 || desired_GPA > 9))
								{
									double desire_Grade_Point = total_credits * desired_GPA;
									double actual_Grade_Point = desire_Grade_Point- grade_point;
									double required_GPA = actual_Grade_Point/ credits_next_session;
								
									if (required_GPA <= 9)
									{
										DecimalFormat df = new DecimalFormat("0.00");
										String result = "You require a GPA of " + df.format(required_GPA) 
												+" next term in order to achieve your desired GPA of " + df.format(desired_GPA);
										return result;
									}
									else 
									{
										String result = "Your desired GPA is not possible to achieve. Please try again.";
										return result;
									}
								}
								else
								{
									String result = "Invalid desired GPA. Please try again.";
									return result;
								}
							}
							else
							{
								String result = "Invalid credit entry. Please try again.";
								return result;
							}
						}
						else
						{
							String result = "Invalid cumulative GPA. Please try again.";
							return result;
						}
					}
					else 
					{
						String result = "Invalid credit entry. Please try again.";
						return result;
					}
				}
			}
		}
		/****************** GRADING SCHEME PART *******************/
		private class GradeScheme
		{
			private JLabel name1, name2, name3, name4;
			private JLabel lg1, lg2, lg3, lg4, lg5, lg6, lg7, lg8, lg9, lg10;
			private JLabel gp1, gp2, gp3, gp4, gp5, gp6, gp7, gp8, gp9, gp10;
			private JLabel gr1, gr2, gr3, gr4, gr5, gr6, gr7, gr8, gr9, gr10;
			private JLabel ds1, ds2, ds3, ds4, ds5, ds6, ds7, ds8, ds9, ds10;
			
			private void myGradeScheme()
			{
				JFrame one = new JFrame();
				one.setLayout(null);
				one.setTitle("Grade Scheme");
				one.setVisible(true);
				one.setSize(490, 260);
				one.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				one.setResizable(false);
				
				 /*TOP LABELS */
				name1 = new JLabel("Letter Grade");
				Dimension d1 = name1.getPreferredSize();
				name1.setBounds(40, 0, d1.width, d1.height);
				one.add(name1);
				Font f1 = name1.getFont();
				Map attributes = f1.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				name1.setFont(f1.deriveFont(attributes));
				
				name2 = new JLabel("Grade Point");
				Dimension d2 = name2.getPreferredSize();
				name2.setBounds(140, 0, d2.width, d2.height);
				one.add(name2);
				Font f2 = name2.getFont();
				Map attributes2 = f2.getAttributes();
				attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				name2.setFont(f2.deriveFont(attributes));
				
				name3 = new JLabel("Grade Range");
				Dimension d3 = name3.getPreferredSize();
				name3.setBounds(240, 0, d3.width, d3.height);
				one.add(name3);
				Font f3 = name3.getFont();
				Map attributes3 = f3.getAttributes();
				attributes3.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				name3.setFont(f3.deriveFont(attributes));
				
				name4 = new JLabel("Description");
				Dimension d4 = name2.getPreferredSize();
				name4.setBounds(350, 0, d4.width, d4.height);
				one.add(name4);
				Font f4 = name4.getFont();
				Map attributes4 = f4.getAttributes();
				attributes4.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				name4.setFont(f4.deriveFont(attributes));
				
				/*BOTTOM LABELS */
				
				 /*LETTER GRADE LABELS **/
				lg1 = new JLabel("A+");
				Dimension d5 = lg1.getPreferredSize();
				lg1.setBounds(60, 20, d5.width, d5.height);
				one.add(lg1);
				
				lg2 = new JLabel("A");
				Dimension d6 = lg2.getPreferredSize();
				lg2.setBounds(60, 40, d6.width, d6.height);
				one.add(lg2);
				
				lg3 = new JLabel("B+");
				Dimension d7 = lg3.getPreferredSize();
				lg3.setBounds(60, 60, d7.width, d7.height);
				one.add(lg3);
				
				lg4 = new JLabel("B");
				Dimension d8 = lg4.getPreferredSize();
				lg4.setBounds(60, 80, d8.width, d8.height);
				one.add(lg4);
				
				lg5 = new JLabel("C+");
				Dimension d9 = lg5.getPreferredSize();
				lg5.setBounds(60, 100, d9.width, d9.height);
				one.add(lg5);
				
				lg6 = new JLabel("C");
				Dimension d10 = lg6.getPreferredSize();
				lg6.setBounds(60, 120, d10.width, d10.height);
				one.add(lg6);
				
				lg7 = new JLabel("D+");
				Dimension d11 = lg7.getPreferredSize();
				lg7.setBounds(60, 140, d11.width, d11.height);
				one.add(lg7);
				
				lg8 = new JLabel("D");
				Dimension d12 = lg8.getPreferredSize();
				lg8.setBounds(60, 160, d12.width, d12.height);
				one.add(lg8);
				
				lg9 = new JLabel("E");
				Dimension d13 = lg9.getPreferredSize();
				lg9.setBounds(60, 180, d13.width, d13.height);
				one.add(lg9);
				
				lg10 = new JLabel("F");
				Dimension d14 = lg10.getPreferredSize();
				lg10.setBounds(60, 200, d14.width, d14.height);
				one.add(lg10);
				
				
				 /*GRADE POINT LABELS */
				gp1 = new JLabel("9");
				Dimension d15 = gp1.getPreferredSize();
				gp1.setBounds(160, 20, d15.width, d15.height);
				one.add(gp1);
				
				gp2 = new JLabel("8");
				Dimension d16 = gp2.getPreferredSize();
				gp2.setBounds(160, 40, d16.width, d16.height);
				one.add(gp2);
				
				gp3 = new JLabel("7");
				Dimension d17 = gp3.getPreferredSize();
				gp3.setBounds(160, 60, d17.width, d17.height);
				one.add(gp3);
				
				gp4 = new JLabel("6");
				Dimension d18 = gp4.getPreferredSize();
				gp4.setBounds(160, 80, d18.width, d18.height);
				one.add(gp4);
				
				gp5 = new JLabel("5");
				Dimension d19 = gp5.getPreferredSize();
				gp5.setBounds(160, 100, d19.width, d19.height);
				one.add(gp5);
				
				gp6 = new JLabel("4");
				Dimension d20 = gp6.getPreferredSize();
				gp6.setBounds(160, 120, d20.width, d20.height);
				one.add(gp6);
				
				gp7 = new JLabel("3");
				Dimension d21 = gp7.getPreferredSize();
				gp7.setBounds(160, 140, d21.width, d21.height);
				one.add(gp7);
				
				gp8 = new JLabel("2");
				Dimension d22 = gp8.getPreferredSize();
				gp8.setBounds(160, 160, d22.width, d22.height);
				one.add(gp8);
				
				gp9 = new JLabel("1");
				Dimension d23 = gp9.getPreferredSize();
				gp9.setBounds(160, 180, d23.width, d23.height);
				one.add(gp9);
				
				gp10 = new JLabel("0");
				Dimension d24 = gp10.getPreferredSize();
				gp10.setBounds(160, 200, d24.width, d24.height);
				one.add(gp10);
				
				/* GRADE RANGE LABELS */
				gr1 = new JLabel("90-100");
				Dimension d25 = gr1.getPreferredSize();
				gr1.setBounds(260, 20, d25.width, d25.height);
				one.add(gr1);
				
				gr2 = new JLabel("80-89");
				Dimension d26 = gr2.getPreferredSize();
				gr2.setBounds(265, 40, d26.width, d26.height);
				one.add(gr2);
				
				gr3 = new JLabel("75-79");
				Dimension d27 = gr3.getPreferredSize();
				gr3.setBounds(265, 60, d27.width, d27.height);
				one.add(gr3);
				
				gr4 = new JLabel("70-74");
				Dimension d28 = gr4.getPreferredSize();
				gr4.setBounds(265, 80, d28.width, d28.height);
				one.add(gr4);
				
				gr5 = new JLabel("65-69");
				Dimension d29 = gr5.getPreferredSize();
				gr5.setBounds(265, 100, d29.width, d29.height);
				one.add(gr5);
				
				gr6 = new JLabel("60-64");
				Dimension d30 = gr6.getPreferredSize();
				gr6.setBounds(265, 120, d30.width, d30.height);
				one.add(gr6);
				
				gr7 = new JLabel("55-59");
				Dimension d31 = gr7.getPreferredSize();
				gr7.setBounds(265, 140, d31.width, d31.height);
				one.add(gr7);
				
				gr8 = new JLabel("50-54");
				Dimension d32 = gr8.getPreferredSize();
				gr8.setBounds(265, 160, d32.width, d32.height);
				one.add(gr8);
				
				gr9 = new JLabel("49-40");
				Dimension d33 = gr9.getPreferredSize();
				gr9.setBounds(265, 180, d33.width, d33.height);
				one.add(gr9);
				
				gr10 = new JLabel("39-0");
				Dimension d34 = gr10.getPreferredSize();
				gr10.setBounds(270, 200, d34.width, d34.height);
				one.add(gr10);
				
				 /*DESCRIPTION LABELS */
				ds1 = new JLabel("Exceptional");
				Dimension d35 = ds1.getPreferredSize();
				ds1.setBounds(350, 20, d35.width, d35.height);
				one.add(ds1);
				
				ds2 = new JLabel("Excellent");
				Dimension d36 = ds2.getPreferredSize();
				ds2.setBounds(350, 40, d36.width, d36.height);
				one.add(ds2);
				
				ds3 = new JLabel("Very Good");
				Dimension d37 = ds3.getPreferredSize();
				ds3.setBounds(350, 60, d37.width, d37.height);
				one.add(ds3);
				
				ds4 = new JLabel("Good");
				Dimension d38 = ds4.getPreferredSize();
				ds4.setBounds(350, 80, d38.width, d38.height);
				one.add(ds4);
				
				ds5 = new JLabel("Competent");
				Dimension d39 = ds5.getPreferredSize();
				ds5.setBounds(350, 100, d39.width, d39.height);
				one.add(ds5);
				
				ds6 = new JLabel("Fairly Competent");
				Dimension d40 = ds6.getPreferredSize();
				ds6.setBounds(350, 120, d40.width, d40.height);
				one.add(ds6);
				
				ds7 = new JLabel("Passing");
				Dimension d41 = ds7.getPreferredSize();
				ds7.setBounds(350, 140, d41.width, d41.height);
				one.add(ds7);
				
				ds8 = new JLabel("Marginally Passing");
				Dimension d42 = ds8.getPreferredSize();
				ds8.setBounds(350, 160, d42.width, d42.height);
				one.add(ds8);
				
				ds9 = new JLabel("Marginally Failing");
				Dimension d43 = ds9.getPreferredSize();
				ds9.setBounds(350, 180, d43.width, d43.height);
				one.add(ds9);
				
				ds10 = new JLabel("Failing");
				Dimension d44 = ds10.getPreferredSize();
				ds10.setBounds(350, 200, d44.width, d44.height);
				one.add(ds10);	
			}
		}
	}
}