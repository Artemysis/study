package parser;

import java.util.Scanner;

import parser.GithubLinkParser;
import parser.LinkParser;
import parser.StackoverflowLinkParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            LinkParser linkParser;
            if (input.startsWith("https://github.com")) {
                linkParser = new GithubLinkParser();
            } else if (input.startsWith("https://stackoverflow.com")) {
                linkParser = new StackoverflowLinkParser();
            } else {
                System.out.println("Неправильная ссылка");
                continue;
            }
            String result = linkParser.parseLink(input);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Не удается отследить ссылку");
            }
        }
    }
}
