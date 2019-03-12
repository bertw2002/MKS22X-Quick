public class Quick{
  //helper that switches places
  private static void switchPlace(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }

  //helper for partition that finds median value
  private static int whichBig(int x, int y, int z){
    if ((x > y && x < z ) || (x < y && x > z )) return x;
    if ((x > y && y > z ) || (x < y && y < z )) return y;
    return z;
  }
  public static int partition (int [] data, int start, int end){
    int randnum = (int)(Math.random() * (end - start) + start + 1);
    //switchPlace(data, randnum, end);
    //int pivot = data[end];
    int pivot = data[randnum];
    int upper = end;
    //testing purposes
    System.out.println("actual pivot, not index: " + pivot);
    //lower needs to smaller than increment.
    int lower = start;
    while (lower < upper){
      while (lower < upper && data[lower] <= pivot){
        System.out.println("lower: " + lower + "\n" + "upper: " + upper);
        lower++;
      }
      while (upper > lower && data[upper] >= pivot){
        upper++;
      }
      if (upper > lower){
        switchPlace(data, upper, lower);
      }
    }
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
      return quickselectHelper(data, k, start, pivot);
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

 }




  public static void main(String[] args) {

    int[] b = new int[] {1, 5, 7, 2, 6, 8, 9};

    System.out.println("\n" + "partition testing" + "\n");
    System.out.println("pivot: " + partition(b, 0, 6));

    for (int x = 0; x < b.length; x++){
      System.out.println(b[x]);
    }
    //System.out.println("\n" + "quicksort testing" + "\n");
    //int[] b1 = new int[] {13, 23, 14, 37, 40, 93, 2};
    //System.out.println(quickselect(b1, 0));
  }
}
