package j;
import java.awt.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import javax.management.RuntimeErrorException;
import javax.swing.*;
 
class my_node {
	private Point point;
	private int data ;
	public int adjacent[];
	int count=0;
	my_node(){
		point =new Point ((int)(400*Math.random()),(int)(400*Math.random()));
		data =-1;
		adjacent=new int[20];
		for(int i=0;i<20;i++)
			adjacent[i]=-1;
	}
	public void setPoint(int a,int b){
		point.x=a;
		point.y=b;
	
	}
	public Point getPoint(){
		return point;	
	}
	public void setData (int a){
		data=a;
	}
	public int getData(){
		return data;	
	}
}
public class my extends JFrame{
	private JPanel n;
	private paintPanel center;	
	private JButton B1,B2,B3;
	private Vector v;
	private my_node node;
	boolean flag=false;int f;
	 boolean dragging=false;
	
			class paintPanel extends JPanel {
			//*	public paintPanel(){}
				public void paintComponent(Graphics g){
					super.paintComponent(g);
					
					my_node temp=new my_node();Point p,p2;my_node tempLink=new my_node();
					
					 for(int i=0;i<v.size();i++){
						 temp=(my_node)v.get(i);
						 p=new Point(temp.getPoint());
						 g.setColor(Color.YELLOW);
				        	g.fillRect(p.x, p.y, 40, 40);
							g.setColor(Color.BLACK);
				            g.drawString(""+temp.getData(), p.x+15, p.y+25);
				            g.setColor(Color.RED);
				            g.drawRect(p.x, p.y, 40, 40);	 
					 }//
					 for(int i=0;i<v.size()-1;i++){
						 temp=(my_node)v.get(i);
						 p=new Point(temp.getPoint());
						 for(int j=i+1;j<v.size();j++){
						 tempLink=(my_node)v.get(j);
						 p2=new Point(tempLink.getPoint());
						 for(int k=0;k<20;k++)
						 if(tempLink.getData()==temp.adjacent[k]&&temp.adjacent[k]!=-1){
						 g.setColor(Color.BLUE);
						 g.drawLine(p.x,p.y,p2.x,p2.y );}}
					 }
						
				
					}	
						 
						 
			}
				
			
	public my(){
		super("Graph Edittor");
		n=new JPanel();
		center=new paintPanel();	
		v=new Vector();
		
		B1=new JButton("Add New Node");
		B1.setToolTipText("Click to add new intager node");
		B2=new JButton("Add New Link");
		B2.setToolTipText("Click to add a lik between two EXISting nodes");
		B3=new JButton("Delete Node");
		B3.setToolTipText("Click to delete an EXISting node ");
		n.setLayout(new FlowLayout());
		n.add(B1);
		n.add(B2);
		n.add(B3);
		center.setBackground(Color.WHITE);
		center.setToolTipText("your work will apear hear");
		add(n,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);

		
		B1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						String s;	
						node=new my_node();
						
						
						s=JOptionPane.showInputDialog(my.this,"Enter number of node you want to ADD");
						my_node temp=new my_node();
						 for(int i=0;i<v.size();i++){
							 temp=(my_node)v.get(i);
						
				 }
						node.setData(Integer.parseInt(s));
						
						v.add(node);
						repaint();	
					
				
					
						
						}
				}
				);
		B2.addActionListener(
				new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
				      String d1,d2;
						d1=	JOptionPane.showInputDialog(my.this,"Enter the first node");
					boolean found =false;boolean found2 =false;boolean found3 =false;
						my_node temp=new my_node();int i;my_node temp2=new my_node();
						for( i=0;i<v.size();i++){
							temp=(my_node)v.get(i);
							 if(temp.getData()==Integer.parseInt(d1))found=true;
							 }
					
						d2=JOptionPane.showInputDialog(my.this,"Enter the second node");
						for( i=0;i<v.size();i++){
							temp=(my_node)v.get(i);
							 if(temp.getData()==Integer.parseInt(d2))found2=true;
							 }	if(!found2)	;
								
							 for( i=0;i<v.size();i++){
									temp=(my_node)v.get(i);
							if(temp.getData()==Integer.parseInt(d1))
								for(int k=0;k<20;k++){
									if(temp.adjacent[k]==Integer.parseInt(d2))found3=true;
								}	
								}
									if(found3);
						
						
						my_node link=new my_node();
						 for( i=0;i<v.size();i++){
							 link=(my_node)v.get(i);
							  if(Integer.parseInt(d2)==link.getData())
								 link.adjacent[link.count++]=Integer.parseInt(d1 ); 
							 if(Integer.parseInt(d1)==link.getData())
								 link.adjacent[link.count++]=Integer.parseInt(d2); 
							 
							 }
						
					 repaint ();	}
				
				}
				);
		B3.addActionListener(
				new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
					String S;
					S=	JOptionPane.showInputDialog(my.this,"Enter number of node you want to DELETE");
					boolean found =false;
					my_node temp=new my_node();int i;
					for( i=0;i<v.size();i++){
						temp=(my_node)v.get(i);
						 if(temp.getData()==Integer.parseInt(S))found=true;
						 }
					if(!found)	 ;
					my_node delete=new my_node();my_node delete2=new my_node();
					 for( i=0;i<v.size();i++){
						 delete=(my_node)v.get(i);
						  if(Integer.parseInt(S)==delete.getData()){
							  for(int k=0;k<0;k++)
								  delete.adjacent[k]=-1;
								for(int j=0;j<v.size();j++){
									 delete2=(my_node)v.get(j);
									 for(int k=0;k<20;k++)
									if(delete.adjacent[k]==delete2.getData()){
										 for(int l=0;l<20;l++)
											 if(delete2.adjacent[l]==Integer.parseInt(S))delete2.adjacent[l]=-1;
									}
								}
							v.remove(i);  
						  }
					 }
					 repaint ();	    	
				
				}}
				);

		
		center.addMouseListener(
				new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
			 }
			 public void mousePressed(MouseEvent evt) {
				 
				 my_node m=new my_node();String S; my_node m2=new my_node();
				 for(int i=0;i<v.size();i++){
					 m=(my_node)v.get(i);
				if(((evt.getX()<m.getPoint().x+40)&&(evt.getX()>m.getPoint().x))
				 &&((evt.getY()<m.getPoint().y+40)&&(evt.getY()>m.getPoint().y))){
				 f=m.getData();
				if(evt.isMetaDown()){
					
					S=	JOptionPane.showInputDialog(my.this,"Enter the new number ");
				
					my_node temp=new my_node();
					 for(int k=0;k<v.size();k++){
						 temp=(my_node)v.get(k);
						 
					 }
						m.setData(Integer.parseInt(S));
					for(int j=0;j<v.size();j++){
						 m2=(my_node)v.get(j);
						 for(int k=0;k<20;k++)
						if(m.adjacent[k]==m2.getData()){
							 for(int l=0;l<20;l++)
								 if(m2.adjacent[l]==f)m2.adjacent[l]=Integer.parseInt(S);	
						}
					}	}
			

						S=	JOptionPane.showInputDialog(my.this,"Enter the new number ");	
						m.setData(Integer.parseInt(S));
						for(int j=0;j<v.size();j++){
							m2=(my_node)v.get(j);
							 for(int k=0;k<20;k++)
							if(m.adjacent[k]==m2.getData()){
								 for(int l=0;l<20;l++)
									 if(m2.adjacent[l]==f)m2.adjacent[l]=Integer.parseInt(S);
						
				
				
				}}}
				
				 dragging=false;	
				 repaint();	 
			 }}
			 public void mouseReleased(MouseEvent evt) {
			
				 my_node m=new my_node();
				 for(int i=0;i<v.size();i++){
					 m=(my_node)v.get(i);
					 if(f==m.getData())
					m.setPoint(evt.getX(), evt.getY());
					dragging=false;
					//*v.addElement(node);}
				 }
						 repaint();
						  
				 
				 
			 }
		
		
		});
		
		center.addMouseMotionListener(
				new MouseMotionAdapter(){
					 public void mouseDragged(MouseEvent evt) { 
						 my_node m=new my_node();
						 for(int i=0;i<v.size();i++){
							 m=(my_node)v.get(i);
							 if(f==m.getData())
						 m.setPoint(evt.getX(), evt.getY());
						 dragging=true;
						// v.addElement(node);
						 }
						 repaint();
						 
						 
					 }	
					
					
					});
		
		
		
		
	
	
	
	
	
			
			
		}//frame
		
	
		
		
	public static void main(String[] args) {
	//JFrame frame =new JFrame();
	my x=new my();
	
	x .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	x.setSize(500,550);
	x.setVisible(true);
		
	

	}

	
	
	}
