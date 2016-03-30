package mavenTest.zad1;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

public class RunJBehave {
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("IsEmptyStory.story", "MyPushStory.story", "MyTopStory.story", "MyPopStory.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new IsEmptySteps());
		embedder.candidateSteps().add(new MyPushSteps());
		embedder.candidateSteps().add(new MyTopSteps());
		embedder.candidateSteps().add(new MyPopSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}
}

