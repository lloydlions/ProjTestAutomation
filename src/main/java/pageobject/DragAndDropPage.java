package pageobject;

import core.BasePage;
import core.DriverFactory;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {
    protected String image = "//div[@id=\"image\"]//img";
    protected String location = "//div[@id=\"box\"]";

    public DragAndDropPage() {
        super(DriverFactory.initialize());
    }
    public void navigateToPage(){
        loadUrl("https://formy-project.herokuapp.com/dragdrop");
        Assert.assertEquals(getPageTitle(),"Drag the image into the box");
    }

    public void dragImageToLocation(){
        dragAndDrop(image, location);
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
