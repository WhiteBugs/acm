package com.acm;

import java.util.Scanner;

/**
 * Create by WhiteBugs .
 */
public class SnakeNumber {

    private int size;

    private boolean clockwise;

    private int[][] array;

    public SnakeNumber(int size){
        this(size,true);
    }

    public SnakeNumber(int size, boolean clockwise){
        this.size = size;
        this.clockwise = clockwise;
        dealWith();
    }

    private void dealWith(){
        array = new int[size][size];

        int flag = 1;
        int i=0, j=array[0].length-1;

        int size = (array.length)*(array[0].length);

        if(clockwise){
            while (flag<=size){
                while (true){
                    if(canAccess(array,i+1,j))
                        array[i++][j]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i,j-1))
                        array[i][j--]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i-1,j))
                        array[i--][j]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i,j+1))
                        array[i][j++]=flag++;
                    else
                        break;
                }
                if(flag == size)
                    array[i][j]=flag++;
            }
        }else {
            while (flag<=size){
                while (true){
                    if(canAccess(array,i,j-1))
                        array[i][j--]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i+1,j))
                        array[i++][j]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i,j+1))
                        array[i][j++]=flag++;
                    else
                        break;
                }
                while (true){
                    if(canAccess(array,i-1,j))
                        array[i--][j]=flag++;
                    else
                        break;
                }
                if(flag == size)
                    array[i][j]=flag++;
            }
        }
    }

    private boolean canAccess(int[][] array, int i, int j){
        if( i<0 || i>=array.length || j<0 || j>=array[0].length)
            return false;
        if(array[i][j] !=0)
            return false;
        return true;
    }


    public void printResult(){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("please input the size :");
        new SnakeNumber(in.nextInt(),false).printResult();
    }
}
