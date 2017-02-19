
import org.junit.Test;

import java.io.IOException;
import java.util.Queue;

import static org.junit.Assert.assertEquals;


public class HtmlValidatorTest {

	@Test
	public void test1() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test1.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            //https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#lineSeparator--
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_1.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
	}

    @Test
    public void test2() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test2.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_2.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test3.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_3.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test4() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test4.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_4.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test5() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test5.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_5.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test6() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test6.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_6.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test7() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test7.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_7.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    @Test
    public void test8() {
        try {
            String pageText = ValidatorMain.readCompleteFileOrURL("testcases/test8.html");
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator validator = new HtmlValidator(tags);
            assertEquals(ValidatorMain.readCompleteFileOrURL("testcases/expected_output_8.txt"),validator.validate().replaceAll("\n",System.lineSeparator()));
        }catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

}
