import java.util.Scanner;
import java.util.*;
import java.awt.Label;
import java.lang.Object;
import java.awt.Point;
import java.io.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserShips
{

    public static void main(String[] args) {
        //char array[][] = new char [10][10];
        char [][] array ={{'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},};
        AutoShips enemyMap = new AutoShips();


        char enemyArray[][] = new char [10][10];
        enemyArray = enemyMap.main(null);


        Scanner enter = new Scanner(System.in);

        System.out.print("\n\n\n\n\t\t\u274CWelcome to the Battleship Game\u274C \n\t\t\t   By Arkin Akisik\n\n\n\n\n\tThis is your battleship board. Let's place your ships.\n\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t\t\t");
            for (int j = 0; j < 10; j++) {

                System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.print("\n\nDO YOU WANT TO LOAD THE GAME? 1 for yes 0 for no\n");
        int load= enter.nextInt();
        if(load==1)
        {

            char loads[][][] = load(array,enemyArray);
            for (int k = 0; k < 10; k++) {

                for (int j = 0; j < 10; j++) {
                    enemyArray[k][j]=loads[0][k][j];
                }
            }
            for (int k = 0; k < 10; k++) {

                for (int j = 0; j < 10; j++) {
                    array[k][j]=loads[1][k][j];
                }
            }


            System.out.println("Here is the last game you have played");
            for (int i = 0; i < 10; i++) {
                System.out.print("\t\t\t");
                for (int j = 0; j < 10; j++) {

                    System.out.print(array[i][j]+" ");
                }
                System.out.println(" ");
            }
            System.out.print("\n\n\n");

            for (int i = 0; i < 10; i++) {
                System.out.print("\t\t\t");
                for (int j = 0; j < 10; j++) {

                    System.out.print(enemyArray[i][j]+" ");
                }
                System.out.println(" ");
            }

        }

              /*System.out.print("\n\nPRESS ENTER TO PLAY\n");
              String wait = enter.nextLine();*/




        Ships Destroyer = new Ships(2,'D');
        Ships Submarine = new Ships(3,'S');
        Ships Cruiser = new Ships(3,'C');
        Ships Battleship = new Ships(4,'B');
        Ships Carrier = new Ships(5,'R');

        Level beginner = new Level(1);
        Level intermediate = new Level(2);
        Level Hard = new Level(3);





        Scanner scan = new Scanner(System.in);

        System.out.println("Please Select Difficulty 1-3 \n 1:Easy 2:Intermediate 3:Hard");
        int level= scan.nextInt();
        if(level==3)
        {
            level = Hard.level;
        }
        else if(level==2)
        {
            level = intermediate.level;
        }
        else
        {
            level = beginner.level;
        }
        if(load==0)
        {
            System.out.println("You have 5 ships to place");

            boolean isValid=false;
            int count=0;
            int[] shipLenght = {Destroyer.lenght,Submarine.lenght,Cruiser.lenght,Battleship.lenght,Carrier.lenght};
            char [] shipLetter ={Destroyer.name,Submarine.name,Cruiser.name,Battleship.name,Carrier.name};

            while(!isValid || count<5)
            {
                System.out.println(5-count+" Ships left");
                isValid=true;
                System.out.println("Please Enter x coordinates:");
                int x = scan.nextInt();
                System.out.println("Please Enter y coordinates:");
                int y = scan.nextInt();
                System.out.println("Please Enter direction 1 is vertical 0 is horizinal:");
                int direction= scan.nextInt();

                if(direction == 1) //row++
                {
                    int finalRowCoord= (shipLenght[count]-1)+x;
                    isValid=validShipRow(array,finalRowCoord,x,y);
                    if(isValid)
                    {
                        for(int i=x;i<=finalRowCoord;i++)
                        {
                            array[i][y]= shipLetter[count];
                        }
                    }
                    if(!isValid)
                    {
                        System.out.println("Coordinates are invalid");
                        count--;
                    }

                }
                else if(direction == 0) //col++
                {
                    int finalColCoord = (shipLenght[count]-1)+y;
                    isValid=validShipCol(array,finalColCoord,y,x);
                    if(isValid)
                    {
                        for(int i=y;i<=finalColCoord;i++)
                        {
                            array[x][i]= shipLetter[count];
                        }
                    }
                    if(!isValid)
                    {
                        System.out.println("Coordinates are invalid");
                        count--;
                    }

                }
                else
                {
                    System.out.println("Invalid Direction.");
                    continue;
                }

                for (int i = 0; i < 10; i++) {
                    System.out.print("\t\t\t");
                    for (int j = 0; j < 10; j++) {

                        System.out.print(array[i][j]+" ");
                    }
                    System.out.println(" ");
                }

                count++;
            }
        }




        target(enemyArray,array,level);

    }
    public static boolean validShipRow(char [][] array,int finalPos,int startPosRow,int startPosCol){
        for(int i=startPosRow;i<=finalPos;i++){
            try{
                char a = array[i][startPosCol];
                a='\0';
            }
            catch(Exception e){
                return false;
            }
            try{
                char b = array[i][startPosCol];
                if(b!='O')
                {
                    return false;
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }

    public static boolean validShipCol(char [][] array,int finalPos,int startPosCol,int startPosRow){
        for(int i=startPosCol;i<=finalPos;i++){
            try{
                char a =array[startPosRow][i];
                a='\0';
            }
            catch(Exception e){
                return false;
            }
            try{
                char b = array[startPosRow][i];
                if(b!='O')
                {
                    return false;
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public static void enemyTarget(char [][]array, char [][] enemyArray, int level)
    {
        boolean isValid=false;
        while(true) {

            for(int i = 0; i<level;i++)
            {
                int x = (int)(Math.random()*10);

                int y=(int)(Math.random()*10);
                isValid=isTargetValid(array,y,x);
                if(isValid)
                {

                    if (array[x][y]!='O' && array[x][y]!='X' && array[x][y]!='M'){
                        System.out.println("Computer is HIT!!");
                        array[x][y]='X';
                    }
                    else if (array[x][y]=='O')
                    {
                        System.out.println("Computer is Missed!!");
                        array[x][y] = 'M';
                    }
                    else if (array[x][y]=='X' || array[x][y]=='M')
                    {
                        continue;
                    }
                }
                else
                {
                    continue;
                }
            }
            Player2Check(array);
            System.out.println("\t\t\tComputer's Map");
            for (int i = 0; i < 10; i++) {
                System.out.print("\t\t\t");
                for (int j = 0; j < 10; j++) {

                    System.out.print(array[i][j]+" ");
                }
                System.out.println(" ");
            }

            boolean victory = checkIfDone(array);
            if(victory)
            {
                System.out.println("Computer Has Won The Game");
                System.exit(0);
            }
            else
            {
                target(enemyArray,array, level);
            }

        }



    }
    public static void target(char [][]array, char [][] array2,int level)
    {


        Scanner scan = new Scanner(System.in);
        boolean isValid=false;
        save(array,array2);
        while(true) {

            System.out.print("\nPlease Enter Target's x coordinates: ");
            int x = scan.nextInt();
            System.out.print("Please Enter Target's y coordinates: ");
            int y = scan.nextInt();
            isValid=isTargetValid(array,y,x);
            if(isValid)
            {

                if (array[x][y]!='O' && array[x][y]!='X' && array[x][y]!='M'){
                    System.out.println("You HIT!!");
                    array[x][y]='X';
                }
                else if (array[x][y]=='O')
                {
                    System.out.println("You Have <Missed!!");
                    array[x][y] = 'M';
                }
                else if (array[x][y]=='X' || array[x][y]=='M')
                {
                    System.out.println("You have already attacked this place!");
                    continue;
                }
            }
            else
            {
                System.out.print("Invalid Coordinates!! ");
                continue;
            }

            Player1Check(array);
            System.out.println("\t\t\tYour Map");
            for (int i = 0; i < 10; i++) {
                System.out.print("\t\t\t");
                for (int j = 0; j < 10; j++) {

                    System.out.print(array[i][j]+" ");
                }
                System.out.println(" ");
            }
            boolean victory = checkIfDone(array);
            if(victory)
            {
                System.out.println("You Are Victorious!");
                System.exit(0);
            }
            else
            {
                enemyTarget(array2,array,level);
            }

        }


    }

    public static boolean isTargetValid(char [][] array,int startPosCol,int startPosRow){
        try{
            char a =array[startPosRow][startPosCol];
            a='\0';
        }
        catch(Exception e){
            return false;

        }
        return true;
    }
    public static boolean checkIfDone(char [][] array){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("\t\t\t");
            for (int j = 0; j < 10; j++) {

                if(array[i][j]=='X')
                {
                    count++;
                }
            }

        }

        if(count == 17)
        {
            return true;
        }
        else
        {
            return false;
        }




    }

    public static void Player1Check(char [][] array)
    {
        Player p1 = new Player(1);


        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if(array[i][j]=='X')
                {
                    p1.addHitPoint();
                }
            }

        }
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if(array[i][j]=='M')
                {
                    p1.addMissPoint();
                }
            }

        }

        System.out.println("Player 1 Hit Score is : "+p1.getHitPoints());
        System.out.println("Player 1 Missed Score is : "+p1.getMissPoints());

    }

    public static void Player2Check(char [][] array)
    {
        Player p2 = new Player(2);


        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if(array[i][j]=='X')
                {
                    p2.addHitPoint();
                }
            }

        }
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if(array[i][j]=='M')
                {
                    p2.addMissPoint();
                }
            }

        }
        System.out.println("Player 2 Hit Score is : "+p2.getHitPoints());
        System.out.println("Player 2 Missed Score is : "+p2.getMissPoints());
    }

    public static void save(char[][] array, char[][] array2)
    {
        Point[] points={ new Point(10,10)};
        try{
            File saveFile = new File("Battleship.txt");
            PrintStream writer = new PrintStream(saveFile);
            int index =0;

            while(index<points.length)
            {
                if(points[index]!=null)
                {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            writer.println(array[i][j]);
                            writer.println(array2[i][j]);
                        }

                    }
                }
                index++;
            }

            writer.close();
        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("The File Wasn't Found");
        }
    }
    public static char [][][] load(char[][] array, char[][] array2)
    {
        Point[] points={ new Point(10,10)};
        try{
            File loadFile = new File("Battleship.txt");
            Scanner reader = new Scanner(loadFile);

            int x,y;
            int index=0;
            while(reader.hasNext())
            {

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {

                        array[i][j]=reader.next().charAt(0);
                        array2[i][j]=reader.next().charAt(0);
                    }

                }

                //points[index] = new Point(x,y);
                index++;
            }

            reader.close();

        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("The File Wasn't Found");
        }
        char arrays[][][]= new char[2][10][10];

        for (int k = 0; k < 10; k++) {

            for (int j = 0; j < 10; j++) {
                arrays[0][k][j] = array[k][j];

            }
        }
        for (int k = 0; k < 10; k++) {

            for (int j = 0; j < 10; j++) {
                arrays[1][k][j] = array2[k][j];

            }
        }
        return arrays;
    }

}





