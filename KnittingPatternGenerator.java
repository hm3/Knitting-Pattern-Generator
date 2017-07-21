import java.util.Random;
/**
 * program to generate a pattern for knitting a 
 * 8 x 8 inch square
 * @author Hannah Morrison
 */
public class KnittingPatternGenerator{
	static final int totalStitches = 20;
	static final int totalRows = 20; 
	static Random rand = new Random();
	public static void main(String[]args){
		//determine the random number; in this case, interval for ribbing
		int randomNum = rand.nextInt(totalStitches) + 1;
		//choices of rows/square types
		String [] rows = {"randomRow", ribbedRow(totalStitches, randomNum), garterRow(totalStitches)};
		int rowIndex = rand.nextInt(rows.length);
		String row = rows[rowIndex];
		//print the row 20 times
		for (int i = 0; i < totalRows; i++){
			//if the random row option was selected,
			//call the method at each pass, so that new random numbers
			//will be generated for each row.
			if(rowIndex == 0){
				row = randomRow(totalStitches, rand);
			}
			System.out.println(row);
		}
	}

	/**
	 * generates a random series of 
	 * knit and purl stitches
	 * @param total # stitches per row
	 * @param 
	 * @return string representing one row
	 */
	public static String randomRow(int totalStitches, Random rand){
		String toReturn = "";
		int sum = 0;
		boolean reachedMax = false;
		while(reachedMax == false){
			if (sum <= totalStitches){
				int randomNum = rand.nextInt(totalStitches) + 1;
				if ((randomNum + sum) <= totalStitches){
					sum += randomNum;
					if (randomNum % 2 == 0){
						toReturn += ("K" + randomNum + " ");
					}
					else{
						toReturn += ("P" + randomNum + " ");
					}
				}

			}
			if (sum == totalStitches){
				reachedMax = true;
			}
		}
		return toReturn;
	}

	/**
	 * generates a rib stitch pattern
	 * @param total # stitches per row
	 * @param interval to use (K3P3, K5P5, etc.)
	 * this number will need to be determined before entering the main loop
	 * @return one row as a String
	 */
	public static String ribbedRow(int totalStitches, int interval){
		String toReturn = "";
		int count = 0;
		int remainCount = 0;
		for (int i = 0; i < (totalStitches/interval)/2; i++){
			toReturn += ("K" + interval + " P" + interval + " ");
			count += (interval * 2);
		}
		remainCount = (totalStitches - count);
		if (remainCount != 0){
			toReturn += "K" + remainCount;
		}
		return toReturn;
	}
	/**
	 * generates a garter stitch pattern
	 * @param total # stitches per row
	 * @return one row as a String
	 */
	public static String garterRow(int totalStitches){
		String toString = "K" + totalStitches;
		return toString;
	}
}