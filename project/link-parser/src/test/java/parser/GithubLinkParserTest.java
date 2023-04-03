package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GithubLinkParserTest {
    @Test
    public void testParseLink() {
        GithubLinkParser parser = new GithubLinkParser();
        String input = "https://github.com/Artemysis/study";
        String expected = "Artemysis/study";
        String result = parser.parseLink(input);
        assertEquals(expected, result);
    }
    
    @Test
    public void testInvalidLink() {
        String input = "https://www.google.com";
        LinkParser linkParser = new GithubLinkParser();
        String result = linkParser.parseLink(input);
        assertNull(result);
    }
    @Test
    public void testUnknownLink() {
        String input = "https://example.com";
        LinkParser linkParser = new GithubLinkParser();
        String result = linkParser.parseLink(input);
        assertNull(result);
    }
}
