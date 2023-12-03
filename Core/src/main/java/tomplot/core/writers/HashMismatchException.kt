package tomplot.core.writers

data class HashMismatchException(
	val storedHash: String,
	val generatedHash: String,
) : Exception("Mismatching hash codes: stored: '$storedHash', generated: '$generatedHash'.")
