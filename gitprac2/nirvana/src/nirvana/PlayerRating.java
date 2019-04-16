package nirvana;

public class PlayerRating {
private int playerPosition;
private String playerName;
private float criticOneRating;
private float criticTwoRating;
private float criticThreeRating;
private float averageRating;
private char category;

public PlayerRating(int playerPosition,String playerName) {
this.playerPosition = playerPosition;
this.playerName = playerName;
}
 
public void calculateAverageRating(float criticOneRating, float criticTwoRating)
{
	averageRating= (criticOneRating+criticTwoRating)/2;
}

public void calculateAverageRating(float criticOneRating, float criticTwoRating ,float criticThreeRating )
{
	averageRating= (criticOneRating+criticTwoRating+criticThreeRating)/3;
}


public void calculateCategory(){
	if(averageRating >8){
		category='A';
	}
	else if(averageRating>5 && averageRating<=8){
		category='B';
		}
	else if (averageRating>0 && averageRating<=5){
		category='C';
	
	}
}

public void display()
{
	System.out.println("playerposition is " +playerPosition);
	System.out.println("Playername is "+playerName);
	System.out.println("averagerating is" +averageRating);
	System.out.println("the category is"+category);
	
}

public static void main(String[] args) {
	PlayerRating pl =  new PlayerRating(1, "kurt cobain");
	pl.calculateAverageRating(9, 9.9f);
	pl.calculateCategory();
	pl.display();
	
	PlayerRating p2 = new PlayerRating(1,"dave grohl");
	p2.calculateAverageRating(1, 1, 1);
    p2.calculateCategory();
    p2.display();
}
}
