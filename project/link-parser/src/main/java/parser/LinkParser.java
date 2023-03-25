package parser;

public sealed interface LinkParser permits GithubLinkParser, StackoverflowLinkParser {
    String parseLink(String url);
}
