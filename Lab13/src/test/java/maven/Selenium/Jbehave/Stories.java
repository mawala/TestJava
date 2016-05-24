package maven.Selenium.Jbehave;

import java.util.Locale;

public class Stories extends LocalizedStories {
    
    @Override
    protected Locale locale() {
        return new Locale("pol");
    }

    @Override
    protected String storyPattern() {
        return "**/*.historia";
    }

    @Override
    protected Object localizedSteps() {
        return new MySteps();
    }
 
}
