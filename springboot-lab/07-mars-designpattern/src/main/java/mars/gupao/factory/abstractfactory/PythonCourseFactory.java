package mars.gupao.factory.abstractfactory;

import mars.gupao.factory.INote;
import mars.gupao.factory.IVideo;
import mars.gupao.factory.PythonNote;
import mars.gupao.factory.PythonVideo;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
