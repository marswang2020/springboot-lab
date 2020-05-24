package mars.gupao.factory.factorymethod;

import mars.gupao.factory.ICourse;
import mars.gupao.factory.PythonCourse;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
