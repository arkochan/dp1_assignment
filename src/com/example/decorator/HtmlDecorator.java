package com.example.decorator;

public abstract class HtmlDecorator implements HtmlComponent {
    public HtmlComponent htmlComponent;

    public HtmlDecorator(HtmlComponent htmlComponent) {
        this.htmlComponent = htmlComponent;
    }

    @Override
    public String getHtml() {
        return htmlComponent.getHtml();
    }
}
