package Rodriguez_Problem2;

public class Application {

	public static void main(String[] args) {
		DuplicateCounter.count("problem2.txt");
		DuplicateCounter.write("unique_word_counts.txt");
	}
}
