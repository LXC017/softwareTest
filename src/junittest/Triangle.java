package junittest;

public class Triangle {
	public int triangle(int a,int b,int c){
		//Return value
		//0 not a triangle
		//1 is a equilateral
		//2 is a isosceles
		//3 is a scalene
		if (istra(a,b,c)){
			if (a==b && a==c){
				return 1;
			}
			else if(a==b || a==c ||b==c){
				return 2;
			}
			else
				return 3;

		}
		else
			return 0;
	}
	private boolean istra(int a,int b,int c){
		if(a+b>c && a+c>b && b+c>a){
			return true;			
		}else{
			return false;
		}
		
	}

}
