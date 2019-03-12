public class Quick{
  //helper that switches places
  private static void switchPlace(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }
  public static int partition (int [] data, int start, int end){
    int randnum = (int)(Math.random() * (end - start) + start);
    switchPlace(data, randnum, end);
    int pivot = data[end];
    int upper = end;
    System.out.println("pivot: " + pivot);
    //lower needs to smaller than increment.
    int lower = start - 1;
    /*
    testing purposes
    System.out.println("pivot is" + pivot);
    boolean startTrue = false;
    boolean endTrue = false;*/
    for (int increment = start; increment < upper; increment++){
      if (data[increment] <= pivot){
        //increment lower because element is smaller than pivot.
        lower++;
        switchPlace(data, lower, increment);
      }
    }
    switchPlace(data, lower + 1, end);
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
    int pivot = partition(data, start, end);
    if (k > 0 && k < end){
      if (k == pivot){
        return data[k];
      }
      if (k < pivot - start + 1){
        return quickselectHelper(data, k, start, data[pivot] - 1);
      }
      else if (k > pivot - start + 1)
        return quickselectHelper(data, k, data[pivot] + 1, end);
      }else{
        return data[pivot];
      }
    }
  }



  public static void main(String[] args) {
    int[] b = new int[] {13, 23, 14, 37, 40, 93, 2, 17, 12, 9, 87, 44, 68};

    System.out.println("\n" + "partition testing" + "\n");
    System.out.println("pivot: " + partition(b, 0, 12));

    for (int x = 0; x < b.length; x++){
      System.out.println(b[x]);
    }
    System.out.println("\n" + "quicksort testing" + "\n");
    int[] b1 = new int[] {13, 23, 14, 37, 40, 93, 2};
    System.out.println(quickselect(b1, 0));
  }
}
