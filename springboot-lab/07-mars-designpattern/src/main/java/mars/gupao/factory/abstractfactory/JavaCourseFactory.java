package mars.gupao.factory.abstractfactory;

import mars.gupao.factory.INote;
import mars.gupao.factory.IVideo;
import mars.gupao.factory.JavaNote;
import mars.gupao.factory.JavaVideo;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
