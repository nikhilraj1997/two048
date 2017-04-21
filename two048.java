import java.util.*;
public class two048
{
	static boolean flag,gamewon;
	static Scanner sc=new Scanner(System.in);
	static Random ra=new Random();
	public static void main(String[] args)
	{
		int[][] arr=new int[4][4];
		char choice;
		int a=ra.nextInt(4);
		int b=ra.nextInt(4);
		arr[a][b]=2;
		a=ra.nextInt(4);
		b=ra.nextInt(4);
		arr[a][b]=2;
		System.out.println("Following are the choice of moves:\nw to move "
				+ "up\ns to move down\na to move left\nd to move right\nq to quit");
		do
		{
			display(arr);
			if(stalemate(arr)){
				System.out.println("GAME OVER!");
				break;
			}
			if(gamewon){
				System.out.println("You won asshole!");
				break;
			}
			System.out.print("Enter your choice: ");
			choice=sc.nextLine().charAt(0);
			switch(choice)
			{
				case 's':
					arr=rotateleft(arr);
					moveleft(arr);
					addLeft(arr);
					moveleft(arr);
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					if(flag)
						{
						randomplacer(arr);
						System.out.println(flag);
						}
					break;
				case 'w':
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					moveleft(arr);
					addLeft(arr);
					moveleft(arr);
					arr=rotateleft(arr);
					if(flag)
						{
						System.out.println(flag);
						randomplacer(arr);
						}
					break;
				case 'a':
					moveleft(arr);
					addLeft(arr);
					moveleft(arr);
					if(flag)
						{
						System.out.println(flag);
						randomplacer(arr);
						}
					break;
				case 'd':
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					moveleft(arr);
					addLeft(arr);
					moveleft(arr);
					arr=rotateleft(arr);
					arr=rotateleft(arr);
					if(flag)
						{
						System.out.println(flag);
						randomplacer(arr);
						}
					break;
				case 'q':
				default:
					System.out.println("Enter correct option");
					break;
			}
			flag=false;
		}while(choice!='q');
	}
	static int[][] rotateleft(int[][] x)
	{
		int a[][]=new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				a[i][j]=x[3-j][i];
			}
		}
		return a;
	}
	static void moveleft(int[][] y)
	{
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<4;j++)
			{
				int x=j;
				if(y[i][j]!=0)
				while(x>0&&y[i][x-1]==0)
				{
					y[i][x-1]=y[i][x];
					y[i][x]=0;
					x--;
					flag=true;
				}
			}
		}
	}
	static void addLeft(int y[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<4;j++)
			{
				if(y[i][j-1]==y[i][j]&&y[i][j]!=0)
				{
					y[i][j-1]+=y[i][j];
					y[i][j]=0;
					flag=true;
				}
			}
		}
	}
	static void randomplacer(int z[][])
	{
		int[] num={2,4,8,16,32};
		int i,j=0,pos=0,a=0,b=0;
		int counter=0;
		do
		{
			a=ra.nextInt(4);
			b=ra.nextInt(4);
		}while(z[a][b]!=0);
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				if(z[i][j]==128)
					counter=1;
				if(z[i][j]==512)
					counter=2;
				if(z[i][j]==1024)
					counter=3;
			}
		}
		if(counter==0)
		{
			pos=ra.nextInt(3);
			z[a][b]=num[pos];
		}
		else if(counter==1)
		{
			pos=ra.nextInt(4);
			z[a][b]=num[pos];
		}
		else
		{
			pos=ra.nextInt(5);
			z[a][b]=num[pos];
		}
	}
	static void display(int arr[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print("\t"+arr[i][j]);
			}
			System.out.println();
		}
	}
	static boolean stalemate(int chk[][]){
		int i=0,j=0;
		int a[][]=new int[4][4];
		for(i=0;i<4;i++)
			for(j=0;j<4;j++)
				a[i][j]=chk[i][j];
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				if(a[i][j]==2048)
					gamewon=true;
				if(a[i][j]==0)
					return false;
				if(i-1>=0)
					if(a[i-1][j]==a[i][j])
						return false;
				if(i+1<4)
					if(a[i+1][j]==a[i][j])
						return false;
				if(j-1>=0)
					if(a[i][j-1]==a[i][j])
						return false;
				if(j+1<4)
					if(a[i][j+1]==a[i][j])
						return false;
			}
		}
		return true;
	}
}