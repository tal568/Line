package def;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

//htp help to player
class project {
	private static Soldier[][] bord = new Soldier[8][8];
	
	private static int enemy=12;
	private static int player=12;
	private static int turn=1;
	private static int depth;
   private static List<Moves> moves=null;
   private static int time;
	
   // amound of slodier each turn
	
	// [0][] is frome and [1][] is to
	
	// [0] is y ,[1] is x
	static int[] save = { -1, -1 };

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.setVisible(true);
		Diff dif=new Diff();
		menu.setSize(500, 500);
		RulseC rulse = new RulseC();
		MainGame play = new MainGame();
		rulse.GetBack().addActionListener(new Window(menu, rulse, play,dif));
		menu.GetHtp().addActionListener(new Window(menu, rulse, play,dif));
		menu.GetStart().addActionListener(new Window(menu, rulse, play,dif));
		play.GetSurnder().addActionListener(new Window(menu, rulse, play,dif));
		dif.GetMed().addActionListener(new Window(menu, rulse, play,dif));
		dif.GetHard().addActionListener(new Window(menu, rulse, play,dif));
		SetBord(play);
		play.GetUndo().addActionListener(new Move(play.GetAction(),play));



	}

	public static void SetBord(MainGame play) {
		for (int y = 0; y < play.GetAction().length; y++)
			for (int x = 0; x < play.GetAction()[0].length; x++) {
				bord[y][x] = new Soldier(0);
				play.SetIcon(y, x,null);
				if ((y == 0 || y == 7) && x != 0 && x != 7) {
					bord[y][x] = new Soldier(1);
					play.SetIcon(y, x, new ImageIcon(Menu.class.getResource("/def/black.png")));
				} else if ((x == 0 || x == 7) && y != 0 && y != 7) {
					bord[y][x] = new Soldier(-1);
					play.SetIcon(y, x, new ImageIcon(Menu.class.getResource("/def/red.png")));
				}
				play.GetAction()[y][x].addActionListener(new Move(play.GetAction(),play));
			}
	}

	public static Boolean ChackMove(int y, int x, int[] disway,int[] save) {

		// [0]up,down [1] left rith[2]\ [3]/

		if (save[0] == y) {
			if (Math.abs(save[1] - x) == disway[1])
				return true;
		} else if (save[1] == x) {
			if (Math.abs(save[0] - y) == disway[0])
				return true;
		} else if ((y - save[0]) == (x - save[1])) {
			if (Math.abs(y - save[0]) == disway[2] && Math.abs(x - save[1]) == disway[2])
				return true;
			return false;
		} else if (Math.abs(y - save[0]) == disway[3] && Math.abs(x - save[1]) == disway[3])
			return true;

		return false;
	}

	public static JButton[][] Paintbord(JButton[][] action,List<int[]> head) {
	 
        while(head!=null) 
        {
        	action[head.GetValue()[0]][head.GetValue()[1]].setBackground(Color.GREEN);
        	head=head.GetNext();
        }
			
		return action;
	}
	public static List<int[]> GetMove(Soldier[][] bord,int[] save) {
		
		
		int[] disway = new int[4];
		List head = null,move = null;
		List help = null;
		disway = DisWay(bord, save[0], save[1]);
		// [0]up,down [1] left rith[2]\ [3]/
	/*	for (int y2 = 0; y2 < bord.length; y2++)
			for (int x2 = 0; x2 < bord[0].length; x2++) {
				if(bord[y2][x2].GetPlayer()!=bord[save[0]][save[1]].GetPlayer())
				{
					
				if (ChackMove(y2, x2, disway,save)) 
				{
					int[] pos= {y2,x2};
				      
					help=new List(pos); 
					if(move==null) 
					{
						move=new List(pos);
						head=move;
					}
					else {
						move.SetNext(new List(pos));
					move=move.GetNext();
					}
					}
		
			}
			
			}
		*/
		int y,x;
		boolean legal=true;
		 x=save[1];
		 y=save[0]-disway[0];
		
		 if(y>=0) {
			 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
			 for(int j=save[0];j>y;j--) {
				 if(bord[j][x].GetPlayer()==-bord[save[0]][save[1]].GetPlayer()) {
				legal=false;
			 break;}
			 }
			if(legal) {
			 int[] arr= {y,x};
			 help=new List(arr);
		 head=help;
		 }
			 }
		 }
		 legal=true;
		y=save[0]+disway[0];
		 if(y<8) 
		 {
			 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
				 for(int j=save[0];j<y;j++) {
					 if(bord[j][x].GetPlayer()==-bord[save[0]][save[1]].GetPlayer()) {
						 legal=false;
				 break;}}
				
		 if(legal) {
			 if(head==null) 
			 {
				 int[] arr= {y,x};
				 help=new List(arr);
				 head=help;
			 }
			 else 
			 {   int[] arr= {y,x};
				 help.SetNext(new List(arr));
				 help=help.GetNext();
			 }
			 
		 
		 }
			 }
		 }
			 // up down
		 legal=true;
			y=save[0];
			 x=save[1]-disway[1];
			 if(x>=0) {
				 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
				 for(int i=save[1];i>x;i--) {
					 if(bord[y][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer()) {
						 legal=false;
				 break;}}
				
		 if(legal) {
					 
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
			 }
				 }
			 }
			 x=save[1]+disway[1];
			 legal=true;
				 if(x<8) {
					if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
					 for(int i=save[1];i<x;i++) {
						 if(bord[y][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer()) {
							 legal=false;
					 break;}}
					
			 if(legal) { 
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
					 }
					}	 
	}
				 // left R
				 int i=save[1],j=save[0];
				y=save[0]+disway[3];
				 x=save[1]-disway[3];
				 legal=true;
				 if(y<8&&x>=0) 
				 {
					 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
						
				  while((i>x &&j<y)&&legal) 
				  { if(bord[j][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer())
					  legal=false;
					  i--;
					  j++;
				  }
				  if(legal) {
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
					 }
				 }
				 }
				 y=save[0]-disway[3];
				 x=save[1]+disway[3];
				 legal=true;
				 i=save[1];
				  j=save[0];
				 if(y>=0&&x<8) 
				 {
					 
					 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
						 while((j>y&&i<x)&&(legal)) 
						 {
							 if(bord[j][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer())
								 legal=false;
							 j--;
							 i++;
						 }
				 if(legal) {
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
					 }
					 }
				 }
				 // \
				 y=save[0]-disway[2];
				 x=save[1]-disway[2];
				  i=save[1];
				  j=save[0];
				 legal=true;
				 if(y>=0&&x>=0) 
				 {
					 
					 
					 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
						 while((j>y&&i>x)&&legal) 
						 {
							 if(bord[j][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer())
							 legal=false;
							 j--;
							 i--;
						 }
						 if(legal) {
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
					 }
				 
					 }
				 }
					 legal=true;
					 i=save[1];
					  j=save[0];
				 y=save[0]+disway[2];
				 x=save[1]+disway[2];
				 if(y<8&&x<8) 
				 {
					 if(bord[y][x].GetPlayer()!=bord[save[0]][save[1]].GetPlayer()) {
				    while((j<y&&i<x)&&legal) 
				    {if(bord[j][i].GetPlayer()==-bord[save[0]][save[1]].GetPlayer())
						 legal=false;
				    	j++;
				    	i++;
				    }
				    if(legal) {
					 if(head==null) 
					 {
						 int[] arr= {y,x};
						 help=new List(arr);
						 head=help;
					 }
					 else 
					 {   int[] arr= {y,x};
						 help.SetNext(new List(arr));
						 help=help.GetNext();
					 }
				 
				    }
		 }
				 }
		
		return head;
		
	}
		

	public static void DefPaint(JButton[][] action) {
		for (int i = 0; i < action[0].length; i++)
			for (int j = 0; j < action.length; j++) {

				if ((i + j) % 2 == 0) {
					action[i][j].setBackground(Color.white);
				} else
					action[i][j].setBackground(Color.DARK_GRAY);

			}
	}
		public static void DefPosBord(Soldier[][] bord,JButton[][] action)
		
		{
			for (int y = 0; y < action[0].length; y++)
				for (int x = 0; x < action.length; x++) 
				{
                 if(bord[y][x].GetPlayer()==0)
                	 action[y][x].setIcon(null);
                 else
                 if(bord[y][x].GetPlayer()==1)
                	 action[y][x].setIcon(new ImageIcon(Menu.class.getResource("/def/black.png")));
				
			else
				action[y][x].setIcon(new ImageIcon(Menu.class.getResource("/def/red.png")));
		}
		}
	

	// after a move was made i call the MakeMove
	public static Soldier[][] MakeMove(JButton[][] action, Soldier[][] bord,int [] end,int[] save,MainGame play) {// 0 is up 1 is left rith 3
		// in save 0 is y and 1 is x // save save the start point end is the end point
		boolean eaten=false;
		int y=end[0];
		int x=end[1];
		if (save[0] == -1 && save[1] == -1) {
			if (bord[y][x].GetPlayer()==turn) {
				save[0] = y;
				save[1] = x;
				List head;
				head=GetMove(bord,save);
				action = Paintbord(action,head);

			}
			return bord;
		}
		if (save[0] == y && save[1] == x) {
			save[0] = -1;
			save[1] = -1;
			DefPaint(action);
			return bord;
		}
		if(bord[save[0]][save[1]].GetPlayer()==bord[y][x].GetPlayer()) 
		{
			save[0] = y;
			save[1] = x;
			DefPaint(action);
			List head;
			head=GetMove(bord,save);
			action = Paintbord(action,head);
			return bord;
		}

		if ((action[y][x].getBackground() != Color.green || bord[save[0]][save[1]].GetPlayer() == bord[y][x].GetPlayer())&&turn!=-1)
			return bord;
		
		
		// chak if the new pos is painted
		if(bord[save[0]][save[1]].GetPlayer() != bord[y][x].GetPlayer()&&bord[y][x].GetPlayer()!=0) 
		{
			if(bord[save[0]][save[1]].GetPlayer()==1) 
			{
				enemy--;
				eaten=true;
			}
			else { 
				player--;
				eaten=true;
			}
		}

		bord[y][x] = new Soldier(bord[save[0]][save[1]].GetPlayer());
		if (bord[y][x].GetPlayer() == 1) {
			action[y][x].setIcon(new ImageIcon(Menu.class.getResource("/def/black.png")));
			
			}
		else
		{
			action[y][x].setIcon(new ImageIcon(Menu.class.getResource("/def/red.png")));
			
			}
		bord[save[0]][save[1]].SetPlayer(0);
		action[save[0]][save[1]].setIcon(null);
		

			Moves move= new Moves(save.clone(),end,eaten);
		if(moves==null) 
		{
			moves=new List<Moves>(move);
		}
		else {
			
		
		List<Moves>help=moves;
		while(help.GetNext()!=null)
			help=help.GetNext();
		help.SetNext(new List<Moves>(move));
		
		}
		DefPaint(action);
		action[end[0]][end[1]].setBackground(Color.red);
		action[save[0]][save[1]].setBackground(Color.blue);
		save[0] = -1;
		save[1] = -1;
		
		

	    turn=-turn;
		
		play.SetEnemy(enemy);
		play.Setplayer(player);

 return bord;
	}

	public static int[] DisWay(Soldier[][] bord, int y, int x) {// say the number of move in aderction

		int[] num = new int[4];
		for (int j = 0; j < bord.length; j++) {
			if (bord[j][x].GetPlayer() != 0)
				num[0]++;
		}
		for (int i = 0; i < bord[0].length; i++) {
			if (bord[y][i].GetPlayer() != 0)
				num[1]++;
		}
		int i = x, j = y;
		// j =y ,i=x
		while (i > 0 && j > 0) {
			i--;
			j--;
		}
		while ((i >= 0 && j >= 0) && (i < 8 && j < 8)) {

			if (bord[j][i].GetPlayer() != 0)
				num[2]++;
			i++;
			j++;
		}
		i = x; 
		j = y;
		while (j > 0 && i < 7) {
			j--;
			i++;
		}
		while ((i >= 0 && j >= 0) && (i < 8 && j < 8)) 
		{

			if (bord[j][i].GetPlayer() != 0)
				num[3]++;
			j++;
			i--;
		}
		return num;

	}

	public static class Move implements ActionListener {
		private JButton[][] action;
		private MainGame play;
		private Menu menu;

		public Move(JButton[][] x,MainGame play) {
			this.action = x;
			this.play=play;
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] to= {0,0};
			
   
			if(arg0.getSource()==play.GetUndo()&& moves!=null) 
			{
			//	Soldier[][] bord,int[] save,int[] to,boolean eaten,int turn)
             UndoList(play.GetAction());
				
				
			}
			else
			if(arg0.getSource()!=play.GetUndo()) {
				
			while (arg0.getSource() != action[to[0]][to[1]]) {

				if (to[1] < action[0].length - 1)
					to[1]++;
				else if (to[0] < action.length) {
					to[1] = 0;
					to[0]++;
				} else if (to[0] == action.length - 1) {
					return;
				}
				
			}
	
			bord = MakeMove(action, bord, to,save,play);
			
		
		
			 if(turn==-1) {
				 
				
					AlpaBeta x =new AlpaBeta(depth);
					x.Start(bord, player, enemy,depth);
			 
			     MakeMove(action,bord,x.GetBestMove()[1],x.GetBestMove()[0],play);
			
			   
			 }
			 if(player==Win(bord,1)) 
			 {
				 JOptionPane.showMessageDialog(play, "the player Won");
				 while(moves!=null)
					 UndoList(action);
			     enemy=12;
			     player=12;
			 	play.SetEnemy(enemy);
				play.Setplayer(player);
				turn=1;
			 }
			 else
			 if(enemy==Win(bord,-1))
					 {
				 JOptionPane.showMessageDialog(play, "the player lost");
				 while(moves!=null)
				 UndoList(action);
					 }
			 turn=1;
					System.out.println("eneamy concetct:"+Win(bord,-1));
				

				}
			
		
				
		}
		}
	
		
	
	

	public static class Window implements ActionListener {

		private Menu menu;
		private RulseC rulse;
		private MainGame play;
		private Diff dif;

		public Window(Menu menu, RulseC rulse, MainGame play,Diff dif) {
			this.menu = menu;
			this.rulse = rulse;
			this.play = play;
			this.dif=dif;
		}
	



	
		

	

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			 if (arg0.getSource() == play.GetSurnder()) {
	             while(moves!=null) 
	             {
	            	 UndoList(play.GetAction());
	             }
	             play.setVisible(false);
	             menu.setVisible(true);
	             enemy=12;
	             player=12;
	         	play.SetEnemy(enemy);
	    		play.Setplayer(player);
	    }
	    else
			if (arg0.getSource() == menu.GetHtp()) {
				menu.setVisible(false);
				rulse.setVisible(true);
			} else if (arg0.getSource() == rulse.GetBack()) {
				menu.setVisible(true);
				rulse.setVisible(false);
			} else if (arg0.getSource() == menu.GetStart()) {
				menu.setVisible(false);
				rulse.setVisible(false);
				dif.setVisible(true);
			}
				else if(arg0.getSource() == dif.GetMed()) 
				{
					time=5;
					depth=3;
					dif.setVisible(false);
					 play.setVisible(true);
				}
				else if(arg0.getSource() == dif.GetHard()) 
				{
					time=15;
					depth=4;
					dif.setVisible(false);
					 play.setVisible(true);
				}

			}
			

		}

		
	
	
	
	
		public static int Win(Soldier[][] bord,int turn) 
		// 
		{
			int max=0;
		Stack<int[]> wait=new Stack();
		Stack<int[]>chaked=new Stack();
		for(int y=0;y<bord.length;y++)
			for(int x=0;x<bord[0].length;x++) 
			{
				
				if(bord[y][x].GetPlayer()==turn) 
				{int[] pice= new int[2];
				pice[0]=y;
				pice[1]=x;
				 if(!Contains(chaked,pice)&&!Contains(wait,pice))
				 {				 
				wait.add(pice);
				int max2=Ser(wait,chaked,turn,bord,y,x);
				
				if(max2>max)
					max=max2;
				
				}
				
					 						
				
				}
			}
		
		return max;
	
			
				}
		

	
		
		
		public static int Ser(Stack<int[]>wait,Stack<int[]>chaked,int turn, Soldier[][] bord,int y,int x) 
		// in pice 0 is the y
		{  int max=1;
           while(!wait.isEmpty()) 
           {
        	
        	   y= wait.peek()[0];
        	   x= wait.peek()[1];
        	   chaked.add(wait.pop());
        	   
        	   if(y>0)
        		   if(bord[y-1][x].GetPlayer()==turn) 
        		   {
        			  int[] pice= {y-1,x};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(x>0)
        		   if(bord[y][x-1].GetPlayer()==turn) 
        		   {
        			  int[] pice = {y,x-1};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			  
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	    if(y<7)
        		   if(bord[y+1][x].GetPlayer()==turn) 
        		   {
        			  int[] pice={y+1,x};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        				  				              
        			 
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(x<7)
        		   if(bord[y][x+1].GetPlayer()==turn) 
        		   {
        			  int[] pice= {y,x+1};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(y>0&&x>0)
        		   if(bord[y-1][x-1].GetPlayer()==turn) 
        		   {
        			  int[] pice= {y-1,x-1};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			 
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(y>0 && x<7)
        		   if(bord[y-1][x+1].GetPlayer()==turn) 
        		   {
        			   int[] pice= {y-1,x+1};
        			   if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			 
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(x>0&&y<7)
        		   if(bord[y+1][x-1].GetPlayer()==turn) 
        		   {
        			 int[] pice= {y+1,x-1};
        			 if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			  
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	   if(y<7 && x<7)
        		   if(bord[y+1][x+1].GetPlayer()==turn) 
        		   {
        			  int[] pice={y+1,x+1};
        			  if(!Contains(chaked,pice)&&!Contains(wait,pice))
        			   {
        			 
        			   wait.add(pice);
        			   max++;
        			   }
        		   }
        	  
        	   
           }

	     return max;

	}
		public static Boolean Contains(Stack<int[]> chaked,int[] pice) 
		{
			Stack<int[]>help= new Stack<int[]>();
			boolean in=false;
			while(!chaked.isEmpty())
				help.add(chaked.pop());
            while(!help.isEmpty()) 
            {
            	if(help.peek()[0]==(pice[0])&&help.peek()[1]==(pice[1]))
            		// chanch it 
            		in=true;
            		chaked.add(help.pop());
            }
			
			
				return in;
		
			
		}
	
	
	
	public static Soldier[][] SimpleMove(Soldier[][] bord,int y,int x,int [] save,int turn,int player,int enemy) 
	{// save is frome y x is to 
	if(bord[y][x].GetPlayer()==-turn) 
	{
		if(turn==-1) 
		{
			player--;
		}
		else 
			enemy--;
	}
	   bord[y][x].SetPlayer(bord[save[0]][save[1]].GetPlayer());
	   bord[save[0]][save[1]].SetPlayer(0);
		
			 
		return bord;
		
	}

	public static  Soldier[][] Undo (Soldier[][] bord,int[] save,int[] to,boolean eaten)
	{ 
		bord[save[0]][save[1]].SetPlayer(bord[to[0]][to[1]].GetPlayer());
		if(eaten==true&&bord[save[0]][save[1]].GetPlayer()==-1)
		{
			bord[to[0]][to[1]].SetPlayer(1);
		}
		else
		if(eaten==true&&bord[save[0]][save[1]].GetPlayer()==1) 
		{
			bord[to[0]][to[1]].SetPlayer(-1);
		}
		else
			bord[to[0]][to[1]].SetPlayer(0);
		
		return bord;

	} 
	public static void UndoList(JButton[][] action) 
	{
		List<Moves>help=moves;
		List<Moves>head=moves;
		while(moves.GetNext()!=null)
		{
			help=moves;
			moves=moves.GetNext();
		}
	
		bord=Undo(bord,moves.GetValue().GetMove()[0],moves.GetValue().GetMove()[1],moves.GetValue().GetEaten());
		
		if(help==moves)
		{
			moves=null;
		}
		else
		{
	   help.SetNext(null);
	   moves=head;
		}
		DefPosBord(bord,action);
		DefPaint(action);
	}

	
	}

	
	
	

	

	
 

		

	
