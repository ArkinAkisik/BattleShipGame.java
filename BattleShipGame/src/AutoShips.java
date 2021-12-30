import java.util.Scanner;
import java.util.*;
import java.awt.Label;
import java.lang.Object;

import java.util.*;


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AutoShips
{
    public static char [][] main(String[] args) {


        //char array[][] = new char [10][10];
        char [][] array2 ={{'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O'},};
                        
                      /*  Ships Destroyer = new Ships(2);
                        Ships Submarine = new Ships(3);
                        Ships Cruiser = new Ships(3);
                        Ships Battleship = new Ships(4);
                        Ships Carrier = new Ships(5); */

        boolean isValid=false;
        int count=0;
        int[] shipLenght = {2,3,3,4,5};
        char [] shipLetter ={'D','S','C','B','R'};

        while(!isValid || count<5)
        {
            isValid=true;

            int x=(int)(Math.random()*10);
            int y=(int)(Math.random()*10);
            int direction=(int)(Math.random()*2);

            if(direction == 1) //row++
            {
                int finalRowCoord= (shipLenght[count]-1)+x;
                isValid=validShipRow(array2,finalRowCoord,x,y);
                if(isValid)
                {
                    for(int i=x;i<=finalRowCoord;i++)
                    {
                        array2[i][y]= shipLetter[count];
                    }
                }
                if(!isValid)
                {
                    count--;
                }

            }
            else if(direction == 0) //col++
            {
                int finalColCoord = (shipLenght[count]-1)+y;
                isValid=validShipCol(array2,finalColCoord,y,x);
                if(isValid)
                {
                    for(int i=y;i<=finalColCoord;i++)
                    {
                        array2[x][i]= shipLetter[count];
                    }
                }
                if(!isValid)
                {
                    count--;
                }

            }
            else
            {
                continue;
            }



            count++;
        }
                                                            /*for (int i = 0; i < 10; i++) {
                                    
                                                                    for (int j = 0; j < 10; j++) {
                                            
                                                                        System.out.print(array2[i][j]+" ");
                                                                    }
                                                                    System.out.println(" ");
                                                                }*/
        return array2;
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
    }}