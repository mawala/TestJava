import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

public class RunJBehave {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("MyStory.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new MySteps());
		embedder.runStoriesAsPaths(storyPaths);
	}
}
