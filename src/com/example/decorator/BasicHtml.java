package com.example.decorator;

public class BasicHtml implements HtmlComponent {
    private String html;

    public BasicHtml(String html) {
        this.html = html;
    }

    @Override
    public String getHtml() {
        return html;
    }
}
