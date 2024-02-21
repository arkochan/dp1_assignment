package com.example.decorator;

public class BlueTextColorDecorator extends HtmlDecorator {
    public BlueTextColorDecorator(HtmlComponent htmlComponent) {
        super(htmlComponent);
    }

    @Override
    public String getHtml() {
        return "<html><body style='color:blue;'>" + htmlComponent.getHtml() + "</body></html>";
    }
}
