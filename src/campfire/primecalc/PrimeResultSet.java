package campfire.primecalc;

import java.math.BigInteger;
import java.util.Random;

public class PrimeResultSet {

	private final int[] resultPrimes;
	private BigInteger result;
	private BigInteger maxPrime;

	private final int[][] primeTable;

	private final int numberOfFactors;
	private final int groupSize;

	PrimeResultSet(final int numberOfFactors, final int groupSize) {

		this.numberOfFactors = numberOfFactors;
		this.groupSize = groupSize;

		this.resultPrimes = new int[numberOfFactors];

		this.primeTable = new int[numberOfFactors][groupSize];

		this.result = BigInteger.ONE;
		this.maxPrime = BigInteger.ONE;

		fillPrimeTable();
		calcMaxPrime();
		calcRandomPrimeProduct();
	}

	private void fillPrimeTable() {

		int[] primes = calcFirstNPrimes(numberOfFactors * groupSize);

		for (int i = 0; i < numberOfFactors; i++) {
			for (int j = 0; j < groupSize; j++) {
				this.primeTable[i][j] = primes[i * groupSize + j];
			}
		}

	}

	public int[] getResultPrimes() {
		return resultPrimes;
	}

	public BigInteger getResult() {
		return result;
	}

	public BigInteger getMaxPrime() {
		return maxPrime;
	}

	@Override
	public String toString() {

		StringBuilder ret = new StringBuilder();
		ret.append("Ergebnis: ");
		ret.append(this.result);
		ret.append("\t\t");
		ret.append("(0x");
		ret.append(this.result.toString(16).toUpperCase());
		ret.append(")");
		ret.append("\n");

		ret.append("Max:      ");
		ret.append(this.getMaxPrime());
		ret.append("\t\t");
		ret.append("(0x");
		ret.append(this.maxPrime.toString(16).toUpperCase());
		ret.append(")");
		ret.append("\n");

		for (int i = 0; i < numberOfFactors; i++) {
			for (int j = 0; j < groupSize; j++) {
				if (primeTable[i][j] == resultPrimes[i]) {
					ret.append("(");
				}
				ret.append(primeTable[i][j]);
				if (primeTable[i][j] == resultPrimes[i]) {
					ret.append(")");
				}
				ret.append(" ");
			}
			ret.append("| ");
		}

		return ret.toString();
	}

	private void calcRandomPrimeProduct() {

		Random rollFor = new Random();

		for (int i = 0; i < numberOfFactors; i++) {
			int factor = this.primeTable[i][rollFor.nextInt(groupSize)];
			result = result.multiply(BigInteger.valueOf(factor));
			resultPrimes[i] = factor;
		}
	}

	private void calcMaxPrime() {

		for (int i = 0; i < numberOfFactors; i++) {
			maxPrime = maxPrime.multiply(BigInteger.valueOf(primeTable[i][groupSize - 1]));
		}
	}

	private int[] calcFirstNPrimes(final int n) {

		int[] ret = new int[n];
		int i = 0;
		int probe = 2;

		while (i < n) {
			if (isPrime(probe)) {
				ret[i] = probe;
				i++;
			}
			probe++;
		}
		return ret;
	}

	private boolean isPrime(final int num) {
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
}
