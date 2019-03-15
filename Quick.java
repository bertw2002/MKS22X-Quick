import java.util.*;
import java.util.Random;
public class Quick{
  //helper that switches places
  private static void switch(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }

  //helper for partition that finds median value
  private static int whichBig(int x, int y, int z){
    int[] val = new int[2];
    if ((x > y && x < z ) || (x < y && x > z )) return 0;
    if ((x > y && y > z ) || (x < y && y < z )) return 1;
    return 2;
  }
//first attempt.
/*
  public static int partition (int [] data, int start, int end){
    //int randnum = (int)(Math.random() * (end - start) + start + 1);
    //int pivot = data[randnum];
    Random random = new Random();
    int rando = 2;
    int middle = ((end - start) / 2) + start;
    int biggest = whichBig(data[middle], data[start], data[end]);
    int big;
    if (biggest == 0){
      big = middle;
    }else if(biggest == 1){
      big = start;
    }
    else{
      big = end;
    }
    int upper = end;
    int lower = start + 1;
    int pivot = data[big];
    switch(data, start, big);
    //System.out.println("end:  " + data[start] + "middle: " + data[middle] + "end: " + data[end]);
    //System.out.println("pivot: " + pivot);
    //testing purposes
    //System.out.println("actual pivot, not index: " + pivot);
    //lower needs to smaller than increment.
    while (lower <= upper){

      if (data[lower] < pivot){
        switch(data, lower, start);
        lower++;
        start++;
        //System.out.println("lower: " + lower + "\n" + "upper: " + upper);
      }
      else if (data[lower] > pivot){
        switch(data, lower, upper);
        //System.out.println("lower: " + lower + "\n" + "upper: " + upper);
        upper--;
      }
      else{
        lower++;

      }
    }
    //return last position of pivot.
    return upper;
  }*/
//better code

  public static int partition (int [] data, int start, int end){
    int rando = 2;
    Random random = new Random();
    //int randnum = (int)(Math.random() * (end - start) + start + 1);
    int middle = ((end - start) / 2) + start;
    int biggest = whichBig(data[middle], data[start], data[end]);
    int big;
    if (biggest == 0){
      big = middle;
    }else if(biggest == 1){
      big = start;
    }
    else{
      big = end;
    }
    //pivot needs to be at end index to work.
    switch(data, big, end);
    int pivot = data[end];
    int upper = end;
    //testing purposes
    //System.out.println("actual pivot, not index: " + pivot);
    //lower needs to smaller than increment.
    int lower = start - 1;
    for (int increment = start; increment < upper; increment++){
      rando = random.nextInt(2)+1;
      if (data[increment] == pivot){
        if (rando == 1){
          lower++;
          switch(data, lower, increment);
        }
      }
      else if (data[increment] < pivot){
        //increment lower because element is smaller than pivot.
        lower++;
        switch(data, lower, increment);
      }
    }
    switch(data, lower + 1, end);
    //return last position of pivot.
    return lower + 1;
  }
  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int[] data, int k){
    //out of bounds
    if (k >= data.length || k < 0) throw new ArrayIndexOutOfBoundsException();
    return quickselectHelper(data, k, 0, data.length - 1);
  }
  private static int quickselectHelper(int[] data, int k, int start, int end){
    //testing purposes
    /*
    for (int x = 0; x < data.length; x++){
      System.out.println(data[x]);
    }*/
    //testing purposes

    //System.out.println("Start: " + start + "\n" + "End: " + end);
    int pivot = partition(data, start, end);
    //if equal, means you have found the kth term.
    if (k == pivot){
      return data[k];
    }
    //if smaller than pivot, do the recursive to the left because answer is to the left.
    else if (k < pivot){
      return quickselectHelper(data, k, start, pivot - 1);
    }//if bigger than pivot, do the recursive to the right because answer is to the right.
    else if (k > pivot){
      return quickselectHelper(data, k, pivot + 1, end);
    } else{
      return data[pivot];
    }
  }
  /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){
   quicksort(data, 0, data.length - 1);
 }
 private static void quicksort(int[] data, int start, int end){
   if (start >= end) {
     //as per Mr. K's suggestion.
     return;
   }else{

     int pivot = partition(data, start, end);
     //testing purposes
     /*
     for (int y = 0; y < data.length; y++){
       System.out.println(data[y]);
     }*/
    // System.out.println("data: ");
      quicksort(data, start, pivot - 1);
      quicksort(data, pivot + 1, end);
   }
 }




  public static void main(String[] args) {
/*
    int[] b = new int[] {1, 5, 7, 2, 6, 8, 9};

    System.out.println("\n" + "partition testing" + "\n");
    System.out.println("pivot: " + partition(b, 3, 6));

    for (int x = 0; x < b.length; x++){
      System.out.println(b[x]);
    }
    System.out.println("\n" + "quickselect testing" + "\n");
    int[] b1 = new int[] {1, 5, 5, 5, 7, 2, 6, 4, 3};
    System.out.println(quickselect(b1, 3));*/
    System.out.println("\n" + "quicksort testing" + "\n");

    // TEST FOR DUPLICATES LATER
    int[] b2 = new int[] {1, 1, 2, 3, 5, 7, 2, 6, 4, 3, 13, 23, 23, 92, 0, 200};
    quicksort(b2);
    for (int y = 0; y < b2.length; y++){
      System.out.println(b2[y]);
    }
  }

}
