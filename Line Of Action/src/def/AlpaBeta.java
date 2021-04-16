package def;

public class AlpaBeta {


	private int[][] bestmove = {{0,0},{0,0}};
	private int o_depth;
	private int timeout=15000;
	private long start;
	

	public int[][] GetBestMove() 
	{
		return this.bestmove;
	}

	public AlpaBeta(int depth) 
	{
		
		this.o_depth=depth;	
	}
	
	public void Start(Soldier[][] bord,int player,int enemy,int depth) 
	{
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		start=System.currentTimeMillis();
		Max(bord,max,min,depth,player,enemy);
	}
// amount [player,enemy] count
		public  int Max(Soldier[][] bord,int max,int min,int depth,int player,int enemy) 
		// the max is the pc 
		{
			boolean eaten=false;
			int x=project.Win(bord, -1)-enemy;
		
			if(depth==0||System.currentTimeMillis()-start>=timeout||x==0)
	//	return project.Win(bord, 1)-player-x;
				return x-project.Win(bord, 1)+player;
				
		  List<int[][]>allmove=AllMoves(bord,-1);
						while(allmove!=null) 
						{
							int[] save= allmove.GetValue()[0];
							int[] to= allmove.GetValue()[1];
						
							eaten=SimpleMove(bord,save,to,eaten);
							if(eaten)
								player--;
							int value=Min(bord,max,min,depth-1,player,enemy);
							bord=Undo(bord,save,to,eaten); 
							if(eaten)
								player++;
							if(value>max) {
								max=value;
							
								if(depth==o_depth) {
								bestmove[0]=save;
								bestmove[1]=to;
								
								
							}
							}
							
							
							
							allmove=allmove.GetNext();
						
					
				
				
			if(max>=min) 
			{
				return max;
			}
						}
			
			return max;
		
}
			public int Min(Soldier[][] bord,int max,int min,int depth,int player,int enemy) 
			{	boolean eaten=false;
			int x=project.Win(bord, 1)-player;
			if(depth==0||System.currentTimeMillis()-start>=timeout||x==0)
					//return -(x-(project.Win(bord, -1)-enemy));
				return -x-enemy+project.Win(bord, -1);
				
				 List<int[][]>allmove=AllMoves(bord,1);
					while(allmove!=null) 
					{ if(allmove.GetValue()!=null) {
						
						int[] save= allmove.GetValue()[0];
						int[] to= allmove.GetValue()[1];
					
						eaten=SimpleMove(bord,save,to,eaten);
						if(eaten)
							enemy--;
						int value=Min(bord,max,min,depth-1,player,enemy);
						bord=Undo(bord,save,to,eaten); 
						if(eaten)
							enemy++;
						if(value<min) {
							min=value;
						
						
						}
						
						
					}
						allmove=allmove.GetNext();
					
				
			
			
				if(max<=min) 
				{
					return min;
				}
				

					}
				
				return min;
				
			}
		



			public  boolean SimpleMove(Soldier[][] bord,int[] save,int[] to,boolean eaten) 
			{// save is frome y x is to 
				if(bord[to[0]][to[1]].GetPlayer()==0)
				{
					eaten=false;
				}
				else
		     	  eaten=true;
				bord[to[0]][to[1]].SetPlayer(bord[save[0]][save[1]].GetPlayer());
				bord[save[0]][save[1]].SetPlayer(0);
				
		      return eaten;
				
			}
			
			public  Soldier[][] Undo (Soldier[][] bord,int[] save,int[] to,boolean eaten)
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

			
public List<int[][]>AllMoves(Soldier[][] bord,int turn)
{
	List<int[][]>allmoves=new List<int[][]>();
	List<int[][]>help=allmoves;
	for(int y=0;y<bord.length;y++)
		for(int x=0;x<bord[0].length;x++) 
		{
			if(bord[y][x].GetPlayer()==turn) 
			{
				int[] start= {y,x};
				List<int[]>moves=project.GetMove(bord,start);
				
				while(moves!=null) 
				{
					int[] end= moves.GetValue();
					moves=moves.GetNext();
					
					if(help.GetValue()==null) 
					{ 
						int[][] insart= {start,end};
						help.SetValue(insart);
						
					}
					else 
					{
					  int[][] insart= {start,end};
					  help.SetNext(new List<int[][]>(insart));
					  help=help.GetNext();
					}
				}
				
				
				
				
			}
		}
	
	return allmoves;
}
}




	
	
	
