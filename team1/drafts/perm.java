import java.util.*;

public class perm
{
	public static int[] toArray(String s)
	{
		int[] arr = new int[s.length()];

		for (int i = 0; i < s.length(); i++)
		{
			arr[i] = Character.getNumericValue(s.charAt(i));
		}

		return arr;
	}

	public static int[] swap(int[] arr, int index)
	{
		int lowest = 10;
		int lowestIndex = -1;
		for (int i = index; i < arr.length; i++)
		{
			if (arr[i] > arr[index] && arr[i] < lowest)
			{
				lowest = arr[i];
				lowestIndex = i;
			}
		}

		int temp = arr[index];
		arr[index] = arr[lowestIndex];
		arr[lowestIndex] = temp;

		return arr;
	}

	public static int[] sort(int[] arr, int index)
	{
		for (int i = index; i < arr.length; i++)
		{
			// for (int j = 0; j < arr.length; j++)
			// {
			// 	System.out.print(arr[j]);
			// }
			// System.out.println();

			int lowestIndex = i;
			boolean change = false;
			for (int j = i+1; j < arr.length; j++)
			{
				if (arr[j] < arr[i] && arr[j] < arr[lowestIndex])
				{
					lowestIndex = j;
					change = true;
				}
			}

			if (change)
			{
				int temp = arr[i];
				arr[i] = arr[lowestIndex];
				arr[lowestIndex] = temp;
			}
		}

		return arr;
	}

	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int i = 0; i < numCases; i++)
		{
			int currCase = input.nextInt();
			String num = input.next();
			int[] numArr = toArray(num);
			int breakpoint = -1;
			boolean possible = false;

			for (int j = 1; j < numArr.length; j++)
			{
				if (numArr[j] > numArr[j-1])
				{
					breakpoint = j - 1;
					possible = true;
				}
			}

			if (!possible)
			{
				System.out.println(currCase + " BIGGEST");
				continue;
			}

			numArr = swap(numArr, breakpoint);
			numArr = sort(numArr, breakpoint+1);

			System.out.print(currCase + " ");
			for (int j = 0; j < numArr.length; j++)
				System.out.print(numArr[j]);
			System.out.println();
		}
	}
}
