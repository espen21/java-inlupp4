import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class EqnTest {
    Environment env = null;

    @Before
    public void createEnvironment() {
        this.env = new Environment();
    }

    @After
    public void destroyEnvironment() {
        this.env = null;
    }

    @Test
    public void constantTest() {
        Expression e = new Constant(42);
        assertEquals(e.evaluate(env), 42);
    }
    @Test(expected=UndefinedVariableException.class)
    public void nonExistingVariableTest() {
        Variable v = new Variable("v");
        v.evaluate(env);
    }
    @Test
    public void assignmentTest() {
        Constant _42 = new Constant(42);
        Constant _0 = new Constant(0);
        Variable v = new Variable("v");

        Assignment a = new Assignment(v, _0);
        assertEquals(a.evaluate(env), 0);

        a = new Assignment(v, _42);
        assertEquals(a.evaluate(env), 42);
    }
}
