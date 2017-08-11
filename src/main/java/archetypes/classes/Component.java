package archetypes.classes;

/**
 * Created by lisboalien on 14/08/2017.
 * Class that defines a Component
 */
public class Component {
    private String xpath;
    private String id;
    private String className;
    private String cssPath;
    private String name;
    private String linkText;
    private String partialLinkText;
    private String tagName;

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCssPath() {
        return cssPath;
    }

    public void setCssPath(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getPartialLinkText() {
        return partialLinkText;
    }

    public void setPartialLinkText(String partialLinkText) {
        this.partialLinkText = partialLinkText;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
