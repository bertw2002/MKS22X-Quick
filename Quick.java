public class Quick{
  public static void switchPlace(int[] data, int first, int second){
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

  public static void main(String[] args) {
    int[] b = new int[] {13, 23, 14, 37, 40, 93, 2, 17, 12, 9, 87, 44, 68};

    System.out.println("\n" + "partition testing" + "\n");
    System.out.println("pivot: " + partition(b, 0, 12));

    for (int x = 0; x < b.length; x++){
      System.out.println(b[x]);
    }

  }
}
