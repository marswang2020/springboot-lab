package mars.gupao.factory.factorymethod;

import mars.gupao.factory.ICourse;
import mars.gupao.factory.JavaCourse;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
