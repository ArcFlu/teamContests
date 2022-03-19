import java.util.*;

class perm {
  public static int[] toArray (String num) {
    int [] arr = new int[num.length()];
    for (int i = 0; i < num.length(); i++) {
      arr[i] = Character.getNumericValue(num.charAt(i));
    }
    return arr;
  }

  public static int[] swap (int[] arr, int index) {
    int swapVal = 9;
    int swapIndex = 0;
    for (int i = index + 1; i < arr.length; i++) {
      if (arr[i] > arr[index] && arr[i] < swapVal) {
        swapVal = arr[i];
        swapIndex = i;
      }
    }
    int temp = arr[index];
    arr[index] = arr[swapIndex];
    arr[swapIndex] = temp;
    return arr;
  }

  public static int[] sort (int[] arr, int index) {
    for (int i = index; i < arr.length; i++) {
      int lowest = 10;
      int lowestIndex = i;
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < lowest && arr[j] < arr[i]) {
          lowest = arr[j];
          lowestIndex = j;
        }
      }

      int temp = arr[i];
      arr[i] = arr[lowestIndex];
      arr[lowestIndex] = temp;

//       for (int j = 0; j < arr.length; j++) {
//         System.out.print(arr[j]);
//       }
//       System.out.println();
    }

    return arr;
  }

  
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCases = input.nextInt();
    int currCase = input.nextInt();
    
    while (currCase != numCases + 1) {
      String num = input.next();
      int [] numArr = toArray(num);
      boolean possible = false;
      int breakpoint = -1;
      
      for (int i = 1; i < numArr.length; i++) {
        int currNum = numArr[i];
        int prevNum = numArr[i-1];
        if (currNum > prevNum) {
          possible = true;
          breakpoint = i-1;
        }
      }

      if (!possible) {
        System.out.println(currCase + " BIGGEST");
        if (!input.hasNextInt()) {
          break;
        }
        currCase = input.nextInt();
        continue;
      }

      numArr = swap(numArr, breakpoint);
      numArr = sort(numArr, breakpoint+1);
      // double newNum = toDouble(numArr);
      System.out.print(currCase + " ");
      for (int i = 0; i < numArr.length; i++) {
        System.out.print(numArr[i]);
      }
      System.out.println();
      if (!input.hasNextInt()) {
        break;
      }
      currCase = input.nextInt();

    }
    System.out.println();
  }
}