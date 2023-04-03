package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackoverflowLinkParserTest {
    @Test
    public void testParseLink() {
        StackoverflowLinkParser parser = new StackoverflowLinkParser();
        String input = "https://stackoverflow.com/questions/61364113/dockerfile-how-to-download-a-file-using-curl-and-copy-into-the-container";
        String expected = "61364113";
        String result = parser.parseLink(input);
        assertEquals(expected, result);
    }
    @Test
    public void testUnknownStackOverflowLink() {
        String input = "https://stackoverflow.com/foo/bar";
        LinkParser linkParser = new StackoverflowLinkParser();
        String result = linkParser.parseLink(input);
        assertNull(result);
    }
}
