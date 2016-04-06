package mavenTest.zad7_1;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class RunJBehaveMain {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("IsEmptyStory.story", "MyPushStory.story", "MyTopStory.story", "MyPopStory.story");
	
	public static void main(String[] args) {
		embedder.configuration().useStoryLoader(new LoadFromClasspath())
		  .useStoryReporterBuilder(new StoryReporterBuilder()
				  .withDefaultFormats() 
				    .withFormats(Format.CONSOLE, Format.TXT));
		embedder.candidateSteps().add(new MyTopSteps());
		embedder.candidateSteps().add(new MyPopSteps());
		embedder.candidateSteps().add(new MyPushSteps());
		embedder.candidateSteps().add(new IsEmptySteps());
		embedder.runStoriesAsPaths(storyPaths);
	}
}
