package com.example.decorator;

public class RedTextColorDecorator extends HtmlDecorator {
    public RedTextColorDecorator(HtmlComponent htmlComponent) {
        super(htmlComponent);
    }

    @Override
    public String getHtml() {
        return "<html><body style='color:red;'>" + htmlComponent.getHtml() + "</body></html>";
    }
}
