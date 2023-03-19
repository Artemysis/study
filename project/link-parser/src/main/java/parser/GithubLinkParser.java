package parser;

import java.util.regex.Pattern;
public final class GithubLinkParser implements LinkParser {
    private final static Pattern GITHUB_URL_PATTERN = Pattern.compile("https://github.com/(?<user>[^/]+)/(?<repo>[^/]+)/?");

    @Override
    public String parseLink(String url) {
        var matcher = GITHUB_URL_PATTERN.matcher(url);
        if (matcher.find()) {
            return matcher.group("user") + "/" + matcher.group("repo");
        } else {
            return null;
        }
    }
}
