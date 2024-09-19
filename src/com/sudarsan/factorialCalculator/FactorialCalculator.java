package com.sudarsan.factorialCalculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Sudarsan Mallick FactorialCalculator Class:- Class to represent the
 *           FactorialCalculator.Here’s an updated implementation to calculate
 *           the factorial of n using both single-threaded and multithreaded
 *           approaches, including performance comparison and verification by
 *           printing the first 10 digits of the result.
 */

public class FactorialCalculator {

	// Single-threaded version
	public static BigInteger factorialSingleThread(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	// Multithreaded version
	public static BigInteger factorialMultiThread(int n, int threadCount)
			throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		List<Future<BigInteger>> futures = new ArrayList<>();

		// Divide the range into chunks, one per thread
		int chunkSize = n / threadCount;
		for (int i = 0; i < threadCount; i++) {
			int start = i * chunkSize + 1;
			int end = (i == threadCount - 1) ? n : (i + 1) * chunkSize;
			futures.add(executor.submit(new FactorialTask(start, end)));
		}

		BigInteger result = BigInteger.ONE;

		// Collect results from all threads
		for (Future<BigInteger> future : futures) {
			result = result.multiply(future.get());
		}

		executor.shutdown();
		return result;
	}

	// Callable task to compute factorial for a range of numbers
	public static class FactorialTask implements Callable<BigInteger> {
		private final int start;
		private final int end;

		public FactorialTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public BigInteger call() {
			BigInteger result = BigInteger.ONE;
			for (int i = start; i <= end; i++) {
				result = result.multiply(BigInteger.valueOf(i));
			}
			return result;
		}
	}

	// Helper method to print the first 10 digits of the factorial result
	public static void printFirstTenDigits(BigInteger result) {
		String resultString = result.toString();
		System.out.println("First 10 digits: " + resultString.substring(0, 10));
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int n = 1000; // You can change the value for larger n
		int threadCount = 4; // Number of threads

		// Measure time for single-threaded factorial
		long startSingleThread = System.nanoTime();
		BigInteger factorialSingle = factorialSingleThread(n);
		long endSingleThread = System.nanoTime();
		long singleThreadDuration = endSingleThread - startSingleThread;

		// Measure time for multi-threaded factorial
		long startMultiThread = System.nanoTime();
		BigInteger factorialMulti = factorialMultiThread(n, threadCount);
		long endMultiThread = System.nanoTime();
		long multiThreadDuration = endMultiThread - startMultiThread;

		// Print results
		System.out.println("Single-threaded time: " + singleThreadDuration / 1_000_000 + " ms");
		System.out.println("Multi-threaded time: " + multiThreadDuration / 1_000_000 + " ms");

		// Verify the result by printing the first 10 digits
		System.out.println("Single-threaded result:");
		printFirstTenDigits(factorialSingle);
		System.out.println("Multi-threaded result:");
		printFirstTenDigits(factorialMulti);
	}
	/**
	 * OUT put like : 
	 * Single-threaded time: 3
	 * ms Multi-threaded time: 23 ms
	 * Single-threaded result:
	 * First 10 digits: 4023872600 
	 * Multi-threaded result:
	 * First 10 digits: 4023872600
	 * 
	 */
}
