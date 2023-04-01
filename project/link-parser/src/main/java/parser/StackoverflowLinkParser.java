package parser;

import java.util.regex.Pattern;

public final class StackoverflowLinkParser implements LinkParser {
    private final static Pattern STACKOVERFLOW_URL_PATTERN = Pattern.compile("https://stackoverflow.com/questions/(?<id>\\d+)/?");

    @Override
    public String parseLink(String url) {
        var matcher = STACKOVERFLOW_URL_PATTERN.matcher(url);
        if (matcher.find()) {
            return matcher.group("id");
        } else {
            return null;
        }
    }
}
