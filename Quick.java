public class Quick{
  public static void switchPlace(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }
  public static int partition (int [] data, int start, int end){
    int randnum = (int)(Math.random() * (end - start) + start);
    int pivot = data[randnum];
    /*
    testing purposes
    System.out.println("pivot is" + pivot);
    boolean startTrue = false;
    boolean endTrue = false;*/
    while (start < end){
      //finds if number is small enough to move to other side.
      // doesnt work.
      while (data[start] < pivot){
        start++;
      }
      while (data[end] > pivot){
        end--;
      }
      if (start < end){
        switchPlace(data, start, end);
      }
    }
    //return last position of pivot.
    return end;
  }

  public static void main(String[] args) {
    int[] b = new int[] {13, 23, 14, 37, 40, 93, 2, 17, 12, 9, 87, 44, 68};
    System.out.println("\n" + "partition testing" + "\n");
    System.out.println(partition(b, 0, 12));

    for (int x = 0; x < b.length; x++){
      System.out.println(b[x]);
    }
  }
}
