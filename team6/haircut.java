import java.util.*;

public class haircut {
	public static long findBarber(long[] barbers, long spot) {
		long high = (long)Integer.MAX_VALUE * 100000;
		long low = 0;
		long mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			long customer = barbers.length;
			for (int i = 0; i < barbers.length; i++)
				customer += mid / barbers[i];

			if (customer < spot)
				low = mid + 1;
			else
				high = mid;
		}

		long customer = barbers.length + 1;
		long time = low - 1;
		for (int i = 0; i < barbers.length; i++)
			customer += time / barbers[i];

		time += 1;
		for (int i = 0; i < barbers.length; i++)
			if (time % barbers[i] == 0)
				if (customer++ == spot)
					return i+1;

		return -1; // no match, only returns if code is flawed
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int currCase = 1; currCase <= numCases; currCase++) {
			int numBarbers = input.nextInt();
			long spot = input.nextInt();
			long[] barbers = new long[numBarbers];
			for (int i = 0; i < numBarbers; i++)
				barbers[i] = input.nextInt();

			long myBarber = findBarber(barbers, spot);
			System.out.println("Case #" + currCase + ": " + myBarber);
		}
	}
}
