public class Quick{
  //helper that switches places
  private static void switchPlace(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }

  //helper for partition that finds median value
  public static int whichBig(int x, int y, int z){
    if ((x > y && x < z ) || (x < y && x > z )) return x;
    if ((x > y && y > z ) || (x < y && y < z )) return y;
    return z;
  }
  public static int partition (int [] data, int start, int end){
    //int randnum = (int)(Math.random() * (end - start) + start + 1);
    //int pivot = data[randnum];

    int middle = ((end - start) / 2) + start;
    int pivot = whichBig(middle, start, end);
    int upper = end;
    //testing purposes
    //System.out.println("actual pivot, not index: " + pivot);
    //lower needs to smaller than increment.
    int lower = start;
    while (lower < upper){
      while (lower <= upper && data[lower] < pivot){
        //System.out.println("lower: " + lower + "\n" + "upper: " + upper);
        lower++;
      }
      while (upper >= lower && data[upper] > pivot){
        //System.out.println("lower: " + lower + "\n" + "upper: " + upper);
        upper--;
      }
      if (upper > lower){
        switchPlace(data, upper, lower);
      }
    }
    //return last position of pivot.
    return lower;
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
     //for (int y = 0; y < data.length; y++){
    //   System.out.println(data[y]);
    // }
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
    int[] b1 = new int[] {1, 5, 7, 2, 6, 4, 3};
    System.out.println(quickselect(b1, 3));*/
    /*
    System.out.println("\n" + "quicksort testing" + "\n");
    // TEST FOR DUPLICATES LATER
    int[] b2 = new int[] {1, 5, 7, 2, 6, 4, 3, 13, 24, 23, 92, 0, 200};
    quicksort(b2);
    for (int y = 0; y < b2.length; y++){
      System.out.println(b2[y]);
    }*/
    System.out.println();

  }

}
