package checks;

//Type is missing: import java.lang.reflect.Constructor;

class ForLoopVariableTypeCheckSample {

  private static <T> void f(Class<T> c) {
    for (Constructor<?> ctor : c.getConstructors()) {
        Constructor<T> match = (Constructor<T>) ctor;
    }
  }

}
