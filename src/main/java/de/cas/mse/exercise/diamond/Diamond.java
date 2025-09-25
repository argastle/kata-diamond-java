package de.cas.mse.exercise.diamond;

public class Diamond {

	public String print(int maxDiamondWidth) {

		if (isInvalidInput(maxDiamondWidth)) {
			return null;	
		}
		
		String result = generateMiddleRow(maxDiamondWidth);
		for (int currentWidth = maxDiamondWidth - 2; currentWidth > 0; currentWidth -= 2) {
			String currentRow = generateRow(maxDiamondWidth, currentWidth);
			result = currentRow + result + currentRow;
		}
		return result;
	}

	private String generateMiddleRow(int width){
		return generateRow(width, width);
	}

	private String generateRow(int maxWidth, int amountOfStars) {
		int spaces = ((maxWidth - amountOfStars) / 2);
		String row = "";
		row = appendSpaces(row, spaces);
		row = appendStars(row, amountOfStars);
		return row + "\n";
	}

	private boolean isInvalidInput(int width){
		return (width <= 0 || width % 2 == 0);
	}

	private String appendSpaces(String current, int amount){
		return appendChars(current, amount, ' ');
	}

	private String appendStars(String current, int amount){
		return appendChars(current, amount, '*');
	}

	private String appendChars(String current, int amount, char symbol){
		for (int i = 0; i < amount; i++){
			current += symbol;
		}
		return current;
	}

}
